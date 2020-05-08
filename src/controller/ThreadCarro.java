package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	private Semaphore farol;
	private String sentido;
	private int idCarro;
	private int percurso = 2000;
	
	public ThreadCarro(Semaphore farol, int idCarro) {
		this.farol = farol;
		this.idCarro = idCarro;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		sentido();
		try {
			farol.acquire();
			carroAndando();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			farol.release();
		}
		
	}
	
	public void sentido(){
		switch ((int)((Math.random()*3) + 1)) {
		case 1:
			sentido = "em frente";
			break;

		case 2:
			sentido = "� direita.";
			break;
			
		case 3:
			sentido = "� esquerda.";			
			break;
		default:
			sentido = "aguardando.";
		
		}
	}
	
	public void carroAndando() {
		System.out.println("O "+idCarro+"� carro seguiu "+sentido);
		try {
			//tempo m�ximo para o passar pelo cruzamento
			sleep(percurso);
			System.out.println("O "+idCarro+"� carro seguiu seu caminho.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
