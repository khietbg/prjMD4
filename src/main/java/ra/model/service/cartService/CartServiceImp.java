package ra.model.service.cartService;

import ra.model.dao.cartDao.CartDaoIpm;
import ra.model.dao.cartDao.ICartDao;
import ra.model.entity.CartItem;
import java.util.List;

public class CartServiceImp implements ICartService{
    ICartDao cartDao = new CartDaoIpm();

    @Override
    public List<CartItem> findAll() {
        return cartDao.findAll();
    }

    @Override
    public boolean save(CartItem cartItem) {
        return cartDao.save(cartItem);
    }

    @Override
    public CartItem findById(Integer integer) {
        return cartDao.findById(integer);
    }

    @Override
    public boolean update(CartItem cartItem) {
        return cartDao.update(cartItem);
    }

    @Override
    public boolean delete(Integer integer) {
        return cartDao.delete(integer);
    }

    @Override
    public List<CartItem> findAllByUserLogin(int cartId) {
        return cartDao.findAllByUserLogin(cartId);
    }

    @Override
    public CartItem checkExistProduct(Integer proId, Integer cartId) {
        return cartDao.checkExistProduct(proId,cartId);
    }

    @Override
    public void clearCartItem(int cartId) {
    }

    @Override
    public int checkOut(int orderID, float total, String phone, String address, int userId) {
        return cartDao.checkOut(orderID,total,phone,address,userId);
    }
}
