import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class rellenar {

	private List<Peliculas> listaPeliculas;
	private Set<Peliculas> pel;

	public rellenar() throws IOException {

		listaPeliculas = new ArrayList<Peliculas>();
		pel= new HashSet<Peliculas>();
		FileReader fichero = new FileReader("ficheros/peliculas.txt");
		BufferedReader leer = new BufferedReader(fichero);

		String im1 = null, im2 = null, pista = null, pista2 = null, tit = null;
		int contador = 0;
		

		while (leer.ready() && leer.readLine().isEmpty()) {

			im1 = leer.readLine();
			im2 = leer.readLine();
			pista = leer.readLine();
			pista2 = leer.readLine();
			tit = leer.readLine();
			
			listaPeliculas.add(new Peliculas(im1, im2, pista, pista2, tit,
					dificultad.FACIL, contador));
			contador++;
		}
	
		for(int j=0;j<listaPeliculas.size();j++){
			System.out.println(listaPeliculas.get(j).toString());
		}
	}

	public Peliculas devuelveAleatorio() {
		// saco la primera de esta y elimino de lista
		Collections.shuffle(listaPeliculas);
		Peliculas p;
		if (listaPeliculas.isEmpty()) {
			throw new RuntimeException("la lista esta vacia");
		} else {
			p = listaPeliculas.get(0);
			listaPeliculas.remove(0);
		}
		return p;
	}
}
