package predictor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;

import weka.classifiers.*;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.j48.*;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.*;

import org.apache.log4j.Logger;

import console.PrestConsoleApp;

public class WekaRunner
{
	static Logger logger = Logger.getLogger(PrestConsoleApp.class.getName());

	private static String findPredResultPath(String trainPath)
	{
		String cut = trainPath.substring(0, trainPath.lastIndexOf(File.separator));
		return cut + File.separator;
	}

	private static int writeToFile(String folder, String fileNames, String nowStr, String data, String outputPath)
	{
		nowStr = nowStr.replaceAll(" ", "-");
		nowStr = nowStr.replaceAll(":", ".");
		BufferedWriter writer;
		try
		{
			if (outputPath == "")
				writer = new BufferedWriter(new FileWriter(folder + "results-" + fileNames + "-" + nowStr + ".res"));
			else
				writer = new BufferedWriter(new FileWriter(outputPath));
			writer.write(data);
			writer.flush();
			writer.close();

		}
		catch (Exception e)
		{
			logger.error("Could not write Weka prediction results to disk.");
		}
		return 1;
	}

	public static Instances doUnderSampling(Instances data)
	{
		Instances newdata = null;
		ArrayList<Integer> defective = new ArrayList<Integer>();
		ArrayList<Integer> defectFree = new ArrayList<Integer>();
		int defectCount = 0;
		int defectFreeCount = 0;
		for (int j = 0; j < data.numInstances(); j++)
		{
			if (data.instance(j).stringValue(data.numAttributes() - 1).equals("true"))
			{
				defectCount++;
				defective.add(j);
			}
			else
			{
				defectFreeCount++;
				defectFree.add(j);
			}
		}
		if (defectCount == 0)
			return null;
		newdata = new Instances(data, defectCount * 2);
		newdata.setClassIndex(data.numAttributes() - 1);
		java.util.Random r = new java.util.Random();
		for (int i = 0; i < defectCount; i++)
		{
			int pos = r.nextInt(defectFreeCount);
			newdata.add(data.instance(defectFree.get(pos)));
			for (int k = 0; k < data.numAttributes() - 1; k++)
			{
				newdata.instance(i).setValue(k, data.instance(defectFree.get(pos)).value(k));
			}
			newdata.instance(i).setValue(data.numAttributes() - 1, "false");
		}
		int dCount = 0;
		for (int i = defectCount; i < 2 * defectCount; i++)
		{
			newdata.add(data.instance(defective.get(dCount)));
			for (int k = 0; k < data.numAttributes() - 1; k++)
			{
				newdata.instance(i).setValue(k, data.instance(defective.get(dCount)).value(k));
			}
			newdata.instance(i).setValue(data.numAttributes() - 1, "true");
			dCount++;
		}
		return newdata;
	}

	public static String runWeka(String trainPath, String testPath, String algorithm, String preProcess, String CrossValidate,
			String logFilter, String outputPath, String fileFilter, int diffSpan)
	{
		String fileNames = trainPath.substring(trainPath.lastIndexOf(File.separator) + 1) + "-"
				+ trainPath.substring(testPath.lastIndexOf(File.separator) + 1);
		String output = "";
		output += "train file: " + trainPath + "\n";
		output += "test file: " + testPath + "\n";
		try
		{
			Date now = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			String nowStr = df.format(now);
			//first load training set 
			Instances trainData = new Instances(new BufferedReader(new FileReader(trainPath)));
			// setting class attribute
			trainData.setClassIndex(trainData.numAttributes() - 1);

			//Instances newTrainData = doUnderSampling(trainData);
			//if (newTrainData != null)
			//	trainData = newTrainData;
			//else
			//{
				//use the previous training set
			//}

			trainData.deleteAttributeAt(0);
			//first load test set 
			//note: if cross validation is to be done than it is not used.
			Instances testData = new Instances(new BufferedReader(new FileReader(testPath)));
			String[] testFilePaths = new String[testData.numInstances()];

			for (int i = 0; i < testData.numInstances(); i++)
			{
				testFilePaths[i] = testData.instance(i).stringValue(0).replace("\\", "/");
			}

			testData.deleteAttributeAt(0);
			//normalize data if option selected
			if (preProcess.equals("Normalize"))
			{
				trainData = Filter.useFilter(trainData, new Normalize());
				testData = Filter.useFilter(testData, new Normalize());
			}

			// setting class attribute
			testData.setClassIndex(testData.numAttributes() - 1);
			Classifier cls = null;

			//choose your algorithm
			if (algorithm.equals("Naive Bayes"))
			{
				cls = new NaiveBayes();
			}
			else if (algorithm.equals("J48"))
			{
				cls = new J48();
			}

			cls.buildClassifier(trainData);

			Evaluation eval = new Evaluation(trainData);

			//if cross validate is selected use cross validation else use test data
			if (CrossValidate.equals("true"))
			{
				eval.crossValidateModel(cls, trainData, 10);
			}
			else
			{
				eval.evaluateModel(cls, testData);
			}

			//show output on screen
			output += "Experiment Results\n" + nowStr + "\n\n" + eval.toClassDetailsString() + eval.toMatrixString() + "\n\n";

			

			int tpC = 0;
			int fpC = 0;
			int tnC = 0;
			int fnC = 0;
			// output the ID, actual value and predicted value for each instance
			for (int i = 0; i < testData.numInstances(); i++)
			{

				double pred = cls.classifyInstance(testData.instance(i));
				output += ("ID: " + testData.instance(i).value(0));
				//	output += (", actual: " + testData.classAttribute().value((int) testData.instance(i).classValue()));
				double  t1 = testData.instance(i).value(testData.numAttributes() - 2);
				String actualLabel = testData.classAttribute().value((int) testData.instance(i).classValue());
				String predictedLabel = trainData.classAttribute().value((int) pred);
				if (testData.instance(i).value(testData.numAttributes() - 2) > diffSpan  && testData.numAttributes() == 94)
				{
					output += (", predicted: " + "false" + ", actual:"
							+ actualLabel + "\n"); // not among changed files
				
					if (actualLabel.equals("false"))
						tnC++;
					else
						fnC++;
				}
				else
				{
					output += (", predicted: " + predictedLabel + ", actual:"
							+ actualLabel + "\n");
					
					if (actualLabel.equals("false"))
					{
						if( predictedLabel.equals("false"))
							tnC++;
						else
							fpC++;
					}
					else
					{
						if( predictedLabel.equals("false"))
							fnC++;
						else
							tpC++;
					}
				}
			}
			output = " tp:" + tpC +  " fp:" + fpC +  " tn:" + tnC +  " fn:" + fnC +  "\n"  + output;
			output = " pd:" + (1.0 * tpC/(tpC + fnC)) +  " pf:" + (1.0 *fpC /(fpC + tnC)) +  "\n" + output;
			writeToFile(findPredResultPath(trainPath), fileNames, nowStr, output, outputPath);
			logger.info("Weka run finished successfully.");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("There was a problem during the execution of Weka.");
		}

		return output;
	}

	private static boolean isAmongChangedFiles(ArrayList<String> changedFiles, String aFile)
	{
		if (changedFiles.size() == 0)//returns true when there are no changed files provided
			return true;

		for (String changedFile : changedFiles)
		{
			if (aFile.endsWith(changedFile))
				return true;
		}
		return false;
	}
}
