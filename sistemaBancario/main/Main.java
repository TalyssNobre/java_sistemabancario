package main;

public class Main {
	static Banco bank;
	static Loja samsung;
	static Loja apple;
	
	static float salarioTotal = 1400f;
	static float contaClientesGeral = 1000f;
	
	public static void main(String[] args) {
		bank = new Banco("Banco de Brasilia-BRB");
		
		samsung = new Loja("Samsung", salarioTotal);
		apple = new Loja("Apple", salarioTotal);
		
		System.out.println("-------------Sistema Bancario---------------");
		Cliente cliente1 = new Cliente("Cliente 01", 500);
		Cliente cliente2 = new Cliente("Cliente 02", 1000);
		Cliente cliente3 = new Cliente("Cliente 03", 1250);
		Cliente cliente4 = new Cliente("Cliente 04", 2200);
		Cliente cliente5 = new Cliente("Cliente 05", 5050);
		
		try {
			cliente1.join();
			cliente2.join();
			cliente3.join();
			cliente4.join();
			cliente5.join();
		} catch (Exception e) {}
		
		System.out.println("--------------------------------------------");
		System.out.println(
				samsung.nome + ": \n" +
				"(R$" + samsung.conta.saldo + ")\n" +
				"    " + samsung.funcionario1.nome + ": \n " +
				"        Conta: R$"
				+ samsung.funcionario1.contaSalario.saldo + "\n " + 
				"        Investimento: R$"
				+ samsung.funcionario1.contaInvestimento.saldo + "\n" +
				"    " + samsung.funcionario2.nome + ": \n " +
				"        Conta: R$"
				+ samsung.funcionario2.contaSalario.saldo + "\n " + 
				"        Investimento: R$"
				+ samsung.funcionario2.contaInvestimento.saldo + "\n\n" +
				
				apple.nome + ": \n" +
				"(R$" + apple.conta.saldo + ")\n" +
				"    " + apple.funcionario1.nome + ": \n " +
				"        Conta: R$"
				+ apple.funcionario1.contaSalario.saldo + "\n " + 
				"        Investimento: R$"
				+ apple.funcionario1.contaInvestimento.saldo + "\n" +
				"    " + apple.funcionario2.nome + ": \n " +
				"        Conta: R$"
				+ apple.funcionario2.contaSalario.saldo + "\n " + 
				"        Investimento: R$"
				+ apple.funcionario2.contaInvestimento.saldo + "\n");
		System.out.println("\n-------------Programa Finalizado---------------");
	}
}
