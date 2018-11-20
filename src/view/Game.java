package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controll.Ctrl;

public class Game extends JFrame {
	private JButton pos1;
	private JButton pos3;
	private JButton pos2;
	private JButton pos6;
	private JButton pos9;
	private JButton pos5;
	private JButton pos10;
	private JButton pos7;
	private JButton pos8;
	private JButton pos4;
	private JButton pos12;
	private JButton pos11;
	private JButton pos18;
	private JButton pos15;
	private JButton pos13;
	private JButton pos20;
	private JButton pos19;
	private JButton pos14;
	private JButton pos16;
	private JButton pos17;
	private JButton pos21;
	private JButton pos22;
	private JButton pos26;
	private JButton pos43;
	private JButton pos30;
	private JButton pos24;
	private JButton pos27;
	private JButton pos29;
	private JButton pos28;
	private JButton pos31;
	private JButton pos25;
	private JButton pos32;
	private JButton pos23;
	private JButton pos47;
	private JButton pos42;
	private JButton pos35;
	private JButton pos48;
	private JButton pos49;
	private JButton pos44;
	private JButton pos45;
	private JButton pos50;
	private JButton pos46;
	private JButton pos36;
	private JButton pos34;
	private JButton pos41;
	private JButton pos38;
	private JButton pos33;
	private JButton pos39;
	private JButton pos37;
	private JButton pos40;
	private JButton pos73;
	private JButton pos72;
	private JButton pos53;
	private JButton pos54;
	private JButton pos52;
	private JButton pos51;
	private JButton pos64;
	private JButton pos63;
	private JButton pos65;
	private JButton pos62;
	private JButton pos56;
	private JButton pos58;
	private JButton pos59;
	private JButton pos57;
	private JButton pos55;
	private JButton pos60;
	private JButton pos66;
	private JButton pos67;
	private JButton pos71;
	private JButton pos69;
	private JButton pos80;
	private JButton pos78;
	private JButton pos77;
	private JButton pos76;
	private JButton pos75;
	private JButton pos74;
	private JButton pos79;
	private JButton pos70;
	private JButton pos68;
	private JButton pos61;
	private JButton pos100;
	private JButton pos91;
	private JButton pos92;
	private JButton pos93;
	private JButton pos94;
	private JButton pos95;
	private JButton pos96;
	private JButton pos97;
	private JButton pos98;
	private JButton pos99;
	private JButton pos90;
	private JButton pos89;
	private JButton pos88;
	private JButton pos87;
	private JButton pos86;
	private JButton pos85;
	private JButton pos84;
	private JButton pos83;
	private JButton pos82;
	private JButton pos81;
	private JLabel jcomp101;
	private JLabel dificuldade;

	private ActionListener l = new ActionListener() {
		public void actionPerformed(final ActionEvent e) {
			Ctrl.getInstance().tratarClique((JButton) e.getSource());
			repaint();
		}
	};
	
	public Game() {
		config();
		addAction();
	}

	private void config() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Jogo das bolinhas");
		pos1 = new JButton();pos3 = new JButton();pos2 = new JButton();pos6 = new JButton();
		pos9 = new JButton();pos5 = new JButton();pos10 = new JButton();pos7 = new JButton();
		pos8 = new JButton();pos4 = new JButton();pos12 = new JButton();pos11 = new JButton();
		pos18 = new JButton();pos15 = new JButton();pos13 = new JButton();pos20 = new JButton();
		pos19 = new JButton();pos14 = new JButton();pos16 = new JButton();pos17 = new JButton();
		pos21 = new JButton();pos22 = new JButton();pos26 = new JButton();pos43 = new JButton();
		pos30 = new JButton();pos24 = new JButton();pos27 = new JButton();pos29 = new JButton();
		pos28 = new JButton();pos31 = new JButton();pos25 = new JButton();pos32 = new JButton();
		pos23 = new JButton();pos47 = new JButton();pos42 = new JButton();pos35 = new JButton();
		pos48 = new JButton();pos49 = new JButton();pos44 = new JButton();pos45 = new JButton();
		pos50 = new JButton();pos46 = new JButton();pos36 = new JButton();pos34 = new JButton();
		pos41 = new JButton();pos38 = new JButton();pos33 = new JButton();pos39 = new JButton();
		pos37 = new JButton();pos40 = new JButton();pos73 = new JButton();pos72 = new JButton();
		pos53 = new JButton();pos54 = new JButton();pos52 = new JButton();pos51 = new JButton();
		pos64 = new JButton();pos63 = new JButton();pos65 = new JButton();pos62 = new JButton();
		pos56 = new JButton();pos58 = new JButton();pos59 = new JButton();pos57 = new JButton();
		pos55 = new JButton();pos60 = new JButton();pos66 = new JButton();pos67 = new JButton();
		pos71 = new JButton();pos69 = new JButton();pos80 = new JButton();pos78 = new JButton();
		pos77 = new JButton();pos76 = new JButton();pos75 = new JButton();pos74 = new JButton();
		pos79 = new JButton();pos70 = new JButton();pos68 = new JButton();pos61 = new JButton();		
		pos100 = new JButton();pos91 = new JButton();pos92 = new JButton();	pos93 = new JButton();
		pos94 = new JButton();pos95 = new JButton();pos96 = new JButton();pos97 = new JButton();
		pos98 = new JButton();pos99 = new JButton();pos90 = new JButton();pos89 = new JButton();
		pos88 = new JButton();pos87 = new JButton();pos86 = new JButton();pos85 = new JButton();
		pos84 = new JButton();pos83 = new JButton();pos82 = new JButton();pos81 = new JButton();
		jcomp101 = new JLabel("Dificuldade Escolhida:");
		dificuldade = new JLabel("Dificuldade");

