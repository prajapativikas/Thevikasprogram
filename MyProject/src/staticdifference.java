class staticdifference
	{
	public static void main(String args[])
		{
		display();
		staticdifference v=new staticdifference();  //(staticdifference=class name)
		v.show();
		}
	static void display()   // static method
	{
		System.out.println("programming is amazing (static method)");
	}
	
	void show()  // non static method
	{
		System.out.println("programming is awesome (non static method)");
	}
}