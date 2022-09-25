package tratamientoFecha;

import java.text.DateFormat;
import java.util.Date;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//clase Date --> java.util
		Date fecha = new Date();
		//syso ctrl space
		System.out.println("Fecha DAte : " + fecha);
		
		//DateFormat --> formatear la fecha y hora con estilos definidos
		DateFormat df = DateFormat.getDateInstance();
		System.out.println("Fecha DateFormat : " + df.format(fecha));
		
		
		DateFormat dfs = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("Fecha Corta : " + dfs.format(fecha));

		DateFormat dfl = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println("Fecha Larga : " + dfl.format(fecha));
		
		DateFormat dfm = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("Fecha Mediana : " + dfm.format(fecha));
		
		DateFormat dff = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("Fecha Completa : " + dff.format(fecha));
		
		DateFormat dfh = DateFormat.getTimeInstance();
		System.out.println("Hora : " + dfh.format(fecha));
		
	}

}