		// adjust size and set layout
		setPreferredSize(new Dimension(677, 570));
		setLayout(null);

		// add components
		add(pos1);add(pos3);add(pos2);add(pos6);add(pos9);add(pos5);add(pos10);add(pos7);add(pos8);
		add(pos4);add(pos12);add(pos11);add(pos18);add(pos15);add(pos13);add(pos20);add(pos19);add(pos14);
		add(pos16);add(pos17);add(pos21);add(pos22);add(pos26);add(pos43);add(pos30);add(pos24);add(pos27);
		add(pos29);add(pos28);add(pos31);add(pos25);add(pos32);add(pos23);add(pos47);add(pos42);add(pos35);
		add(pos48);add(pos49);add(pos44);add(pos45);add(pos50);add(pos46);add(pos36);add(pos34);add(pos41);
		add(pos38);add(pos33);add(pos39);add(pos37);add(pos40);add(pos73);add(pos72);add(pos53);add(pos54);
		add(pos52);add(pos51);add(pos64);add(pos63);add(pos65);add(pos62);add(pos56);add(pos58);add(pos59);
		add(pos57);add(pos55);add(pos60);add(pos66);add(pos67);add(pos71);add(pos69);add(pos80);add(pos78);
		add(pos77);add(pos76);add(pos75);add(pos74);add(pos79);add(pos70);add(pos68);add(pos61);add(pos100);
		add(pos91);add(pos92);add(pos93);add(pos94);add(pos95);add(pos96);add(pos97);add(pos98);add(pos99);
		add(pos90);add(pos89);add(pos88);add(pos87);add(pos86);add(pos85);add(pos84);add(pos83);add(pos82);
		add(pos81);add(jcomp101);add(dificuldade);

