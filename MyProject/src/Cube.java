//constructor
public class Cube
{
		int length;
		int breadth;
		int height;
		
		public int getCubevolume()
		{
			return(length*breadth*height);
		}
		
		Cube()
		{
		   //	System.out.println("we are in constructor");
			length=10;
			breadth=20;
			height=30;
		}
      Cube(int l,int b,int h)
       {
    	    length=l;
			breadth=b;
			height=h;
       }
      
	}

