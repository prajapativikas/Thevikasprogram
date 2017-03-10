import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculate extends JTextField {

  public static void main(String[] args) {
    JFrame f = new JFrame("Calculate");
    f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
    final JTextField  text1 = new JTextField(20);
  

    final JTextField text2 = new JTextField(20);
  

    JPanel panel = new JPanel();
    JButton button = new JButton("Calculate");
    panel.add(button);
    f.getContentPane().add(text1);
    f.getContentPane().add(panel);
    f.getContentPane().add(text2);
    
  ActionListener l = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        System.out.println("Action event from a text field");
      }
    };
    text1.addActionListener(l);
  text2.addActionListener(l);
  button.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent evt) {
  int a=Integer.parseInt(text1.getText()); 
  int sum = 0;
  int count=1;
  while(count<=a)
  {
    sum+=count;
    count++;
  }
    text2.setText(String.valueOf(sum));
  }
    });
    f.setSize(300,200);
    f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}