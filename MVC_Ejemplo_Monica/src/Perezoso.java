import javax.swing.JFrame;
import javax.swing.JPanel;


public class Perezoso {

	public static void main(String[] args) {
		Vista pere=new Juju();
		Controlador ctr=new Controlador(pere);
		pere.controlador(ctr);
		
		JFrame ventana = new JFrame("Ejemplo de MVC");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setContentPane((JPanel) pere);
		ventana.pack();
		ventana.setResizable(false);
		ventana.setVisible(true);
	}

}
