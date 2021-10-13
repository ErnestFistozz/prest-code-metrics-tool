package common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.text.Collator;

import common.monitor.Logger;

/**
 * Insert the type's description here.
 * Creation date: (27.03.2008 21:19:32)
 * @author: Caner, Gurhan
 */
public class BaseObject {
	
	/**
	 * Insert the method's description here.
	 * Creation date: (01.10.2001 13:32:46)
	 * @return java.lang.Object
	 * @param type java.lang.String
	 */
	public static Object constructObjectFromString(
		String className,
		String value) {
		try {
			Object o = constructSimpleObjectsFromString(className, value);

			if (o != null)
				return o;

			Class[] params = new Class[1];
			Object[] args = new Object[1];

			params[0] = String.class;
			args[0] = value;

			Class cl = Class.forName(className);
			Constructor c = cl.getDeclaredConstructor(params);

			return c.newInstance(args);
		} catch (Exception e) {
			// Error handling and Logging. OY 
			//e.printStackTrace();
			/*
			VPEventLog.report(
				VPEventLog.ERROR,
				"VPObject.constructObjectFromString",
				"cannot construct classname:" + className + " value:" + value);
			*/
			return null;
		}
	}
	/**
	 * @author caner gurhan
	 * args parametresinde verilen parametrlere göre 
	 * className parametresinde belirtilen Objecti yaratýr
	 */
	public static Object constructObjectFromString(
		String className,
		Object[] args) {
		try {

			Class[] params = new Class[args.length];
			for (int i = 0; i < args.length; i++)
				params[i] = args[i].getClass();

			Class cl = Class.forName(className);
			Constructor c = cl.getDeclaredConstructor(params);

			return c.newInstance(args);

		} catch (Exception e) {
			// Error handling and Logging. OY 
			//e.printStackTrace();
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.10.2001 13:32:46)
	 * @return java.lang.Object
	 * @param type java.lang.String
	 */
	public static Object constructSimpleObjectsFromString(
		String className,
		String value) {
		try {
			if (className.equals("java.lang.String")) {
				return value;
			} else if (className.equals("java.lang.Integer")) {
				return new Integer(value);
			}

			return null;
		} catch (Exception e) {
			return null;
		}
	}


	/**
	 * Tests for numeric value objects.
	 * Creation date: (30.09.2001 10:08:29)
	 * @return boolean
	 * @param obj java.lang.Object
	 */
	public static boolean isNumeric(Object obj) {
		try {
			if (Number.class.isAssignableFrom(obj.getClass())) {
				return true;
			}
		} catch (Exception e) {
			//e.printStackTrace();	
		}

		return false;
	}
		
	/**
	 * Tests for numeric value objects.
	 * Creation date: (30.09.2001 10:08:29)
	 * @return boolean
	 * @param obj java.lang.Object
	 */
	public static byte[] serialize(Object obj) {

		ObjectOutputStream oos = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			// serialize and pass the object
			oos.writeObject(obj);
			oos.flush();
			return bos.toByteArray();
		} catch (Exception e) {
//			com.vp.veribranch.monitor.VPEventLog.report(
//				com.vp.veribranch.monitor.VPEventLog.ERROR,
//				"VPObject",
//				"serialize",
//				e);
			Logger.error("BaseObject => serialize: " + e.getMessage() );
			return null;
		} finally {
			try {
				oos.close();
			} catch (Exception e) {
//				com.vp.veribranch.monitor.VPEventLog.report(
//					com.vp.veribranch.monitor.VPEventLog.ERROR,
//					"VPObject",
//					"serialize close streams",
//					e);
				Logger.error("BaseObject => serialize close streams: " + e.getMessage() );
			}
		}
	}

}
