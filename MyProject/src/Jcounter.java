public class Jcounter{  
int count=0;//will get memory when instance is created  
  
Jcounter(){  
count++;  
System.out.println(count);  
}  
  
public static void main(String args[]){  
  
Jcounter c1=new Jcounter();  
Jcounter c2=new Jcounter();  
Jcounter c3=new Jcounter();  
  
 }  
}  