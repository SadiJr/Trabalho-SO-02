package controll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;

import model.Balls;
import view.Game;
import view.MainScreen;

public class Ctrl {
	private static final Ctrl instance = new Ctrl();
	private MainScreen mainScreen;
	private Game game;
	private int deadBalls;
	private Collection<Balls> balls;
	private List<JButton> livres;
	private List<JButton> ocupados;
	private TimeController timer;
	private int tempo;
	
	public Ctrl() {
		mainScreen = new MainScreen();
		game = new Game();
		balls = new ArrayList<>();
		criarThreads();
		livres = game.getButtons();
		ocupados = new ArrayList<>();
	}
	
	public static Ctrl getInstance() {
		return instance;
	}
	
	public void facil() {
		timer = new TimeController(120);
		addTimeThreads(1.5f);
		game.setDificuldade("Fácil");
		game.pack();
		game.setVisible(true);
		startThreads();
	}

	public void medio() {
		timer = new TimeController(60);
		addTimeThreads(1.0f);
		game.setDificuldade("Médio");
		game.pack();
		game.setVisible(true);
		startThreads();
	}
	
	public void dificil() {
		timer = new TimeController(30);
		addTimeThreads(0.5f);
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
		for (Balls ball : balls) {
			ball.setSpeed(speed);
		}
	}
	
	private void startThreads() {
		for (Balls ball : balls) {
			ball.start();
		}
	}
	
	private void criarThreads() {
		for(int i = 0; i < 4; i++) {
			Balls ball = new Balls(0);
			balls.add(ball);
		}
	}
	
	private void inicio() {
		for(int i = 0; i < 4; i++) {
			move();
		}
	}
	
	public synchronized void move() {
		game.pack();
		game.setVisible(true);
		int pos = (int) (Math.random() * livres.size());
		game.addBolinha(livres.get(pos));
		ocupados.add(livres.get(pos));
		JButton jButton = ocupados.get(0);
		livres.add(jButton);
		game.removeBolinha(jButton);
		ocupados.remove(jButton);
	}
	
	private class TimeController extends Thread {
		private Timer timer;
		
		public TimeController(int time) {
			timer = new Timer(time);
		}
		
		@Override
		public void run() {
			timer.run();
			if(timer.getTime() <= 0) {
				Ctrl.getInstance().exitGame();
			}
		}
	}
	
	private class Timer extends Thread {
		private int time;

		public Timer(int time) {
			this.time = time;
		}

		public int getTime() {
			return time;
		}
		
		@Override
		public void run() {
			this.time--;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void exitGame() {
		if(deadBalls == 5) {
			game.informMessage("Você ganhou!");
		} else {
			game.informMessage("Você perdeu!");
		}
	}
	
	public void killThread(int index) {
		for(Balls ball : this.balls) {
			if(ball.getIndex() == index) {
				ball.interrupt();
			}
		}
	}

}
