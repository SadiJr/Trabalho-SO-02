package controll;

import view.Game;
import view.MainScreen;

public class Ctrl {
	private static final Ctrl instance = new Ctrl();
	private MainScreen mainScreen;
	private Game game;
	private int tempo;
	
	public Ctrl() {
		mainScreen = new MainScreen();
		game = new Game();
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
	}
	
	

}
