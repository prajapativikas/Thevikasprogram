class Thiskeyword
{  
  int id;  
  String name;  
    
 //Thiskeyword(int id,String name)
 // {  
  //id = id;           
  //name = name; */ // without using "this" keyword
	  
  //this.id=id;
	  //this.name=name;  // using "this" keyword
 //}
  
  Thiskeyword(int i,String n)
  {  
   id = i;           
   name = n;  // when no need of "this" keyword

  } 
  
  
 void show() 
 {
  System.out.println(id+" "+name);
 } 
  public static void main(String args[])
  {  
	  Thiskeyword e1 = new Thiskeyword(111,"Harry");  
	  Thiskeyword e2 = new Thiskeyword(112,"Jacy");  
   e1.show();
   e2.show();
  }  
}
