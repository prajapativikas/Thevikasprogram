import java.util.Scanner;
public class Palindrome 
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
       rev=rev*10+i;
      }
      System.out.println("the reverse number is "+ rev);
      if (t==rev)
    	  System.out.println("palindrome number");  
      else
    	  System.out.println("not a palindrome number");
	} 
}
