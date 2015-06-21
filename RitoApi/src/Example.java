import java.util.Map;

import constant.Region;
import dto.Summoner.Summoner;
import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;
import com.google.gson.*;

public class Example {

	public static void main(String[] args) throws RiotApiException {

		RiotApi api = new RiotApi("CLAVE");
		Invocadores obtener = new Invocadores(api);
		String nombreInvocador = "ameltee";
		Region region = Region.EUW;
		if (obtener.ObtenerInvocador(region, nombreInvocador).isEmpty()) {
			System.out.println(obtener.devolverLista().get(0).toString());
		}else{
			System.out.println(obtener.ObtenerInvocador(region, nombreInvocador));
		}
	}
}