import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class controladorPeliculas implements ActionListener {

	private vistaPeliculas vista;
	private Peliculas pel;
	private int contador = 0;
	private rellenar r;
	

	
	public controladorPeliculas(vistaPeliculas v, Peliculas p) {
		vista = v;
		pel = p;
		pel.siguiente(false);
		try {
			r = new rellenar();
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		pel.siguiente(false);
		vista.modificarPuntuacion(pel.puntosAcumulados());
		if (comando.equals(vistaPeliculas.PISTA)) {
			if (contador == 0) {
				vista.escribirPista(pel.textoAyuda());
				contador++;
			} else if (contador == 1) {
				vista.cambiarImagen(pel.imagenSecundaria());
				contador++;
			} else {
				vista.escribirPista(pel.parteTextoTitulo());
				contador++;
			}
		} else if (comando.equals(vistaPeliculas.SOLUCION)) {
			vista.escribirPista(pel.solucion());
			vista.activarNO(true);
		} else if (comando.equals(vistaPeliculas.ENVIAR)) {
			if (pel.comparar(vista.leerRespuesta())) {
				System.out.println(vista.leerRespuesta());
				System.out.println(pel.comparar(vista.leerRespuesta()));
				vista.activarNO(false);
				vista.activarSI(true);
				if (contador == 0) {
					vista.modificarPuntuacion(20);
					pel.acumulaPuntos(20);
				} else if (contador == 1) {
					vista.modificarPuntuacion(15);
					pel.acumulaPuntos(15);
				} else if (contador == 2) {
					vista.modificarPuntuacion(10);
					pel.acumulaPuntos(10);
				} else {
					vista.modificarPuntuacion(5);
					pel.acumulaPuntos(5);
				}
				pel.siguiente(true);			
			} else {
				System.out.println(vista.leerRespuesta());
				System.out.println(pel.comparar(vista.leerRespuesta()));
				vista.activarNO(true);
				vista.activarSI(false);
			}
		}
	}


}
