package model;

import controll.Ctrl;

public class Ball extends Thread {
	private float speed;
	private boolean alive;
	
	public Ball(float speed) {
		this.setSpeed(speed);
		this.alive = true;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	@Override
	public void run() {
		while(alive) {
			Ctrl.getInstance().move();
			try {
				Thread.sleep((long) speed);
			} catch (InterruptedException e) {
//				currentThread().interrupt();
				setAlive(false);
//				e.printStackTrace();
			}
		}
		System.out.println("Eu morriiiiii!");
	}
	
	public void setAlive(boolean dead) {
		this.alive = dead;
	}
	
	public boolean getAlive() {
		return alive;
	}
}
