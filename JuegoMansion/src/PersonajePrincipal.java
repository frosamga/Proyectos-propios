
public class PersonajePrincipal {

	private String nombre;
	private float daño;
	private float vida;
	private boolean muerto=false;
	private Habitacion hab;
	
	public PersonajePrincipal(String nom, float damage, float healt){
		nombre=nom;
		daño=damage;
		vida=healt;
		hab=new Habitacion("Habitacion1",true,false,false,false,false);
	}
	
	public float atacar(){
		return daño;
	}
	
	public void loHieren(float dam){
		vida=vida-dam;
		if(vida<=0){
			muerto=true;
		}
	}
	
	public void arma(Arma arma){
		daño=daño+arma.dañoQueHace();
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
		//que coño!
	}
}
