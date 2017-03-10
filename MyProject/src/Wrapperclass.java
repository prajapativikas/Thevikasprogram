class Wrapperclass
	{
		public static void main(String[] args)
		{
			String  s[] = {"10", "20"};
			System.out.println("before Sum : "+ s[0] +     s[1]); // 1020
			int x=Integer.parseInt(s[0]); // convert String to Integer
			int y=Integer.parseInt(s[1]); // convert String to Integer
			int z=x+y;
			System.out.println("after sum : "+z); // 30
		}
}