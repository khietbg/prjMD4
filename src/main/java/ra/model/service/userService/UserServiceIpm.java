package ra.model.service.userService;

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
    @Override
    public List<User> findAll() {
        List<User> users = null;
        Connection  conn = null;
        CallableStatement call = null;
        try{
            users = new ArrayList<>();
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call getAllUser()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("fullName"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getBoolean("sex"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getBoolean("roleId"));
                user.setUserStatus(rs.getBoolean("userStatus"));
                users.add(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return users;
    }

    @Override
    public boolean save(User user) {
        Connection conn = null;
        CallableStatement call = null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call createUser(?,?,?,?,?,?,?,?)}");
            call.setString(1,user.getUserName());
            call.setString(2,user.getPassword());
            call.setString(3,user.getEmail());
            call.setString(4,user.getFullName());
            call.setInt(5,user.getAge());
            call.setBoolean(6,user.isSex());
            call.setString(7,user.getAddress());
            call.setString(8,user.getPhone());
            int rs = call.executeUpdate();
            if (rs==1){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(Integer integer) {
        Connection conn = null;
        CallableStatement call= null;
        User user = null;
        try {
            conn = ConnectionDB.getConnection();
            call= conn.prepareCall("{call findUserById(?)}");
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("fullName"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getBoolean("sex"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getBoolean("roleId"));
                user.setUserStatus(rs.getBoolean("userStatus"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        Connection conn = null;
        CallableStatement call = null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call updateUser(?,?,?,?,?,?,?,?)}");
            call.setString(1,user.getPassword());
            call.setString(2,user.getEmail());
            call.setString(3,user.getFullName());
            call.setInt(4,user.getAge());
            call.setBoolean(5,user.isSex());
            call.setString(6,user.getAddress());
            call.setString(7,user.getPhone());
            call.setInt(8,user.getUserId());
            int rs = call.executeUpdate();
            if (rs==1){
                return true;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        Connection conn = null;
        CallableStatement call = null;
        try{
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call deleteUser(?)}");
            call.setInt(1,integer);
            int rs = call.executeUpdate();
            if (rs == 1){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean blockUser(int id) {
        Connection conn = null;
        CallableStatement call = null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call blockUser(?)}");
            call.setInt(1,id);
            int rs = call.executeUpdate();
            if (rs==1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public UserLogin checkLogin(String userName, String password) {
        Connection conn = null;
        UserLogin userLogin = null;
        CallableStatement call=null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call checkLogin(?,?)}");
            call.setString(1,userName);
            call.setString(2,password);
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                userLogin = new UserLogin();
                userLogin.setUserId(rs.getInt("userId"));
                userLogin.setUserName(rs.getString("userName"));
                userLogin.setPassword(rs.getString("password"));
                userLogin.setEmail(rs.getString("email"));
                userLogin.setFullName(rs.getString("fullName"));
                userLogin.setAge(rs.getInt("age"));
                userLogin.setSex(rs.getBoolean("sex"));
                userLogin.setAddress(rs.getString("address"));
                userLogin.setPhone(rs.getString("phone"));
                userLogin.setRole(rs.getBoolean("roleId"));
                userLogin.setUserStatus(rs.getBoolean("userStatus"));
                userLogin.setCartId(rs.getInt("orderId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userLogin;
    }



}
