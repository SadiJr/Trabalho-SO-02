package model;

import com.sun.xml.internal.bind.v2.runtime.InlineBinaryTransducer;

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
		while(!interrupted()) {
			Ctrl.getInstance().move();
			try {
				Thread.sleep((long) speed);
			} catch (InterruptedException e) {
				interrupt();
				e.printStackTrace();
			}
		}
	}
}
