import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelPeliculas extends JPanel implements vistaPeliculas {

	private JButton pista, solucion,send;
	private JLabel ImagenSI, ImagenNO, puntuacion, contadorPuntuacion,
			imagenPrincipal, imagenSecundaria,espacioPista;
	private ImageIcon SI, NO, Imagen1, Imagen2;
	private JTextField escrito;
	protected int ptosTotales;
	private String imagenQueEntra;
	private boolean n=false,s=false;


	public panelPeliculas(String im1) { //deberia de entrarle las cosas para poner las peliculas
	
		imagenQueEntra=im1;	
		Imagen1= new ImageIcon(imagenQueEntra);
		imagenPrincipal = new JLabel(Imagen1);  //imagen variable entre imagen1 e imagen2
		SI = new ImageIcon("Images/si.jpg");
		ImagenSI = new JLabel(SI);
		ImagenSI.setVisible(s);
		NO = new ImageIcon("Images/no.jpg");
		ImagenNO = new JLabel(NO);
		ImagenNO.setVisible(n);
		puntuacion = new JLabel("Puntuacion :");
		//ver puntuacion
		contadorPuntuacion = new JLabel("Al final la pondre"); //String.valueOf(ptosTotales)
		pista= new JButton("Pista");
		solucion= new JButton("Solucion");
		espacioPista= new JLabel(""); // es variable la pista, ya vere
		escrito= new JTextField(50);
		send = new JButton("=>");
		
		
		JPanel arriba1_1= new JPanel();
		arriba1_1.setLayout(new GridLayout(1,2));
		arriba1_1.add(ImagenSI);
		arriba1_1.add(ImagenNO);
		arriba1_1.setBackground(Color.LIGHT_GRAY);
		
		JPanel arriba1_2= new JPanel();
		arriba1_2.setLayout(new GridLayout(1,2));
		arriba1_2.add(puntuacion);
		arriba1_2.add(contadorPuntuacion);
		arriba1_2.setBackground(Color.LIGHT_GRAY);
		
		JPanel arriba1= new JPanel();
		arriba1.setLayout(new GridLayout(1,2));
		arriba1.add(arriba1_1);
		arriba1.add(arriba1_2);
		arriba1.setBackground(Color.LIGHT_GRAY);
		
		JPanel arriba = new JPanel();
		arriba.setLayout(new FlowLayout());
		arriba.add(arriba1);
		arriba.setBackground(Color.LIGHT_GRAY);

		JPanel medio = new JPanel();
		medio.setLayout(new FlowLayout());
		medio.add(imagenPrincipal);
		medio.setBackground(Color.LIGHT_GRAY);

		
		JPanel abajo1 = new JPanel();
		abajo1.setLayout(new GridLayout (1,2));
		abajo1.add(pista);
		abajo1.add(solucion);
		abajo1.setBackground(Color.LIGHT_GRAY);
		
		JPanel abajo2 = new JPanel();
		abajo2.setLayout(new FlowLayout());
		abajo2.add(espacioPista);
		abajo2.setBackground(Color.LIGHT_GRAY);
		
		JPanel abajo3 = new JPanel();
		abajo3.setLayout(new BorderLayout());
		abajo3.add(escrito, new BorderLayout().WEST);
		abajo3.add(send, new BorderLayout().EAST);
		abajo3.setBackground(Color.LIGHT_GRAY);
		
		JPanel abajo = new JPanel();
		abajo.setLayout(new GridLayout(3,1));
		abajo.add(abajo1);
		abajo.add(abajo2);
		abajo.add(abajo3);
		abajo.setBackground(Color.LIGHT_GRAY);
		
		JPanel total = new JPanel();
		total.setLayout(new BorderLayout());
		total.add(arriba, BorderLayout.NORTH);
		total.add(medio,BorderLayout.CENTER);
		total.add(abajo, BorderLayout.SOUTH);
		total.setBackground(Color.LIGHT_GRAY);
		
		add(total);
	}



	public void controlador(ActionListener ctr) {
		pista.addActionListener(ctr);
		pista.setActionCommand(PISTA);
		solucion.addActionListener(ctr);
		solucion.setActionCommand(SOLUCION);
		send.addActionListener(ctr);
		send.setActionCommand(ENVIAR);
	}


	
	public void escribirPista(String s) {
		espacioPista.setText(s);
	}
	

	public void cambiarImagen(String s) {
		this.imagenPrincipal.setIcon(new ImageIcon(s));
	}

	public void activarSI(boolean b) {
		this.ImagenSI.setVisible(b);
		
	}

	public void activarNO(boolean b) {
		this.ImagenNO.setVisible(b);
		
	}
	
	public String leerRespuesta() {
		return escrito.getText();
	}
	public void modificarPuntuacion(int s) {
		ptosTotales+=s;
		this.contadorPuntuacion.setText(String.valueOf(ptosTotales));
		
	}
	public int puntuacionTotal(){
		return ptosTotales;
	}
	

}