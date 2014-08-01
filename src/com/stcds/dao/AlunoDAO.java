package com.stcds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * Retrieve all Students on database
	 * 
	 * that means select * from ...
	 * 
	 * @return
	 */
	public List<Aluno> getAll(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from aluno");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
			    // Creating a object
			    Aluno aluno = new Aluno();
			    
			    aluno.setNome(rs.getString("nome"));
			    aluno.setEndereco(rs.getString("endereco"));
			    aluno.setIdade(Integer.valueOf(rs.getString("idade")));
			    aluno.setCpf(rs.getString("cpf"));
			    aluno.setTelefone(rs.getString("telefone"));

			    //adding object in the list
			    alunos.add(aluno);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return alunos;
	}
}
