package ra.model.service.userService;

import ra.model.entity.User;
import ra.model.service.IService;

public interface IUserService extends IService<User,Integer> {
    boolean blockUser(int id);
    User checkLogin(String userName,String password);
}
