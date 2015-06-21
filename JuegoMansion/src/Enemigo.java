
public class Enemigo {
	
	private String nombre;
	private float da�o;
	private float vida;
	private boolean muerto=false;
	
	public Enemigo(String nom, float damage, float healt){
		nombre=nom;
		da�o=damage;
		vida=healt;
	}
	
	public float atacar(){
		return da�o;
	}
	public void recibeDa�o(float dam){
		vida=vida-dam;
		if(vida<=0){
			muerto=true;
		}
	}
	public boolean estaMuerto(){
		return muerto;
	}
	
	public float vida(){
		return vida;
	}
}
