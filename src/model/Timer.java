package model;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controll.Ctrl;

@SuppressWarnings("serial")
public class Timer extends JFrame {
	private int timeSec;
	private Time t;
	private boolean alive = true;

	private JLabel jcomp1;
	private JLabel tempo;

	public Timer() {
		t = new Time();
		config();
	}

	private void config() {
		setTitle("Cronômetro");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		centerFrame();
		//construct components
        jcomp1 = new JLabel ("Tempo restante:");
        tempo = new JLabel ("");

        //adjust size and set layout
        setPreferredSize (new Dimension (166, 100));
        setLayout (null);

        //add components
        add (jcomp1);
        add (tempo);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (25, 0, 120, 25);
        tempo.setBounds (75, 25, 95, 25);
	}

	public class Time  extends Thread {
		@Override
		public void run() {
			while (getAlive()) {
				timeSec--;
				tempo.setText(""+timeSec);
				repaint();
				try {
					Thread.sleep(1000);
					verifyTime();
				} catch (InterruptedException e) {
					currentThread().interrupt();
					e.printStackTrace();
				}
			}
			System.out.println("Eu, TIMER, morriiiii!");
		}
	
		private void verifyTime() {
			if (timeSec <= 0) {
				Ctrl.getInstance().exitGame();
			}
	
		}
	}

	public int getTimeSec() {
		return timeSec;
	}

	public void setTimeSec(int timeSec) {
		this.timeSec = timeSec;
	}
	
	 private void centerFrame() {

         Dimension windowSize = getSize();
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
         Point centerPoint = ge.getCenterPoint();

         int dx = centerPoint.x - windowSize.width / 2;
         int dy = centerPoint.y - windowSize.height / 2;    
         setLocation(dx, dy);
 }

	public void interrupt() {
		setAlive(false);
	}

	public void start() {
		t.start();
	}

	public boolean getAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Time getCurrentThread() {
		return t;
	}
}
