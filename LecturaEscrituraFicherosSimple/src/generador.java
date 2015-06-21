import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class generador {

	public String LeeFichero() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea = "";
		try {
			archivo = new File("C:/Users/Alan_2/Desktop/estadisticas");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			linea = br.readLine();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return linea;
	}

	public void EscribeFichero(String texto) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("C:/Users/Alan_2/Desktop/estadisticas");
			pw = new PrintWriter(fichero);
			pw.println(texto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void puntuaciones(String tipoEjercicio, int repeticionesHechas) {
		String datos = this.LeeFichero();

		StringTokenizer st = new StringTokenizer(datos, "+");
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.contains(tipoEjercicio)) {
				String num = token.substring(1);
				token = tipoEjercicio
						+ String.valueOf((Integer.parseInt(num) + repeticionesHechas));
			}

			sb.append("+" + token);
		}
		this.EscribeFichero(sb.toString());
	}
	public String leerPuntuaciones(String tipoEjercicio) {
		String devolver = null;
		String datos = this.LeeFichero();
		StringTokenizer st = new StringTokenizer(datos, "+");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.contains(tipoEjercicio)) {
				String num = token.substring(1);				
				devolver = String.valueOf((Integer.parseInt(num)));
			}
		}
		return devolver;
	}
}
