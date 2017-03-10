import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

class Json1{

   public static void main(String[] args){
      JSONObject obj = new JSONObject();
   
      
      obj.put("balance", new Integer(1000));
      obj.put("name", "foo");
      obj.put("num", new Double(100));
   //   obj.put("balance", new Double(1000.21));
    // obj.put("is_vip", new Boolean(false));

      System.out.println(obj);
      System.out.print(obj);

      System.out.println(obj);
 
      }
}