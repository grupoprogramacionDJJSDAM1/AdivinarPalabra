package codigo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Partida {
private static LocalDate fecha=LocalDate.now();
private static String nombrejugador;
private final static int INTENTOS=3;
private Palabra palabras[];
public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
public static boolean salirBucle = false;

public Partida(LocalDate fecha, String nombrejugador, Palabra[] palabras) {
	
	this.fecha = fecha;
	this.nombrejugador = nombrejugador;
	this.palabras = palabras;
}


public Partida() {
	
}

public static void pintarMenuPrincipal() {

    System.out.println(nombrejugador +" "+"|" + fecha +"|"+ " "+ "Intentos:" + INTENTOS + " "+"" + "\n" );
    System.out.println("*****************************************************************************");
    System.out.println("--------------------------ADIVINAR PALABRAS----------------------------------");
//    System.out.println("----------------------"+" "+ nombrejugador +" "+"|" + fecha +"|"+ " "+ "Intentos:" +INTENTOS + " " + "-------------------------");
    System.out.println("------------------------1. Resolver palabra----------------------------------");
    System.out.println("------------------------2. Decir letra---------------------------------------");
    System.out.println("------------------------3. Dar palabra---------------------------------------");
    System.out.println("------------------------4. Salir---------------------------------------------");
    System.out.println("*****************************************************************************");

    System.out.println("\n Elige una opcion del 1 al 4: ");
}


public static void menu() throws IOException {

	do {
		try {
			pintarMenuPrincipal();
			int opcion = Integer.parseInt(br.readLine()); // lee la opcion del usuario

			switch (opcion) {
			case 1:
				System.out.println("Has elegido resolver la palabra. ");
				resolverPalabra();
				break;
			case 2:
				System.out.println("Has elegido decir letra.");
				decirLetra();
				break;
			case 3:
				System.out.println("Has elegido dar palabra.");
				darPalabra();
				break;
			case 4:
				System.out.println("Has elegido salir.");
				salirBucle = true;
				br.readLine();// Para que no vuelva a mostrar el menu o se meta en bucle infinito
				break;
			default:
				System.out.println("Numeros del 1 al 4!!");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error!! Solo se admiten numeros");

		}

	} while (salirBucle == false);

}

private static void darPalabra() {
	
}


private static void decirLetra() {
	
}


public static void resolverPalabra() {
	
}

}
