import javax.swing.*;  
public class Optionpane1 
{  
	JFrame f;  
	Optionpane1(){  
    f=new JFrame();   
    String name=JOptionPane.showInputDialog(f,"Enter Name");      
}  
	public static void main(String[] args) 	
	{  
		new Optionpane1();  
	}  
}  