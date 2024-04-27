package main;

public class Funcionario extends Thread {
	String nome;
	Loja loja;

	Conta contaSalario;
	Conta contaInvestimento;

	public Funcionario(String nome, Loja loja) {
		this.nome = nome;
		this.loja = loja;

		contaSalario = new Conta(0f);
		contaInvestimento = new Conta(0f);
	}

	public void notificar(float salario) {
		this.investir(salario, 20f);
	}

	public void investir(float valor, float porcento) {
		float valorFinal = (porcento * valor) / 100;
		contaSalario.bank.transferir(valorFinal, contaSalario, contaInvestimento);
		System.out.println("o " + this.nome + " da loja " + this.loja.nome + " investiu a quantia total de R$" +
				valorFinal + " em sua conta bancaria de investimentos");
	}
}
