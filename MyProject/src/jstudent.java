import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
public class jstudent extends Frame implements ActionListener
{
	String msg;
	Button b1=new Button("save");
	Label l11=new Label("Student details",Label.CENTER);
	Label l1=new Label("Name:",Label.LEFT);
	Label l2=new Label("age:",Label.LEFT);
	Label l3=new Label("Sex(M/F):",Label.LEFT);
	Label l4=new Label("Address:",Label.LEFT);
	Label l5=new Label("Course:",Label.LEFT);
	Label l6=new Label("Semester:",Label.LEFT);
	Label l7=new Label("",Label.RIGHT);
	TextField t1=new TextField();
	Choice c1=new Choice();
	CheckboxGroup cbg=new CheckboxGroup();
	Checkbox ck1=new Checkbox("Male",false,cbg);
	Checkbox ck2=new Checkbox("Female",false,cbg);
	TextArea t2=new TextArea("",180,90,TextArea.SCROLLBARS_VERTICAL_ONLY);
  	Choice course=new Choice();
  	Choice sem=new Choice();
  	Choice age=new Choice();
  		public jstudent()
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
  			add(course);
  			add(sem);
  			add(age);
  			add(b1);
  			b1.addActionListener(this);
  			add(b1);
  			course.add("ec");
  			course.add("comp");
  			course.add("it");
  			course.add("civil");
  			course.add("electrical");
  			course.add("mechanical");
  			course.add("chemical");
  			course.add("biomedical");
  			course.add("textile");
  			course.add("plastic");
  			course.add("environment");
  			sem.add("1");
  	  		sem.add("2");
  	  		sem.add("3");
  	  		sem.add("4");
  	  		sem.add("5");
  	  		sem.add("6");
  	  		sem.add("7");
  	  		sem.add("8");
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
  	  	 course.setBounds(120,260,100,20);
  	  	 sem.setBounds(120,290,50,20);
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
	jstudent stu=new jstudent();
	stu.setSize(new Dimension(500,500));
	stu.setTitle("student registration");
	stu.setVisible(true);
	}
}
 class myWindowAdapter extends WindowAdapter
{
	 public void windowClosing(WindowEvent we)
 {
		 System.exit(0);
 }
}