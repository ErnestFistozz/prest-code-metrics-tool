package predictor;
import java.util.Date;
import java.text.DateFormat;

import weka.classifiers.*;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.j48.*;
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileReader;
import weka.classifiers.evaluation.*;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.*;

public class WekaRunner {

	public static String runWeka(String trainPath, String testPath,
			String algorithm, String preProcess, String CrossValidate, String logFilter) {
		String output = "";
		try { 
			//first load training set 
			Instances trainData = new Instances(new BufferedReader(
					new FileReader(trainPath)));
			// setting class attribute
			trainData.setClassIndex(trainData.numAttributes() - 1);
			
			//first load test set 
			//note: if cross validation is to be done than it is not used.
			Instances testData = new Instances(new BufferedReader(
					new FileReader(testPath)));
			
			//normalize data if option selected
			if (preProcess == "Normalize") {
				trainData = Filter.useFilter(trainData, new Normalize());
				testData = Filter.useFilter(testData, new Normalize());
			}
			
			// setting class attribute
			testData.setClassIndex(testData.numAttributes() - 1);
			Classifier cls = null;
			
			//choose your algorithm
			if (algorithm == "Naive Bayes") {
				cls = new NaiveBayes();
			} else if (algorithm == "J48") {
				cls = new J48();
			}

			cls.buildClassifier(trainData);

			Evaluation eval = new Evaluation(trainData);

			//if cross validate is selected use cross validation else use test data
			if (CrossValidate == "true") {
				eval.crossValidateModel(cls, trainData, 10);
			} else {
				eval.evaluateModel(cls, testData);
			}
			
			Date now = new Date();
		    DateFormat df = DateFormat.getDateTimeInstance();
		    //show output on screen
			//output = "Experiment Results\n" +  df.format(now) + "\n\n" + eval.toClassDetailsString() + eval.toMatrixString() + "\n\n";
			//output = "fileName,actual,prediction \n";
			// output the ID, actual value and predicted value for each instance
			for (int i = 0; i < testData.numInstances(); i++) {
				   double pred = cls.classifyInstance(testData.instance(i));
				   output += (testData.instance(i).stringValue(0));
				   output += ("," + testData.classAttribute().value((int) pred)+ "\n");
			}
			

		} catch (Exception e) {
			//should be extended to handle other exceptions
			output = "error in parser, examine your datasets...";
		}

		return output;
	}
}
