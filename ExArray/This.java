public class This {
    public static int a=10;
    //static int b;
   void ta(int a){
        a=a;
        System.out.println(a);
        System.out.println(this.a);
    }
   
    public static void main(String[] arg){
       This a=new This();
        //This b=new This(2,3);
       a.ta(4);
    }
}
