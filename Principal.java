import java.io.IOException;

public class Principal {
	public static Palabra arrayPalabras[] = new Palabra[3];
	
	
	private static String valor1 = "ordenador";
	private static String valor2 = "monitor";
	private static String valor3 = "teclado";
	
	
	public static void main(String[] args) throws IOException {
		
		arrayPalabras[0] = new Palabra ();
		arrayPalabras[1] = new Palabra ();
		arrayPalabras[2] = new Palabra ();
		
		arrayPalabras[0].rellenarChar(valor1.length(),valor1);
		arrayPalabras[1].rellenarChar(valor2.length(),valor2);
		arrayPalabras[2].rellenarChar(valor3.length(),valor3);
		
		arrayPalabras[0].setValor(valor1);
		arrayPalabras[1].setValor(valor2);
		arrayPalabras[2].setValor(valor3);
		
		arrayPalabras[0].rellenarBooleano(valor1.length());
		arrayPalabras[1].rellenarBooleano(valor2.length());
		arrayPalabras[2].rellenarBooleano(valor3.length());
		Partida.comenzar();
		Partida mipartida=new Partida (arrayPalabras);
		Partida.menu();
	}	
	
}
