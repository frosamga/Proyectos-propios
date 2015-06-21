import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ArregloFicheros {

	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter fichero = null;
	PrintWriter pw = null;

	public FileWriter Arreglo(File entrada) {
		try {
			archivo = entrada;
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			try {
				String lectura = br.readLine();
				fichero = new FileWriter(
						"C:/Users/Alan_2/Desktop/Twitter/almacenaje/auth_file.txt");
				pw = new PrintWriter(fichero);

				pw.println(lectura.substring(0, 50));
				pw.print(lectura.substring(51, 96));

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
		return null;
	}

}
