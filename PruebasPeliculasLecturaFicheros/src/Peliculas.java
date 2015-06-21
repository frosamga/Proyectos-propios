import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Peliculas {

	private String textoCorto, textoTituloCacho, solucion,rutaImagenPrincipal, rutaImagenSecundaria;
	private int ID, puntos;
	private boolean siguiente=false;

	public Peliculas(String im1, String im2, String pista1, String pistaTit,
			String titulo, int ident) {
		rutaImagenPrincipal = im1;
		rutaImagenSecundaria = im2;
		textoCorto = pista1;
		textoTituloCacho = pistaTit;
		solucion = titulo;
		ID = ident;
		puntos = 0;
	}

	public String imagenPrincipal() {
		return rutaImagenPrincipal;
	}

	public String imagenSecundaria() {
		return rutaImagenSecundaria;
	}

	public int id() {
		return ID;
	}

	public int puntosAcumulados() {
		return puntos;
	}

	public String textoAyuda() {
		return textoCorto;
	}

	public String parteTextoTitulo() {
		return textoTituloCacho;
	}

	public String solucion() {
		return solucion;
	}

	public void acumulaPuntos(int p) {
		this.puntos += p;
	}

	public boolean comparar(String t) {
		return this.solucion.toUpperCase().equals(t.toUpperCase());
	}

	public void siguiente(boolean sig) {
		siguiente = sig;
	}
	public boolean devuelveSiguiente() {
		return siguiente;
	}
	public String toString(){
		return rutaImagenPrincipal+" , "+rutaImagenSecundaria+" , "+textoCorto+" , "+textoTituloCacho+" , "+solucion+" , "+ID;
	}

}
