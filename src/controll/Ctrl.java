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
		game.setVisible(true);
	}

	public void medio() {
		
	}
	
	public void dificil() {
		
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
}
