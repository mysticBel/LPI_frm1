package tratamientoExcepciones;

public class Prueba2 {

	public static void main(String[] args) {
		try {
			int num1, num2, res;
			num1 = 60;
			num2 = 90;
			//      90 -   60+30 
			num2 = num2 - (num1+30);
			res = num1 / num2;  //60/0
			System.out.println("Resultado :" + res);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block

			System.out.println("Error en la operación aritmetica: "+e.getMessage()); //Error: / by zero :)
		}
	}

}
