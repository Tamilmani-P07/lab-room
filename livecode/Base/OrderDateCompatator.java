import java.util.Comparator;

public class OrderDateCompatator implements Comparator<Orders>{


    @Override
    public int compare(Orders o1, Orders o2) {

        return o1.getDate().compareTo(o2.getDate());
        
    }

}
