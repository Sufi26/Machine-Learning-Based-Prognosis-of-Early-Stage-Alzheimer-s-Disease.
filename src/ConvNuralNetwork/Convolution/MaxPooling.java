/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConvNuralNetwork.Convolution;

import java.util.Arrays;

/**
 *
 * @author virendra
 */
public class MaxPooling {
  public static  int MaxPoolingMatVal =0;

public static int MaxpoolingResult(int[][] MaxpoolingMat)
        
{
MaxPoolingMatVal = findMax(MaxpoolingMat);
return MaxPoolingMatVal;
}
static int findMax(int mat[][])
    {
 
        // Initializing max element as INT_MIN
        int maxElement = Integer.MIN_VALUE;
 
        // checking each element of matrix
        // if it is greater than maxElement,
        // update maxElement
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (mat[i][j] > maxElement) {
                    maxElement = mat[i][j];
                }
            }
        }
 
        // finally return maxElement
        return maxElement;
    }
 
}
