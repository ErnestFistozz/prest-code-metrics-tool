/**
 * 
 */
package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import console.PrestConsoleApp;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 * @author stepne
 *
 */
public class ArffUtils
{
	static Logger logger = Logger.getLogger(PrestConsoleApp.class.getName());

	public static boolean aggregateMethod2File(String file)
	{
		Instances data;
		ArffLoader loader = new ArffLoader();
		BufferedWriter writer = null;
		try
		{
			logger.info(file);
			loader.setSource(new File(file));
			data = loader.getDataSet();
			data.setClassIndex(data.numAttributes() - 1);
			Instances newdata = new Instances(data, data.numInstances());

			String filename = "";
			String temp = "";
			double minValue = -1;
			double maxValue = 0;
			double totalValue = 0;
			double avgValue;

			/*put distinct file names into newdata */
			int count = 0;
			for (int i = 0; i < data.numInstances(); i++)
			{
				temp = data.instance(i).stringValue(0);
				if (i == 0)
				{
					filename = temp;
					newdata.add(data.instance(i));
					newdata.instance(count).setValue(0, data.instance(i).stringValue(0));
					count++;
				}
				if (temp.equals(filename))
				{
				}
				else
				{
					filename = temp;
					newdata.add(data.instance(i));
					newdata.instance(count).setValue(0, data.instance(i).stringValue(0));
					count++;
				}
			}

			ArrayList<ArrayList<String>> valueArray = new ArrayList<ArrayList<String>>();
			ArrayList<String> tempArray = null;
			int index = 4;
			int index2 = newdata.numAttributes() - 1;
			boolean firstinst = true;
			Instance tempinst;
			int lastpos = -1;
			for (int j = 0; j < newdata.numInstances(); j++)
			{
				filename = newdata.instance(j).stringValue(0);
				//	System.out.println(filename);
				tempArray = new ArrayList<String>();
				for (int k = lastpos + 1; k < data.numInstances(); k++)
				{
					tempinst = data.instance(k);
					if (filename.equals(tempinst.stringValue(0)))
					{
						//	System.out.println(tempinst.stringValue(0));
						for (int y = 7; y < data.numAttributes()-1; y++)
						{
							tempArray.add("" + tempinst.value(y));
						}
						valueArray.add(tempArray);
						tempArray = new ArrayList<String>();
						lastpos = k;
					}
					else
					{
						//	System.out.println("New File: " + tempinst.stringValue(0));
						/*compute new attributes for each (distinct) file */
						for (int x = 0; x < valueArray.get(0).size(); x++)
						{
							//iterate for attributes
							for (int y = 0; y < valueArray.size(); y++)
							{
								//iterate for instances (transpose)
								tempArray.add(valueArray.get(y).get(x));
							}
							for (int z = 0; z < tempArray.size(); z++)
							{
								if (Double.parseDouble(tempArray.get(z)) < minValue || minValue < 0)
									minValue = Double.parseDouble(tempArray.get(z));
								if (Double.parseDouble(tempArray.get(z)) > maxValue)
									maxValue = Double.parseDouble(tempArray.get(z));
								totalValue = totalValue + Double.parseDouble(tempArray.get(z));
							}
							avgValue = totalValue / valueArray.size();
							if (firstinst)
							{
								newdata.insertAttributeAt(new Attribute("MaxValue"), index2);
								newdata.insertAttributeAt(new Attribute("TotalValue"), index2 + 1);
								newdata.insertAttributeAt(new Attribute("AvgValue"), index2 + 2);
							}
							newdata.instance(j).setValue(index, minValue);
							index++;
							newdata.instance(j).setValue(index2, maxValue);
							index2++;
							newdata.instance(j).setValue(index2, totalValue);
							index2++;
							newdata.instance(j).setValue(index2, avgValue);
							index2++;
							minValue = -1;
							maxValue = 0;
							totalValue = 0;
							avgValue = 0;
							tempArray = new ArrayList<String>();
						}
						firstinst = false;
						valueArray = new ArrayList<ArrayList<String>>();
						tempArray = null;
						index = 4;
						index2 = data.numAttributes() - 1;
						break;
					}
				}
			}
			/*final touch: remove method name and method id from the dataset*/
			newdata.deleteAttributeAt(2);
			newdata.deleteAttributeAt(2);
			logger.info("Writing to new file...");
			String outFile = file.substring(0, file.lastIndexOf("."));
			logger.info(outFile);
			writer = new BufferedWriter(new FileWriter(outFile + "_AG.arff"));
			writer.write(newdata.toString());
			writer.flush();
			writer.close();
			logger.info("Aggregation is applied to " + file + " successfully");
		}
		catch (Exception e)
		{
			logger.error("Aggregation function could not be processed due to IOException");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param arffFile
	 * @param changesFile
	 * @param resultPath
	 */
	public static void addChanges(String sourceRoot, String arffFile, String changesFile, int referenceFreezeLabel, String resultPath)
	{
		Instances data;
		ArffLoader loader = new ArffLoader();
		BufferedWriter writer = null;
		logger.info("reference freeze = " + referenceFreezeLabel);
		try
		{
			loader.setSource(new File(arffFile));
			data = loader.getDataSet();
			data.insertAttributeAt(new Attribute("FreezeCountBetweenChanges"), data.numAttributes() - 1);
			BufferedReader changesReader = new BufferedReader(new FileReader(changesFile));
			String text = null;
			HashMap<String, Integer> changeDict = new HashMap<String, Integer>();
			while ((text = changesReader.readLine()) != null)
			{
				String freeze = (text.substring(text.indexOf(",") + 1));
				int fNum = Integer.parseInt(freeze.charAt(7) + "" + freeze.charAt(9) + freeze.charAt(10));
				String codeFileName = text.substring(0, text.indexOf(","));
				if (changeDict.containsKey(codeFileName))
				{
					if (changeDict.get(codeFileName) < fNum && fNum < referenceFreezeLabel)
					{
						changeDict.put(codeFileName.replace(File.separator, "/"), new Integer(fNum));
					}
				}
				else
				{
					if (fNum < referenceFreezeLabel)
					{
						changeDict.put(codeFileName.replace(File.separator, "/"), new Integer(fNum));
					}
				}
			}

			for (int i = 0; i < data.numInstances(); i++)
			{
				String localFilePath = data.instance(i).stringValue(0);
				localFilePath = localFilePath.replace(sourceRoot, "");
				localFilePath = localFilePath.replace(File.separator, "/");
				localFilePath = localFilePath.replace("//", "/");
				try
				{
					double freezeDif = referenceFreezeLabel - changeDict.get(localFilePath).doubleValue();
					data.instance(i).setValue(data.numAttributes() - 2, freezeDif);
				}
				catch (Exception e)
				{
					data.instance(i).setValue(data.numAttributes() - 2,
							100);
				}

			}

			writer = new BufferedWriter(new FileWriter(resultPath));
			writer.write(data.toString());
			writer.flush();
			writer.close();
			logger.info("Change metric(s) added to " + resultPath + " successfully");

		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("Changes could  not be added");
		}

	}
}
