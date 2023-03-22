package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    // реализуйте настройку соеденения с БД
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USER = "root";
    private final String PASSWORD = "root";


    public Connection getConnection() {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Ошибка соединения с БД");
        }
        return con;
    }
}
