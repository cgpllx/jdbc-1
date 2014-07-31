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

	public static void main(String[] args) {
    Connection con = null;
	try {
	 //open a connection
	   con = new ConnectionFactory().getConnection();
		  
	// creating a preparedStatement
	String sql = "insert into aluno " +
		                " (nome,cpf,telefone,endereco,idade)" +
		                " values (?,?,?,?,?)";
	PreparedStatement stmt = con.prepareStatement(sql);

	// fill the values
	stmt.setString(1, "Fernanda");
	stmt.setString(2, "103.486.887.00");
	stmt.setString(3, "5689-1415");
	stmt.setString(4, "R. Julio Leitao, 8074");
	stmt.setInt(5, 26);
		        
	// execute
	stmt.execute();
	stmt.close();

	System.out.println("Gravado!");
	}
	catch(SQLException e) {
	     e.printStackTrace();
	} finally {
	     try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}   

	}
}
