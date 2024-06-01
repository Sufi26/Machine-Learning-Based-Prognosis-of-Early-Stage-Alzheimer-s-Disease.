/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alzhimerdetectionsystem.KNN;

/**
 *
 * @author virendra
 */
import java.io.*;
import java.util.*;

public class FeatureVectorComparision {
    public static ArrayList<String> main(String[] args) {
       
        ArrayList<String> Result = new ArrayList<String>();
        String trainingDataFile = "D:\\Alzaimer\\train.txt";
        String testDataFile = "D:\\Alzaimer\\test.txt";
        String trainingLabelsFile = "D:\\Alzaimer\\labels.txt";
        String classNamesFile = "D:\\Alzaimer\\classnames.txt";
        int k = 4;
        
        // read in the training data, test data, class names, and labels
        List<double[]> trainingData = readFeatureVectors(trainingDataFile);
        List<double[]> testData = readFeatureVectors(testDataFile);
        List<Integer> trainingLabels = readLabels(trainingLabelsFile);
        List<String> classNames = readClassNames(classNamesFile);
        
        // extract features from the training and test data
        List<double[]> trainingFeatures = trainingData;
        List<double[]> testFeatures = testData;
        
        // create a KNN classifier using the training features and labels
        KNNClassifier knn = new KNNClassifier(trainingFeatures, trainingLabels, k);
        
        // classify each test feature vector and print out the predicted class
        for (double[] query : testFeatures) {
            int predictedLabel = knn.classify(query);
            String predictedClassName = classNames.get(predictedLabel-1);
             Result.add(predictedClassName);
            System.out.println(" Predicted Class: " + predictedClassName);
        }
     return  Result;
    }
    
    public static List<double[]> readFeatureVectors(String filename) {
        List<double[]> featureVectors = new ArrayList<double[]>();
        try  {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
              try{
                String[] values = line.split(",");
                double[] featureVector = new double[values.length];
                for (int i = 0; i < values.length; i++) {
                    featureVector[i] = Double.parseDouble(values[i]);
                }
              
             
                featureVectors.add(featureVector);
            }catch(Exception ex)
              {
              
              }
              }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return featureVectors;
    }
    
    public static List<Integer> readLabels(String filename) {
        List<Integer> labels = new ArrayList<Integer>();
        try  {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                int label = Integer.parseInt(line);
                labels.add(label);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return labels;
    }
    
    public static List<String> readClassNames(String filename) {
        List<String> classNames = new ArrayList<String>();
        try  {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                classNames.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classNames;
    }
    
    public static List<double[]> extractFeatures(List<double[]> data) {
        List<double[]> features = new ArrayList<double[]>();
        for (double[] datum : data) {
            double[] feature = new double[datum.length];
            // TODO: compute the features for the datum and store them in the feature vector
            features.add(feature);
        }
        return features;
    }
    
    public static String queryToString(double[] query) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < query.length; i++) {
            sb.append(query[i]);
            if (i < query.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

     
}
