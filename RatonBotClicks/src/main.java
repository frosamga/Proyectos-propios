import java.awt.AWTException;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Un pequeño bot que te da 5 segundos para poner el raton donde quieras y
 * clickea muchas veces, sirve para el coockie clicker, para juegos de facebook
 * y para hacer trampas, configurable y demas para hacer que cliquee en muchos
 * sitios, en un principio lo cree por trabajo, luego lo continue por diversion y
 * termine usandolo para "hckaear" una web y conseguir x1000 veces mas puntos que
 * los demas participantes mundiales :D
 * 
 * @author alan
 * 
 */

public class main {

	public static void main(String[] args) throws AWTException, IOException {

		JFrame frame = new JFrame("");
		frame.setSize(400, 100);
		frame.setTitle("Cierra esto para cerrar el programa");
		frame.add(new JTextField(
				"           Tienes 5 segundos para poner el raton donde se clickeara"));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocation(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		detallesRaton r = new detallesRaton(5);
	}

}
