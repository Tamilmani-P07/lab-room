import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class OrdersDaoImpl implements OrdersDao {
    List<Orders> orderList = new ArrayList<Orders>();

    public OrdersDaoImpl() {
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
    }

    @Override
    public void getNumberofOrder() {

        System.out.println("Total Number Orders is : " + orderList.size());
    }

    @Override
    public void datewiseOrderCount() {

        ArrayList<String> bb = new ArrayList<String>();
        for (Orders t : orderList) {
            bb.add(t.getDate());
        }
        // System.out.println(bb);
        Set<String> ab = new TreeSet<String>(bb);
        for (String date1 : ab) {
            System.out.println(date1 + ":" + Collections.frequency(bb, date1));
        }

    }

    @Override
    public void dateAndCustomerwiseOrderCount() {

        ArrayList<String> dateList = new ArrayList<String>();
        for (Orders orders1 : orderList) {
            dateList.add(orders1.getDate());
        }
        Set<String> dateString = new HashSet<String>(dateList);
        for (String date1 : dateString) {
            ArrayList<Integer> custIdList = new ArrayList<Integer>();
            for (Orders orders1 : orderList) {
                if (orders1.getDate() == date1) {
                    custIdList.add(orders1.getCustomerId());
                }
            }
            Set<Integer> custString = new HashSet<Integer>(custIdList);
            for (int cust : custString) {
                System.out.println("On " + date1 + " CustomerID " + cust + " has "
                        + Collections.frequency(custIdList, cust) + " orders");
            }
        }
    }

    @Override
    public void freqCustomer() {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        int max = 0;
        int ans;
        for (Orders orders1 : orderList) {
            l1.add(orders1.getCustomerId());
        }
        for (Integer orders : l1) {
            l2.add(Collections.frequency(l1, orders));
        }
        max = Collections.max(l2);
        for (Integer integer : l1) {
            if (integer == max) {
                ans = l1.get(integer);
                System.out.println(" frequently visited customer CustomerId is : " + ans);
            }
        }
    }

    @Override
    public void topSaleProduct() {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        int max = 0;
        int ans;
        for (Orders orders1 : orderList) {
            l1.add(orders1.getProductId());
        }
        for (Integer orders : l1) {
            l2.add(Collections.frequency(l1, orders));
        }
        max = Collections.max(l2);
        for (Integer integer : l1) {
            if (integer == max) {
                ans = l1.get(integer);
                System.out.println(" top sale Product productId is : " + ans);
            }
        }

    }

    @Override
    public List<Orders> getAllOrderList() {

        return orderList;
    }

    @Override
    public void datewiseOrderCountMap() {
        Collections.sort(orderList, new OrderDateCompatator());
        HashMap<String, List<Orders>> map = new HashMap<String, List<Orders>>();

        for (Orders orders : orderList) {
            String key = orders.getDate();
            if (map.containsKey(key)) {
                List<Orders> list = map.get(key);
                list.add(orders);
            } else {
                List<Orders> list = new ArrayList<Orders>();
                list.add(orders);
                map.put(key, list);
            }
        }
        for (Map.Entry<String, List<Orders>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", count : " + entry.getValue().size());
        }

    }

}
