/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConvNuralNetwork.Convolution;

import ConvNuralNetwork.Convolution.POJO.JAVABeans;
import java.util.Vector;

/**
 *
 * @author virendra
 */
public class Flatterning {
  
    public static void FlatternMat(int MaxPoolVal)
    {
        Vector<Integer> FlatternVector = JAVABeans.getFlatternList();
    FlatternVector.add(MaxPoolVal);
    JAVABeans.setFlatternList(FlatternVector);
    
    }
    
}
