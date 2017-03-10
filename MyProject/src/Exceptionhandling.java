/*class Exceptionhandling
{
	public static void main(String[] args) 
	{
		int a=10, ans=0;
		ans=a/0;
		System.out.println("Denominator not be zero");		
	}
}*/

/*class Exceptionhandling
	{
		public static void main(String[] args) 
		{
			int a=10, ans=0;
			try
			{
				ans=a/0;
			}
			catch (Exception v)  //(write anything letter inplace of v )
			{
				System.out.println("Denominator not be zero");
			}	
		}
}*/

import java.util.*;
class Exceptionhandling
{
public static void main(String[] args) 
{
int a, b, ans=0;
Scanner s=new Scanner(System.in);
System.out.println("Enter any two numbers: ");
try
{
	a=s.nextInt();
	b=s.nextInt();
	ans=a/b;
	System.out.println("Result: "+ans);
}
//catch(ArithmeticException ae)
//{
//System.out.println("Denominator not be zero");
//}	
catch(Exception e)
{
System.out.println("Enter valid number");
}	
}
}