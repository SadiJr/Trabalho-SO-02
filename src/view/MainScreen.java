package view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controll.Ctrl;
import sun.applet.Main;

public class MainScreen extends JFrame {
	private JLabel lbGuide;
	private JPanel panel;
	private JButton facil;
	private JButton medio;
	private JButton dificil;
	private ButtonManager btManager;
	
	public MainScreen() {
		super("Threads");
		btManager = new ButtonManager();
		config();
	}
	
	private void config() {
		Container container = getContentPane();
		GridBagConstraints cons = new GridBagConstraints();
		container.setLayout(new GridBagLayout());
		
		
		cons.fill = GridBagConstraints.BOTH; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 300);
		setLocationRelativeTo(null);
		setResizable(true);
		
		configButtons(cons, container);
	}
	
	private void configButtons(GridBagConstraints cons, Container container) {
		lbGuide = new JLabel("Escolha a dificuldade");
		cons.gridx = 0;  
        cons.gridy = 1;
		container.add(lbGuide, cons);
		
		facil = new JButton("Fácil");
		cons.gridx = 0;  
        cons.gridy = 2;
		container.add(facil, cons);
		facil.addActionListener(btManager);
		
		 medio = new JButton("Médio");
		cons.gridx = 0;  
        cons.gridy = 3;
		container.add(medio, cons);
		medio.addActionListener(btManager);
			
	      
		dificil= new JButton("Difícil");
		cons.gridx = 0;  
	    cons.gridy = 4;
        container.add(dificil, cons);
		dificil.addActionListener(btManager);
	}
	
	private class ButtonManager implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(facil)) {
				setVisible(false);
				Ctrl.getInstance().facil();
			} else if(e.getSource().equals(medio)) {
				setVisible(false);
				Ctrl.getInstance().medio();			
			} else {
				setVisible(false);
				Ctrl.getInstance().dificil();
			}
		}
	}
}
