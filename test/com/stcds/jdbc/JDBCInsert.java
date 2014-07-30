package com.stcds.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Insert into table
 * 
 * @author Samuel T. C. Santos
 *
 */
public class JDBCInsert {

	public static void main(String[] args) throws SQLException {
		//open a connection
        Connection con = new ConnectionFactory().getConnection();

        // creating a preparedStatement
        String sql = "insert into aluno " +
                " (nome,cpf,telefone,endereco,idade)" +
                " values (?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);

        // fill the values
        stmt.setString(1, "Samara");
        stmt.setString(2, "123.456.987.22");
        stmt.setString(3, "8888-8989");
        stmt.setString(4, "R. Jose Amorim, 998");
        stmt.setInt(5, 26);
        
        // execute
        stmt.execute();
        stmt.close();

        System.out.println("Gravado!");

        con.close();
	}
}
