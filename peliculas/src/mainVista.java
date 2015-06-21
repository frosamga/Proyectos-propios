import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** Juego de descubre la pelicula en Java con GUI propia.
 * 
 *  Mas adelante la planteare en Android estilo League of voices!(visitadlo y +1!!)
 * 
 * @author alan
 *
 */

public class mainVista {
	public static void main(String[] args) throws IOException{
		
		int contador=0,puntos=0;
		boolean seguir=true;
		
		rellenar r1 = new rellenar();
		Peliculas p = r1.devuelveAleatorio();
		vistaPeliculas vista = new panelPeliculas(p.imagenPrincipal());
		ActionListener control = new controladorPeliculas(vista, p);
		vista.controlador(control);

		JFrame ventana = new JFrame("Peliculas");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vista);
		ventana.pack();
		ventana.setResizable(true);
		ventana.setVisible(true);
		ventana.getContentPane().setBackground(Color.GREEN);

		while (seguir) {
			System.out.println(p.devuelveSiguiente());
			if (p.devuelveSiguiente()) {
				ventana.dispose();
				p = r1.devuelveAleatorio();
				vista = new panelPeliculas(p.imagenPrincipal());
				control = new controladorPeliculas(vista, p);
				vista.controlador(control);
				puntos+=vista.puntuacionTotal();
				contador++;
				
				ventana.dispose();
				ventana = new JFrame("Peliculas");
				ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventana.setContentPane((JPanel) vista);
				ventana.pack();
				ventana.setResizable(true);
				ventana.setVisible(true);
				ventana.setResizable(false);
				ventana.getContentPane().setBackground(Color.GREEN);
				if(contador==4){
					seguir=false;
					vista.modificarPuntuacion(puntos);
				}
			}
		}
	
	}
}