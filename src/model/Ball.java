package model;

import controll.Ctrl;

public class Ball implements Runnable {
	private float speed;
	
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
		while(!Thread.interrupted()) {
			Ctrl.getInstance().move();
			try {
				Thread.sleep((long) speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
