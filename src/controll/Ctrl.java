package controll;

import java.util.ArrayList;
import java.util.Collection;
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
	private Collection<Ball> balls;
	private List<JButton> livres;
	private List<JButton> ocupados;
	private Timer timer;
	private int tempo;
	
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
	
	public void facil() {
		timer.setTimeSec(240);
		addTimeThreads(2000);
		game.setDificuldade("Fácil");
		game.pack();
		game.setVisible(true);
		startThreads();
	}

	public void medio() {
		timer.setTimeSec(120);
		addTimeThreads(1000);
		game.setDificuldade("Médio");
		game.pack();
		game.setVisible(true);
		startThreads();
	}
	
	public void dificil() {
		timer.setTimeSec(60);
		addTimeThreads(000.5f);
		game.setDificuldade("Difícil");
		game.pack();
		game.setVisible(true);
		startThreads();
	}

	public void start() {
		mainScreen.pack();
		mainScreen.setVisible(true);
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	private void addTimeThreads(float speed) {
		for (Ball ball : balls) {
			ball.setSpeed(speed);
		}
	}
	
	private void startThreads() {
		for (Ball ball : balls) {
			ball.start();
		}
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

	public void exitGame() {
		if(deadBalls == 5) {
			game.informMessage("Você ganhou!");
		} else {
			game.informMessage("Você perdeu!");
		}
		killAllThreads();
	}

	public void killThread(int index) {
		for(Ball ball : this.balls) {
			if(ball.getIndex() == index) {
				ball.interrupt();
			}
		}
	}
	
	private void killAllThreads() {
		for (Ball ball : balls) {
			ball.interrupt();
		}
		timer.interrupt();
	}

}
