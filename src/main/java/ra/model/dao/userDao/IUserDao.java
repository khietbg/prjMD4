package ra.model.dao.userDao;

import ra.model.dao.IDao;
import ra.model.entity.Cart;
import ra.model.entity.User;
import ra.model.entity.UserLogin;

import java.util.List;

public interface IUserDao extends IDao<User,Integer> {
    boolean blockUser(int id);
    UserLogin checkLogin(String userName, String password);
    boolean changePass(int idC,String pass);
    boolean updateUser(int idUp,String fullNameUp,String emailUp,String phoneUp, String addressUp);
    User checkUserName(String userName);

}
