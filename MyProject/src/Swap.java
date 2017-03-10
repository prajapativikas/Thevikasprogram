public class Swap
{
	public static void main(String args[])  
	{
		int a=5,b=4,temp;
		/*
		a=a^b;
		b=a^b;
		a=a^b;
		*/
		
		/*
		a=a+b;
		b=a-b;
		a=a-b;
		*/
		
		/*
		temp=a;
		a=b;
		b=temp;
		*/
		
		b=a+b-(a=b);
		
		System.out.println("value of a is "+a);
		System.out.println("value of b is "+b);
	}
}
