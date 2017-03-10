import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*; 
class Login extends JFrame implements ActionListener
{
 JButton SUBMIT;
 JPanel panel;
 JLabel label1,label2;
 final JTextField  text1,text2;
	Login()
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
	    add(panel,BorderLayout.CENTER);
        SUBMIT.addActionListener((ActionListener) this);
        setTitle("LOGIN FORM");
	}
   public void actionPerformed(ActionEvent ae)
	{
		String value1=text1.getText();
		String value2=text2.getText();
        if (value1.equals("vikas prajapati") && value2.equals("vikas.1993")) {
	    NextPage1 page=new NextPage1();
		page.setVisible(true);
		JLabel label = new JLabel("Welcome: "+value1);
        page.getContentPane().add(label);
	}
		else{
			System.out.println("enter the valid username and password");
			JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
	}
}
}
 public class Java
{
	public static void main(String arg[])
	{
		try
		{
		Login frame=new Login();
		frame.setSize(300,100);
		frame.setVisible(true);
		}
	catch(Exception e)
		{JOptionPane.showMessageDialog(null, e.getMessage());}
	}
}