import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
public class MyLogin {
	
	 JButton SUBMIT;
	 JPanel panel;
	 JLabel label1,label2;
	 final JTextField  text1,text2;
	private JFrame f = new JFrame("Login");
	private JButton bok = new JButton("OK");
	
	public MyLogin() {
	     
		   label1 = new JLabel();
			label1.setText("Username:");
			text1 = new JTextField(15);

			label2 = new JLabel();
			label2.setText("Password:");
		    text2 = new JPasswordField(15);
		    
			SUBMIT=new JButton("SUBMIT");
			
	        panel=new JPanel(new GridLayout(3,1));
			panel.add(label1);
			panel.add(text1);
			panel.add(label2);
			panel.add(text2);
			panel.add(SUBMIT);
		    add(panel,BorderLayout.CENTER);
	     //   SUBMIT.addActionListener((ActionListener) this);
	        setTitle("LOGIN FORM");
		    
		    
		    
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.getContentPane().add(bok);
		
	//	bok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new SecondFrame1();
			}
		});
		f.setSize(100,100);
		f.setVisible(true);
	}
	
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}

	private void add(JPanel panel2, String center) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new MyLogin();
	}
}
