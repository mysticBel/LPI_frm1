package tratamientoExcepciones;

public class Prueba3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String nombre [] = {"Jose", "Eduardo", "Jaime"};
			
			//for(int i = 0; i < nombre.length;  i++) {
			for(int i = 0; i < 5;  i++) {
				System.out.println(nombre[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice no permitido" + e.getMessage());
		}
	}

}
