import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class detallesRaton {
	private int contador = 0, x, y;
	private int segundos;
	private String ruta;
	private Point p;
	private boolean capturar = true;

	public detallesRaton(int segundos, String ruta) {
		this.segundos = segundos;
		this.ruta = ruta;
	}

	private int SegundosAMili(int segundos) {
		return segundos * 1000;
	}

	public void moverRaton() throws AWTException {
		Robot robot = new Robot();
		//espero 10 segundos a que ponga el raton donde se cliqueara, y otros 10 segundos para la prueba
		if (capturar) {
			robot.delay(this.SegundosAMili(10));
			p = MouseInfo.getPointerInfo().getLocation();
			System.out.println("x: " + p.x + " | y: " + p.y);
			capturar = false;
			robot.delay(this.SegundosAMili(10));
		}
		if (p == null) {
			x = 0;
			y = 0;
		} else {
			x = (int) p.getX();
			y = (int) p.getY();
		}
		
			robot.mouseMove(x, y);
			robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
			robot.mousePress(InputEvent.BUTTON2_MASK);
			robot.mouseRelease(InputEvent.BUTTON2_MASK);
			robot.delay(this.SegundosAMili(5));
		
	}

	public void pantallazo() throws IOException {
		try {
			Robot robot = new Robot();
			if (ruta == null) {
				ruta = "C://";
			}
			robot.delay(this.SegundosAMili(segundos));
			BufferedImage pantalla = robot.createScreenCapture(new Rectangle(
					Toolkit.getDefaultToolkit().getScreenSize()));
			File file = new File(ruta + contador + ".jpg");
			ImageIO.write(pantalla, "jpg", file);
			contador++;

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}