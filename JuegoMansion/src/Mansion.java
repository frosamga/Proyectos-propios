public class Mansion {

	private int AltoMatriz , AnchoMatriz;
	private Habitacion[][] hab;
	

	private Habitacion h = new Habitacion ("Hab1",true,false,false,false,false);
	
	public Mansion() {
		AltoMatriz = 3;
		AnchoMatriz = 4;
		hab = new Habitacion[AltoMatriz][AnchoMatriz];
	}

	public Mansion(int a, int b) {
		AltoMatriz = a;
		AnchoMatriz = b;
	}
	
	//solo comprobacion de filas y columnas
	public void mostrarMatriz(){
		for(int i =0;i<AltoMatriz;i++){
			for(int u=0; u<AnchoMatriz;u++){
				System.out.print(hab[i][u]+"             ");
			}
			System.out.println("");
		}	
	}
	
	
	// se rellenan manualmente desde aqui, en el main da problemas
	public void rellenarHabitaciones() {
		
		hab[0][0] = new Habitacion("Hab4",false,false,true,false,false);		
		hab[0][1] = new Habitacion("Hab5",false,true,false,false,false);	
		hab[0][2] = new Habitacion("Hab6",false,false,true,false,false);		
		hab[1][0] = new Habitacion("Pas1",false,false,false,false,false);
		hab[1][1] = new Habitacion("Pas2",false,false,false,false,false);
		hab[1][2] = new Habitacion("Pas3",false,false,false,false,false);
		hab[1][3] = new Habitacion("Hall",false,false,false,false,false);
		hab[2][0] = new Habitacion("Hab1",true,false,false,false,true);
		hab[2][1] = new Habitacion("Hab2",false,false,false,true,true);
		hab[2][2] = new Habitacion("Hab3",false,false,true,false,false);

	}
	
	public String nombreHabitacionPersonajePrincipal(PersonajePrincipal p){
		return "sfd";
	}
}
