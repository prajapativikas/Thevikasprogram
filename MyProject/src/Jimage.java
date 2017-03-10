import javax.swing.*;      
public class Jimage{    
Jimage()
{    
JFrame f=new JFrame("Button Example");     
//AbstractButton headerLabel = null;
//headerLabel.setText("image of html5"); 
JButton b=new JButton(new ImageIcon("C:\\Users\\lenovo\\Desktop\\html5.png","html5"));    
b.setBounds(100,100,150,60);  
f.add(b);    
f.setSize(300,400);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }         
 public static void main(String[] args)
 {    
    new Jimage();    
 }    
}  