import java.awt.event.ActionListener;
public interface vistaPeliculas {
public static final String PISTA = "PISTA";
public static final String SOLUCION = "SOLUCION";
public static final String ENVIAR = "ENVIAR";



public void controlador(ActionListener ctr);

public void escribirPista(String s);

public void cambiarImagen(String s);

public void activarSI(boolean b);

public void activarNO(boolean b); 

public String leerRespuesta();

public void modificarPuntuacion(int s);

public int puntuacionTotal();

}