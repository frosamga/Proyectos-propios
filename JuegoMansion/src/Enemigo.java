
public class Enemigo {
	
	private String nombre;
	private float daño;
	private float vida;
	private boolean muerto=false;
	
	public Enemigo(String nom, float damage, float healt){
		nombre=nom;
		daño=damage;
		vida=healt;
	}
	
	public float atacar(){
		return daño;
	}
	public void recibeDaño(float dam){
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
