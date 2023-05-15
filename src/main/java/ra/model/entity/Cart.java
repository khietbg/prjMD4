package ra.model.entity;

import java.sql.Date;

public class Cart {
    private int cartId;
    private int userId;
    private int cartItemId;

    public Cart() {
    }

    public Cart(int cartId, int userId, int cartItemId) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartItemId = cartItemId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }
}
