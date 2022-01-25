import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

/* Enunciado: Calculadora de operaciones modularizada.

 * Fecha: 25/01/22
 * Autor: Jaime Fernando Martín Gil, Jorge Parra López, David Mateos Lorenzo y Saul Fernández García.
 * Comentarios: 
 * -Constructores Partida() con parámetros y Partida() sin parametros.
 * 
 * -Metodo numeroRandom() genera una palabra aleatoria entre las 3 que hay.
 * -Metodo pintarMenuPrincipal() no devuelve nada ni tiene parametros, pinta el menu. 
 *-Metodo menu() ejecuta el menu.
 * -Metodo darPalabra() Obtiene el valor de la palabra y se muestra al jugador.
 * -Metodo decirLetra() desvela la letra que introduce el jugador.
 * -Metodo resolverPalabra() se le pide que introduzca la palabra.
 * -Metodo rellenearHuecos() no tiene parámetros ni devuelve nada.
 * -Método contarAsteriscos() no tiene parámetros y devuelve un entero con los asteriscos.
 *  
 */


public class Partida {
	private static LocalDate fecha = LocalDate.now();
	private static int elegirPalabra,  elegirLetra; //Variable de tipo entero que se usan para guardar numeros aleatorios.
	private static String nombrejugador; 
	private static char letraIntroducida; //letra que introduce el jugador
	private static int intentos = 3;
	private static Palabra palabras[]; //array que contiene las palabras a jugar.
	private static char letrasVacias[]; // array para mostrar la palabra a adivinar.
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static boolean salirBucle = false; //variable para salir del menu.

	public Partida(LocalDate fecha, String nombrejugador, Palabra[] arrayPalabras) { //Constructor con parametros.
		this.fecha = fecha;
		this.nombrejugador = nombrejugador;
		this.palabras = arrayPalabras;
	}

	public Partida(Palabra arrayPalabras[]) { //Constructor con parametro array de Palabras.
		this.palabras = arrayPalabras;
	}

	public static void numeroRandom() throws IOException, NullPointerException { 
		elegirPalabra = (int) (Math.random() * (3)); //genera una palabra aleatoria entre las 3 que hay.
	}

	public static void comenzar() throws IOException {
		System.out.println("Introduzca su nombre para comenzar la partida:");
		nombrejugador = br.readLine(); //recoge el nombre introducido por teclado.
		numeroRandom(); //llamada al método para que genere una de las 3 palabras.
	}

	public static void pintarMenuPrincipal() {

		System.out.println(nombrejugador + " " + "|" + fecha + "|" + " " + "Intentos:" + intentos + " " + "" + "\n");
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

	public void menu() throws IOException, NullPointerException {
		rellenarHuecos(); 
		do {
			try {

				pintarMenuPrincipal();
				int opcion = Integer.parseInt(br.readLine()); // lee la opcion del usuario

				switch (opcion) {
				case 1:
					System.out.println("Has elegido resolver la palabra. ");
					resolverPalabra();
					br.readLine(); // Para que no vuelva a mostrar el menu o se meta en bucle infinito.
					break;
				case 2:
					System.out.println("Has elegido decir letra.");
					if (contarAsteriscos() <= 2) {  //si quedan dos o menos letras por adivinar pierde automaticamente.
						System.out.println("Has perdido!!");
						salirBucle = true;
						break;
					}
					decirLetra();
					br.readLine();
					break;
				case 3:
					System.out.println("Has elegido dar palabra.");
					darPalabra();
					System.out.println("Has perdido!!");
					salirBucle = true;
					br.readLine(); 
					break;
				case 4:
					System.out.println("Has elegido salir.");
					salirBucle = true;
					br.readLine();
					break;
				default:
					System.out.println("Numeros del 1 al 4!!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Error!! Solo se admiten numeros");

			}

		} while (salirBucle == false);

	}

	private static void darPalabra() { //Obtiene el valor de la palabra y se muestra al jugador.
		System.out.println("La palabra es " + palabras[elegirPalabra].getValor());
	}

	private static void decirLetra() throws IOException { //metodo desvela la letra que introduce el jugador.
		System.out.println("Introduzca una letra:");
		letraIntroducida = (char) br.read();
		int bandera = 0;// variable que se incrementa si encuentra la letra.
		for (int i = 0; i < letrasVacias.length; i++) {
			if (letraIntroducida == palabras[elegirPalabra].getLetrasDisponibles()[i]) {  //compara la letra introducida con la letra de la palabra de esa posición.
				letrasVacias[i] = letraIntroducida;
				palabras[elegirPalabra].setPosicionesOcupadas(i);
				bandera++;
			}
		}
		if (bandera == 0) { // bandera sigue con el mismo valor y muestra el mensaje de error.
			System.out.println("Has fallado!! Letra no encontrada!!");
		}
	}

	public static void resolverPalabra() throws IOException { //se le pide que introduzca la palabra 
		System.out.println("Introduzca la palabra:");
		String resolverPalabra = br.readLine();

		if (!resolverPalabra.equals(palabras[elegirPalabra].getValor())) { //comprueba si la palabra introducida es distinta y si lo es,
			System.out.println("Has fallado!!");							//muestra el mensaje de error y se resta 1 a los intentos.
			intentos--;
			while (intentos == 0) { //si se queda sin intentos se acaba la partida.
				salirBucle = true;
				System.out.println("Has perdido!! Te quedaste sin intentos!!");
			}
		} else {
			System.out.println("Enhorabuena!! Has ganado!! "); //si la palabra introducida es igual muestra un mensaje de que ha ganado.
			salirBucle = true;

		}
	}

	public static void rellenarHuecos() {
		letrasVacias = new char[palabras[elegirPalabra].getLetrasDisponibles().length];
		for (int i = 0; i < (palabras[elegirPalabra].getValor().length() / 2); i++) {
			elegirLetra = (int) (Math.random() * ((palabras[elegirPalabra].getValor().length())));
			letrasVacias[elegirLetra] = palabras[elegirPalabra].getLetrasDisponibles()[elegirLetra];
			palabras[elegirPalabra].setPosicionesOcupadas(elegirLetra);
		}
		for (int j = 0; j < letrasVacias.length; j++) {
			if (palabras[elegirPalabra].getPosicionesOcupadas()[j] == false) {
				letrasVacias[j] = '*';
			}
		}
	}

	public static int contarAsteriscos() { //método cuenta los asteriscos para cuando queden 2 o menos letras por adivinar pierde automaticamente.
		int contadorAsterisco = 0;

		for (int i = 0; i < letrasVacias.length; i++) {
			if (letrasVacias[i] == '*') {
				contadorAsterisco++;
			}
		}
		return contadorAsterisco;
	}

}
