package common;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Blob;

import common.data.DataContext;

/**
 * Insert the type's description here.
 * Creation date: (26.03.2008 23:45:32)
 * @author: Gürhan Caner
 */
public class ObjectToTypes {
	/**
	 * @returns int 
	 * @param obj Object casted to basic type
	 */
	public static int getInt(Object obj) {
		return getInt(obj, 0);
	}
	public static int getInt(Object obj, int defaultValue) {
		if (obj == null)
			return defaultValue;
		return ((Integer) obj).intValue();
	}
    public static int getInteger(Object o){
    	if(o == null){
    		return 0;
    	}
    	return getInt((String)o);
    }
	public static int getInt(String str) {
		if (str == null)
			return 0;
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {

		}
		return 0;
	}
	public static BigDecimal getBigDecimal(Object obj){
		if(obj == null) return null;
		return (BigDecimal)obj;
	}
	public static BigDecimal getBigDecimal(Object obj, BigDecimal altObject){
			if(obj == null) return altObject;
			return (BigDecimal)obj;
	}
	/**
	 * @returns double
	 * @param obj Object casted to basic type
	 */
	public static double getDouble(Object obj) {
		if (obj == null)
			return 0;

		return ((Double) obj).doubleValue();
	}

	/**
	 * @returns long
	 * @param obj Object casted to basic type
	 */
	public static long getLong(Object obj) {
		if (obj == null)
			return 0L;

		return ((Long) obj).longValue();
	}

	/**
	 * @returns long
	 * @param obj Object casted to basic type
	 */
	public static long getLong(String str) {
		if (str == null)
			return 0L;
		try {
			return Long.parseLong(str);
		} catch (Exception e) {

		}
		return 0L;
	}

	/**
	 * @returns boolean
	 * @param obj Object casted to basic type
	 */
	public static boolean getBoolean(Object obj) {
		if (obj == null)
			return false;
		return ((Boolean) obj).booleanValue();
	}
	/**
	 * @returns boolean
	 * @param obj Object casted to basic type
	 */
	public static boolean getBoolean(int val) {
		if (val == 0)
			return false;
		return true;
	}

	/**
	 * @returns boolean
	 * @param obj Object casted to basic type
	 */
	public static boolean getBoolean(String obj) {
		if (obj == null)
			return false;
		if (obj.equalsIgnoreCase("true"))
			return true;
		return false;
	}

	/**
	 * @returns String
	 * @param obj Object casted to String
	 */
	public static String getString(Object obj) {
		if (obj == null)
			return "";
		return obj.toString();
	}
	/**
	 * @returns String
	 * @param obj Object casted to String
	 */
	public static String getString(Object obj, String defaultValue) {
		if (obj == null)
			return defaultValue;
		return obj.toString();
	}

	/**
	 * @author huseyin
	 * @returns String
	 * @param obj Object casted to String
	 * Object null ise ya da zero length 
	 * bir string ise default valueyu return eder
	 */
	public static String getString(
		Object obj,
		String defaultValue,
		boolean ignoreZeroLength) {
		if (obj == null)
			return defaultValue;
		if(ignoreZeroLength){
			if (obj.toString().compareTo("") == 0)
				return defaultValue;
		}
		return obj.toString();
	}

	/**
	 * @returns java.sql.Date
	 * @param obj Object casted to String
	 */
	public static java.sql.Date getSqlDate(Object obj) {
		if (obj == null)
			return null;
		return (java.sql.Date) obj;
	}
	public static java.util.Date getUtilDate(Object obj) {
			if (obj == null)
				return null;
			return (java.util.Date) obj;
		}
	/**
	 * @returns java.sql.Time
	 * @param obj Object casted to Time
	 */
	public static java.sql.Time getSqlTime(Object obj) {
		if (obj == null)
			return null;
		return (java.sql.Time) obj;
	}
//	public static DataContext getDataContext(Object obj) {
//
//		if (obj == null) {
//			return null;
//		}
//		try {
//			return new DataContext(getBlob(obj));
//		} catch (Exception e) {
//			return null;
//		}
//
//	}
	public static String getBlob(Object obj) {
		if (obj == null) {
			return null;
		}
		String clsName = "";
		if (obj instanceof byte[]) {
			return new String((byte[]) obj);
		} else {
			clsName = obj.getClass().getName();

			if (clsName.equals("COM.ibm.db2.jdbc.net.DB2Blob")) {
				Blob blob = (Blob) obj;
				try {

					int length = (int) blob.length();

					/*
					// Although documentation gives that method 
					// it generates an Exception					
					byte[] bytes = blob.getBytes(0, length);
					*/

					InputStreamReader ir =
						new InputStreamReader(blob.getBinaryStream());
					char[] bytes = new char[length];
					ir.read(bytes);
					ir.close();
					return new String(bytes);

				} catch (Exception sqle) {
					return sqle.getMessage();
				}
			}

		}
		return clsName;
	}
}