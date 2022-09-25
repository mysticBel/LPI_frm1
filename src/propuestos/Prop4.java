package propuestos;

public class Prop4 {
		 public static void main(String[] args) {
		try {
			new Prop4().metodo1();
			System.out.println("Bloque Main");
		} catch (ArithmeticException e) {
			System.out.println("Capturado en la Principal 1");
		} catch (Exception e) {
			System.out.println("Capturado en la Principal 2");
		} finally {
			System.out.println("Final");
		}
		}
		void metodo1() {
		try {
		metodo2();
		} catch (Exception e) {
		System.out.println("Capturado en el método 1");
		}
		}
		void metodo2() {
		String[] lista = { "Alex", "Samuel", "Juan" };
		String nom = lista[3];
		System.out.println("Nombre " + nom);
		}
		} //Capturado en la Principal 2
          //Final   si es metodo 2
    /* si es metodo 1 : 
     * Capturado en el método 1
      	Bloque Main
		Final

     */




