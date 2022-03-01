package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Conta;
import entidade.ContaCorrente;
import entidade.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
		
		
		Conta cc = new ContaCorrente();		
		Conta poupanca = new ContaPoupanca();
		int controle = 1;
		double valor = 0;
		
		while(controle != 0) {
			System.out.println(" === Bem vindo ao Banco Aqui! === ");
			System.out.println("Para uma operção escolha o menu abaixo e digite:");
			System.out.println("1 - Para conta Corrente");
			System.out.println("2 - Para conta Poupanca");
			controle = leitor.nextInt();
			
			if(controle == 1) {
				while(controle != 0) {
					System.out.println("Para uma operção escolha o menu abaixo e digite:");
					System.out.println("3 - Para deposito");
					System.out.println("4 - Para saque");
					System.out.println("5 - Para transferencia");
					System.out.println("6 - Para extrato");
					controle = leitor.nextInt();
					
					switch (controle) {
					case 3:
						System.out.println("informe o valor:");
						valor = leitor.nextDouble();
						cc.depositar(valor);
						break;
					
					case 4:
						System.out.println("informe o valor:");
						valor = leitor.nextDouble();
						cc.sacar(valor);
						break;
						
					case 5:
						System.out.println("informe o valor:");
						valor = leitor.nextDouble();
						cc.transferir(valor, poupanca);
						break;
						
					case 6:
						cc.imprimirExtrato();
						break;
					
					case 0:
						System.out.println("Obrigado");
						break;

					default:
						break;
					}
				}
				controle = 1;
			}
			else if(controle == 2) {
				while(controle != 0) {
					System.out.println("Para uma operção escolha o menu abaixo e digite:");
					System.out.println("3 - Para deposito");
					System.out.println("4 - Para saque");
					System.out.println("5 - Para transferencia");
					System.out.println("6 - Para extrato");
					controle = leitor.nextInt();
					
					switch (controle) {
					case 3:
						System.out.println("informe o valor:");
						valor = leitor.nextDouble();
						poupanca.depositar(valor);
						break;
					
					case 4:
						System.out.println("informe o valor:");
						valor = leitor.nextDouble();
						poupanca.sacar(valor);
						break;
						
					case 5:
						System.out.println("informe o valor:");
						valor = leitor.nextDouble();
						poupanca.transferir(valor, cc);
						break;
						
					case 6:
						poupanca.imprimirExtrato();
						break;
					
					case 0:
						System.out.println("Obrigado");
						break;

					default:
						break;
					}
				}
				controle = 1;
			}
			else if(controle == 0) {
				System.out.println("Obrigado");
			}
			else {
				System.out.println("Operacao invalida");
			}
			
		}
		
		leitor.close();
	}

}
