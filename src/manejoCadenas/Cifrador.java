package manejoCadenas;

public class Cifrador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Dado una cadena, realizar un método que “encripte” las letras
			del texto considerando lo siguiente:
				a->e, e->i, i->o, o->u, u->a */

		////
		String texto = "Hola mundo esto es un texto bonito";
		StringBuilder encriptado = new StringBuilder();
		
		//Agregar el texto a la variable
		encriptado.append(texto);
		//texto en inversa --> otinob otxet nu se otse odnum aloH
		encriptado.reverse();
		
		
		//Reemplazar las vocales
		for (int i = 0; i < encriptado.length(); i++) {
			switch (encriptado.charAt(i)){ 
			case 'a':
				encriptado.setCharAt(i, 'e');
				break;
			case 'e':
				encriptado.setCharAt(i, 'i');
				break;
			case 'i':
				encriptado.setCharAt(i, 'o');
				break;
			case 'o':
				encriptado.setCharAt(i, 'u');
				break;
			case 'u':
				encriptado.setCharAt(i, 'a');
				break;
			
			}
		}
		
		//SAlida
		System.out.println(">>>>>>>>>>>>>>>>>Encriptador<<<<<<<<<<<<<<<");
		System.out.println("Texto original : " + texto);
		System.out.println("Texto encriptado : " + encriptado);  // utonub utxit na si utsi udnam eluH
		
		//tareita --> texto encriptado debe regresar al texto original
		//System.out.println("Texto encriptado-reverse : " + encriptado.reverse());
		
		StringBuilder desencriptado = new StringBuilder();
	
		desencriptado.append(encriptado);
		
		
		for (int i = 0; i < desencriptado.length(); i++) {
			switch (desencriptado.charAt(i)){ 
			case 'e':
				desencriptado.setCharAt(i, 'a');
				break;
			case 'i':
				desencriptado.setCharAt(i, 'e');
				break;
			case 'o':
				desencriptado.setCharAt(i, 'i');
				break;
			case 'u':
				desencriptado.setCharAt(i, 'o');
				break;
			case 'a':
				desencriptado.setCharAt(i, 'u');
				break;
			
			}
		}
		
		//SAlida
				System.out.println(">>>>>>>>>>>>>>>>>DesEncriptador<<<<<<<<<<<<<<<");
				System.out.println("Texto encriptado : " + encriptado);
				System.out.println("Texto desencriptado: " + desencriptado);
				System.out.println("Texto desencriptado-original : " + desencriptado.reverse());
	}

}
