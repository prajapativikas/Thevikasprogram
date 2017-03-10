// Solution of multiple inheritance (Hybrid inheritance implementation using interfaces)
interface A
{
     public void methodA();
}
interface B extends A
{
     public void methodB();
}
interface C extends A
{
     public void methodC();
}
class D implements B, C
{
    public void methodA()
    {
         System.out.println("Method A");
    }
    public void methodB()
    {
         System.out.println("Method B");
    }
    public void methodC()
    {
         System.out.println("Method C");
    }
    public static void main(String args[])
    {
         D obj1= new D();
         obj1.methodA();
         obj1.methodB();
         obj1.methodC();
     }
}

