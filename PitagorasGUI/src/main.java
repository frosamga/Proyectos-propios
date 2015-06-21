import java.awt.event.ActionListener;
import javax.swing.*;

/**Ejemplo con GUI que calcula el teorema de pitagoras, dandole 2 variables de las tres que hay.
 * 
 * Quizas la haga tambien para android si no hay muchas de estas.
 * 
 * @author alan
 *
 */

public class main {
	public static void main(String[] args) {
		
		triangulo tri = new triangulo();
		vistaPitagoras vista = new PanelPitagoras();
		ActionListener control= new CrtPitagoras(vista,tri);
		vista.controlador(control);
		
		JFrame ventana = new JFrame("Pitagoras");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vista);
		ventana.pack();
		ventana.setVisible(true);
			
	}

}
