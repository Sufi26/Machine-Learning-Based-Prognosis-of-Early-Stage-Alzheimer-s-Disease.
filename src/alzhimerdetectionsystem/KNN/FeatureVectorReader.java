/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alzhimerdetectionsystem.KNN;

/**
 *
 * @author virendra
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FeatureVectorReader {

    public static List<double[]> readFeatureVectorFile(String fileName) {
        List<double[]> featureVectors = new ArrayList<double[]>();
        try  {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                String[] features = line.split(",");
                double[] featureVector = new double[features.length];
                for (int i = 0; i < features.length; i++) {
                    featureVector[i] = Double.parseDouble(features[i]);
                }
                featureVectors.add(featureVector);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return featureVectors;
    }
    
    
    public static List<String> readClassNames(String fileName) {
        List<String> classNames = new ArrayList<String>();
        try  {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                classNames.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading class names from file " + fileName + ": " + e.getMessage());
        }
        return classNames;
    }
    
    
    public static List<Integer> readLabels(String fileName) {
        List<Integer> labels = new ArrayList<Integer>();
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                labels.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            System.err.println("Error reading labels from file " + fileName + ": " + e.getMessage());
        }
        return labels;
    }
}
