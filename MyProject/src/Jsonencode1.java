import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONValue;

public class Jsonencode1 {
	public static void main(String args[]) {
		Map obj = new HashMap();
		obj.put("name", "sonoo");
		obj.put("age", new Integer(27));
		obj.put("salary", new Double(600000));
		System.out.print(obj);
		 
//		String jsonText = JSONValue.toJSONString(obj);
//		System.out.print(jsonText);
		 
	}
}
