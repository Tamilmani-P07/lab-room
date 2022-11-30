public class ExeEqual {
    public String name; 
    public int id; 
        
    public ExeEqual(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) 
    {
    if(this == obj) 
            return true; 
          
         
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
       
        ExeEqual ee = (ExeEqual) obj; 

        return (ee.name == this.name && ee.id == this.id); 
    } 
      
    @Override
    public int hashCode() 
    { 
          
       
        return this.id; 
    } 
    public static void main(String[] args) {
          ExeEqual g1 = new ExeEqual("Tamil", 1); 
          ExeEqual g2 = new ExeEqual("Tamil", 1); 
          ExeEqual g3=g1;
            
          if(g1.hashCode() == g2.hashCode()) 
          { 
    
              if(g1.equals(g2)) 
                  System.out.println("Both Objects are equal. "); 
              else
                  System.out.println("Both Objects are not equal. "); 
        
          } 
          else
          System.out.println("Both Objects are not equal. "); 

    }
}
