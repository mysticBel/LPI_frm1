package manejoCadenas;

public class EjemploString {

	public static void main(String[] args) {
		String texto = "a001;  Juancito ;  Pando  ;12;05;LP1";
		

		
		// Separar los textos en código, nombre, apellido, nota1, nota2 y curso
		
		String sep[] = texto.split(";");
		String primerElem = sep[0].trim();
		String segundoElem = sep[1].trim().toLowerCase();
		String tercerElem = sep[2].trim();
		String cuartoElem = sep[3].trim();
		String quintoElem = sep[4].trim();
		String sextoElem = sep[5].trim();
		
		System.out.println( "código : " + primerElem);
		System.out.println( "nombre : " + segundoElem);
		System.out.println( "apellido : " + tercerElem );
		System.out.println( "nota1 : " + cuartoElem);
		System.out.println( "nota2 : " +quintoElem);
		System.out.println( "curso : " + sextoElem);
		
		// Convertir el apellido a mayúscula y el nombre el minúscula
		System.out.println( tercerElem.toUpperCase() );
		System.out.println( segundoElem.toLowerCase() );
		
		// Validar que el curso sea LP1
		System.out.println( sextoElem.equals("LP1")); //true
		
		if(sextoElem.equals("LP1")) {
			System.out.println( "Curso correcto");
		}else {
			System.out.println( "Curso incorrecto");
		}
		
		// validar que el tamaño del código sea 4
		System.out.println( primerElem.length() == 4 ); //true
		
		// Validar que el código empiece con la letras “a” o “p”
		System.out.println( primerElem.startsWith("a") ||  primerElem.startsWith("p")); //true
		
		
		// Generar un correo con el siguiente formato: 
		//1° letra del nombre + parte numérica del código + @cibertec.pe. Ej.  j001@cibertec.pe
		
		char primerComponente = segundoElem.charAt(0);
		String segundoComponente =primerElem.substring(1,4);
		
		System.out.println( primerComponente + segundoComponente + "@cibertec.pe");
	}

}
