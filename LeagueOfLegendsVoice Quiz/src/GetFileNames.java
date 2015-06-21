import java.io.File;
import java.util.ArrayList;

public class GetFileNames {
	String sDirectorio;
	File f;

	public GetFileNames(String rutaCarpeta) {
		sDirectorio = rutaCarpeta;
		f = new File(sDirectorio);
		String name,nameTotal;
		if (f.exists()) {
			File[] ficheros = f.listFiles();
			for (int x = 0; x < ficheros.length; x++) {
				name = ficheros[x].getName().toLowerCase();
				name=name.substring(0, name.length()-7);
				System.out.println(name);
				ficheros[x].renameTo(new File("C:/Users/Alan_2/Desktop/APPS ANDROID/LeagueOfLegendsQuizVoices/Sonidos/raw", name+"_me.mp3"));
			}
		} else {

		}
	}
}
