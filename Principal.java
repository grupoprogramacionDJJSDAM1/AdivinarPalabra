import java.io.IOException;
/* Fecha: 25/01/22
 * Autor: Jaime Fernando Martín Gil, Jorge Parra López, David Mateos Lorenzo y Saul Fernández García.
 * 
 */

public class Principal {
	public static Palabra arrayPalabras[] = new Palabra[3];// array de Objetos palabra para pasar al construir la
															// partida

	private static String valor1 = "ordenador";// valor para pasar el valor de los objetos Palabra
	private static String valor2 = "monitor";
	private static String valor3 = "teclado";

	public static void main(String[] args) throws IOException {

		arrayPalabras[0] = new Palabra();// Creamos los objetos vacios
		arrayPalabras[1] = new Palabra();
		arrayPalabras[2] = new Palabra();

		arrayPalabras[0].rellenarChar(valor1.length(), valor1);// Les rellenamos el array de char con el metodo rellenar char
		arrayPalabras[1].rellenarChar(valor2.length(), valor2);
		arrayPalabras[2].rellenarChar(valor3.length(), valor3);

		arrayPalabras[0].setValor(valor1);// Les establecemos el valor del objeto con el metodo set usando los String valor1, 2 y 3
		arrayPalabras[1].setValor(valor2);
		arrayPalabras[2].setValor(valor3);

		arrayPalabras[0].rellenarBooleano(valor1.length());// Les rellenamos el array de char con el metodo rellenar char
		arrayPalabras[1].rellenarBooleano(valor2.length());
		arrayPalabras[2].rellenarBooleano(valor3.length());
		Partida.comenzar();
		Partida mipartida = new Partida(arrayPalabras);// Creamos el objeto mipartida de la clase Partida
		mipartida.menu();
	}

}