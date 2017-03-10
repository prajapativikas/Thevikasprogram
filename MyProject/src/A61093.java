import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*; 
class Login5 extends JFrame implements ActionListener
{
 JButton SUBMIT;
 JPanel panel;
 JLabel label1,label2;
 JTextField  text1,text2;
 //final JTextField  text1,text2;
	Login5()
	{
	    label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);

		label2 = new JLabel();
		label2.setText("Password:");
	    text2 = new JPasswordField(15);
	    //this.setLayout(new BorderLayout());
 
		SUBMIT=new JButton("SUBMIT");
		
        panel=new JPanel(new GridLayout(3,1));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(SUBMIT);
		
		  //  add(panel,BorderLayout.PAGE_START);
		  //  add(panel,BorderLayout.PAGE_END);
		   // add(panel,BorderLayout.LINE_START);
		  //  add(panel,BorderLayout.LINE_END);

	    add(panel,BorderLayout.CENTER);
        SUBMIT.addActionListener((ActionListener) this);
        setTitle("LOGIN FORM");
	}
   public void actionPerformed(ActionEvent ae)
	{
		String value1=text1.getText();
		String value2=text2.getText();
        if (value1.equals("vikas") && value2.equals("61093")) {
		NextPage page=new NextPage();
		page.setVisible(true);
		JLabel label = new JLabel("Welcome: "+value1+ " "+ "prajapati");
        page.getContentPane().add(label);
	}
		else{
			System.out.println("enter the valid username and password");
			JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
	}
}
}
 public class A61093
{
	public static void main(String arg[])
	{
		try
		{
		Login5 frame=new Login5();
		frame.setSize(300,100);
		frame.setVisible(true);
		}
	catch(Exception e)
		{
		JOptionPane.showMessageDialog(null, e.getMessage());}
	}
}