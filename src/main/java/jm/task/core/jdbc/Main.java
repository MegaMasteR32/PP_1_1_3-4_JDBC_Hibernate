package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Петр", "Петров", (byte) 45);
        user.saveUser("Максим", "Максимов", (byte) 15);
        user.saveUser("Иван", "Иванов", (byte) 20);
        user.saveUser("Вова", "Сидоров", (byte) 67);
        System.out.println(user.getAllUsers());

        user.cleanUsersTable();
        user.dropUsersTable();
    }
}

