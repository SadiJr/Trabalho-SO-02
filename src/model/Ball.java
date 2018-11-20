package model;

import controll.Ctrl;

public class Ball extends Thread {
	private float speed;
	private boolean alive = true;
	
	public Ball(float speed) {
		this.setSpeed(speed);
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
				e.printStackTrace();
			}
		}
	}
	
	public void setAlive(boolean dead) {
		this.alive = dead;
	}
}
