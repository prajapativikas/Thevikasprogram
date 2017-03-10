import javax.swing.*;
import java.awt.event.*;
public class A6101993 {
	private JFrame f = new JFrame("Login");
	private JButton bok = new JButton("OK");
	
	public A6101993() {
	
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.getContentPane().add(bok);
		
		bok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				
				f.dispose();
				new A1234();
		       //new Registration();
			}
		});
		f.setSize(100,100);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new A6101993();
	}
}