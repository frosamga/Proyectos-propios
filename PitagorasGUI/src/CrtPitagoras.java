import java.awt.event.*;

public class CrtPitagoras implements ActionListener {

	private vistaPitagoras vista;
	private triangulo tri;
	private double valorC1, valorC2, valorH;

	public CrtPitagoras(vistaPitagoras v, triangulo t) {
		vista = v;
		tri = t;
	}

	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		try {
			if (comando.equals(vistaPitagoras.CALCULO)) {
				valorC1 = vista.obtenerCantidadA();
				valorC2 = vista.obtenerCantidadB();
				valorH = vista.obtenerCantidadC();

				if ((valorC1 != 0) && (valorC2 != 0) && (valorH != 0)) {
					vista.mensaje("Introduce solo 2 valores");
				} else if ((valorC1 != 0) && (valorC2 != 0) && (valorH == 0)) {
					vista.mensaje("La hipotenusa vale: "+String.valueOf(tri.resultado_catetos(valorC1,
							valorC2)));
				} else if ((valorC1 == 0) && (valorC2 != 0) && (valorH != 0)) {
					if (valorH <= valorC2) {
						vista.mensaje("La hipotenusa no puede ser mas pequeña que el cateto");
					} else {
						vista.mensaje("El cateto vale: "
								+ String.valueOf(tri
										.resultado_cateto_hipotenusa(valorC2,
												valorH)));
					}
				} else if ((valorC1 != 0) && (valorC2 == 0) && (valorH != 0)) {
					if (valorH <= valorC1) {
						vista.mensaje("La hipotenusa no puede ser mas pequeña que el cateto");
					} else {
						vista.mensaje("El cateto vale: "
								+ String.valueOf(tri
										.resultado_cateto_hipotenusa(valorC1,
												valorH)));
					}
				} else if ((valorC1 == 0) && (valorC2 == 0) && (valorH == 0)) {
					vista.mensaje("Pon dos valores");
				} else {
					vista.mensaje("introduce 2 valores numericos");
				}
			}
		} catch (RuntimeException e) {
			e.getMessage();
		}
	}

}
