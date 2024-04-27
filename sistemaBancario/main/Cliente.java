package main;

import java.util.Random;

public class Cliente extends Thread{
	Conta conta;
	String nome;
	int atividade; 
	
	Random random;
	
	public Cliente(String nome, int atividade) {
		this.conta = new Conta(Main.contaClientesGeral);
	    this.nome = nome;
	    this.atividade = atividade;

		this.random = new Random();
		
		// A thread iniciará assim que ela for instânciada
		this.start();
	}
	
	@Override
	public void run() {
		
		Loja qualLoja; // o cliente comprara em qual loja?
		float qualValor = 100.00f; // Quanto o cliente vai gastar? Entao iremos começar com a quantia de R$100
		
		while (conta.temSaldo(qualValor)) {
			
			if (random.nextBoolean()) { qualLoja = Main.samsung; }
			else { qualLoja = Main.apple; }
			
			this.comprar(qualLoja, qualValor);
			
			try {
				Thread.sleep(atividade);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (random.nextBoolean()) { qualValor = 100.00f; }
			else { 
				qualValor = 200.00f;
				
				if (!conta.temSaldo(qualValor)) { qualValor = 100.00f;}
			}
		}
	}
	
	public void comprar(Loja loja, float preco) {
		if (conta.temSaldo(preco)) {
			this.conta.bank.transferir(preco, this.conta, loja.conta);
			loja.notificar();
			System.out.println("O " + this.nome + " gastou a quantia de R$" + preco + " na loja da: " + loja.nome);
		}
	}
}