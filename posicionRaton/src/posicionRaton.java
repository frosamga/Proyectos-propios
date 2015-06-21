import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**Permite obtener datos con respecto a la posicion del raton y de acciones. 
 * 
 * @author alan
 *
 */


public class posicionRaton extends Applet implements MouseListener,
		MouseMotionListener {
	TextField text1;

	public void init() {
		text1 = new TextField(35);
		add(text1);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void mousePressed(MouseEvent e) {
		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
			text1.setText("Botón izquierdo del ratón apretado en " + e.getX()
					+ "," + e.getY());
		} else {
			text1.setText("Botón derecho del ratón apretado en " + e.getX()
					+ "," + e.getY());
		}
	}

	public void mouseClicked(MouseEvent e) {
		text1.setText("Hizo clic sobre el ratón en " + e.getX() + ","
				+ e.getY());
	}

	public void mouseReleased(MouseEvent e) {
		text1.setText("Se soltó el botón del ratón.");
	}

	public void mouseEntered(MouseEvent e) {
		text1.setText("Ratón para introducir.");
	}

	public void mouseExited(MouseEvent e) {
		text1.setText("Ratón para salir.");
	}

	public void mouseDragged(MouseEvent e) {
		text1.setText("Se arrastó el ratón.");
	}

	public void mouseMoved(MouseEvent e) {
		text1.setText("Se movió el ratón.");
	}
}
