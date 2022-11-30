import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArList {
    public static void main(String[] args) {
        List <Integer>ar=new ArrayList<Integer>();
        List c=new ArrayList<Integer>();
        ar.add(2);
        System.out.println(ar);
        ar.clear();
        ar.add(45);
        ar.add(7);
        ar.add(5);
            System.out.println(ar);
        
        ar.add(2, 3);
            System.out.println(ar);
        
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(121);
        arr.addAll(ar);
        arr.add(111);
        System.out.println(arr);

        arr.addAll(3, ar);
        System.out.println(arr);
        System.out.println(arr.contains(121));
        System.out.println(arr.containsAll(ar));
        System.out.println(ar.get(3));
        System.out.println(arr.indexOf(7));
        System.out.println(c.isEmpty());
       // arr.removeIf(n -> (n == 5));
       // System.out.println(arr.removeIf(n -> (n ==0)));
       System.out.println(arr.removeIf(n -> (n == 54))); 

       System.out.println(arr.set(5, 6));
       System.out.println(arr);
       System.out.println(arr.subList(2, 7));
       
      Object[] a=arr.toArray();
       
        System.out.println(Arrays.toString(a));
    
        System.out.println(ar);
       
            

    }
}
