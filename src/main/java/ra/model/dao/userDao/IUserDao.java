package ra.model.dao.userDao;

import ra.model.dao.IDao;
import ra.model.entity.User;
import ra.model.entity.UserLogin;

public interface IUserDao extends IDao<User,Integer> {
    boolean blockUser(int id);
    UserLogin checkLogin(String userName, String password);
}
