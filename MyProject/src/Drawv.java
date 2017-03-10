public class Drawv
  {
	  public static void main(String[] args) 
	  {
		 
		int height=5;
		int rowLen = (height-1)*2;

    for(int i=0; i<height; i++)
		{
			int start = i;
			int end = rowLen-i;
			for(int j=0;j<=rowLen; j++)
				{
				if(j==end)
					{
					System.out.println("v");
					break;
					}
            else if(j==start)
						{
							System.out.print("v");
						}
						else
							{
								System.out.print(" ");
						    }		
				}
		}
    } 
}