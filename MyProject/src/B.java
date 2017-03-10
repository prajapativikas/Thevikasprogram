
class B
{  
 public static void main(String args[])
 {  
  A obj = new A(); //Compile Time Error, can't access outside the package
  obj.show();   //Compile Time Error, can't access outside the package  
 }  
} 
