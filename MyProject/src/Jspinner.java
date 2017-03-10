import javax.swing.*;    
public class Jspinner
{  
    public static void main(String[] args)
    {    
    
    	JFrame f=new JFrame("Spinner Example");    
    	Number month = null;
		SpinnerModel value =  
             new SpinnerNumberModel(2010, //initial value  
                1990, //minimum value  
                2050, //maximum value  
                1); //step  
    	JSpinner spinner = new JSpinner(value);   
            spinner.setBounds(100,100,50,30);   
            
            
        	SpinnerModel value1 =  
                    new SpinnerNumberModel(5, //initial value  
                       1, //minimum value  
                       12, //maximum value  
                       1); //step  
           	JSpinner spinner1 = new JSpinner(value1);   
                   spinner1.setBounds(190,100,50,30); 
                   
               	SpinnerModel value2 =  
                        new SpinnerNumberModel(2, //initial value  
                          1, //minimum value  
                          7 , //maximum value  
                          1); //step  
               	JSpinner spinner2 = new JSpinner(value2);   
                       spinner2.setBounds(270,100,50,30);        
                   
                   
            f.add(spinner);  
            f.add(spinner1);
            f.add(spinner2);
            f.setSize(500,500);    
            f.setLayout(null);    
            f.setVisible(true); 
            f.setVisible(true);     
   }  
}  