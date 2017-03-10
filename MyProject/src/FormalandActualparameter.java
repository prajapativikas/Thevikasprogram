public class FormalandActualparameter {

 

    /**

     * Display the info name, course and grade

     */

    public void displayMethod (String name, String course, String grade){

        // A. Formal parameters are those defined in method declaration

         

        // Following are the formal parameters of this method

        // 1. formal parameter is name and type is String

        // 2. formal parameter is course and type is String

        // 3. formal parameter is grade and type is String

         

       System.out.println("Name : " + name); // Print details

        System.out.println("Course : " + course);

        System.out.println("Grade : " + grade);

    }

     
    public static void main(String[] args) {

        // local variables

        String studentName = "John";

        String studentcourse = "Java Programming Course";

        String studentGrade = "A";

         
    // Instantiate

        FormalandActualparameter parameters = new FormalandActualparameter();

         
     // B. Actual parameters are the parameters in the method call

         

        // Following are the actual parameters in the method call

         // 1. actual parameter: studentName
         // 2. actual parameter: studentCourse
         // 3. actual parameter: studentGrade
       

         

        parameters.displayMethod(studentName, studentcourse, studentGrade); // Method call

         

    }

}

