package manejoCadenas;

public class Demo2 {

	public static void main(String[] args) {
		// m�todos de indexaci�n
		String cadena = "Programadores  ";
		// P r o g r a m a d o  r  e  s
		// 0 1 2 3 4 5 6 7 8 9 10 11 12
		// index --> ubicaci�n o posiciones (0 -12)
		// longitud --> cantidad (1 - 13)
		System.out.println("Cantidad de caracteres : " + cadena.length());
		System.out.println(cadena.substring(5,10));    // texto amado
		System.out.println(cadena.charAt(12)); // s
		System.out.println(cadena.trim());  // elimina los vacios
	}

}
