import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
public class TextFieldExa {
	public static void main(String[] args) {
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	  
	    JFrame f = new JFrame("Text Field Examples");
	    f.getContentPane().setLayout(new FlowLayout());
	    f.getContentPane().add(new JTextField("Text field 1"));
	    f.getContentPane().add(new JTextField("Text field 2", 8));
	    JTextField t = new JTextField("Text field 3", 8);
	    t.setHorizontalAlignment(JTextField.RIGHT);
	    f.getContentPane().add(t);
	    t = new JTextField("Text field 4", 8);
	    t.setHorizontalAlignment(JTextField.CENTER);
	    f.getContentPane().add(t);
	    f.getContentPane().add(new JTextField("Text field 5", 3));

	    f.pack();
	    f.setVisible(true);
	  }
}
