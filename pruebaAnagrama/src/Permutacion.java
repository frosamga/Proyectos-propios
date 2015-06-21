
import java.util.ArrayList;
import java.util.List;

public class Permutacion {

	List<String> listaPermutaciones = new ArrayList<String>();
	
	public void perm(String[] elem, String act, int n, int r) {
		if (n == 0) {
			listaPermutaciones.add(act);
		} else {
			for (int i = 0; i < r; i++) {
				if (!act.contains(elem[i])) {
					perm(elem, act + elem[i], n - 1, r);
				}
			}
		}
	}
	public List<String> devolverListaPermutaciones(){
		return listaPermutaciones;
	}
}
