import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;


public class Partida {
private static LocalDate fecha=LocalDate.now();
private static int elegirPalabra;
private static int elegirLetra;
private static String nombrejugador;
private  static int intentos=3;
private static Palabra palabras[];
private static char letrasVacias[]; //array para mostrar la palabra a adivinar.
private static boolean posicionOcupada[];
public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
public static boolean salirBucle = false;

public Partida(LocalDate fecha, String nombrejugador, Palabra[] arrayPalabras) {
	
	this.fecha = fecha;
	this.nombrejugador = nombrejugador;
	this.palabras = arrayPalabras;
	
}


public Partida(Palabra arrayPalabras[]) {
	this.palabras = arrayPalabras;
	}

public static void numeroRandom() throws IOException, NullPointerException {
	 elegirPalabra =(int)(Math.random()*(3)+1);
	 	
}

public static void comenzar() throws IOException  {
	System.out.println("Introduzca su nombre para comenzar la partida:");
	nombrejugador=br.readLine();
	numeroRandom();
	
}

public static void pintarMenuPrincipal() {
	

    System.out.println(nombrejugador +" "+"|" + fecha +"|"+ " "+ "Intentos:" + intentos + " "+"" + "\n" );
    rellenarHuecos();
    
    System.out.println(letrasVacias);
    
    System.out.println("*****************************************************************************");
    System.out.println("--------------------------ADIVINAR PALABRAS----------------------------------");
    System.out.println("------------------------1. Resolver palabra----------------------------------");
    System.out.println("------------------------2. Decir letra---------------------------------------");
    System.out.println("------------------------3. Dar palabra---------------------------------------");
    System.out.println("------------------------4. Salir---------------------------------------------");
    System.out.println("*****************************************************************************");

    System.out.println("\n Elige una opcion del 1 al 4: ");
}


public static void menu() throws IOException, NullPointerException{

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
				System.out.println("Has perdido!!");
				salirBucle=true;
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
	System.out.println("La palabra es " + palabras[elegirPalabra].getValor());
}


private static void decirLetra() {
	
}


public static void resolverPalabra() throws IOException {
	System.out.println("Introduzca la palabra:");
	String resolverPalabra=br.readLine();
	
	if (!resolverPalabra.equals(palabras[elegirPalabra].getValor())) {
		System.out.println("Has fallado!!");
		intentos--;
		while (intentos==0) {
			salirBucle=true;
			System.out.println("Has perdido!! Te quedaste sin intentos!!");
		}
	}else {
		System.out.println("Enhorabuena!! ");
		salirBucle=true;
			
		}
	}
public static void rellenarHuecos() {
	letrasVacias=new char [palabras[elegirPalabra].getLetrasDisponibles().length];
	for (int i = 0; i < (palabras[elegirPalabra].getValor().length()/2); i++) {
		 elegirLetra =(int)(Math.random()*((palabras[elegirPalabra].getValor().length())));
		letrasVacias [elegirLetra]= palabras[elegirPalabra].getLetrasDisponibles()[elegirLetra];
		palabras[elegirPalabra].setPosicionesOcupadas(elegirLetra);
	}
	for (int j = 0; j < letrasVacias.length; j++) {
		if(palabras[elegirPalabra].getPosicionesOcupadas()[j]==false){
		letrasVacias[j]='*';
		
		}
	}
}
}


