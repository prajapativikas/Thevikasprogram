// Hierarchical inheritance
class Polygon 
{
 int height=4;
 int breadth=5;
}
 
  class Rectangle extends Polygon
  {
	 int area() 
	 {
		 return height*breadth;
     } 
  }
  
  class Triangle extends Polygon
  {
	  int area() 
	  {
		  return (height*breadth)/2;
	  }
   }
  class Test1
   {
   public static void main(String[] args) 
   {
	Rectangle r=new Rectangle();
	Triangle t=new Triangle();
	System.out.println("Area of rectangle is "+r.area());
	System.out.println("Area of triangle is "+t.area());
   }
}
