package manejoCadenas;

public class Demo3 {

	public static void main(String[] args) {
		// métodos de modificacion
		String mensaje = "No tengas miedo al éxito";
		
		System.out.println(mensaje.toUpperCase());  // Mayúsculas NO TENGAS MIEDO AL ÉXITO
		System.out.println(mensaje.toLowerCase());   //no tengas miedo al éxito
		
		System.out.println(mensaje.replace(" ", "_")); // Remplazar espacios por guiones bajos No_tengas_miedo_al_éxito
		
		System.out.println(mensaje + ", tú puedes !");  //concatenar : No tengas miedo al éxito, tú puedes !
		System.out.println(mensaje.concat(", tú puedes !"));  //No tengas miedo al éxito, tú puedes !
	}

}
