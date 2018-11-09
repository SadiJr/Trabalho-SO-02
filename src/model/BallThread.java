package model;

import controll.Ctrl;

public class BallThread extends Thread{
	
	Ctrl ctrl;
	private int x;
	private int y;
	
	public BallThread() {
		this.ctrl = Ctrl.getInstance();
	}
	
	@Override
	public void run() {
		
		while(true) {
			ctrl.move(this);
			try {
				Thread.sleep(ctrl.getTempo());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
