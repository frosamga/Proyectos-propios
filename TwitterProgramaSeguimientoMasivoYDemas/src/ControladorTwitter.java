import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import twitter4j.TwitterException;

public class ControladorTwitter implements ActionListener {
	private VistaTwitter v;
	private Twitter1 twitter;

	public ControladorTwitter(VistaTwitter vt, Twitter1 tw)
			throws TwitterException {
		v = vt;
		twitter = tw;
	}

	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals(v.ENVIARUSUARIO)) {
			enviarUsuario(v.usuario(), v.pass());
		} else if (comando.equals(v.ACTUALIZARESTADO)) {
			actualizarEstado(v.PublicarTweet());
		} else if (comando.equals(v.ACTUALIZARFOTO)) {
			actualizarFoto(v.ActualizarFoto());
		} else if (comando.equals(v.SEGUIDORES)) {
			seguidoresDe(v.SeguidoresDe(), v.checkSeguidores());
		} else if (comando.equals(v.SEGUIDOS)) {
			seguidosDe(v.SeguidosDe(), v.checkSeguidos());
		} else if (comando.equals(v.TIMELINE)) {
			timeline(v.Timeline());
		} else if (comando.equals(v.BUSCARTWEETS)) {
			buscarTweets(v.buscarTweetsDe());
		} else if (comando.equals(v.SEGUIRSEGUIDORES)) {
			seguirSeguidoresDe(v.SeguirSeguidoresDe());
		} else if (comando.equals(v.SEGUIRSEGUIDOS)) {
			seguirSeguidosDe(v.SeguirSeguidosDe());
		} else if (comando.equals(v.INFO)) {
			info();
		}

	}

	private void enviarUsuario(String usuario, String pass) {

	}

	private void actualizarEstado(String publicarTweet) {
		try {
			v.añadirAHistórico(twitter.ActualizarEstado(publicarTweet));
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private void actualizarFoto(String actualizarFoto) {
		try {
			v.añadirAHistórico(twitter.ActualizarFoto(new File(actualizarFoto)));
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private void seguirSeguidosDe(String seguirSeguidosDe) {
		try {
			twitter.SeguirAQuienSigue(seguirSeguidosDe);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void seguirSeguidoresDe(String seguirSeguidoresDe) {
		try {
			twitter.SeguirASeguidoresDe(seguirSeguidoresDe);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void buscarTweets(String buscarTweetsDe) {
		try {
			v.añadirAHistórico(twitter.BuscarTweetsDeUsuario(buscarTweetsDe));
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private void timeline(int timeline) {
		try {
			v.añadirAHistórico(twitter.GetTimeLine(timeline));
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private void seguidosDe(String seguidosDe, boolean checkSeguidos) {
		try {
			v.añadirAHistórico(twitter.ObtenerListaSeguidos(seguidosDe,
					checkSeguidos));
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private void seguidoresDe(String seguidoresDe, boolean checkSeguidores) {
		try {
			v.añadirAHistórico(twitter.ObtenerListaSeguidores(seguidoresDe,
					checkSeguidores));
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void info() {
		v.añadirAHistórico(twitter.informacionDeCuentaPropia());
	}

	private void enviarUsuario() {
		/*
		 * int capacidadInicialA; int capacidadInicialB; try { capacidadInicialA
		 * = v.capacidadInicialA(); capacidadInicialB = v.capacidadInicialB();
		 * if ((capacidadInicialA > 0) && (capacidadInicialB > 0)) { jarraA =
		 * new Jarra(capacidadInicialA); jarraB = new Jarra(capacidadInicialB);
		 * v.capacidadA(capacidadInicialA); v.capacidadB(capacidadInicialB);
		 * v.contenidoA(0); v.contenidoB(0);
		 * v.ok("Jarras creadas correctamente"); v.habilitarInicio(true); } else
		 * { v.error("Las capacidades de las jarras deben ser mayor que cero");
		 * } } catch (NumberFormatException e) {
		 * v.error("Las capacidades de las jarras deben ser números"); }
		 */

	}

}
