public abstract class TypesC {
    abstract void run();
    public static void main(String[] args) {
        
    TypesC tc = new TypesC() {
        void run() {
            System.out.println("-------run run-------");
        }
    };

    tc.run();
}
}
