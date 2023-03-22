package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    private Connection connection;

    public UserDaoJDBCImpl() {
        connection = new Util().getConnection();
    }

    public void createUsersTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE users (\n" +
                    "\tid INT auto_increment NOT NULL,\n" +
                    "\tname varchar(100) NULL,\n" +
                    "\tlastname varchar(100) NULL,\n" +
                    "\tage INT NULL,\n" +
                    "\tCONSTRAINT users_pk PRIMARY KEY (id)\n" +
                    ")\n" +
                    "ENGINE=InnoDB\n" +
                    "DEFAULT CHARSET=utf8mb3\n" +
                    "COLLATE=utf8mb3_general_ci;\n");
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Таблица уже существует!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("DROP TABLE users CASCADE");
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Таблица не существует!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        System.out.println("User с именем – " + name + " добавлен в базу данных ");
        String sql = "INSERT INTO mydbtest.users (name, lastName, age) VALUES(?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setByte(3, age);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * from users");
            while (rs.next()) {
                User user = new User(rs.getNString(2), rs.getNString(3), rs.getByte(4));
                user.setId(rs.getLong("id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("TRUNCATE mydbtest.users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

