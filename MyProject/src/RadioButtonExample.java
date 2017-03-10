/*import javax.swing.*;    
public class RadioButtonExample 
{    
	JFrame f;    
	RadioButtonExample()
	{    
		f=new JFrame();     
		JRadioButton r1=new JRadioButton("A) Male");    
		JRadioButton r2=new JRadioButton("B) Female");    
		r1.setBounds(75,50,100,30);    
		r2.setBounds(75,100,100,30);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);    
		f.add(r1);f.add(r2);      
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);    
	}    
public static void main(String[] args) 	
	{    
    	new RadioButtonExample();    
	}    
} //only radio button  */

import javax.swing.*;    
import java.awt.event.*;    
class RadioButtonExample extends JFrame implements ActionListener{    
JRadioButton rb1,rb2;    
JButton b;    
RadioButtonExample()
{     
	//JLabel l1 = new JLabel("Name:");
	JLabel l2 = new JLabel("Gender");
	rb1=new JRadioButton("Male");    
	rb1.setBounds(100,50,100,30);      
	rb2=new JRadioButton("Female");    
	rb2.setBounds(100,100,100,30);    
	ButtonGroup bg=new ButtonGroup();    
	bg.add(rb1);bg.add(rb2); 
	b=new JButton("click");    
	b.setBounds(100,150,80,30);    
	b.addActionListener(this); 
	rb1.setBounds(100,50,100,30);
	rb2.setBounds(100,100,100,30);
	//l1.setBounds(100, 5, 200, 30);
	l2.setBounds(100, 25, 200, 30);
	
	 //add (l1);
	 add (l2); add(rb1);add(rb2);add(b);    
	setSize(300,300);    
	setLayout(null);    
	setVisible(true);    
}    
public void actionPerformed(ActionEvent e){    
if(rb1.isSelected()){    
JOptionPane.showMessageDialog(this,"You are Male.");    
}    
if(rb2.isSelected()){    
JOptionPane.showMessageDialog(this,"You are Female.");    
}    
}    
public static void main(String args[]){    
new RadioButtonExample();    
}}  