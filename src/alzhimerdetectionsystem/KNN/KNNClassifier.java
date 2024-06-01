/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alzhimerdetectionsystem.KNN;

import java.util.List;

/**
 *
 * @author virendra
 */


import java.util.*;

public class KNNClassifier {
    private final List<double[]> trainingFeatures;
    private final List<Integer> trainingLabels;
    private final int k;
    
    public KNNClassifier(List<double[]> trainingFeatures, List<Integer> trainingLabels, int k) {
        this.trainingFeatures = trainingFeatures;
        this.trainingLabels = trainingLabels;
        this.k = k;
    }
    
    public int classify(double[] query) {
        // compute the distances between the query and each training feature vector
        List<Double> distances = new ArrayList<Double>();
        for (double[] trainingFeature : trainingFeatures) {
            double distance = distance(query, trainingFeature);
            distances.add(distance);
        }
                                    
        // find the k nearest neighbors
        List<Integer> nearestNeighborLabels = new ArrayList<Integer>();
        List<Double> nearestNeighborDistances = new ArrayList<Double>();
        for (int i = 0; i < k; i++) {
            double minDistance = Double.MAX_VALUE;
             int minDistanceIndex = -1;
            for (int j = 0; j < distances.size(); j++) {
                if (distances.get(j) < minDistance) {
                    minDistance = distances.get(j);
                    minDistanceIndex = j;
                }
            }
            nearestNeighborLabels.add(trainingLabels.get(minDistanceIndex));
            nearestNeighborDistances.add(minDistance);
            distances.set(minDistanceIndex, Double.MAX_VALUE);
        }
        
        // compute the majority label among the nearest neighbors
        int majorityLabel = majorityLabel(nearestNeighborLabels);
        return majorityLabel;
    }
    
    private double distance(double[] a, double[] b) {
        double distance = 0.0;
        for (int i = 0; i < a.length; i++) {
            distance += Math.pow(a[i] - b[i], 2);
        }
        return Math.sqrt(distance);
    }
    
    private int majorityLabel(List<Integer> labels) {
        Map<Integer, Integer> labelCounts = new HashMap<Integer, Integer>();
        for (int label : labels) {
            if (labelCounts.containsKey(label)) {
                labelCounts.put(label, labelCounts.get(label) + 1);
            } else {
                labelCounts.put(label, 1);
            }
        }
        int majorityLabel = -1;
        int maxCount = -1;
        for (int label : labelCounts.keySet()) {
            int count = labelCounts.get(label);
            if (count > maxCount) {
                majorityLabel = label;
                maxCount = count;
            }
        }
        return majorityLabel;
    }
}
