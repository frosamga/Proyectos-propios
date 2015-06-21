import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Permutacion2 {
	static List<String> lista = new ArrayList<String>();;

	public static void main(String[] args) {
		String[] elementosMal = "sol".split("");
		String[] elementos = corregirArray(elementosMal);
		perm(elementos, 0);
		System.out.println(lista.toString());
	}

	public static void perm(String[] elem, int n) {
		permute(Arrays.asList(elem), n);

		HashSet<String> hashSet = new HashSet<String>(lista);
		lista.clear();
		lista.addAll(hashSet);

	}

	private static void permute(List<String> palabra, int min) {

		if (min != palabra.size()) {

			for (int i = min; i < palabra.size(); i++) {
				Collections.swap(palabra, i, min);
				String aux = "";
				for (int j = min; j < palabra.size(); j++) {
					aux = aux + palabra.get(j);
				}
				if (aux.length() != 1) {
					lista.add(aux);
				}
				permute(palabra, min + 1);
				Collections.swap(palabra, min, i);
			}
		}
	}

	private static String ArrayToString(String[] palabra) {
		StringBuilder x = new StringBuilder();
		for (int i = 0; i < palabra.length; i++) {
			x.append(palabra[i]);
		}
		return x.toString();
	}

	public static String[] corregirArray(String[] array) {
		String[] nuevo = new String[array.length - 1];
		for (int i = 0; i < array.length - 1; i++) {
			nuevo[i] = array[i + 1];
		}
		return nuevo;
	}
}
