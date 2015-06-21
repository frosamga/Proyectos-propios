import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{

	private Vista vista;
	public Controlador(Vista vista){
		this.vista=vista;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Vista.CARGAR)){
			vista.cargar();
		}
		
	}
	
}
