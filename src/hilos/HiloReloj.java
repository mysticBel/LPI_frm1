package hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import vista.FrmPreLoader;
import vista.FrmPrincipal;

public class HiloReloj extends Thread {
	public void run() {
		while (true) {
			//Obtener la fecha del sistema
			Date hora = new Date();
			//Formato para la hora
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss ");
			// mostrar la hora en la etiqueta "lblHora"
			FrmPrincipal.lblHora.setText(sdf.format(hora));
		}
}
}