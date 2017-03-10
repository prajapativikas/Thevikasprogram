import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*; 
import java.io.File;
class Login4 extends JFrame implements ActionListener
{
 JButton SUBMIT;
 JPanel panel;
 JLabel label1,label2;
 JTextField  text1,text2;
 //final JTextField  text1,text2;
 JFileChooser chooser = new JFileChooser();
	Login4()
	{
	    label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);

		label2 = new JLabel();
		label2.setText("Password:");
	    text2 = new JPasswordField(15);
	    //this.setLayout(new BorderLayout());
 
		SUBMIT=new JButton("SUBMIT");
		
        panel=new JPanel(new GridLayout(3,2));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(SUBMIT);
	   // add(panel,BorderLayout.CENTER);
	  //  add(panel,BorderLayout.PAGE_START);
	  //  add(panel,BorderLayout.PAGE_END);
	    add(panel,BorderLayout.LINE_START);
	  //  add(panel,BorderLayout.LINE_END);
	   
	    
        SUBMIT.addActionListener((ActionListener) this);
        setTitle("LOGIN FORM");
   
	}
   public void actionPerformed(ActionEvent ae)
	{
		String value1=text1.getText();
		String value2=text2.getText();
        if (value1.equals("vikas prajapati") && value2.equals("61093")) {
		NextPage1 page=new NextPage1();
		page.setVisible(true);
		JLabel label = new JLabel("Welcome: "+value1);
        page.getContentPane().add(label);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame f = new JFrame("Document Viewer");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                final JFileChooser fileChooser = new JFileChooser();

                JPanel gui = new JPanel(new BorderLayout());

                final JEditorPane document = new JEditorPane();
                gui.add(new JScrollPane(document), BorderLayout.CENTER);

                JButton open = new JButton("click");
                open.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        int result = fileChooser.showOpenDialog(f);
                        if (result==JFileChooser.APPROVE_OPTION) {
                            File file = fileChooser.getSelectedFile();
                            try {
                                document.setPage(file.toURI().toURL());
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                gui.add(open, BorderLayout.NORTH);

                f.setContentPane(gui);
                f.pack();
                f.setSize(400,300);
                f.setLocationByPlatform(true);

                f.setVisible(true);
            }
        });   
	}
		else{
			System.out.println("enter the valid username and password");
			JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
	}
}
}
 public class Logindemo
{
	public static void main(String arg[])
	{
		try
		{
		Login4 frame=new Login4();
		frame.setSize(300,100);
		frame.setVisible(true);
		}
	catch(Exception e)
		{JOptionPane.showMessageDialog(null, e.getMessage());}
	}
}