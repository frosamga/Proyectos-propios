
public class PersonajePrincipal {

	private String nombre;
	private float da�o;
	private float vida;
	private boolean muerto=false;
	private Habitacion hab;
	
	public PersonajePrincipal(String nom, float damage, float healt){
		nombre=nom;
		da�o=damage;
		vida=healt;
		hab=new Habitacion("Habitacion1",true,false,false,false,false);
	}
	
	public float atacar(){
		return da�o;
	}
	
	public void loHieren(float dam){
		vida=vida-dam;
		if(vida<=0){
			muerto=true;
		}
	}
	
	public void arma(Arma arma){
		da�o=da�o+arma.da�oQueHace();
	}
	
	public float vidaQueTiene(){
		return vida;
	}
	
	public boolean estaMuerto(){
		return muerto;
	}
	
	public String HabitacionDondeEsta(){
		return hab.DevolverNombreHabitacion();
	}
	public void CambiaDeHabitacion(Habitacion h){
		//que co�o!
	}
}
