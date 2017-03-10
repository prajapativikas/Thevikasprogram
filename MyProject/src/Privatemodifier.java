class Privatemodifier1   //example of public access modifier
{
public int a=20;  
//System.out.println(obj.a);  
public void show()
{
System.out.println("Hello java");
}  
}  
  
public class Privatemodifier
{  
 public static void main(String args[])
 {  
	 Privatemodifier1 obj=new Privatemodifier1();  
     System.out.println(obj.a);  
     obj.show();
 }
}