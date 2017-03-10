import java.util.Random;
public class RandomIntegers1
 {
  public static void main(String[]args)
  {
   Random randomNumbers=new Random();
   int face;
   
   for(int counter=1; counter<=24;counter++)
   {
    face=1+randomNumbers.nextInt(6);
	System.out.printf(" %d ",face);
	
	if (counter%2==0)
	System.out.println();
	
   }
 
  }

 }
