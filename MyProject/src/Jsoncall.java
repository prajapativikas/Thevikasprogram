import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Iterator;

public class Jsoncall {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("C://Users//lenovo//Desktop//java//3_2.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

          /*  String name = (String) jsonObject.get("subject_id");
            int[] subject_id = null;
			System.out.println(subject_id);

        //    long age = (Long) jsonObject.get("age");
          //  System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}