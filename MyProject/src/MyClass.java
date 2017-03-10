public class MyClass
{

	public static void main(String[] args)
	{
		
	String Mystring = "vikas prajapati";
	int MystringLength = Mystring.length();
	String Mystringtolower = Mystring.toLowerCase();
	String Mystringtoupper = Mystring.toUpperCase();
	
	System.out.println(Mystring);
	System.out.println(MystringLength);
	System.out.println(Mystringtolower);
	System.out.println(Mystringtoupper);
	System.out.println(Mystring.replace('i','a'));
	System.out.println(Mystring.replace("vikas","subhash"));
	System.out.println(Mystring.indexOf('o'));
	System.out.println(Mystring.indexOf('m'));
	System.out.println(Mystring.indexOf('i'));
	System.out.println(Mystring.indexOf('v'));
	System.out.println(Mystring.lastIndexOf('i'));
	System.out.println(Mystring.lastIndexOf('a'));
	
	}

} 