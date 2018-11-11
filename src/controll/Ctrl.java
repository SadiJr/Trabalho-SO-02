package controll;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.BallThread;
import view.Game;
import view.MainScreen;

public class Ctrl {
	private static final Ctrl instance = new Ctrl();
	private MainScreen mainScreen;
	private Game game;
	private int deadBalls;
	private Collection<Balls> balls;
	private TimeController timer;
	private int tempo;
	private ArrayList<BallThread> balls;
	
	public Ctrl() {
		mainScreen = new MainScreen();
		game = new Game();
		balls = new ArrayList<>();
	}
	
	public static Ctrl getInstance() {
		return instance;
	}
	
	public void facil() {
		timer = new TimeController(120);
		addTimeThreads(1.5f);
		game.setVisible(true);
	}

	public void medio() {
		timer = new TimeController(60);
		addTimeThreads(1.0f);
	}
	
	public void dificil() {
		timer = new TimeController(30);
		addTimeThreads(0.5f);
	}

	public void start() {
		mainScreen.setVisible(true);
		
		for(int i = 0; i > 5; i++) {
			Thread t = new BallThread();
			t.start();
		}
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public synchronized void move(BallThread ball) {
		ball.setX(randNumber());
		ball.setY(randNumber());		
	}
	
	public void addTimeThreads(float speed) {
		for(Balls ball : this.balls) {
			ball = new Balls(speed);
		}
	}
	public int randNumber() {
		return ThreadLocalRandom.current().nextInt(0, 9 + 1);
	}
	
	public synchronized void clicked(int x, int y) {
		for(BallThread ball: balls) {
			
			if(ball.getX() == x && ball.getY() == y) {
				Thread t = ball;
			}
		}
	}
	public synchronized void move() {
		
		game.repaint();
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
