/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConvNuralNetwork.Convolution;

import ConvNuralNetwork.Convolution.Kernals.Kernals;
import ConvNuralNetwork.Convolution.POJO.JAVABeans;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;

/**
 *
 * @author virendra
 */
public class convolution {
    public static Vector<Integer> GenerateConvMatrix(String path)
    {
        JAVABeans.setFlatternList(new Vector<Integer>());
        try
        {
         int k=0,l = 0;       
         int temp1=3,temp2 =3;
        int temp=0;
    BufferedImage image = ImageIO.read(new File(path));
            for (int i = 0; i < image.getHeight()-3; i++) {
                for (int j = 0; j < image.getWidth()-3; j++) {
                     int[][] Matrixconv = new int[3][3]; 
                    for (int m = i; m < temp1; m++) {
                        for (int n = j; n < temp2; n++) {
                            int pixel = image.getRGB(n, m);
                            Color color = new Color(pixel);
                            if(color.getRed() > 128)
                               temp = 1;
                            else
                              temp = 0;
                             Matrixconv[k][l] = temp; 
                            l++;
                        }
                        k++;
                        l=0;
                    }
                    GenerateFeatureMap(Matrixconv);
                    k=l=0;
                    temp2++;
                }
                temp2 = 3;
                temp1++;
            }
     System.out.println("Array Size"
             + ": "+JAVABeans.getFlatternList().size());
//            for (int i = 0; i < JAVABeans.getFlatternList().size(); i++) {
//                int a= JAVABeans.getFlatternList().elementAt(i);
//               
//                 System.out.println(a);
//            }
    
        }
        catch(IOException ex)
        {
        
        System.out.println(ex);
        }
        
        return JAVABeans.getFlatternList();
        
        }
    
    public static void main(String a[])
    {
    
   // GenerateConvMatrix();
    }

    
    
    private static int[][] GenerateFeatureMap(int[][] Matrixconv) {
        int a[][]=Matrixconv;    
int b[][]=Kernals.Kernl;    
    int[][] MaxPoolingMat= new int[2][2]; 
        
        
        int FeatureMap[][]=new int[3][3];  //3 rows and 3 columns  
    
//multiplying and printing multiplication of 2 matrices    
for(int i=0;i<3;i++){    
for(int j=0;j<3;j++){    
FeatureMap[i][j]=0;      
for(int k=0;k<3;k++)      
{      
FeatureMap[i][j]+=a[i][k]*b[k][j];      
}//end of k loop  
int temp = FeatureMap[i][j];
int RelVal = ReluActivation.ActivationFunction(temp);
FeatureMap[i][j]=RelVal;
if(i < 2 && j < 2)
{
    MaxPoolingMat[i][j] = RelVal;
//System.out.print(MaxPoolingMat[i][j]+" ");  //printing matrix element  
}
}//end of j loop  
//System.out.println();//new line    
}
int MaxPoolVal = MaxPooling.MaxpoolingResult(MaxPoolingMat);
Flatterning.FlatternMat(MaxPoolVal);
return MaxPoolingMat;
}

}  
    


