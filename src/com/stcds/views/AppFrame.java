package com.stcds.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

/**
 * Main Frame for this application, this is the first
 * window opened when the program is loaded.
 * 
 * @author Samuel T. C. Santos
 * @version 1.0
 */

public class AppFrame implements Runnable, ActionListener {

  private JFrame frame;
  private JMenuBar menuBar;
  private JMenu fileMenu;
 
  private JMenuItem addMenuItem;
  private JMenuItem listMenuItem;
  
  public static void main(String[] args)
  {
    // needed on mac os x
    System.setProperty("apple.laf.useScreenMenuBar", "true");
    // the proper way to show a jframe (invokeLater)
    SwingUtilities.invokeLater(new AppFrame());
  }
 
  public void run()
  {
    frame = new JFrame("STCD App");
    menuBar = new JMenuBar();
    
    // build the File menu
    fileMenu = new JMenu("File");
    addMenuItem = new JMenuItem("Adicionar Aluno");
    listMenuItem = new JMenuItem("Listar Alunos");
    
    addMenuItem.addActionListener(this);
    listMenuItem.addActionListener(this);
    
    fileMenu.add(addMenuItem);
    fileMenu.add(listMenuItem);
 
    // add menus to menubar
    menuBar.add(fileMenu);
   
    // put the menubar on the frame
    frame.setJMenuBar(menuBar);
 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
 
  /**
   * This handles the action for event, and demonstrates
   * the implementation of an ActionListener.
   * In a real-world program you'd handle this differently.
   */
  public void actionPerformed(ActionEvent ev)
  {
	  if (ev.getSource() == addMenuItem){
	    AlunoFrame dialog = new AlunoFrame();
	    dialog.setModal(true);
	    dialog.setVisible(true);
	  }
	  else if (ev.getSource() == listMenuItem){
		AlunoTable dialog = new AlunoTable();
		dialog.setModal(true);
		dialog.setVisible(true);
	  }
  }
 
  
}
