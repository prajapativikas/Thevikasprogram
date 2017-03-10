class Staticdemo
{
	
	
	
	public static void main(String args[])
	{
	System.out.println("This is main()");
	} 

/*note	(Static block is a set of statements, which will be executed by the JVM before execution of main method.

	At the time of class loading if we want to perform any activity we have to define that activity inside static block because this block execute at the time of class loading.

	In a class we can take any number of static block but all these blocks will be execute from top to bottom.)*/
	
	
	static
	{
		System.out.println("Second Static block");
	}   
	
	
	static
	{
		System.out.println("First static block");
	}


}