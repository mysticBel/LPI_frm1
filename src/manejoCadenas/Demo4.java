package manejoCadenas;

public class Demo4 {

	public static void main(String[] args) {
		// metodo de inspección
		String texto = "Java";
		
		System.out.println(texto.equals("Java"));            //true
		System.out.println(texto.equalsIgnoreCase("jAva"));  // true

		System.out.println(texto.endsWith("a"));   //true
		System.out.println(texto.startsWith("J")); //true 
		
		//Otra forma: 
		String nombres = "Julio, Cesar, Jimmy";
		//imprimir nombres
		System.out.println(nombres.substring(0,5));
		//System.out.println(nombres.replace(",", "\n"));
		
		String sep[] = nombres.split(",");
		
		
	}

}
