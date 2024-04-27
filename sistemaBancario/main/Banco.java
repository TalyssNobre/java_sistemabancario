package main;

public class Banco {
	String nome;
	
	public Banco(String nome) {
		this.nome = nome;
	}
	
	public synchronized void transferir(float valor, Conta quemRecebe, Conta destino) {
		
		quemRecebe.saldo -= valor;
		destino.saldo += valor;
		
	}
}
