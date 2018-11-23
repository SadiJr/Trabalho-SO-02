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
				setAlive(false);
			}
		}
		System.out.println("Thread " + currentThread().getName() + " morreu");
	}
	
	public void setAlive(boolean dead) {
		this.alive = dead;
	}
	
	public boolean getAlive() {
		return alive;
	}
}
