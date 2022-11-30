import java.util.List;

public interface OrderDao {
    public void createOrderDetails(OrderDetail orderDetail);
    public void updateOrderDetails(OrderDetail orderDetail,Long orderid);
    public void deleteOrderDetails(long orderid);
    public List<OrderDetail> getAllOrderList();
    public OrderDetail getOrderList(long orderid);
}
