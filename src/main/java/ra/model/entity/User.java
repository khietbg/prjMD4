package ra.model.entity;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private int age;
    private boolean sex;

    private String address;
    private String phone;
    private boolean role;
    private boolean userStatus;

    public User() {
    }

    public User(String userName, String password, String email, String fullName, int age, boolean sex, String address, String phone) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public User(int userId, String userName, String password, String email, String fullName, int age, boolean sex, String address, String phone, boolean role, boolean userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.userStatus = userStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
}
