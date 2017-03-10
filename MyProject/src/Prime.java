import java.util.Scanner;
public class Prime
{
	public static void main(String args[])  
	{
	  Scanner input = new Scanner(System.in);

      System.out.print("Enter a number: ");
      int n = input.nextInt();
      int i;
    for(i=3;i<n;i++)
      {
    	
        if (n%i==0 && n%n==0)
         System.out.println("its not a Prime number");
        
    	    else
         System.out.println("its a Prime number");
        break;
      }
   
    }
}
