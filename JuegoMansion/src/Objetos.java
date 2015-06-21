public class Objetos {

	private String nombre;
	private String[] ObjetosInventario= new String[10];

	public Objetos(String nombre) {
		nombre = nombre;
	}

	public void ObjetoAñadir(String o) {
		for (int i = 0; i < this.ObjetosInventario.length; i++) {
			if (this.ObjetosInventario[i] == null) {
				this.ObjetosInventario[i] = o;
				i = this.ObjetosInventario.length - 1;
			} else {
				// no puedes llevar mas objetos, mostrar
				i = this.ObjetosInventario.length - 1;
				//quizas esto sea innecesario
			}
		}
	}

	public void ObjetoQuitar(String o) {
		for (int i = 0; i < this.ObjetosInventario.length; i++) {
			if (this.ObjetosInventario[i] == o) {
				this.ObjetosInventario[i] = null;
				i = this.ObjetosInventario.length - 1;
			} else {
				// ese objeto no esta, mostrar
			}
		}

	}
}
