import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Casino {

	private double dinero, mesaGasto;
	private List<Integer> negras = new ArrayList<Integer>();
	private List<Integer> rojas = new ArrayList<Integer>();

	public Casino(double dineroTienes, double mesaCuantoCuesta) {
		dinero = dineroTienes;
		mesaGasto = mesaCuantoCuesta;
		this.agregarNum();
	}

	public void agregarNum() {

		// Si si, recorrelo con un while o un for y haz i%2, pero la ruleta no
		// tiene un patron, tipo pares = negras, sino es que haz jugado poco
		negras.add(2);
		negras.add(4);
		negras.add(6);
		negras.add(8);
		negras.add(10);
		negras.add(11);
		negras.add(13);
		negras.add(15);
		negras.add(17);
		negras.add(20);
		negras.add(22);
		negras.add(24);
		negras.add(26);
		negras.add(28);
		negras.add(29);
		negras.add(31);
		negras.add(33);
		negras.add(35);
		rojas.add(1);
		rojas.add(3);
		rojas.add(5);
		rojas.add(7);
		rojas.add(9);
		rojas.add(12);
		rojas.add(14);
		rojas.add(16);
		rojas.add(18);
		rojas.add(19);
		rojas.add(21);
		rojas.add(23);
		rojas.add(25);
		rojas.add(27);
		rojas.add(30);
		rojas.add(32);
		rojas.add(34);
		rojas.add(36);
	}

	public int random() {
		Random ran = new Random();
		int res = ran.nextInt(37);
		return res;
	}

	public int fichasQueTienes(double dinero, double mesa) {
		int res;
		if (dinero < mesa) {
			res = 0;
		} else {
			res = (int) (dinero / mesa);
		}
		return res;
	}

	public void apostar(int numApuesta) {
		this.fichasQueTienes(dinero, mesaGasto);
		dinero -= mesaGasto;

	}

}
