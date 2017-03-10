import java.awt.*;  
import javax.swing.*;  
  
public class Jboxlayout extends Frame {  
 Button buttons[];  
  
 public Jboxlayout () {  
   buttons = new Button [5];  
    
   for (int i = 0;i<5;i++) {  
      buttons[i] = new Button ("Button " + (i + 1));  
      add (buttons[i]);  
    }  
  
//setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); 
//setLayout (new BoxLayout(this, BoxLayout.X_AXIS));
//setLayout (new BoxLayout(this, BoxLayout.LINE_AXIS));
  setLayout (new BoxLayout(this, BoxLayout.PAGE_AXIS));

setSize(400,400);  
setVisible(true);  
}  
  
public static void main(String args[]){

Jboxlayout b=new Jboxlayout();  
}  
}  