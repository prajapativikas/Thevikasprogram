class SuperKeyword1
	{
	float salary=10000;
	}
	class HR extends SuperKeyword1
	{
		float salary1=20000;
		void display() //static void display()
		{
			System.out.println("Salary: "+salary1);  //print current class salary1 (salary1 is the current class name)
			System.out.println("Salary: "+super.salary); //print base class salary	(salary is the base class name) 
		}
	}
	class SuperKeyword
	{
		public static void main(String[] args)
		{
		HR obj=new HR();
		obj.display();
			//display();
		}
	}