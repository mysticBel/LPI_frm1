package propuestos;

public class Prop3 {

		public int metodo(int x) {
		int r = 1;
		r += x;
		if ((x > 4) && (x < 10)) {
		r += 3 * x;
		} else if (x <= 4) {
		r += 2 * x;
		} else {
		r += 4 * x;
		}
		r += 2 * x;
		return r;
		}
		public static void main(String[] args) {
			Prop3 o = new Prop3();
		System.out.println("OF(11) is: " + o.metodo(11));
		}
		} ///78 ....

