package main;

public class Conta {
	float saldo;
	Banco bank;
	
	public Conta (float quantia) {
		this.saldo = quantia;
		this.bank = Main.bank;
	}
	
	// essa linha confere se a conta tem  o saldo o suficiente
	public boolean temSaldo(float saldo) {
		return this.saldo >= saldo;
	}
}