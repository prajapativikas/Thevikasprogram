import java.applet.*;  
import java.awt.*;  
import java.awt.event.*;  
public class EventApplet extends Applet implements ActionListener
{  
	Button b;  
	TextField tf;  
  
	public void init()
		{  
			tf=new TextField();  
			tf.setBounds(30,60,100,30);  
  
			b=new Button("Click");  
			b.setBounds(80,150,60,50);  
  
			add(b);add(tf);  
			b.addActionListener(this);  
  
			setLayout(null);  
		}  
  
	public void actionPerformed(ActionEvent e)
	{  
		tf.setText("vikas prajapati");  
	}   
}  