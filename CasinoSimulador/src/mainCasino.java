import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Mi intencion en un principio era crear un simulador de casino para probar la
 * teoria del doble, que consiste en apostar siempre a un color y el doble de la
 * apuesta anterior si pierdes, cuando ganas entonces comienzas desde el
 * principio, ademas de diferentes pruebas de iteracion sobre numeros y demas
 * 
 * 
 * Falta por completar, pero no le queda mucho
 * @author alan
 * 
 */

public class mainCasino {

	public static void main(String[] args) {

		// Casino modelo= new Casino();
		vistaCasino vista = new PanelCasino();

		JFrame ventana = new JFrame("Casino");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vista);
		ventana.pack();
		ventana.setResizable(false);
		ventana.setVisible(true);

	}

}
