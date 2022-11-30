import java.util.List;

public interface OrdersDao {
    //public void createOrder(Orders orders);
    public void getNumberofOrder();
    public void datewiseOrderCount();
    public void dateAndCustomerwiseOrderCount();
    public void freqCustomer();
    public void topSaleProduct();
    public List<Orders> getAllOrderList();
    public void datewiseOrderCountMap();
}