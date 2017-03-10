import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
public class Logingmail extends Frame implements ActionListener
{
	String msg;
	Button b1=new Button("save");
	Label l11=new Label("Gmail sign in",Label.CENTER);
	Label l1=new Label("Name:",Label.LEFT);
	Label l2=new Label("choose your username(@gmail.com):",Label.LEFT);
	Label l3=new Label("create a password:",Label.LEFT);
	Label l4=new Label("confirm password:",Label.LEFT);
	Label l5=new Label("birthday",Label.LEFT);
	Label l6=new Label("Gender(M/F)",Label.LEFT);
	Label l7=new Label("Location",Label.LEFT);
	Label l8=new Label("",Label.RIGHT);
	TextField t1=new TextField();
	Choice c1=new Choice();
	CheckboxGroup cbg=new CheckboxGroup();
	Checkbox ck1=new Checkbox("Male",false,cbg);
	Checkbox ck2=new Checkbox("Female",false,cbg);
	TextArea t2=new TextArea("",180,90,TextArea.SCROLLBARS_VERTICAL_ONLY);
  	Choice bithday=new Choice();
  	Choice Location=new Choice();
  	Choice age=new Choice();
  		public Logingmail()
  		{
  			addWindowListener(new myWindowAdapter());
  			setBackground(Color.LIGHT_GRAY);
  			setForeground(Color.black);
  			setLayout(null);
  			add(l11);
  			add(l1);
  			add(l2);
  			add(l3);
  			add(l4);
  			add(l5);
  			add(l6);
  			add(l7);
  			add(t1);
  			add(t2);
  			add(ck1);
  			add(ck2);
  			add(bithday);
  			add(Location);
  			add(age);
  			add(b1);
  			b1.addActionListener(this);
  			add(b1);
  			bithday.add("1");
  			bithday.add("2");
  			bithday.add("3");
  			bithday.add("4");
  			bithday.add("5");
  			bithday.add("6");
  			bithday.add("7");
  			bithday.add("8");
  			bithday.add("9");
  			bithday.add("10");
  			bithday.add("11");
  			bithday.add("12");
  			Location.add("Ahmedabad");
  	  		Location.add("Mehsana");
  	  		Location.add("Gandhinagar");
  	  		Location.add("Surat");
  	  		Location.add("Rajkot");
  	  		Location.add("Bhavanagr");
  	  		Location.add("Patan");
  	  		Location.add("Palanpur");
  	  		age.add("19");
  	  		age.add("20");
  	  		age.add("21");
  	  		age.add("22");
  	  		age.add("23");
  	  	 l1.setBounds(25,65,90,20);
  	  	 l2.setBounds(25,90,90,20);
  	  	 l3.setBounds(25,120,90,20);
  	  	 l4.setBounds(25,185,90,20);
  	  	 l5.setBounds(25,260,90,20);
  	  	 l6.setBounds(25,290,90,20);
  	  	 l7.setBounds(25,260,90,20);
  	  	 l11.setBounds(10,40,280,20);
  	  	 t1.setBounds(120,65,170,20);
  	  	 t2.setBounds(120,185,170,60);
  	  	 ck1.setBounds(120,120,50,20);
  	  	 ck2.setBounds(170,120,60,20);
  	  	 bithday.setBounds(120,260,100,20);
  	  	 Location.setBounds(120,290,50,20);
  	  	 age.setBounds(120,90,50,20);
  	  	 b1.setBounds(120,350,50,30);
 
  		}
public void paint(Graphics g)
 {
	g.drawString(msg,200,450);
}
   public void actionPerformed(ActionEvent ae)
       {
	   if(ae.getActionCommand().equals("save"))
  {
		   msg="Student details saved!";
          setForeground(Color.GREEN); 
        }
}
public static void main(String g[])
	{
	Logingmail stu=new Logingmail();
	stu.setSize(new Dimension(500,500));
	stu.setTitle("student registration");
	stu.setVisible(true);
	}
}
