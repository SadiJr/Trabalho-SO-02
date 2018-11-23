package controll;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.JButton;

import model.Ball;
import model.Timer;
import model.Timer.Time;
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
	private int index = 0;
	private boolean livre = true;
	
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
		limparTela();
		for (int i = 0; i < 5; i++) {
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

	private synchronized void startThreads(int seg, float speed) {
		init();
		System.out.println(balls.size());
		for (Ball ball : balls) {
			if (ball.getAlive()) {
				ball.setSpeed(speed);
				ball.start();
			} else {
				ball.setSpeed(speed);
				ball.setAlive(true);
				new Thread(ball).start();
//				ball = null;
//				System.gc();
//				ball = new Ball(speed);
//				ball.start();
			}
		}
		timer.setTimeSec(seg);
		if (timer.getAlive()) {
			timer.start();
		} else {
			timer.setAlive(true);
			new Thread(timer.getCurrentThread()).start();
		}
		timer.pack();
		timer.setVisible(true);
		game.pack();
		game.setVisible(true);
	}

	private void criarThreads() {
		for (int i = 0; i < 5; i++) {
			balls.add(new Ball(0));
		}
	}

	public synchronized void move() {
		if(livre) {
			livre = false;
			int pos = (int) (Math.random() * livres.size());
			JButton ocupada = livres.get(pos);
			livres.remove(ocupada);
			ocupados.add(ocupada);
			JButton livre = ocupados.get(0);
			livres.add(livre);
			ocupados.remove(livre);
			game.removeBolinha(livre);
			game.addBolinha(ocupada);
			this.livre = true;
		}
	}

	public void exitGame() {
		timer.setVisible(false);
		killAllThreads();
		cleanBalls();
		novaPartida = false;
		index = 0;
		if (deadBalls >= 5) {
			game.informMessage("Você ganhou!");
		} else {
			game.informMessage("Você perdeu!");
		}
		deadBalls = 0;
		limparTela();
	}
	
	private void cleanBalls() {
		for(JButton button : ocupados) {
			livres.add(button);
			ocupados.remove(button);
		}
	}

	private synchronized void killAllThreads() {
		timer.interrupt();
		for (Ball ball : balls) {
			ball.setAlive(false);
		}
	}

	public synchronized void tratarClique(JButton b) {
		if(livre) {
			livre = false;
			for (JButton button : ocupados) {
				Rectangle bounds = button.getBounds();
				if (bounds.equals(b.getBounds())) {
					deadBalls += 1;
					ocupados.remove(button);
					livres.add(button);
					game.removeBolinha(button);
					balls.get(index).setAlive(false);
					index++;
					break;
				}
			}
			livre = true;
		}
		if (index >= 5) {
			exitGame();
		}
	}

	private void limparTela() {
		game.limparTela();
		game.setVisible(false);
		mainScreen.setVisible(true);
	}

	public boolean isNovaPartida() {
		return novaPartida;
	}

	public void setNovaPartida(boolean novaPartida) {
		this.novaPartida = novaPartida;
	}
	
	public int getBalls() {
		return deadBalls;
	}

}
