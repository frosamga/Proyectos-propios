
public class TiempoEspera {

	private long tiempoInicio;
	
	public TiempoEspera(){
		tiempoInicio= System.currentTimeMillis();
	}
	public long tiempoQueHaPasadoEnSegundos(){
		return (System.currentTimeMillis()-tiempoInicio)/1000;
	}
	public void ponerTiempoACero(){
		tiempoInicio=System.currentTimeMillis();
	}
}
