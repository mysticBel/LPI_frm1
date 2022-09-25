package propuestos;

public class Prop6 {

	public static void main(String[] args) {
		//Si es un digito
		System.out.println("1".matches("\\d")); //true
		System.out.println("132".matches("\\d")); //false
		System.out.println("1".matches("[0-9]")); //true
		System.out.println("132".matches("[0-9]")); //false
		System.out.println("132".matches("[0-9]{3}")); //true

	}

}
