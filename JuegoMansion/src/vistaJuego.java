import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class vistaJuego extends JPanel implements InterfazJuego {

	private JButton IrA, Coger, Atacar, Hablar, Huir, Mirar, Puerta, Baul,
			Enemigo1, Enemigo2, Enemigo3, NPC1;
	private ImageIcon enemigo1, enemigo1Herido, enemigo1CasiMuerto,
			enemigo1Muerto, enemigo2, enemigo2Herido, enemigo2CasiMuerto,
			enemigo2Muerto, enemigo3, enemigo3Herido, enemigo3CasiMuerto,
			enemigo3Muerto, NPC, Habitacion1, Habitacion2, Habitacion3,
			Habitacion4, Habitacion5, Habitacion6, Pasillo1, Pasillo2,
			Pasillo3, PasilloFin, Fin;
	private JLabel H1;
	private JTextField texto;
	private String textoCambiante = "Despiertas confuso en esta habitación y no sabes que ha pasado...";
	
	//private ctrJuego mouse = new Escuchador();

	public vistaJuego() {
		
			Habitacion1= new ImageIcon("Images/Habitacion1.jpg");
			H1=new JLabel(Habitacion1);
			IrA= new JButton("Ir a");
		    Coger= new JButton("Coger");
		    Hablar= new JButton("Hablar");
		    Mirar= new JButton("Mirar");
		    texto = new JTextField(textoCambiante);
		    texto.setEditable(false);
		    texto.setBackground(Color.GREEN);
	
		    //H1.addMouseListener(mouse);
		    
		    JPanel panelTexto = new JPanel();
		    panelTexto.setLayout(new FlowLayout());
		    panelTexto.add(texto);
		    
			JPanel panelSuperior = new JPanel();
			panelSuperior.setLayout(new FlowLayout());
			panelSuperior.setSize(500, 400);
			panelSuperior.add(H1);
			
			
			JPanel panelInferior1 = new JPanel();
			panelInferior1.setLayout(new GridLayout(2,2));
			panelInferior1.setSize(500, 200);
			panelInferior1.add(IrA);
			panelInferior1.add(Coger);
			panelInferior1.add(Hablar);
			panelInferior1.add(Mirar);
			
			JPanel panelDerecha = new JPanel();
			panelDerecha.setLayout(new BorderLayout());
			panelDerecha.setSize(200, 600);
			panelDerecha.add(new JLabel("Objetos del Inventario"));
			
			JPanel izquierda= new JPanel();
			izquierda.setLayout(new BorderLayout());
			izquierda.add(panelSuperior, BorderLayout.NORTH);
			izquierda.add(panelInferior1, BorderLayout.SOUTH);
			
			
			JPanel Completo= new JPanel();
			Completo.setLayout(new BorderLayout());
			Completo.add(panelTexto, BorderLayout.NORTH);
			Completo.add(izquierda, BorderLayout.WEST);
			Completo.add(panelDerecha, BorderLayout.EAST);
			add(Completo);
		
	}
	
	public void controlador (ActionListener ctr){
		IrA.addActionListener(ctr);
		IrA.setActionCommand(IRA);
		Coger.addActionListener(ctr);
		Coger.setActionCommand(COGER);
		Hablar.addActionListener(ctr);
		Hablar.setActionCommand(HABLAR);
		Mirar.addActionListener(ctr);
		Mirar.setActionCommand(MIRAR);
	}
	//ver!
	public void recibirClick(ctrJuego c){
		H1.addMouseListener(c);
	}

}
