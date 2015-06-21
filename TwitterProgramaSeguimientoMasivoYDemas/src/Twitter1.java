import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import twitter4j.AccountSettings;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterBase;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter1 {
	Twitter twitter;

	Twitter1() throws TwitterException {

		ConfigurationBuilder configBuilder = new ConfigurationBuilder();
		String Token = new String(); // Los almaceno en un string, ya que pueden
										// variar según la cuenta
		String TokenSecret = new String();
		File archivo = null;
		FileReader fileR = null;
		BufferedReader lecturaTeclado = null;
		try {
			// Apertura del fichero y creacion de BufferedReader
			archivo = new File("almacenaje/auth_file.txt");
			fileR = new FileReader(archivo);
			lecturaTeclado = new BufferedReader(fileR);
			String linea = new String();
			int n = 0;
			while ((linea = lecturaTeclado.readLine()) != null) {
				if (n == 0) {
					System.out.println("clave normal:" + linea);
					Token = linea;
				} else if (n == 1) {
					System.out.println("clave secreta:" + linea);
					TokenSecret = linea;
				}
				n++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fileR) {
					fileR.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		configBuilder
				.setDebugEnabled(true)
				.setOAuthConsumerKey("MICLAVE")
				.setOAuthConsumerSecret(
						"MICLAVE")
				.setOAuthAccessToken(Token)
				.setOAuthAccessTokenSecret(TokenSecret);
		configBuilder.setUseSSL(true);
		twitter = new TwitterFactory(configBuilder.build()).getInstance();

	}

	// solo sirve para enviar un mensaje de texto.
	public String ActualizarEstado(String estado) throws TwitterException {
		Status tweetEscrito = twitter.updateStatus(estado);
		return "Se ha publicado: " + estado;
	}

	public String ActualizarFoto(File foto) throws TwitterException {
		User fotoTweet = twitter.updateProfileImage(foto);
		return "Se ha publicado la foto";
	}

	// Obtener seguidores de un usuario -> se obtienen hasta 5000 por página, se
	// puede setear un cursor para ir obteniendo la información.
	// si usamos el nombre solo ponemos el nick actual, no la direccion, es
	// decir, 91Alan por ejemplo.
	// --- he usado el metodo show user, quizas necesite usar otro tipo de
	// metodo, tal como searchUser o LookupUsers
	public String ObtenerListaSeguidores(String nombreUser, boolean ultimoTweet)
			throws TwitterException {
		try {
			StringBuilder cad = new StringBuilder();
			long cursor = -1;
			IDs ids;
			User user = null;
			do {
				ids = twitter.getFollowersIDs(nombreUser, cursor);
				for (long id : ids.getIDs()) {
					user = twitter.showUser(id);
					if (ultimoTweet) {
						if (user.getStatus() != null) {
							cad.append("@" + user.getScreenName() + "= "
									+ user.getDescription().toString() + "\n");
						} else {
							// por si el usuario esta protegido
							cad.append("@" + user.getScreenName() + "\n");
						}
					} else {
						if (user.getStatus() != null) {
							cad.append("@" + user.getScreenName() + "\n");
						}
					}
				}
			} while ((cursor = ids.getNextCursor()) != 0);
			return cad.toString();
			// System.exit(0);
		} catch (TwitterException te) {
			return te.getErrorMessage();
			/*
			 * te.printStackTrace();
			 * System.out.println("Fallo al obtener los siguientes ids: " +
			 * te.getMessage()); System.exit(-1);
			 */
		}
	}

	public String ObtenerListaSeguidos(String nombreUser, boolean verEstado)
			throws TwitterException {
		try {
			StringBuilder cad = new StringBuilder();
			long cursor = -1;
			IDs ids;
			User user = null;
			do {
				ids = twitter.getFriendsIDs(nombreUser, cursor);
				for (long id : ids.getIDs()) {
					user = twitter.showUser(id);
					if (verEstado) {
						if (user.getStatus() != null) {
							cad.append("@" + user.getScreenName() + "= "
									+ user.getDescription() + "\n");
						} else {
							cad.append("@" + user.getScreenName() + "\n");
						}
					} else {
						if (user.getStatus() != null) {
							cad.append("@" + user.getScreenName() + "\n");
						}
					}
				}
			} while ((cursor = ids.getNextCursor()) != 0);
			return cad.toString();
			// System.exit(0);
		} catch (TwitterException te) {
			return te.getErrorMessage();
			/*
			 * te.printStackTrace();
			 * System.out.println("Fallo al obtener los siguientes ids: " +
			 * te.getMessage()); System.exit(-1);
			 */
		}
	}

	// Recuperar listado de ultimos tweets escritos por ti y por la gente que
	// sigues
	public String GetTimeLine(int numeroTweets) throws TwitterException {
		StringBuilder cad = new StringBuilder();
		Paging pagina = new Paging();
		pagina.setCount(numeroTweets);
		ResponseList listado = twitter.getHomeTimeline(pagina);
		for (int i = 0; i < listado.size(); i++) {
			cad.append(((Status) listado.get(i)).getText() + "\n");
		}
		return cad.toString();
	}

	// se puede usar la clase Query y hacer una consulta que debería otorgar más
	// de 20 resultados, es decir, es posible obtener más tweets de un mismo
	// usuario (creo es posible hasta 160 resultados).

	// es curioso, porque con algunas lecturas no me deja leer nada, puede que
	// sea por el tiempo que ha estado la cuenta sin actualizar su estado y que
	// JSON lo elimine de su registro, tambien puede ser util la lista que nos
	// devuelve
	public String BuscarTweetsDeUsuario(String usuario) throws TwitterException {
		StringBuilder cad = new StringBuilder();
		Query query = new Query(usuario);
		QueryResult result = twitter.search(query);
		for (Status tweet : result.getTweets()) {
			cad.append(tweet.getUser() + ":" + tweet.getText());
		}
		return cad.toString();
	}

	// seguir personas, se le pasa el nombre de usuario sin el @
	public String SeguirA(String usuario) {
		StringBuilder cad = new StringBuilder();
		try {
			twitter.createFriendship(usuario);
			cad.append("Siguiendo a : [@" + usuario + "]");
			// System.exit(0);
		} catch (TwitterException te) {
			cad.append("fallo: \n " + te.getErrorMessage());
			/*
			 * te.printStackTrace(); System.out.println("Fallo al seguir: " +
			 * te.getMessage()); System.exit(-1);
			 */
		}
		return cad.toString();
	}

	// obtener una lista de seguidores
	public Set<String> SeguidoresDe(String usuario) throws InterruptedException {
		Set<String> listaUsuarios = new HashSet<>();
		try {
			long cursor = -1;
			IDs ids;
			User user = null;
			do {
				ids = twitter.getFollowersIDs(usuario, cursor);
				for (long id : ids.getIDs()) {
					user = twitter.showUser(id);
					if (user.getStatus() != null) {
						listaUsuarios.add(user.getScreenName());
					}
				}
			} while ((cursor = ids.getNextCursor()) != 0);

		} catch (TwitterException te) {
			System.out.print(te.getErrorMessage());
			/*
			 * te.printStackTrace();
			 * System.out.println("Fallo al obtener los siguientes ids: " +
			 * te.getMessage()); System.exit(-1);
			 */
		}
		System.out.println(listaUsuarios);
		System.out.println(listaUsuarios.size());
		return listaUsuarios;
	}

	public Set<String> SeguidosDe(String usuario) throws InterruptedException {
		Set<String> listaUsuarios = new HashSet<>();
		try {
			long cursor = -1;
			IDs ids;
			User user = null;
			do {
				ids = twitter.getFriendsIDs(usuario, cursor);
				for (long id : ids.getIDs()) {
					user = twitter.showUser(id);
					if (user.getStatus() != null) {
						listaUsuarios.add(user.getScreenName());
					}
				}
			} while ((cursor = ids.getNextCursor()) != 0);

		} catch (TwitterException te) {
			System.out.print(te.getErrorMessage());
			/*
			 * te.printStackTrace();
			 * System.out.println("Fallo al obtener los siguientes ids: " +
			 * te.getMessage()); System.exit(-1);
			 */
		}
		System.out.println(listaUsuarios);
		return listaUsuarios;
	}

	public Set<String> SiguiendoA(String usuario) throws InterruptedException {
		Set<String> listaUsuarios = new HashSet<>();
		try {
			long cursor = -1;
			IDs ids;
			User user = null;
			do {
				ids = twitter.getFriendsIDs(usuario, cursor);
				for (long id : ids.getIDs()) {
					user = twitter.showUser(id);
					if (user.getStatus() != null) {
						listaUsuarios.add(user.getScreenName());
					}
				}
			} while ((cursor = ids.getNextCursor()) != 0);

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Fallo al obtener los siguientes ids: "
					+ te.getMessage());
			System.exit(-1);
		}
		System.out.println(listaUsuarios);
		System.out.println(listaUsuarios.size());
		return listaUsuarios;
	}

	// seguir a todos los seguidores de un usuario
	// falta probar el metodo a ver si todo funciona.
	public void SeguirASeguidoresDe(String usuario) throws InterruptedException {
		Random rnd = new Random();
		int tiempoActual;
		int tiempoRandom = rnd.nextInt(5) + 5;
		TiempoEspera tiempo = new TiempoEspera();
		Iterator it;
		try {
			Set<String> listaUsuario = this.SeguidoresDe(usuario);
			listaUsuario.removeAll(this.SeguidoresDe(twitter.getScreenName()));
			listaUsuario.remove(twitter.getScreenName());
			System.out.println(listaUsuario.toString());
			it = listaUsuario.iterator();
			while (it.hasNext()) {
				tiempoActual = (int) tiempo.tiempoQueHaPasadoEnSegundos();
				if (tiempoActual == tiempoRandom) {
					System.out.println("segundo:" + tiempoActual);
					this.SeguirA(it.next().toString());
					tiempo.ponerTiempoACero();
					tiempoRandom = rnd.nextInt(5) + 5;
				}
			}
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Fallo al obtener los siguientes ids: "
					+ te.getMessage());
			System.exit(-1);
		}
	}

	public void SeguirASeguidoresDe_FormaArborea(String usuario)
			throws InterruptedException {
		Random rnd = new Random();
		int tiempoActual;
		int tiempoRandom = rnd.nextInt(5) + 5;
		TiempoEspera tiempo = new TiempoEspera();
		Iterator itAux, it;
		try {
			Set<String> listaUsuario = this.SeguidoresDe(usuario);
			Set<String> AuxListaUsuario = this.SeguidoresDe(usuario);
			itAux = AuxListaUsuario.iterator();
			while (itAux.hasNext()) {
				listaUsuario.addAll(this.SeguidoresDe(itAux.next().toString()));
			}
			listaUsuario.removeAll(this.SeguidoresDe(twitter.getScreenName()));
			listaUsuario.remove(twitter.getScreenName());
			it = listaUsuario.iterator();
			while (it.hasNext()) {
				tiempoActual = (int) tiempo.tiempoQueHaPasadoEnSegundos();
				if (tiempoActual == tiempoRandom) {
					System.out.println("segundo:" + tiempoActual
							+ "siguiendo a : " + it.next().toString());
					// this.SeguirA(it.next().toString());
					tiempo.ponerTiempoACero();
					tiempoRandom = rnd.nextInt(5) + 5;
				}
			}
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Fallo al obtener los siguientes ids: "
					+ te.getMessage());
			System.exit(-1);
		}
	}

	/*
	 * Random rnd = new Random(); int tiempoActual; int tiempoRandom =
	 * rnd.nextInt(5) + 5; TiempoEspera tiempo = new TiempoEspera(); while
	 * (true) { tiempoActual = (int) tiempo.tiempoQueHaPasadoEnSegundos(); if
	 * (tiempoActual == tiempoRandom) { System.out.println("Segundo:" +
	 * tiempoActual); tiempo.ponerTiempoACero(); tiempoRandom = rnd.nextInt(5) +
	 * 5; } }
	 */

	public String informacionDeCuentaPropia() {
		StringBuilder cad = new StringBuilder();
		try {
			AccountSettings settings = twitter.getAccountSettings();
			//cad.append("nombre de la cuenta: " + twitter.getScreenName() + "\n");
			//cad.append("sleep permitido: " + settings.isSleepTimeEnabled()+ "\n");
			//cad.append("Sleep tiempo de inicio: "+ settings.getSleepStartTime() + "\n");
			//cad.append("Sleep tiempo de final: " + settings.getSleepEndTime()+ "\n");
			//cad.append("Nombre de usuario: "+ ((TwitterBase) settings).getScreenName() + "\n");		
		} catch (TwitterException te) {
			// te.printStackTrace();
			cad.append("Fallo al obtener la cuenta: " + te.getMessage() + "\n");
			// System.exit(-1);
		}
		return cad.toString();
	}

	// seguir a todos los que sigue el usuario tal
	public void SeguirAQuienSigue(String usuario) throws InterruptedException {
		Random rnd = new Random();
		int tiempoActual;
		int tiempoRandom = rnd.nextInt(5) + 5;
		TiempoEspera tiempo = new TiempoEspera();
		Iterator it;
		try {
			Set<String> listaUsuario = this.SeguidosDe(usuario);
			listaUsuario.removeAll(this.SeguidosDe(twitter.getScreenName()));
			listaUsuario.remove(twitter.getScreenName());
			System.out.println(listaUsuario.toString());
			it = listaUsuario.iterator();
			while (it.hasNext()) {
				tiempoActual = (int) tiempo.tiempoQueHaPasadoEnSegundos();
				if (tiempoActual == tiempoRandom) {
					System.out.println("segundo:" + tiempoActual);
					this.SeguirA(it.next().toString());
					tiempo.ponerTiempoACero();
					tiempoRandom = rnd.nextInt(5) + 5;
				}
			}
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Fallo al obtener los siguientes ids: "
					+ te.getMessage());
			System.exit(-1);
		}
	}
}