import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.*;  
public class Jspinner1 {  
    public static void main(String[] args) {    
      	JFrame f=new JFrame("Spinner Example1");    
    	SpinnerModel value =  
             new SpinnerNumberModel(10, //initial value  
                -10, //minimum value  
                10, //maximum value  
                5); //step  
    	JSpinner spinner = new JSpinner(value);   
            spinner.setBounds(100,100,50,30);    
            f.add(spinner);    
            f.setSize(300,300);    
            f.setLayout(null);    
            f.setVisible(true);     
            /*spinner.addChangeListener(new ChangeListener() {  
       		public void stateChanged(ChangeEvent e) {  
         label.setText("Value : " + ((Jspinner1)e.getSource()).getValue());  
        }  
     });  */
}  
}  