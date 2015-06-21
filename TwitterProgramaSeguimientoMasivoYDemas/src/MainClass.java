import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

public class MainClass {
	public static void main(String[] args) throws TwitterException {
		// si es la primera vez que se accede a la aplicacion esta parte es
		// obligatoria para la esritura del fichero

		/*
		try {
			Autorizacion aut = new Autorizacion(false);
		} catch (IOException | TwitterException ex) {
			Logger.getLogger(Twitter1.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		*/
		
		VistaTwitter vistaTwitter = new PanelTwitter();
		Twitter1 twitter = new Twitter1();
		ActionListener ctrJa = new ControladorTwitter(vistaTwitter, twitter);
		vistaTwitter.controlador(ctrJa);
		// Mantener la vista en una ventana
		JFrame ventana = new JFrame("Control de cuentas");

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vistaTwitter);

		ventana.pack();
		ventana.setResizable(false);
		ventana.setVisible(true);

		/*
		 * 
		 * Twitter1 twitter = new Twitter1(); //twitter.ActualizarEstado(
		 * "[JAVA] Bueno, solucionado el conflicto con ssl");
		 * //twitter.ActualizarFoto(new
		 * File("C:/Users/Alan_2/Desktop/Imagenes/ryze.jpg"));
		 * //twitter.ObtenerListaSeguidores("91Alan", true);
		 * //twitter.ObtenerListaSeguidos("Alan Martellotti", 50,false);
		 * //twitter.GetTimeLine(100);
		 * //twitter.BuscarTweetsDeUsuario("GuisantitoVerde");
		 * //twitter.SeguirA("91Alan"); //twitter.SeguidoresDe("91Alan");
		 * twitter.SeguirASeguidoresDe("91Alan"); twitter.SiguiendoA("91Alan");
		 * //twitter.SeguirASeguidoresDe_FormaArborea("91Alan");
		 * //twitter.informacionDeCuentaPropia(); //--falla
		 * //twitter.SeguirAQuienSigue("91Alan");
		 */
	}
}
