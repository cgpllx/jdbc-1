package com.stcds.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        Connection conexao = new ConnectionFactory().getConnection();
        
        System.out.println("Connection openned!");
        
        conexao.close();
    }
}