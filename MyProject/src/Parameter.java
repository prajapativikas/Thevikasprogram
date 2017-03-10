public class Parameter 
{

	public static void main(String[] args) 
		{
		      parametermethod("vikas prajapati");
		      parametermethod("subhash prajapati");
		      parametermethod("natvar prajapati");
		      parametermethod(100,200);
		    
		    int sum = Add(100,200,300);
		    int result= sum*10;
		    System.out.println(sum);
		    System.out.print(result);
		 }

	         public static void parametermethod(String name)
			{
			 System.out.println("Hello "+ name);
			}
	         
			 public static void parametermethod(int a, int b)
			{
			 System.out.println(a+b);
			}
		
			 public static int Add(int a, int b,int c)
			{
			 return (a+b+c);
			}
			 
			
			
}
