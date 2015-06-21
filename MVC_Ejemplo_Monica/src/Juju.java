import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.net.URL;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Juju extends JPanel implements Vista{
	JButton cargar;
	JTextField texto;
	ImageIcon fusfus,fusfus1;
	JLabel mec,aux,fufi,fufi1;
	String perezoso="perezoso";
	boolean nop=false;
	public Juju(){
		cargar=new JButton("cargar");
		texto=new JTextField();
		mec=new JLabel("¿Qué animal estará escondido?");
		fusfus = new ImageIcon("perezoso/ewee.gif"); 
		fusfus1=new ImageIcon("perezoso/perezoso.jpg");
		fufi1=new JLabel(fusfus1);
		fufi1.setVisible(false);
		fufi=new JLabel(fusfus);
		fufi.setVisible(false);
		
		aux=new JLabel("Pista: es lento");
		aux.setVisible(nop);
		
		 
		
		JPanel ofu=new JPanel();
		ofu.setLayout(new GridLayout(3,1));
		ofu.add(texto);
		ofu.add(cargar);
		ofu.add(aux);
		
		JPanel piu=new JPanel();
		piu.setLayout(new GridLayout(2,2));
		piu.add(mec);
		piu.add(fufi);
		piu.add(ofu);
		piu.add(fufi1);
		add(piu);
		
	}
	public void controlador(ActionListener ctr){
		cargar.addActionListener(ctr);
		cargar.setActionCommand(CARGAR);
	}
	
	public void cargar() {
		if(texto.getText().contentEquals(perezoso)){
			fufi.setVisible(true);
			fufi1.setVisible(true);
			aux.setVisible(nop);
			
		}else{
			nop=true;
			aux.setVisible(nop);
			nop=false;
		}
		
		
	}
	
}
