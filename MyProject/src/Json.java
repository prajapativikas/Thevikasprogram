import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Json
{
    public static void main(String args[])
    {
        String jsonString = "{\"Name\":\"Javainterviewpoint\",\"Age\":\"100\"}";
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser
                    .parse(jsonString);
            
            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;
            
            //Reading the String
            String name = (String) jsonObject.get("Name");
            String age = (String) jsonObject.get("Age");
            
            //Printing the values
            
            System.out.println("Age: " + age);
            System.out.println("Name: " + name);
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}