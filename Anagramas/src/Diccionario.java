import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diccionario {

	private List<String> dicc;

	public Diccionario() {

		dicc = new ArrayList<String>();
		try {
			cargaFichero("C:/Users/Alan_2/Desktop/words.txt");
		} catch (Exception e) {
			System.err.println("No puedo crear el diccionario");
			System.err.println("  Razon: " + e.getMessage());
			System.exit(1);
		}
	}

	private void cargaFichero(String fichero) throws Exception {
		Scanner scanner = new Scanner(new FileInputStream(fichero));
		String p1;
		while (scanner.hasNext()) {
			p1 = scanner.next();
			if (!scanner.hasNext())
				break;
			dicc.add(p1.toLowerCase());
		}
		scanner.close();
	}

	public boolean existePalabra(String palabra) {
		if (dicc.contains(palabra)) {
			return true;
		} else {
			return false;
		}
	}
}
