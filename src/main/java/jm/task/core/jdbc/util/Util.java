package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection con;
    public static Connection getConnection() {

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Ошибка соединения с БД");
        }
        return con;
    }

    public static void closeConnection(){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Ошибка закрытия коннекшена");
            }
        }
    }
}
