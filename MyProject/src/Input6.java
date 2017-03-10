import java.util.*;
class Input6
{
  public static void main(String[] args){
    Scanner s1 = new Scanner(System.in);
    int l,b;
    System.out.println("Enter length of rectangle");
    l = s1.nextInt();
    
    System.out.println("Enter breath of rectangle");
    b = s1.nextInt();
    
    System.out.println("Area of rectangle is "+ (l*b));
  }
}
