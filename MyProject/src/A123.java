import javax.swing.*;
import java.awt.event.*;
public class A123 {
	private JFrame f = new JFrame("Login");
	private JButton bok = new JButton("OK");
	
	public A123() {
	
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.getContentPane().add(bok);
		
		bok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				f.dispose();
				new A1234();
		      // new Registration();
			}
		});
		f.setSize(100,100);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new A123();
	}
}