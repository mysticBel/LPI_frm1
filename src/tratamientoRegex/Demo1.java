package tratamientoRegex;

public class Demo1 {

	public static void main(String[] args) {
		// Digitos
		String num = "55";
		System.out.println(num.matches("\\d"));
		System.out.println(num.matches("[0-9]")); //otra forma

		

		//dni

		String dni= "48856525";
		System.out.println(dni.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"));
		System.out.println(dni.matches("\\d{8}"));
		System.out.println(dni.matches("[0-9]{8}"));

		

		//validar RUC 11 digitos - iniciar con 2
		String ruc= "20411383569";
		System.out.println("Validar RUC"); 
		System.out.println(ruc.matches("[2][0-9]{10}")); 
		System.out.println(ruc.matches("2[0-9]{10}"));
		System.out.println(ruc.matches("2\\d{10}"));

		

		//validar el ingreso de solo numeros enteros 5, 10, 1000

		String numEntero = "100";
		System.out.println("Validar Nros enteros"); 
		System.out.println(numEntero.matches("\\d*"));
		System.out.println(numEntero.matches("\\d+"));
		System.out.println(numEntero.matches("[0-9]{1,}"));
	

		//validar el ingreso de decimales 1.5 , 5.22
	}

}
