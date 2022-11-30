/**
 * MainRunner
 */
public class MainRunner {

    public static void main(String[] args) {
        // Thread t1 = new ThreadCapital();
        // Thread t2 = new ThreadSmall();
        Thread t1=new Thread(){
            public void run(){
                Sample sample=new Sample();
                sample.printCap();
             }
        };
        Thread t2=new Thread(){
            public void run(){
                Sample sample=new Sample();
                sample.printSmall();
             }
        };
        Runnable rb=new MyRunnable(){
            public void run() {
                System.out.println("runnable");        
              }
        };
        Thread t3=new Thread(rb);
        System.out.println("main Thread Strat");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("main Thread end");
       
    }
}