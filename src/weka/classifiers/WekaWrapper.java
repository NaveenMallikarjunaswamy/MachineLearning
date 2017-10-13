package weka.classifiers;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.CDClassifier;
import weka.classifiers.AbstractClassifier;

public class WekaWrapper extends AbstractClassifier {

  /**
   * Returns only the toString() method.
   *
   * @return a string describing the classifier
   */
  public String globalInfo() {
    return toString();
  }

  /**
   * Returns the capabilities of this classifier.
   *
   * @return the capabilities
   */
  public Capabilities getCapabilities() {
    weka.core.Capabilities result = new weka.core.Capabilities(this);

    result.enable(weka.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.NUMERIC_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.DATE_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.MISSING_VALUES);
    result.enable(weka.core.Capabilities.Capability.NOMINAL_CLASS);
    result.enable(weka.core.Capabilities.Capability.MISSING_CLASS_VALUES);


    result.setMinimumNumberInstances(0);

    return result;
  }

  /**
   * only checks the data against its capabilities.
   *
   * @param i the training data
   */
  public void buildClassifier(Instances i) throws Exception {
    // can classifier handle the data?
    getCapabilities().testWithFail(i);
  }

  /**
   * Classifies the given instance.
   *
   * @param i the instance to classify
   * @return the classification result
   */
  public double classifyInstance(Instance i) throws Exception {
    Object[] s = new Object[i.numAttributes()];
    
    for (int j = 0; j < s.length; j++) {
      if (!i.isMissing(j)) {
        if (i.attribute(j).isNominal())
          s[j] = new String(i.stringValue(j));
        else if (i.attribute(j).isNumeric())
          s[j] = new Double(i.value(j));
      }
    }
    
    // set class value to missing
    s[i.classIndex()] = null;
    
    return WekaClassifier.classify(s);
  }

  /**
   * Returns the revision string.
   * 
   * @return        the revision
   */
  public String getRevision() {
    return RevisionUtils.extract("1.0");
  }

  /**
   * Returns only the classnames and what classifier it is based on.
   *
   * @return a short description
   */
  public String toString() {
    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.8.1).\n" + this.getClass().getName() + "/WekaClassifier";
  }

  /**
   * Runs the classfier from commandline.
   *
   * @param args the commandline arguments
   */
  public static void main(String args[]) {
    runClassifier(new WekaWrapper(), args);
  }
  
}

class WekaClassifier {

  public static double classify(Object[] i) throws Exception {

    double p = Double.NaN;
    p = WekaClassifier.N1848be170(i);
    return p;
    
  }
  
  static double N1848be170(Object []i) {
	  
    double p = Double.NaN;
    if (i[0] == null) {
      p = 0;
    } else if (i[0].equals("end_rack")) {
      p = 0;
    } else if (i[0].equals("cd_spec")) {
    p = WekaClassifier.N5c8d095d1(i);
    } else if (i[0].equals("std_rack")) {
    p = WekaClassifier.N3238f3442(i);
    } 
    return p;
    
  }
  
  static double N5c8d095d1(Object []i) {
	  
    double p = Double.NaN;
    if (i[2] == null) {
      p = 0;
    } else if (((Double) i[2]).doubleValue() <= 80.0) {
      p = 0;
    } else if (((Double) i[2]).doubleValue() > 80.0) {
      p = 1;
    } 
    return p;
    
  }
  
  static double N3238f3442(Object []i) {
	  
    double p = Double.NaN;
    if (i[3] == null) {
      p = 1;
    } else if (i[3].equals("FALSE")) {
      p = 1;
    } else if (i[3].equals("TRUE")) {
      p = 0;
    } 
    return p;
  }
  
}
