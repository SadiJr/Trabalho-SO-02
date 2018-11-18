package model;

import controll.Ctrl;

public class Ball extends Thread {
	private int index;
	private float speed;
	
	public Ball(float speed) {
		this.setSpeed(speed);
		this.setIndex(index);
	}
	
	public Ball(float speed, int index) {
		this.setSpeed(speed);
		this.setIndex(index);
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	@Override
	public void run() {
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}	
}
