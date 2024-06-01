/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;
 import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
/**
 *
 * @author Codeft
 */
 
   
public class BarChart1 extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public BarChart1(String appTitle) {  
    super(appTitle);  
  
    // Create Dataset  
    CategoryDataset dataset = createDataset();  
      
    //Create chart  
    JFreeChart chart=ChartFactory.createBarChart(  
        "Alzhimer Chart ", //Chart Title  
        " Alzhimer Detection", // Category axis  
        " Percentage", // Value axis  
        dataset,  
        PlotOrientation.VERTICAL,  
        true,true,false  
       );  
  
    ChartPanel panel=new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private CategoryDataset createDataset() {  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
  
       
    dataset.addValue(88, "SIFT", "");  
    dataset.addValue(80, "CNN", "");  
    dataset.addValue(90, "LBP", "");  
    dataset.addValue(93.75, "KNN", "");  
    
    
    return dataset;  
  }  
  
  public static void main(String[] args) throws Exception {  
       
      barchart example=new   barchart("Bar Chart Window");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
   
  
  }  
}  
    

