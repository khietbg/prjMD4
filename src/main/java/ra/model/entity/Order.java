package ra.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order {
    private int orderId;
    private int cartId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    private boolean orderStatus;
    private float totalAmount;
    private String feedback;

    public Order() {
    }

    public Order(int orderId, int cartId, Date orderDate, boolean orderStatus, float totalAmount, String feedback) {
        this.orderId = orderId;
        this.cartId = cartId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.feedback = feedback;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
