import java.io.StringWriter;

 

public class Jstring1 {

 

    public static void main(String[] args) {

         

        String str1 = "Hello World";

        String str2 =" of JavaCodeGeeks";

         

        StringWriter outputWriter = new StringWriter();

        outputWriter.write(str1);

        
        System.out.println(outputWriter.toString());
        System.out.println(outputWriter.toString());

 

        outputWriter.write(str2);

         

     //   System.out.println(outputWriter.toString());

 

     //   outputWriter.append(" "+str1);
       
     //   outputWriter.append(" "+str2);

 
        System.out.println(outputWriter.toString());
      

    }

}
