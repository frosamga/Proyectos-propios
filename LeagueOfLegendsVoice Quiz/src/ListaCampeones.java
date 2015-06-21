import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ListaCampeones {

	private List<String> listaCampeones;
	private List<String> listaSeleccionados;
	private List<Integer> numerosOcupados;
	private String[] arrayCampeones = { "Aatrox", "Ahri", "Akali", "Alistar",
			"Amumu", "Anivia", "Annie", "Ashe", "Azir", "Bardo", "Blitzcrank",
			"Brand", "Braum", "Caitlyn", "Cassiopeia", "ChoGath", "Corki",
			"Darius", "Diana", "DrMundo", "Draven", "Elise", "Evelynn",
			"Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank",
			"Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger",
			"Irelia", "Janna", "JarvanIV", "Jax", "Jayce", "Jinx", "Kalista",
			"Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kennen",
			"KhaZix", "KogMaw", "LeBlanc", "LeeSin", "Leona", "Lissandra",
			"Lucian", "Lulu", "Lux", "MasterYi", "Malphite", "Malzahar",
			"Maokai", "MissFortune", "Mordekaiser", "Morgana", "Nami",
			"Nasus", "Nautilus", "Nidalee", "Nocturne", "Nunu", "Olaf",
			"Orianna", "Pantheon", "Poppy", "Quinn", "Rammus", "RekSai",
			"Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Sejuani",
			"Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner",
			"Sona", "Soraka", "Swain", "Syndra", "Talon", "Taric", "Teemo",
			"Thresh", "Trundle", "Tryndamere", "Twisted Fate", "Twitch",
			"Udyr", "Urgot", "Varus", "Vayne", "Veigar", "VelKoz", "Vi",
			"Viktor", "Vladimir", "Volibear", "Warwick", "Monkeyking", "Xerath",
			"XinZhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs", "Zilean",
			"Zyra" };
	Random rnd;

	public ListaCampeones() {
		// creo una lista con los campeones
		listaCampeones = new ArrayList<String>();
		listaCampeones.addAll(Arrays.asList(arrayCampeones));
		// los que ya se hayan cogido entran aqui
		listaSeleccionados = new ArrayList<String>();
		numerosOcupados = new ArrayList<Integer>();
		// genera un numero aleatorio para coger de la lista
		rnd = new Random();
	}

	public Map<String, Boolean> getPreguntaCampeonAleatorio() {

		// tira un random cualquiera
		int random = rnd.nextInt(listaCampeones.size());
		String campeon = "";
		boolean esta = true;

		//
		while (esta) {
			if (!listaSeleccionados.contains(listaCampeones.get(random))) {
				campeon = listaCampeones.get(random);
				numerosOcupados.add(random);
				esta = false;
			} else {
				random = rnd.nextInt(listaCampeones.size());
			}

		}
		Map<String, Boolean> pregunta = new HashMap<String, Boolean>();
		List<Integer> randomParaPregunta = new ArrayList<Integer>();
		listaSeleccionados.add(campeon);
		randomParaPregunta = this.generarListaCampeones(random);
		pregunta.put(campeon, true);
		pregunta.put(listaCampeones.get(randomParaPregunta.get(0)), false);
		pregunta.put(listaCampeones.get(randomParaPregunta.get(1)), false);
		pregunta.put(listaCampeones.get(randomParaPregunta.get(2)), false);
		// elimina la posibilidad que salgan 3 en una lista de 4
		while (pregunta.size() < 4) {
			random = rnd.nextInt(listaCampeones.size());
			if (!listaSeleccionados.contains(listaCampeones.get(random))) {
				pregunta.put(listaCampeones.get(random), false);
			}
		}
		return pregunta;
	}

	private List<Integer> generarListaCampeones(int numeroYaCogido) {
		List<Integer> aleatorioCampeones = new ArrayList<Integer>();
		
		numerosOcupados.add(numeroYaCogido);
		boolean esta = true;
		int random = rnd.nextInt(listaCampeones.size());
		while (esta) {
			if (!numerosOcupados.contains(random)) {
				aleatorioCampeones.add(random);
				random = rnd.nextInt(listaCampeones.size());
				esta = false;
			} else {
				random = rnd.nextInt(listaCampeones.size());
			}
		}
		while (!esta) {
			if (!numerosOcupados.contains(random)) {
				aleatorioCampeones.add(random);
				random = rnd.nextInt(listaCampeones.size());
				esta = true;
			} else {
				random = rnd.nextInt(listaCampeones.size());
			}
		}
		while (esta) {
			if (!numerosOcupados.contains(random)) {
				aleatorioCampeones.add(random);
				random = rnd.nextInt(listaCampeones.size());
				esta = false;
			} else {
				random = rnd.nextInt(listaCampeones.size());
			}
		}
		return aleatorioCampeones;
	}
}
