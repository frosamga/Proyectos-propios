import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**Intento de juego de mansion
 * 
 * En un principio crea bien la GUI y por consola los atributos se quedan bien creados. Como comienzo funciona bien.
 * 
 * Ahora mismo si se quisiera crear un juego tipo point and click es as facil con gamemaker, html5, unity, asi que este proyecto queda obsoleto pero util para el 
 * aprendizaje de GUI y de lógica de videojuegos.
 * 
 * 
 * @author alan
 *
 */

public class main {

	public static void main(String[] args) {


		PersonajePrincipal kevin = new PersonajePrincipal("kevin", 5, 25);
		Enemigo bicho = new Enemigo("bicho", 7, 20);
	
		

		Mansion mansion = new Mansion();
		mansion.rellenarHabitaciones();
		mansion.mostrarMatriz();
		
		
		
		vistaJuego vista = new vistaJuego();
		JFrame ventana = new JFrame("Juego");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vista);
		ventana.pack();
		ventana.setVisible(true);
		ventana.setResizable(false);
		
		
		/*
		//modificar por favor.,...
		while ((kevin.estaMuerto() != true) && (bicho.estaMuerto() != true)) {
		
			System.out.println("kevin ataca:");
			bicho.recibeDaño(kevin.atacar());
			System.out.println("bicho tiene :" + bicho.vida()
					+ " puntos de vida");
			System.out.println("bicho ataca:");
			kevin.loHieren(bicho.atacar());
			System.out.println("Kevin tiene :" + kevin.vidaQueTiene()
					+ " puntos de vida");
			if (kevin.estaMuerto() == true) {
				System.out.println("Has Muerto");
			}else if (bicho.estaMuerto() == true) {
				System.out.println("Has matado a tu enemigo");
			}
		}
		*/
		

	}

}
