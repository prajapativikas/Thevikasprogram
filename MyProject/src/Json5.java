import org.json.simple.JSONArray;

public class Json5 {
	public static void main(String args[]) {
		JSONArray arr = new JSONArray();
		arr.add("sonoo");
		arr.add(new Integer(27));
		arr.add("vicky");
		arr.add(new Double(600000));
		System.out.print(arr);
	}
}
