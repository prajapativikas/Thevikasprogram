import java.lang.*;

public class Append {

   public static void main(String[] args) {
  
   StringBuilder str = new StringBuilder("vikas ");
   System.out.println("string = " + str);
    
   // appends the string argument to the StringBuilder
   str.append("prajapati");
   // print the StringBuilder after appending
   System.out.println("After append = " + str);
    
   str = new StringBuilder("mobile number");
   System.out.println("string = " + str);
   // appends the string argument to the StringBuilder 
   str.append(" 7575757575");
   // print the StringBuilder after appending
   System.out.println("After append = " + str);
   }
} 