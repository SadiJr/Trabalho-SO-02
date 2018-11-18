package model;

import controll.Ctrl;

public class Timer extends Thread {
	private int timeSec;

	@Override
	public void run() {
		super.run();
		while(true) {
			timeSec--;
			try {
				Thread.sleep(1000);
				verifyTime();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void verifyTime() {
		if(timeSec <= 0) {
			Ctrl.getInstance().exitGame();
		}
		
	}

	public int getTimeSec() {
		return timeSec;
	}

	public void setTimeSec(int timeSec) {
		this.timeSec = timeSec;
	}
}
