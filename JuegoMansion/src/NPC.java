public class NPC {

	private String nombre;

	public NPC(String nombre) {
		this.nombre = nombre;
	}

	public String Dialogo(String nombreNPC, String opcion){
	 
		String dialogo1="Debemos escapar de aqui, pasan cosas muy raras, nesecito algo para abrir esta caja y coger la llave de la Mansion para poder escapar";
		String dialogo2="¿Que te puede ayudar?";
		String dialogo3="Cualquier cosa que sea solida, unas tenazas estarian bien...";
		String dialogo4="De acuerdo, ire a buscar";
		String dialogo5="Ya he conseguido lo que nesecitabas";
		String dialogo6="Perfecto,ya esta abierto, vamonos, la salida esta al final del pasillo ya te contare lo que ha ocurrido aqui..."; 
		String aux= null;
		if(nombreNPC == "Elodin"){
			if(opcion==dialogo1){
				aux=dialogo1;
			}else if(opcion==dialogo2){
				aux=dialogo2;
			}else if(opcion==dialogo3){
				aux=dialogo3;
			}else if(opcion==dialogo4){
				aux=dialogo4;
			}else if(opcion==dialogo5){
				aux=dialogo5;
			}else if(opcion==dialogo6){
				aux=dialogo6;
			}			
		}else{
			aux="error";
			//otros personajes
		}
		return aux;
	}
}
