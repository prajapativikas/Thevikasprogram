import java.util.*; //note:The only difference between the methods nextLine() and next() is that nextLine() reads the entire line including white spaces, whereas next() reads only upto the first white space and then stops.
class Input5
{
  public static void main(String[] args)
  {
    Scanner s1 = new Scanner(System.in);
    System.out.println("Enter your name");
    String w = s1.nextLine();
    //String w = s1.next();
    System.out.println("Your name is " + w);
    System.out.println("Again enter your name");
    String st = s1.next();
    System.out.println("Your name is " + st);
  }
}