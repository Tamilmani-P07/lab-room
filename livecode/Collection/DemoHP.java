import java.util.HashMap;
import java.util.Map.Entry;

/**
 * DemoHP
 */
public class DemoHP {

    public static void main(String[] args) {
        HashMap<Integer, String> vi = new HashMap<Integer,String>();
        vi.put(1, "car");
        vi.put(2, "Bike");
        vi.put(3, "bus");
        vi.put(4, "train");

        
           System.out.println("Key : "+vi.keySet()+"Value : "+ vi.values());
           System.out.println();
           for (Entry<Integer, String> v : vi.entrySet()) {
            System.out.println("Key : "+v.getKey()+" - Value : "+ v.getValue());
        }
    }
}