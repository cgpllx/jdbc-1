package com.stcds.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Creating a connection with the Database.
 * 
 * @author Samuel T. C. Santos
 *
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
          "jdbc:mysql://127.0.0.1/stcds", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}