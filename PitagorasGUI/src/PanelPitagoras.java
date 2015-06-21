import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelPitagoras extends JPanel implements vistaPitagoras {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3470916583776107997L;
	private JTextField catetoA, catetoB, hipotenusa;
	private JButton inicio;
	private ImageIcon imagen1;
	private JLabel e1, e2, e3, eImagen, resultado;

	public PanelPitagoras() {

		e1 = new JLabel("1º cateto");
		catetoA = new JTextField(10);
		e2 = new JLabel("2º cateto");
		catetoB = new JTextField(10);
		e3 = new JLabel("hipotenusa");
		hipotenusa = new JTextField(10);
		resultado = new JLabel("");
		inicio = new JButton("Inicio");
		imagen1 = new ImageIcon("Imagenes/triangulo.jpg");
		eImagen = new JLabel(imagen1);

		JPanel oeste = new JPanel();
		oeste.setLayout(new GridLayout(6, 1));
		oeste.add(e1);
		oeste.add(catetoA);
		oeste.add(e2);
		oeste.add(catetoB);
		oeste.add(e3);
		oeste.add(hipotenusa);
		//oeste.setBackground(Color.);
	

		JPanel parteSuperior = new JPanel();
		parteSuperior.setLayout(new GridLayout(1,2));
		parteSuperior.add(oeste);
		parteSuperior.add(eImagen);
		
		JPanel parteInferior = new JPanel();
		parteInferior.setLayout(new FlowLayout());
		parteInferior.add(inicio);
		parteInferior.add(resultado);
		parteInferior.setBackground(Color.CYAN);
		
		JPanel total = new JPanel();
		total.setLayout(new BorderLayout());
		total.add(parteSuperior, BorderLayout.NORTH);
		total.add(parteInferior, BorderLayout.SOUTH);
		add(total);
	}

	public void controlador(ActionListener ctr) {
		inicio.addActionListener(ctr);
		inicio.setActionCommand(CALCULO);
	}

	public double obtenerCantidadA() {
		if (catetoA.getText().isEmpty()) {
			return 0;
		} else {
			return Double.parseDouble(catetoA.getText());
		}
	}

	public double obtenerCantidadB() {
		if (catetoB.getText().isEmpty()) {
			return 0;
		} else {
			return Double.parseDouble(catetoB.getText());
		}
	}

	public double obtenerCantidadC() {
		if (hipotenusa.getText().isEmpty()) {
			return 0;
		} else {
			return Double.parseDouble(hipotenusa.getText());
		}
	}
	public void mensaje(String s){
		resultado.setText(s);
	}
}

