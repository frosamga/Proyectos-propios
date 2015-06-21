public class main {

	public static void main(String[] args) {
		// GetFileNames x = new
		// GetFileNames("C:/Users/Alan_2/Desktop/APPS ANDROID/LeagueOfLegendsQuizVoices/Sonidos/voice-me");
		ListaCampeones listac = new ListaCampeones();
		for(int i=1; i<=121;i++){
			System.out.println(listac.getPreguntaCampeonAleatorio().size());
		}

	
		
	}

}
