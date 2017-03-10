public class Methodoverloading // (same method name but different parameter with same class name) 
{

	public static void main(String[] args) 
	{
	System.out.println(Add(5,6));
	System.out.println(Add(5.4,4.6));
	System.out.println(Add("vikas ","prajapati"));
		
    }
	
	public static int Add(int a, int b)
	{
		return (a+b);
		
	}
	
	public static double Add(double a, double b)
	{
		return (a+b);
		
	}
	
	public static String Add(String a, String b)
	{
		return (a+b);
		
	}
	


}
