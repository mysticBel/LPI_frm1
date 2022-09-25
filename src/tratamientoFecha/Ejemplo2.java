package tratamientoFecha;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejemplo2 {

	public static void main(String[] args) {
		Date fecha = new Date();
		//SimpleDateFormat --> permite definir el formato o mejorarlo
		// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss a ");
		SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE/MMMM/YY");
		SimpleDateFormat sdf3 = new SimpleDateFormat("EE-MM-YY");

		System.out.println("Fecha Personalizada 1 : " + sdf.format(fecha));
		System.out.println("Hora Personalizada  : " + sdf1.format(fecha));
		System.out.println("Fecha Personalizada 2 : " + sdf2.format(fecha));
		System.out.println("Fecha Personalizada 3 : " + sdf3.format(fecha));
	}

}
