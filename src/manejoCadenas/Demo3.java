package manejoCadenas;

public class Demo3 {

	public static void main(String[] args) {
		// m�todos de modificacion
		String mensaje = "No tengas miedo al �xito";
		
		System.out.println(mensaje.toUpperCase());  // May�sculas NO TENGAS MIEDO AL �XITO
		System.out.println(mensaje.toLowerCase());   //no tengas miedo al �xito
		
		System.out.println(mensaje.replace(" ", "_")); // Remplazar espacios por guiones bajos No_tengas_miedo_al_�xito
		
		System.out.println(mensaje + ", t� puedes !");  //concatenar : No tengas miedo al �xito, t� puedes !
		System.out.println(mensaje.concat(", t� puedes !"));  //No tengas miedo al �xito, t� puedes !
	}

}
