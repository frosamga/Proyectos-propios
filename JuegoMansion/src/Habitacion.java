
public class Habitacion {

	private boolean tieneCofre,tieneNPC,tieneEnemigo,tieneObjeto,tieneArma;
	private String nombre;
	
	public Habitacion (String nombreHabitacion, boolean Cofre, boolean NPC, boolean Enemigo, boolean Objeto, boolean Arma){
		nombre= nombreHabitacion;
		tieneCofre=Cofre;
		tieneNPC=NPC;
		tieneEnemigo=Enemigo;
		tieneObjeto = Objeto;
		tieneArma = Arma;
	}
	
	public String DevolverNombreHabitacion(){
		return nombre;
	}
	
	public String toString(){
		return nombre+" - "+"Cofre: "+tieneCofre+" NPC: "+tieneNPC+" Enemigo: "+tieneEnemigo+ "Objeto: "+tieneObjeto+" Arma: "+tieneArma;
	}
}
