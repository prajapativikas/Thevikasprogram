/*import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeExample {
  public static void main(String[] args) {
    LocalDateTime  now = LocalDateTime.now(); 
    System.out.println(now.get(ChronoField.YEAR)); 
    System.out.println(now.get(ChronoField.MONTH_OF_YEAR)); 
    System.out.println(now.get(ChronoField.DAY_OF_MONTH)); 
    System.out.println(now.get(ChronoField.HOUR_OF_DAY));
    System.out.println(now.get(ChronoField.HOUR_OF_AMPM)); 
    System.out.println(now.get(ChronoField.AMPM_OF_DAY));

  }
}
*/
import java.time.LocalDateTime;  
import java.time.temporal.ChronoField;  
public class LocalDateTimeExample
{  
  public static void main(String[] args)
  {  
    LocalDateTime a = LocalDateTime.of(2017, 2, 14, 15, 56);    
    System.out.println(a.get(ChronoField.DAY_OF_WEEK)); // (14 days=2 week)
    System.out.println(a.get(ChronoField.DAY_OF_YEAR));  //(given 45 days in year 2017)
    System.out.println(a.get(ChronoField.DAY_OF_MONTH)); // (14 days of months)
    System.out.println(a.get(ChronoField.HOUR_OF_DAY));  
    System.out.println(a.get(ChronoField.MINUTE_OF_DAY));   
  }  
} 
