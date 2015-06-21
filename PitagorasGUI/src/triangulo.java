public class triangulo {

	public double resultado_catetos(double a, double b) {
			return  Math.sqrt((a*a) + (b*b));
	}

	public double resultado_cateto_hipotenusa(double cat, double hip) {
		return  Math.sqrt((hip*hip) - (cat*cat));
}
}
