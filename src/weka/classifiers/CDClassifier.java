package weka.classifiers;

import java.io.BufferedReader;
import java.io.FileReader;

import weka.core.Instances;

public class CDClassifier {

	public static void main(String[] args) {
		WekaWrapper wekaWrapper = new WekaWrapper();
		try {
			Instances unlabeled = new Instances(new BufferedReader(new FileReader("E:\\ICT\\Scobot\\MachineLearning\\DesisionTree\\trainingdata.arff")));
			unlabeled.setClassIndex(unlabeled.numAttributes() - 1);
			for(int i = 0; i< unlabeled.numInstances(); i++) {
				double clsLabel = wekaWrapper.classifyInstance(unlabeled.instance(i));
				System.out.println(clsLabel + " ->" + unlabeled.classAttribute().value((int) clsLabel));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