		// set component bounds (only needed by Absolute Positioning)
		pos1.setBounds(135, 90, 40, 40);
		pos3.setBounds(215, 90, 40, 40);
		pos2.setBounds(175, 90, 40, 40);
		pos6.setBounds(335, 90, 40, 40);
		pos9.setBounds(455, 90, 40, 40);
		pos5.setBounds(295, 90, 40, 40);
		pos10.setBounds(495, 90, 40, 40);
		pos7.setBounds(375, 90, 40, 40);
		pos8.setBounds(415, 90, 40, 40);
		pos4.setBounds(255, 90, 40, 40);
		pos12.setBounds(175, 130, 40, 40);
		pos11.setBounds(135, 130, 40, 40);
		pos18.setBounds(415, 130, 40, 40);
		pos15.setBounds(295, 130, 40, 40);
		pos13.setBounds(215, 130, 40, 40);
		pos20.setBounds(495, 130, 40, 40);
		pos19.setBounds(455, 130, 40, 40);
		pos14.setBounds(255, 130, 40, 40);
		pos16.setBounds(335, 130, 40, 40);
		pos17.setBounds(375, 130, 40, 40);
		pos21.setBounds(135, 170, 40, 40);
		pos22.setBounds(175, 170, 40, 40);
		pos26.setBounds(335, 170, 40, 40);
		pos43.setBounds(215, 250, 40, 40);
		pos30.setBounds(495, 170, 40, 40);
		pos24.setBounds(255, 170, 40, 40);
		pos27.setBounds(375, 170, 40, 40);
		pos29.setBounds(455, 170, 40, 40);
		pos28.setBounds(415, 170, 40, 40);
		pos31.setBounds(135, 210, 40, 40);
		pos25.setBounds(295, 170, 40, 40);
		pos32.setBounds(175, 210, 40, 40);
		pos23.setBounds(215, 170, 40, 40);
		pos47.setBounds(375, 250, 40, 40);
		pos42.setBounds(175, 250, 40, 40);
		pos35.setBounds(295, 210, 40, 40);
		pos48.setBounds(415, 250, 40, 40);
		pos49.setBounds(455, 250, 40, 40);
		pos44.setBounds(255, 250, 40, 40);
		pos45.setBounds(295, 250, 40, 40);
		pos50.setBounds(495, 250, 40, 40);
		pos46.setBounds(335, 250, 40, 40);
		pos36.setBounds(335, 210, 40, 40);
		pos34.setBounds(255, 210, 40, 40);
		pos41.setBounds(135, 250, 40, 40);
		pos38.setBounds(415, 210, 40, 40);
		pos33.setBounds(215, 210, 40, 40);
		pos39.setBounds(455, 210, 40, 40);
		pos37.setBounds(375, 210, 40, 40);
		pos40.setBounds(495, 210, 40, 40);
		pos73.setBounds(215, 370, 40, 40);
		pos72.setBounds(175, 370, 40, 40);
		pos53.setBounds(215, 290, 40, 40);
		pos54.setBounds(255, 290, 40, 40);
		pos52.setBounds(175, 290, 40, 40);
		pos51.setBounds(135, 290, 40, 40);
		pos64.setBounds(255, 330, 40, 40);
		pos63.setBounds(215, 330, 40, 40);
		pos65.setBounds(295, 330, 40, 40);
		pos62.setBounds(175, 330, 40, 40);
		pos56.setBounds(335, 290, 40, 40);
		pos58.setBounds(415, 290, 40, 40);
		pos59.setBounds(455, 290, 40, 40);
		pos57.setBounds(375, 290, 40, 40);
		pos55.setBounds(295, 290, 40, 40);
		pos60.setBounds(495, 290, 40, 40);
		pos66.setBounds(335, 330, 40, 40);
		pos67.setBounds(375, 330, 40, 40);
		pos71.setBounds(135, 370, 40, 40);
		pos69.setBounds(455, 330, 40, 40);
		pos80.setBounds(495, 370, 40, 40);
		pos78.setBounds(415, 370, 40, 40);
		pos77.setBounds(375, 370, 40, 40);
		pos76.setBounds(335, 370, 40, 40);
		pos75.setBounds(295, 370, 40, 40);
		pos74.setBounds(255, 370, 40, 40);
		pos79.setBounds(455, 370, 40, 40);
		pos70.setBounds(495, 330, 40, 40);
		pos68.setBounds(415, 330, 40, 40);
		pos61.setBounds(135, 330, 40, 40);
		pos100.setBounds(495, 450, 40, 40);
		pos91.setBounds(135, 450, 40, 40);
		pos92.setBounds(175, 450, 40, 40);
		pos93.setBounds(215, 450, 40, 40);
		pos94.setBounds(255, 450, 40, 40);
		pos95.setBounds(295, 450, 40, 40);
		pos96.setBounds(335, 450, 40, 40);
		pos97.setBounds(375, 450, 40, 40);
		pos98.setBounds(415, 450, 40, 40);
		pos99.setBounds(455, 450, 40, 40);
		pos90.setBounds(495, 410, 40, 40);
		pos89.setBounds(455, 410, 40, 40);
		pos88.setBounds(415, 410, 40, 40);
		pos87.setBounds(375, 410, 40, 40);
		pos86.setBounds(335, 410, 40, 40);
		pos85.setBounds(295, 410, 40, 40);
		pos84.setBounds(255, 410, 40, 40);
		pos83.setBounds(215, 410, 40, 40);
		pos82.setBounds(175, 410, 40, 40);
		pos81.setBounds(135, 410, 40, 40);
		jcomp101.setBounds(90, 15, 165, 25);
		dificuldade.setBounds(265, 15, 100, 25);
	}
	
	public void setDificuldade(String dificuldade) {
		this.dificuldade.setText(dificuldade);
		repaint();
	}
	
	public List<JButton> getButtons() {
		List<JButton> buttons = new ArrayList<>();
		Component[] components = getContentPane().getComponents();
		for (Component component : components) {
			if(component instanceof JButton) 
				buttons.add((JButton) component);
		}
		return buttons;
	}
	
	public void addBolinha(JButton button) {
		Image iconLogo = new ImageIcon("imagens/ball.png").getImage()
				.getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(iconLogo);
		button.setIcon(imageIcon);
		pack();
		repaint();
	}
	
	private void addAction() {
		Component[] components = getContentPane().getComponents();
		for (Component component : components) {
			if(component instanceof JButton)
				((JButton) component).addActionListener(l);
		}
	}
	
	public void removeBolinha(JButton button) {
		if(button != null) {
			button.setIcon(null);
		}
		pack();
		repaint();
	}
	
	public void informMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Aviso", JOptionPane.PLAIN_MESSAGE);
	}

	public void limparTela() {
		for(JButton button : getButtons()) {
			button.setIcon(null);
		}
		repaint();
		pack();
	}
}
