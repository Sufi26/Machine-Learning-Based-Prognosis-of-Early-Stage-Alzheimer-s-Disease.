/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConvNuralNetwork.Convolution.POJO;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author virendra
 */
public class JAVABeans {
      public static Vector<Integer> FlatternList = new Vector<Integer>();

    public static Vector<Integer> getFlatternList() {
        return FlatternList;
    }

    public static void setFlatternList(Vector<Integer> FlatternList) {
        JAVABeans.FlatternList = FlatternList;
    }
    public static ArrayList<String> SIFTFeatures;
    public static int[] LBPFeatures;
    public static Vector<Integer> CNNFeatures;

    public static ArrayList<String> getSIFTFeatures() {
        return SIFTFeatures;
    }

    public static void setSIFTFeatures(ArrayList<String> SIFTFeatures) {
        JAVABeans.SIFTFeatures = SIFTFeatures;
    }

    public static int[] getLBPFeatures() {
        return LBPFeatures;
    }

    public static void setLBPFeatures(int[] LBPFeatures) {
        JAVABeans.LBPFeatures = LBPFeatures;
    }

    public static Vector<Integer> getCNNFeatures() {
        return CNNFeatures;
    }

    public static void setCNNFeatures(Vector<Integer> CNNFeatures) {
        JAVABeans.CNNFeatures = CNNFeatures;
    }

   
}
