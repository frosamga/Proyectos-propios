import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Diccionario {

	private List<String> dicc;

	public Diccionario() {

		dicc = new ArrayList<String>();
		try {
			cargaFichero("C:/Users/alan/Desktop/App Anagramas/words.txt");
		} catch (Exception e) {
			System.err.println("No puedo crear el diccionario");
			System.err.println("  Razon: " + e.getMessage());
			System.exit(1);
		}
	}

	private void cargaFichero(String fichero) throws Exception {

		try {
			FileInputStream fIn = new FileInputStream(fichero);
			InputStreamReader archivo = new InputStreamReader(fIn);
			BufferedReader br = new BufferedReader(archivo);
			String linea = br.readLine();
			String p1;
			while (linea != null) {
				p1 = linea;
				linea = br.readLine();
				dicc.add(p1.toLowerCase());
			}
			br.close();
			archivo.close();

		} catch (IOException e) {

		}

	}

	public String sacarPalabra(int x) {
		return dicc.get(x);
	}

	public boolean existePalabra(String palabra) {
		if (dicc.contains(palabra)) {
			return true;
		} else {
			return false;
		}
	}
}
