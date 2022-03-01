package util;


import java.util.Locale;
import java.util.Scanner;

import entidade.Conta;

public class Operacoes {

	
	public void chamar(Conta tipoConta, Conta antTipoConta) {
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);

		double valor = 0;
		int controle = 1;

			while (controle != 0) {
				System.out.println("Para uma operção escolha o menu abaixo e digite:");
				System.out.println("3 - Para deposito");
				System.out.println("4 - Para saque");
				System.out.println("5 - Para transferencia");
				System.out.println("6 - Para extrato");
				System.out.println("0 - Para voltar ao menu de contas");
				controle = leitor.nextInt();

				switch (controle) {
				case 3:
					System.out.println("informe o valor:");
					valor = leitor.nextDouble();
					tipoConta.depositar(valor);
					break;

				case 4:
					System.out.println("informe o valor:");
					valor = leitor.nextDouble();
					tipoConta.sacar(valor);
					break;

				case 5:
					System.out.println("informe o valor:");
					valor = leitor.nextDouble();
					tipoConta.transferir(valor, antTipoConta);
					break;

				case 6:
					tipoConta.imprimirExtrato();
					break;

				case 0:
					System.out.println("Obrigado");
					break;

				default:
					break;
				}
			}			
	}
	 
	
}
