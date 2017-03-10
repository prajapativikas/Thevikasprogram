import java.util.Scanner;
public class Perfect 
{
	public static void main(String args[])  
	{
	  Scanner input = new Scanner(System.in);

      System.out.print("Enter a number: ");
      int n = input.nextInt();
      int sum=0;
      
      for(int i=1;i<n;i++)
      {
    	  if(n%i==0)
          sum=sum+i;
    	
      }
      	if(n==sum)
      		System.out.print("the number is perfect number");
      	else
      		System.out.print("the number is not aperfect number");
}
}