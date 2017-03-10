import java.io.*;

public class Jstring {

   public static void main(String[] args) {
      String s = "Hello World";

      // create a new writer
      StringWriter sw = new StringWriter();

      // write strings
      sw.write(s, 0, 4);
      sw.write(s,5,3);
      sw.write(s, 6, 3);
     

      // print result by converting to string
      System.out.println(" " + sw.toString());

   }
}
