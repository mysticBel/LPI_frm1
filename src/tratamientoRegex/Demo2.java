package tratamientoRegex;

public class Demo2 {

	public static void main(String[] args) {
		// Texto
		// texto de 3 a 15 letras
		
		System.out.println("tres".matches("[a-zA-Z]{3,15}"));

		String nombre = "Maribel Maz�";
		String apellido = "Magui�a Maldonado";

		System.out.println(nombre.matches("[a-zA-Z\\s]{3,20}")); //false
		System.out.println(nombre.matches("[a-zA-Z\\s\\�\\�\\�\\�\\�\\�]{3,20}")); //false
		System.out.println(apellido.matches("[a-zA-Z\\s\\�\\�\\�\\�\\�\\�]{3,20}")); //true
		
		
		//placa AZ -  
	}

}
