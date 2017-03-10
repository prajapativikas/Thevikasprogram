import javax.swing.*;  
public class JsliderExample1 extends JFrame
{  
	public JsliderExample1() 
	{  
		//JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);  
		JSlider slider = new JSlider(JSlider.VERTICAL, 0, 50, 25);
		slider.setMinorTickSpacing(2);  
		slider.setMajorTickSpacing(15);  
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true);  
  
			JPanel panel=new JPanel();  
			panel.add(slider);  
			add(panel);  
	}  
	public static void main(String s[])
		{  
		JsliderExample1 frame=new JsliderExample1();  
		frame.pack();  
		frame.setVisible(true);  
		}  
}  
