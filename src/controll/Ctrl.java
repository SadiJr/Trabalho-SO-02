package controll;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import model.Ball;
import model.Timer;
import view.Game;
import view.MainScreen;

public class Ctrl {
	private static final Ctrl instance = new Ctrl();
	private MainScreen mainScreen;
	private Game game;
	private int deadBalls;
	private ArrayList<Ball> balls;
	private List<JButton> livres;
	private List<JButton> ocupados;
	private Timer timer;
	private boolean novaPartida = true;
	
	public Ctrl() {
		mainScreen = new MainScreen();
		game = new Game();
		balls = new ArrayList<>();
		timer = new Timer();
		criarThreads();
		livres = game.getButtons();
		ocupados = new ArrayList<>();
	}
	
	public static Ctrl getInstance() {
		return instance;
	}
	
	private void init() {
		for(int i =0; i < 5; i++) {
			int pos = (int) (Math.random() * livres.size());
			JButton ocupada = livres.get(pos);
			livres.remove(ocupada);
			ocupados.add(ocupada);
			game.addBolinha(ocupada);
		}
	}
	
	public void facil() {
		game.setDificuldade("Fácil");
		game.pack();
		startThreads(100, 2000);
	}

	public void medio() {
		game.setDificuldade("Médio");
		game.pack();
		startThreads(50, 1000);
	}
	
	public void dificil() {
		game.setDificuldade("Difícil");
		game.pack();
		startThreads(20, 500);
	}

	public void start() {
		mainScreen.pack();
		mainScreen.setVisible(true);
	}
	
	private void startThreads(int seg, float speed) {
		init();
		for (Ball ball : balls) {
			if(isNovaPartida()) {
				ball.setSpeed(speed);
				ball.start();
			} else {
				ball = new Ball(speed);
				ball.start();
			}
		}
		if(isNovaPartida()) {
			timer.setTimeSec(seg);
			timer.start();
		} else {
			timer = new Timer();
			timer.setTimeSec(seg);
			timer.start();
		}
		timer.pack();
		timer.setVisible(true);
	}
	
	private void criarThreads() {
		for(int i = 0; i < 5; i++) {
			balls.add(new Ball(0));
		}
	}
	
	public synchronized void move() {
		int pos = (int) (Math.random() * livres.size());
		JButton ocupada = livres.get(pos);
		livres.remove(ocupada);
		ocupados.add(ocupada);
		JButton livre = ocupados.get(0);
		livres.add(livre);
		ocupados.remove(livre);
		game.removeBolinha(livre);
		
		game.pack();
		game.setVisible(true);
		game.addBolinha(ocupada);
	}

	public void exitGame() {
		if(deadBalls >= 5) {
			game.informMessage("Você ganhou!");
		} else {
			game.informMessage("Você perdeu!");
		}
		timer.setVisible(false);
		killAllThreads();
		limparTela();
		novaPartida = false;
		deadBalls = 0;
	}
	
	private void killAllThreads() {
		for (Ball ball : balls) {
			ball.interrupt();
		}
		timer.interrupt();
	}
	
	public synchronized void tratarClique(JButton b) {
		if(ocupados.size() > 0) {
			for (JButton button : ocupados) {
				Rectangle bounds = button.getBounds();
				if(bounds.equals(b.getBounds())) {
					deadBalls+=1;
					ocupados.remove(button);
					livres.add(button);
					game.removeBolinha(button);
					balls.get(0).interrupt();
					return;
				}
			}
		} else {
			exitGame();
		}
	}
	
	private void limparTela() {
		game = null;
		game = new Game();
		mainScreen.setVisible(true);
	}

	public boolean isNovaPartida() {
		return novaPartida;
	}

	public void setNovaPartida(boolean novaPartida) {
		this.novaPartida = novaPartida;
	}

}
