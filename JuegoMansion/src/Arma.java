
public class Arma {

	private float da�o;
	private String nombre;
	private Arma [] arma = new Arma[10] ;
	
	public Arma(float damage, String nombre){
		da�o=damage;
		this.nombre=nombre;
	}
	
	public void ArmaA�adir(Arma[] o) {
	
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
	public float da�oQueHace(){
		return da�o;
	}
	
}
