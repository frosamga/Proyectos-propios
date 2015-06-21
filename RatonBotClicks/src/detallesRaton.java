import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class detallesRaton implements KeyListener {
	private int contador = 0, x, y;
	private Point p;
	private boolean capturar = true;

	public detallesRaton(int segundos) throws AWTException {
		this.ClickRaton((int) 0.2);	
	}

	private int SegundosAMili(int segundos) {
		return segundos * 1000;
	}

	public void ClickRaton(int segundos) throws AWTException {
		Robot robot = new Robot();
		robot.delay(this.SegundosAMili((int) 5));
		p = MouseInfo.getPointerInfo().getLocation();
		capturar = false;
		x = (int) p.getX();
		y = (int) p.getY();
		System.out.println("x: " + x + " | y: " + y);

		
		while (true) {
			robot.mouseMove(x, y);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.delay(this.SegundosAMili((int) 0.2));
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(this.SegundosAMili((int) segundos));
		}
		/*
		
		
		*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KEY TYPED: "+e.getKeyChar());
	}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("KEY TYPED: "+e.getKeyChar());
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("KEY TYPED: "+e.getKeyChar());
		
	}

}