import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws IOException {

		ArrayList<Peliculas> listaPeliculas = new ArrayList<Peliculas>();
		FileReader fichero = new FileReader("ficheros/peliculas.txt");
		BufferedReader leer = new BufferedReader(fichero);
		String im1 = null, im2 = null, pista = null, pista2 = null, tit = null;
		int contador = 0;

		while (leer.readLine() != null) {

			im1 = leer.readLine();
			im2 = leer.readLine();
			pista = leer.readLine();
			pista2 = leer.readLine();
			tit = leer.readLine();

			listaPeliculas.add(new Peliculas(im1, im2, pista, pista2, tit,
					contador));
			contador++;

			

		}
		for(int i=0;i<listaPeliculas.size();i++) {
			System.out.println(listaPeliculas.get(i).toString());
			i++;
		}

	}
}
