/*MARCELO BATISTA DA SILVA  - 07/05/2020
 *Exercício de travessia de 4 carros em cruzamento considerando que os 4 estão simultaneamente parados no cruzamento*/
package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCarro;

public class Principal {
	
	public static void main(String[] args) {
		int autorizacao = 1;
		Semaphore farol = new Semaphore(autorizacao);
		
		
		for(int idCarro=1; idCarro<=4; idCarro++) {
			Thread carro = new ThreadCarro(farol, idCarro);
			carro.start();
		}
		
	}
}
