package ra.model.service.userService;

import ra.model.dao.userDao.IUserDao;
import ra.model.dao.userDao.UserDaoIpm;
import ra.model.entity.User;
import ra.model.entity.UserLogin;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIpm implements IUserService{
    IUserDao userDao = new UserDaoIpm();


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(Integer integer) {
        return userDao.findById(integer);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(Integer integer) {
        return userDao.delete(integer);
    }

    @Override
    public boolean blockUser(int id) {
        return userDao.blockUser(id);
    }

    @Override
    public UserLogin checkLogin(String userName, String password) {
        return userDao.checkLogin(userName,password);

    }

    @Override
    public boolean changePass(int idC, String pass) {
        return userDao.changePass(idC,pass);
    }

    @Override
    public boolean updateUser(int idUp, String fullNameUp, String emailUp, String phoneUp, String addressUp) {
        return userDao.updateUser(idUp,fullNameUp,emailUp,phoneUp,addressUp);
    }
}
