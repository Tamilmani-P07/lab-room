public class Tam {
   void add(){
        System.out.println("add");
    }
     static void add(int a){
        System.out.println("add"+ a);
    }
    public static void main(String[] args) {
     //add();
     Tam a=new Tam();
     Tam b=new Mani();
     a.add();
     b.add();
    }
}
class Mani extends Tam{
void add(){
    System.out.println("add sub");
}
}
