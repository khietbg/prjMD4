package ra.model.service.userService;

import ra.model.entity.User;
import ra.model.entity.UserLogin;
import ra.model.service.IService;

public interface IUserService extends IService<User,Integer> {
    boolean blockUser(int id);
    UserLogin checkLogin(String userName, String password);

}
