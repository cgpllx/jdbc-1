package com.stcds.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.stcds.dao.AlunoDAO;
import com.stcds.models.Aluno;

/**
 * Table to Show Students informations.
 * 
 * @author Samuel T. C. Santos
 *
 */
@SuppressWarnings("serial")
public class AlunoTable extends JDialog {

	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	
	public AlunoTable(){
		initComponents();
		setTitle("Lista de Alunos");
		
		table.setModel(model);
		scroll.setViewportView(table);
		add(scroll);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,400);
	}
	
	private void initComponents(){
		table = new JTable();
		//Columns Title
		String[] columns = new String[]{"Cpf","Nome","Idade", "Telefone", "Endereço"};
		String[][] data = new String[][]{};
		
		//Reading from database and fill the model
		List<Aluno> alunos = new ArrayList<Aluno>();
		AlunoDAO dao = new AlunoDAO();
		alunos = dao.getAll();
		
		model = new DefaultTableModel(data , columns );
		
		for (Aluno aluno : alunos){
			String [] line = new String[]{null,null,null,null,null};
			line[0] = aluno.getCpf();
			line[1] = aluno.getNome();
			line[2] = String.valueOf(aluno.getIdade());
			line[3] = aluno.getTelefone();
			line[4] = aluno.getEndereco();
			model.addRow(line);
		}
		
		scroll = new JScrollPane();
	}
}
