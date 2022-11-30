import java.util.*;
class CarTest{
    public static Scanner sc=new Scanner(System.in);
    static int i=sc.nextInt();
   static Car cars[]=new Car[i];
 
    public static void main(String[] args) {

        // for(int i=0;i<cars.length;i++){
        // System.out.println(cars[i].colour);
        // System.out.println(cars[i].price);

        // }
       // System.out.println(Arrays.toString(cars));
       create();
       display();
       System.out.println("Enter index position for delete");
       int indexDelete=sc.nextInt();
       delete(indexDelete);
       display();
       System.out.println("Enter values and index");
       String c=sc.next();
       String b=sc.next();
       int p=sc.nextInt();
       int i=sc.nextInt();
       update(c,b,p,i);
       display();
    
    }

    public static void display(){
       
        // Car c2=new Car("blue", "benz", 100000000l);
        // cars[0]=c1;
        // cars[1]=c2;
       // System.out.println("Calling display");
        System.out.println(Arrays.toString(cars));
    }
    public static void create(){
        
        // Car abc=new Car(c,b,p);
        // cars[i++]=abc;
        // Car c1=new Car("black", "BMW", 5000000l);
        // Car c2=new Car("blue", "benz", 100000000l);
        // 
        for(int j=0;j<i;j++){
            String c=sc.next();
            String b=sc.next();
            int p=sc.nextInt();
            cars[j]=new Car(c,b,p);
        }
    }
    public static void delete(int i){
        cars[i]=null;
    }
    public static void update(String c,String b,int l,int i){
       cars[i]=new Car(c, b, l);
    //    cars[i].brand=b;
    //    cars[i].colour=c;
    //    cars[i].price=l;
    }
}