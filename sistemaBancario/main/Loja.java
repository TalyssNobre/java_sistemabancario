package main;

public class Loja {
	String nome;
	Conta conta;
	float salario;

	Funcionario funcionario1;
	Funcionario funcionario2;

	boolean pagamento = true;

	public Loja(String nome, float salario) {
		this.nome = nome;
		this.salario = salario;

		this.conta = new Conta(0f);
		
		this.funcionario1 = new Funcionario("Funcionário 1", this);
		this.funcionario2 = new Funcionario("Funcionário 2", this);
	}

	public void notificar() {
		if (this.conta.saldo >= this.salario) {
			
			// Confere quem irá pagar dessa vez
			if (this.pagamento) { 
				this.pagar(funcionario1); 
				this.pagamento = false; // Alterna a vez
			}
			else {
				this.pagar(funcionario2); 
				this.pagamento = true; // Alterna a vez
			}
		}
		
		
	}

	public void pagar(Funcionario funcionario) {
		this.conta.bank.transferir(this.salario, this.conta, funcionario.contaSalario);
		System.out.println(funcionario.nome + " da loja " 
				+ this.nome + " recebeu a quantia de R$" + this.salario + " de salário");
		funcionario.notificar(this.salario);
	}
}
