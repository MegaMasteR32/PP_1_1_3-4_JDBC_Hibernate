package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl user = new UserServiceImpl();
       // user.createUsersTable();
//        user.saveUser("Петр1", "Петров", (byte) 45);
//        user.saveUser("Максим1", "Максимов", (byte) 15);
//        user.saveUser("Иван1", "Иванов", (byte) 20);
//        user.saveUser("Вова1", "Сидоров", (byte) 67);
//        System.out.println(user.getAllUsers());
        user.removeUserById(5);
//        user.cleanUsersTable();
//        user.dropUsersTable();
    }
}

