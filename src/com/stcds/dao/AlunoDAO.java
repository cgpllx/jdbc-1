package com.stcds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stcds.jdbc.ConnectionFactory;
import com.stcds.models.Aluno;

/**
 * Using Data Access Object Pattern to save Student
 * 
 * @author Samuel T. C. Santos
 *
 */
public class AlunoDAO {
	
	private Connection con;
	
	public AlunoDAO(){
		con = new ConnectionFactory().getConnection();
	}
	
	/**
	 * Saving a new Student in the database.
	 * 
	 * @param aluno
	 */
	public void save(Aluno aluno){
		try {
			 //open a connection
			   con = new ConnectionFactory().getConnection();
				  
			// creating a preparedStatement
			String sql = "insert into aluno " +
				                " (nome,cpf,telefone,endereco,idade)" +
				                " values (?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			// fill the values
			stmt.setString(1,aluno.getNome());
			stmt.setString(2, aluno.getCpf());
			stmt.setString(3, aluno.getTelefone());
			stmt.setString(4, aluno.getEndereco());
			stmt.setInt(5, aluno.getIdade());
				        
			// execute
			stmt.execute();
			stmt.close();

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
