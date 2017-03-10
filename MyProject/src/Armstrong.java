import java.util.Scanner;
public class Armstrong 
{
	public static void main(String args[])  
	{
	  Scanner input = new Scanner(System.in);

      System.out.print("Enter a number: ");
      int n = input.nextInt();
      int t=n;
      int rev=0,i;
      while(n>0)
      {
       i=n%10;
       n=n/10;
       rev=rev+i*i*i;
      }

      if (t==rev)
    	  System.out.println("its an Armstrong number");  
      else
    	  System.out.println("its not a Armstrong number");
	} 
}
