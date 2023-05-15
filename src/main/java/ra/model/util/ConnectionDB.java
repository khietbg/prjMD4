package ra.model.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/kingShoe";
    private static final String USER = "root";
    private static final String PASS = "Minhkhiet1";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASS);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        try {
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

