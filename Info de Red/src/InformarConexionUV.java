import java.io.*;
import java.net.*;

/**
 * Ejemplo de formas de obtener a donde esta conectado, puerto, desde la direccion y tal, es como un ipconfig pero desde java
 * 
 * @author alan
 *
 */

public class InformarConexionUV {

		public static void main(String[] args){
			Socket socket= null;
			try{
				InetAddress direccion= InetAddress.getByName("5.109.233.30");
				socket= new Socket(direccion, 25565);
				System.out.println("Conectado a "+socket.getInetAddress());
				System.out.println("por el puerto "+socket.getPort());
				System.out.println("Desde el puerto "+socket.getLocalPort());
				System.out.println("y desde la direccion local "+socket.getLocalAddress());
			}
			catch(UnknownHostException e1){
				System.out.println("no se encontro la maquina");
			}catch(SocketException e2){
				System.out.println("no se pudo encontrar la maquina por ese puerto");
			}catch(IOException e3){
				System.out.println(e3);
			}finally{
				try{
					socket.close();
				}catch(IOException e4){
					//es por si ya se ha cerrado
					System.out.println(e4);
				}
			}
		}
}
