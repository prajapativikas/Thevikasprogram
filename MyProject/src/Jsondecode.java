import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Jsondecode {
	public static void main(String args[]) {
		String JSONObjectString = "{\"name\":\"Neeraj Mishra\"}";
		String JSONArrayString = "[\"C\",\"C++\",\"Java\"]";

		JSONObject obj = (JSONObject) JSONValue.parse(JSONObjectString);
		JSONArray ar = (JSONArray) JSONValue.parse(JSONArrayString);

		System.out.println(obj);
		System.out.println(ar);

	}
}