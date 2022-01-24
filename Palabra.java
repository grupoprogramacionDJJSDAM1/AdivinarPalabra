package codigo;

import java.util.Arrays;

public class Palabra {
	private String valor;
	private char letrasDisponibles[];
	private boolean posicionesOcupadas[];
	public Palabra() {
		
	}
	public Palabra(String valor, char[] letrasDisponibles, boolean[] posicionesOcupadas) {
		this.valor = valor;
		this.letrasDisponibles = letrasDisponibles;
		this.posicionesOcupadas = posicionesOcupadas;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public char[] getLetrasDisponibles() {
		return letrasDisponibles;
	}
	public void setLetrasDisponibles(char[] letrasDisponibles) {
		this.letrasDisponibles = letrasDisponibles;
	}
	public boolean[] getPosicionesOcupadas() {
		return posicionesOcupadas;
	}
	public void setPosicionesOcupadas(boolean[] posicionesOcupadas) {
		this.posicionesOcupadas = posicionesOcupadas;
	}
	
	public boolean comprobarLetra(char letrasDisponibles[], String valor) {
		boolean comprobar = false;
		for(int i = 0; i<valor.length(); i++) {
			if(letrasDisponibles[i] == valor.charAt(i)) {
				comprobar = true;			
			}
		}
		return comprobar;
	}
	
	public void rellenarChar(int longitudPalabra, String palabra) {
		letrasDisponibles =  new char[longitudPalabra];
		for(int i = 0;i<longitudPalabra;i++){
            letrasDisponibles[i]=palabra.charAt(i);
		}	
	}
	
	public void rellenarBooleano(int longitudPalabra) {
		posicionesOcupadas =  new boolean[longitudPalabra];
		for(int i = 0;i<longitudPalabra;i++){
            posicionesOcupadas[i]=false;
		}	
	}
	@Override
	public String toString() {
		return "Palabra [valor = " + valor + ", letrasDisponibles = " + Arrays.toString(letrasDisponibles)
				+ ", posicionesOcupadas = " + Arrays.toString(posicionesOcupadas) + "]";
	}
	
}
