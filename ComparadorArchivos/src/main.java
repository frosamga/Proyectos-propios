import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.Patch;

import difflib.Delta;
import difflib.DiffUtils;

/**
 * Compara dos archivos de texto para averiguar si son iguales y en caso
 * contrario dice la linea y que parte difiere en los dos archivos Utiliza la
 * clase DiffUtil y debe ser añadida a las bibliotecas.
 * 
 * @author Alan
 *
 */

public class main {

	public static void main(String[] args) {

		String ruta_viejo = "C:/Users/Alan_2/Desktop/TIC/hecho/Main.java";
		String ruta_nuevo = "C:/Users/Alan_2/Desktop/TIC/sinhacer/Main.java";

		List<String> viejoList = fileToLines(ruta_viejo);
		List<String> nuevoList = fileToLines(ruta_nuevo);
		difflib.Patch patch = DiffUtils.diff(viejoList, nuevoList);
		List<Delta> diff = patch.getDeltas();
		if (diff.isEmpty()) {
			System.out.println("(DiffUtils msg): No hay cambios");
		} else {
			System.out.println(diff.toString());
		}

	}

	private static List<String> fileToLines(String filename) {
		List<String> lines = new LinkedList<String>();
		String line = "";
		BufferedReader in;

		try {
			in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
