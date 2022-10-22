package manejoCadenas;

public class Demo1 {

	public static void main(String[] args) {
		String nom = "Jose";
		String nom1 = "Jose Paredes";
		
		String nom2  =  new String("Jose");
		String nom3  =  new String("Jose");
		
		//Comparar direccion de memoria de una variable con objeto
		
			if (nom ==nom2) {
				System.out.println("Tienen mismas direcciones de memoria");
			} else {
				System.out.println("Direcciones de memoria diferentes");
			}

			if (nom2 ==nom3) {
				System.out.println("Tienen mismas direcciones de memoria");
			} else {
				System.out.println("Direcciones de memoria diferentes");
			}	
		
		
		/*Comparar texto
		
		if (nom.equals(nom1)) {
			System.out.println("Tienen el mismo texto");
		} else {
			System.out.println("Textos diferentes");
		}
		
		
		//Comparar direccion de memoria
	
		if (nom ==nom1) {
			System.out.println("Tienen mismas direcciones de memoria");
		} else {
			System.out.println("Direcciones de memoria diferentes");
		}*/
			
	}

}
