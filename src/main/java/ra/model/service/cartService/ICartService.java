package ra.model.service.cartService;

import ra.model.entity.CartItem;

import ra.model.service.IService;

import java.util.List;

public interface ICartService extends IService<CartItem,Integer> {
   List<CartItem> findAllByUserLogin(int cartId);
   CartItem checkExistProduct(Integer proId,Integer cartId);
   void clearCartItem(int cartId);
   boolean checkOut(int orderID,float total,String phone,String address,int userId);

}
