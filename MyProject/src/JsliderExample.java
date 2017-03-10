import javax.swing.*;  
public class JsliderExample extends JFrame
{  
	public JsliderExample() 
	{  
		//JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);  
		JSlider slider = new JSlider(JSlider.VERTICAL, 0, 70, 50);  
		JPanel panel=new JPanel();  
		panel.add(slider);  
		add(panel);  
	}  
  
		public static void main(String s[]) 	
		{  
			JsliderExample frame=new JsliderExample();  
			frame.pack();  
			frame.setVisible(true);  
        }  
} 