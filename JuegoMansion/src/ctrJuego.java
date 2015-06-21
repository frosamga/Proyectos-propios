import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrJuego implements ActionListener,MouseListener {
	
	private vistaJuego v;
	private Mansion m;
	private Habitacion h;
	private PersonajePrincipal p;
	private Enemigo e;
	private Objetos o;
	private Arma a;
	private float x,y;
	private MouseListener mouse;
	
	public ctrJuego(vistaJuego vj, Mansion man ,Habitacion hab, PersonajePrincipal per, Enemigo ene, Objetos obj, Arma ar){
		v=vj;
		m=man;
		h=hab;
		p=per;
		e=ene;
		o=obj;
		a=ar;
	}
	public ctrJuego(MouseListener m){
		mouse=m;
	}

	public void actionPerformed(ActionEvent e) {
		/*
		String comando = evento.getActionCommand();
		try{
			if(comando.equals(vistaJuego.IRA)&&){
				
			}
		}
		*/
	}

	public void mouseClicked(MouseEvent arg0) {
		x=arg0.getX();
		y=arg0.getY();
	    System.out.println("x es ->"+x);
	    System.out.println("y es ->"+y);
	}
	
	public float devuelvePosicionX(){
		return x;
	}
	
	public float devuelvePosicionY(){
		return y;
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}
	
}
