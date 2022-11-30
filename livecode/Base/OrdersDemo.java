import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OrdersDemo {
    public static void main(String[] args) {
        // OrdersDao ordersDao=new OrdersDaoImpl();

        // for (Orders orders : ordersDao.getAllOrderList()) {
        //     System.out.println(orders);
        // }
            //HASH MAP
        // HashMap<Integer, Orders> orders = new HashMap<Integer,Orders>();
        // orders.put(1, new Orders(10, "10-10-2022", 1, 1));
        // orders.put(2, new Orders(12, "11-10-2022", 3, 3));
        // orders.put(3, new Orders(13, "13-10-2022", 5, 2));
        // orders.put(4, new Orders(14, "14-10-2022", 1, 3));

        // for (Entry<Integer, Orders> st : orders.entrySet()) {
        //     System.out.println(st.getKey()+" : "+st.getValue());
        // }

       // ordersDao.getNumberofOrder();

        // ordersDao.datewiseOrderCount();

        // ordersDao.datewiseOrderCountMap();

        //ordersDao.freqCustomer();

        //ordersDao.topSaleProduct();

        //ordersDao.dateAndCustomerwiseOrderCount();

        List<Orders> orderList = new ArrayList<Orders>();
        Orders o1 = new Orders(10, "29-09-2020", 1, 1);
        Orders o2 = new Orders(11, "30-09-2022", 2, 1);
        Orders o3 = new Orders(12, "30-09-2020", 3, 2);
        Orders o4 = new Orders(13, "01-10-2022", 2, 1);
        Orders o5 = new Orders(14, "10-10-2022", 2, 3);
        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);
        orderList.add(o4);
        orderList.add(o5);

       long l1 = orderList.stream().count();
       System.out.println("Total Number of Orders is : "+l1);

       System.out.println("Total sales count is : "+l1); 

       //l1.add((Collections.frequency(orderList, )));
      // orderList.stream().filter(p->p.getCustomerId()==orderList.indexOf(orderList.max))

     System.out.println(orderList.stream().map(Orders::getDate));
     //orderList.stream().collect(Collectors.groupingBy(null, null))
        //, Collectors.counting()))max(Map.Entry.comparingByValue()).ifPresent(System.out::println);                           
    }
}
