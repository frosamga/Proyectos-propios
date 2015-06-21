import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class Autorizacion {

	Autorizacion(boolean proxy) throws IOException, TwitterException {
		ConfigurationBuilder configBuilder = new ConfigurationBuilder();
		configBuilder.setDebugEnabled(true);

		configBuilder.setOAuthConsumerKey("MICLAVE");
		configBuilder
				.setOAuthConsumerSecret("MICLAVE");
		configBuilder.setUseSSL(true);
		if (proxy) {
			configBuilder.setHttpProxyHost("PROXY");
			configBuilder.setHttpProxyPort(3128);
			configBuilder.setHttpProxyUser("PROXYUSER");
			configBuilder.setHttpProxyPassword("PROXYPASS");
		}
		Twitter OAuthTwitter = new TwitterFactory(configBuilder.build())
				.getInstance();
		RequestToken requestToken = null;
		AccessToken accessToken = null;
		String url = null;
		do {
			try {
				requestToken = OAuthTwitter.getOAuthRequestToken();
				System.out.println("Request Tokens obtenidos con éxito.");
				System.out.println("Request Token: " + requestToken.getToken());
				System.out.println("Request Token secret: "
						+ requestToken.getTokenSecret());
				url = requestToken.getAuthorizationURL();
				System.out.println("URL:");
				System.out.println(requestToken.getAuthorizationURL());
			} catch (TwitterException ex) {
				Logger.getLogger(Twitter1.class.getName()).log(Level.SEVERE,
						null, ex);
			}
			BufferedReader lectorTeclado = new BufferedReader(
					new InputStreamReader(System.in));
			// Abro el navegador Firefox.
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("firefox " + url);
			} catch (Exception e) {
			}
			System.out
					.print("Introduce el PIN del navegador y pulsa intro PIN: ");
			// Leemos el PIN
			String pin = lectorTeclado.readLine();
			if (pin.length() > 0) {
				accessToken = OAuthTwitter.getOAuthAccessToken(requestToken,
						pin);
			} else {
				accessToken = OAuthTwitter.getOAuthAccessToken(requestToken);
			}
		} while (accessToken == null);
		System.out.println("Tokens obtenidos con éxito.");
		System.out.println("Token de acceso: " + accessToken.getToken());
		System.out.println("Token de acceso secreto: "
				+ accessToken.getTokenSecret());
		FileOutputStream fileOS = null;
		File file;
		String content = accessToken.getToken() + "n"
				+ accessToken.getTokenSecret();
		try {
			file = new File("almacenaje/auth_file.txt");
			fileOS = new FileOutputStream(file);
			// Si el archivo no existe, se crea
			if (!file.exists()) {
				file.createNewFile();
			}
			// Se obtiene el contenido en Bytes
			byte[] contenidoEnBytes = content.getBytes();

			fileOS.write(contenidoEnBytes);
			fileOS.flush();
			fileOS.close();
			System.out.println("Escritura realizada con éxito.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOS != null) {
					fileOS.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// arreglo del fichero de texto, para separar en dos partes, la normal y
		// la secreta.
		ArregloFicheros arreglo = new ArregloFicheros();
		arreglo.Arreglo(new File("almacenaje/auth_file.txt"));
	}

}