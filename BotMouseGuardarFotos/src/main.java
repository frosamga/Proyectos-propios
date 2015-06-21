import java.awt.AWTException;
import java.io.IOException;


/**
 * Bot que cada 10 segundos saca un pantallazo y lo guarda, es un bot interesante para guardar info
 * 
 * @author alan
 *
 */

public class main {


	public static void main(String[] args) throws AWTException, IOException {
		detallesRaton r= new detallesRaton(5,"C:/Users/alan/Pictures/PruebaJava/");
		while(true){
			r.moverRaton();
			//r.pantallazo();
		}
	}

}
