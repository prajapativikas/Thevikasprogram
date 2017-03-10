public class Teacher 
   {
    String name;
    int age;
    static int noofteachers=0;
    
 Teacher()
   {
	 noofteachers++;
   }
 public static int getnoofteachers()
     {
	 return noofteachers;
      }

 public String getname()
   {
	 return name;
   }
 
   }