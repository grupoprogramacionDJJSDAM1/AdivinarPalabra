/*
 * Fecha: 25/01/22
 * Autor: Jaime Fernando Martín Gil, Jorge Parra López, David Mateos Lorenzo y Saul Fernández García.
 * 
 */
public class Palabra {
    private String valor;//atributo que contiene valor de tipo string
    private char letrasDisponibles[];//atributo que es el valor separado en caracteres en un array de caracteres
    private boolean posicionesOcupadas[];//atributo que contiene el estado de los caracteres del array de arriba

    public Palabra() {//Constructor sin parametros

    }
    public Palabra(String valor, char[] letrasDisponibles, boolean[] posicionesOcupadas) {//Constructor con parametros
        this.valor = valor;
        this.letrasDisponibles = letrasDisponibles;
        this.posicionesOcupadas = posicionesOcupadas;
    }

    public String getValor() {//getters y setters
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
    public void setPosicionesOcupadas(int posicion) {
        this.posicionesOcupadas[posicion]=true;
    }

    public void rellenarChar(int longitudPalabra, String palabra) {//Rellena el array de char con el calor separado en sus carácteres
        letrasDisponibles =  new char[longitudPalabra];
        for(int i = 0;i<longitudPalabra;i++){
            letrasDisponibles[i]=palabra.charAt(i);
        }
    }

    public void rellenarBooleano(int longitudPalabra) {//Rellena el array de booleano con todo false
        posicionesOcupadas =  new boolean[longitudPalabra];
        for(int i = 0;i<longitudPalabra;i++){
            posicionesOcupadas[i]=false;
        }
    }
}
