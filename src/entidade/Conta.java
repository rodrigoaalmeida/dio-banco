package entidade;

public abstract class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int GERADORNUMEROCONTA = 1;
	
	protected int agencia;
	protected int numeroConta;
	protected int tipoConta;
	protected double saldo;
	
	public Conta(int tipoConta) {
		this.agencia = AGENCIA_PADRAO;
		this.numeroConta = GERADORNUMEROCONTA++;
		this.tipoConta = tipoConta;
	}
	
	public int getAgencia() {
		return agencia;
	}
	public int getnumeroConta() {
		return numeroConta;
	}
	public int getTipoConta() {
		return tipoConta;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public void sacar(double valor) {
		
		double saldoAtual = getSaldo();

		if (saldoAtual > 0 && saldoAtual >= valor) {
			saldo -= valor;
			imprimirExtrato();
		} else {
			System.out.println("O saldo seu saldo é insuficiente para esta transacao!!");
			System.out.printf("Saldo atual em conta e: R$ %.2f%n", getSaldo());
		}
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public void transferir(double valor, Conta contaDestino) {
		double saldoAtual = getSaldo();
		
		this.sacar(valor);
		if(saldo != saldoAtual) {
			contaDestino.depositar(valor);
		}
		
	}
	
	public void imprimirExtrato() {
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("numeroConta: %d", this.numeroConta));
		System.out.println(String.format("Tipo da conta: %d", this.numeroConta));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
