package tratamientoExcepciones;

public class Prueba1 {

	public static void main(String[] args) {
		try {
			int num1 = Integer.parseInt("63");
			int num2 = Integer.parseInt("dos");
			int suma = num1+num2;
			System.out.println("Suma : "+suma);
		} catch (NumberFormatException e) {
			System.out.println("Error en el formato de número");
			System.out.println("Error: " +e.getMessage());
			//Error: For input string: "dos"
			e.printStackTrace();
			
		}

	}

}
