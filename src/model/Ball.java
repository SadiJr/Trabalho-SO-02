package model;

import controll.Ctrl;

public class Ball extends Thread {
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
		super.run();
		while(true) {
			Ctrl.getInstance().move();
			try {
				sleep((long) speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
