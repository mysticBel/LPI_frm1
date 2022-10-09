package hilos;

import vista.Editor;

public class HiloEnvio extends Thread {
 public void run () {
	 //proceso que imprima del 1 al 10
	 synchronized(Editor.txtS) {
	 for(int i =0; i <=10 ; i++) {
		 Editor.txtS.append(i + "--> " +getName() + "\n");
	 }
 }
}}
