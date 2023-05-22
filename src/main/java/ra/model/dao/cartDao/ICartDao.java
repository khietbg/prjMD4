package ra.model.dao.cartDao;

import ra.model.dao.IDao;
import ra.model.entity.CartItem;

import java.util.List;

public interface ICartDao extends IDao<CartItem,Integer> {
    List<CartItem> findAllByUserLogin(int cartId);
    CartItem checkExistProduct(Integer proId,Integer cartId);
    void clearCartItem(int cartId);
    int checkOut(int orderID,float total,String phone,String address,int userId);
}
