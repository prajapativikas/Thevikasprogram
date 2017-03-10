import java.util.Scanner;
import java.util.*;

public class Pattern1 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter a number: ");
      int n = input.nextInt(); 

      for (int x = 0; x <= n; x++) {
         for (int y = n; y >= 1; y--) {
            if (y > x) {
               System.out.print("* ");
            }
            else
               System.out.print(" ");
         } 
         System.out.println(); 
      }      
   }
}