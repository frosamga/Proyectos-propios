import java.awt.event.ActionListener;

public interface VistaTwitter {
	public static final String ENVIARUSUARIO = "ENVIARUSUARIO";
	public static final String ACTUALIZARESTADO = "ACTUALIZARESTADO";
	public static final String ACTUALIZARFOTO = "ACTUALIZARFOTO";
	public static final String SEGUIDORES = "SEGUIDORES";
	public static final String SEGUIDOS = "SEGUIDOS";
	public static final String TIMELINE = "TIMELINE";
	public static final String BUSCARTWEETS = "BUSCARTWEETS";
	public static final String SEGUIRSEGUIDORES = "SEGUIRSEGUIDORES";
	public static final String SEGUIRSEGUIDOS = "SEGUIRSEGUIDOS";
	public static final String INFO = "INFO";

	public void controlador(ActionListener ctr);

	public String usuario();

	public String pass();

	public String PublicarTweet();

	public String ActualizarFoto();

	public String SeguidoresDe();

	public String SeguidosDe();

	public String buscarTweetsDe();

	public int Timeline();

	public String SeguirSeguidoresDe();

	public String SeguirSeguidosDe();

	public void ok(String mensaje);

	public void habilitarInicio(boolean b);

	public boolean checkSeguidores();

	public boolean checkSeguidos();

	public void limpiar();

	void añadirAHistórico(String mensaje);
	

}
