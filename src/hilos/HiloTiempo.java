package hilos;

public class HiloTiempo extends Thread {
  public void run() {
		for (int i = 0; i <=10; i++) {
			lblTiempo.setText(i + "s");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 }
}
