package com.stcds.views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Frame to register new Students in the Database.
 * 
 * @author Samuel T. C. Santos
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AlunoFrame extends JDialog {
	
	//Creating Text Fields
	private JTextField tfNome;
	private JTextField tfEnd;
	private JTextField tfCpf;
	private JTextField tfFone;
	private JTextField tfIdade;
	
	//Creating Label
	private JLabel lbNome;
	private JLabel lbEnd;
	private JLabel lbCpf;
	private JLabel lbFone;
	private JLabel lbIdade;
	
	//Creating a Panel
	private JPanel panel;
	
	//Creating a layout Manager
	private GridLayout layout;
	
	//Creating a border title
	private TitledBorder title;
	
	//Creating buttons
	private JButton btSalva;
	private JButton btCancela;
	
	public AlunoFrame(){
		initComponents();
		setTitle("Novo Aluno");
		panel.setBorder(title);
		panel.setLayout(layout);
		
		panel.add(lbNome);		
		panel.add(tfNome);
		panel.add(lbEnd);
		panel.add(tfEnd);
		panel.add(lbFone);
		panel.add(tfFone);
		panel.add(lbCpf);
		panel.add(tfCpf);
		panel.add(lbIdade);
		panel.add(tfIdade);
		panel.add(btCancela);
		panel.add(btSalva);
		
		panel.setBackground(Color.white);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,250);
		setResizable(false);
		
		add(panel);
	}
	
	private void initComponents(){
		layout = new GridLayout(6,2,3,3);
		panel = new JPanel();
		title = BorderFactory.createTitledBorder("Dados do Aluno");
		lbNome = new JLabel("Nome");
		tfNome = new JTextField();
		lbEnd = new JLabel("Endereço");
		tfEnd = new JTextField();
		lbFone = new JLabel("Telefone");
		tfFone = new JTextField();
		lbCpf = new JLabel("CPF");
		tfCpf = new JTextField();
		lbIdade = new JLabel("Idade");
		tfIdade = new JTextField();
		btSalva = new JButton("Salvar");
		btCancela = new JButton("Cancelar");
	}
}
