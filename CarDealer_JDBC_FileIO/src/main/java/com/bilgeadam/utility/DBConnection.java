package com.bilgeadam.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Constant.DbURL, Constant.USERNAME, Constant.PASSWORD);
            System.out.println("Connected to PostgreSQL server successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
