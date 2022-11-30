

public class Orders {
    private long orderId;
    private String date;
    private int productId;
    private int customerId;
    
    public Orders(long orderId, String date, int productId, int customerId) {
        this.orderId = orderId;
        this.date = date;
        this.productId = productId;
        this.customerId = customerId;
    }
    public String toString(){
        return "[ orderId "+orderId+" ,date "+date+" ,productId "+productId+" ,customerId "+customerId+" ]";
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
}
