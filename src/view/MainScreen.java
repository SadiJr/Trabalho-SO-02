package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controll.Ctrl;

public class MainScreen extends JFrame {
	private JButton dificil;
	private JButton medio;
	private JButton facil;
	private JLabel jcomp4;
	
	private ActionListener l = new ActionListener() {
		public void actionPerformed(final ActionEvent e) {
			if (e.getSource().equals(facil)) {
				setVisible(false);
				Ctrl.getInstance().facil();
			} else if (e.getSource().equals(medio)) {
				setVisible(false);
				Ctrl.getInstance().medio();
			} else {
				setVisible(false);
				Ctrl.getInstance().dificil();
			}
			repaint();
		}
	};

	public MainScreen() {
		config();
	}

	private void config() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// construct components
		dificil = new JButton("Difícil");
		medio = new JButton("Médio");
		facil = new JButton("Fácil");
		jcomp4 = new JLabel("Escolha a dificuldade");

		// adjust size and set layout
		setPreferredSize(new Dimension(223, 270));
		setLayout(null);

		// add components
		add(dificil);
		add(medio);
		add(facil);
		add(jcomp4);

		// set component bounds (only needed by Absolute Positioning)
		dificil.setBounds(40, 200, 140, 20);
		medio.setBounds(40, 160, 140, 20);
		facil.setBounds(40, 110, 140, 20);
		jcomp4.setBounds(35, 30, 155, 35);
		
		facil.addActionListener(l);
		medio.addActionListener(l);
		dificil.addActionListener(l);
	}
}
