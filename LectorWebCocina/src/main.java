public class main {

	public static void main(String[] args) {
		String foto = "http://canalcocina.es/medias/_cache/zoom-dc595907f75bea7f61da7c4a0dfb1912-398-299.jpg";
		String dondeGuardar = "C:/Users/alan/Desktop/AppCocina/foto.jpg";
		Lector lc = new Lector();
		//lc.guardarFoto(foto, dondeGuardar);
		lc.leerRutaARecetasHastax("http://canalcocina.es/recetas/buscar/pag/", 1);
		//lc.leerRutaARecetas("http://canalcocina.es/recetas");
	}
}
