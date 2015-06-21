
public class Arma {

	private float daño;
	private String nombre;
	private Arma [] arma = new Arma[10] ;
	
	public Arma(float damage, String nombre){
		daño=damage;
		this.nombre=nombre;
	}
	
	public void ArmaAñadir(Arma[] o) {
	
		for (int i = 0; i < this.arma.length; i++) {
			if (this.arma[i] == null) {
				this.arma = o;
				i = this.arma.length - 1;
			} else {
				// no puedes llevar mas objetos, mostrar
				i = this.arma.length - 1;
				//quizas esto sea innecesario
			}
		}
	}

	public String nombre(){
		return nombre;
	}
	public float dañoQueHace(){
		return daño;
	}
	
}
