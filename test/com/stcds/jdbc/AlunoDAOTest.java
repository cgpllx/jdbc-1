package com.stcds.jdbc;

import java.util.ArrayList;
import java.util.List;

import com.stcds.dao.AlunoDAO;
import com.stcds.models.Aluno;

/**
 * Testing the AlunoDAO class.
 * 
 * @author Samuel T. C. Santos
 * @version 1.0
 *
 */
public class AlunoDAOTest {

	public static void main(String[] args) {
		lista();
	}
	
	private static void lista(){
		//Creating a new Object Aluno
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		//Creating a new Object AlunoDAO
		AlunoDAO dao = new AlunoDAO();
		
		alunos = dao.getAll();
		
		for (Aluno aluno: alunos){
			System.out.print(aluno.getCpf());
			System.out.print(" " + aluno.getIdade());
			System.out.println(" " + aluno.getNome());
		}
	}
	
	private static void adiciona(){
		//Creating a new Object Aluno
		Aluno aluno = new Aluno();
		
		aluno.setNome("Jessica");
		aluno.setCpf("111.220.333.58");
		aluno.setEndereco("Av. Inacio Dias, 105");
		aluno.setTelefone("0(88) 9478-9885");
		aluno.setIdade(21);
		
		//Creating a new Object AlunoDAO
		AlunoDAO dao = new AlunoDAO();
		
		//Saving the Student in the database
		dao.save(aluno);
	}
}
