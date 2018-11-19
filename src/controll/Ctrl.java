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
		timer.setTimeSec(100);
		addTimeThreads(2000);
		game.setDificuldade("Fácil");
		game.pack();
		startThreads();
	}

	public void medio() {
		timer.setTimeSec(50);
		addTimeThreads(1000);
		game.setDificuldade("Médio");
		game.pack();
		startThreads();
	}
	
	public void dificil() {
		timer.setTimeSec(20);
		addTimeThreads(500f);
		game.setDificuldade("Difícil");
		game.pack();
		startThreads();
	}

	public void start() {
		mainScreen.pack();
		mainScreen.setVisible(true);
	}
	
	private void addTimeThreads(float speed) {
		for (Ball ball : balls) {
			ball.setSpeed(speed);
		}
	}
	
	private void startThreads() {
		init();
		for (Ball ball : balls) {
			Thread t = new Thread(ball);
			t.start();
		}
		Thread t = new Thread(timer);
		t.start();
		timer.pack();
		timer.setVisible(true);
	}
	
	private void criarThreads() {
		for(int i = 0; i < 5; i++) {
			Ball ball = new Ball(0);
			balls.add(ball);
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

	public synchronized void exitGame() {
		if(deadBalls >= 5) {
			game.informMessage("Você ganhou!");
		} else {
			game.informMessage("Você perdeu!");
		}
		killAllThreads();
		limparTela();
	}
	
	private synchronized void killAllThreads() {
		for (Ball ball : balls) {
			Thread t = new Thread(ball);
			t.interrupt();
		}
		Thread t = new Thread(timer);
		t.interrupt();
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
					Thread t = new Thread(balls.get(0));
					t.interrupt();
					return;
				}
			}
		} else {
			exitGame();
		}
	}
	
	private void limparTela() {
		game.limparTela();
		game.repaint();
		game.setVisible(false);
		mainScreen.setVisible(true);
	}

}
