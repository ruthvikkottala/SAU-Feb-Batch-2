package assignment;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton ob=Singleton.getInstance();
		ob.s=(ob.s).toLowerCase();
		System.out.println("The resultant string is :"+ob.s);
	}

}
class Singleton 
{ 
    private static Singleton single_instance = null; 
     public String s; 
     private Singleton() 
    { 
        s = "THIS IS SINGLETON_CLASS"; 
    } 
  public static Singleton getInstance() 
    { 
      
        if (single_instance == null) 
            single_instance = new Singleton(); 
  
        return single_instance; 
    } 
} 