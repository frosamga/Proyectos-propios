import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.StringTokenizer;

public class Lector {
	private boolean hayLista = false;
	private String titulo = null, foto = null;
	private String FICHERO = "C:/Users/Alan_2/Desktop/AppCocina/cocina.txt";

	public Lector() {
		Properties props = System.getProperties();
		props.put("http.proxyPort", "3128"); // proxy port
		props.put("http.proxyHost", "proxy.alu.uma.es"); // the proxy server
															// name or IP
		props.put("http.proxySet", "true");
	}

	public void guardarFoto(String fotoAGuardar, String dondeGuardar) {
		try {
			URL url = new URL(fotoAGuardar);
			URLConnection urlCon = url.openConnection();
			InputStream is = urlCon.getInputStream();
			FileOutputStream fos = new FileOutputStream(dondeGuardar);

			// Lectura de la foto de la web y escritura en fichero local
			byte[] array = new byte[1000]; // buffer temporal de lectura.
			int leido = is.read(array);
			while (leido > 0) {
				fos.write(array, 0, leido);
				leido = is.read(array);
			}

			// cierre de conexion y fichero.
			is.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leerRutaARecetasHastax(String url, int n) {
		for (int i = 1; i <= n; i++) {
			// System.out.println(url+i);
			this.leerRutaARecetas(url + i);
		}
	}

	public void leerRutaARecetas(String url) {
		URL urlObject;
		String codigo;
		StringTokenizer st;
		try {
			urlObject = new URL(url);
			InputStreamReader isr = new InputStreamReader(
					urlObject.openStream());
			BufferedReader br = new BufferedReader(isr);
			while ((codigo = br.readLine()) != null) {
				if (hayLista) {
					// System.out.println(codigo);
					st = new StringTokenizer(codigo, "\"");
					st.nextToken();
					this.leerComponentesReceta("http://canalcocina.es"
							+ st.nextToken());
					// System.out.println("http://canalcocina.es" +
					// st.nextToken());
					hayLista = false;
				}
				if (codigo.contains("liAnchor")) {
					// System.out.println(codigo);
					hayLista = true;
				}

			}
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leerComponentesReceta(String url) {
		URL urlObject;
		String codigo, tituloANormalizar;
		StringTokenizer st, st1;
		StringBuilder ingredientesBuilder = new StringBuilder();
		try {
			urlObject = new URL(url);
			InputStreamReader isr = new InputStreamReader(
					urlObject.openStream());
			BufferedReader br = new BufferedReader(isr);
			while ((codigo = br.readLine()) != null) {
				if (codigo.contains("tituloReceta")) {
					st = new StringTokenizer(codigo, "<");
					st.nextToken();
					st1 = new StringTokenizer(st.nextToken(), ">");
					st1.nextToken();
					tituloANormalizar = st1.nextToken();
					titulo = tituloANormalizar;
				}

				if (codigo.contains("my_photo_1")) {
					st = new StringTokenizer(codigo, "\"");
					st.nextToken();
					foto = st.nextToken();
				}
				if (codigo.contains("dd itemprop")
						&& !codigo.contains("strong")) {
					st = new StringTokenizer(codigo, ">");
					st.nextToken();
					st1 = new StringTokenizer(st.nextToken(), "<");
					tituloANormalizar = st1.nextToken();
					ingredientesBuilder.append(tituloANormalizar + "%");
				}
				//TODO
				if (codigo.contains("class=\"tiempo\"")) {
					System.out.println(codigo);
				}
			}
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//TODO: habilitar al terminar de leer todo
		// this.escribirFichero(titulo+"#"+foto+"#"+ingredientesBuilder.toString()+"|");

	}

	private void leerFichero() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(FICHERO);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void escribirFichero(String texto) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(FICHERO, true);
			pw = new PrintWriter(fichero);
			pw.print(texto);
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
}