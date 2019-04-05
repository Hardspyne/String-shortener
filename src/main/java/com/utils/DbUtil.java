package com.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static Connection dbConnection;

    public static Connection getDbConnection() {
        if (dbConnection != null) {
            return dbConnection;
        }

        Properties properties = new Properties();
        try {
            properties.load(DbUtil.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            dbConnection = DriverManager.getConnection(url + "?user=" + user + "&password=" + password +
                    "&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dbConnection;
    }

}
