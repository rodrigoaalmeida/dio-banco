package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Conta;
import entidade.ContaCorrente;
import entidade.ContaPoupanca;
import util.Operacoes;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
		
		Operacoes movimentacao = new Operacoes();
		
		
		Conta cc = new ContaCorrente();		
		Conta poupanca = new ContaPoupanca();
		Conta conta;
		int controle = 1;
		
		List<Conta> tipoConta = new ArrayList<>();
		List<Conta> contas = new ArrayList<>();
		
		tipoConta.add(null);
		tipoConta.add(cc);
		tipoConta.add(poupanca);
		
		while(controle != 0) {
			System.out.println(" === Bem vindo ao Banco Aqui! === ");
			System.out.println("Para uma opercao escolha o menu abaixo e digite:");
			System.out.println("1 - Para conta Corrente");
			System.out.println("2 - Para conta Poupanca");
			System.out.println("9 - Para criar uma conta");
			System.out.println("0 - Para sair do programa");
			controle = leitor.nextInt();

			switch(controle){
				case 1:
				case 2:
				case 9:
					int escolhaTipoConta = 0;
					System.out.println("Para uma opercao escolha o menu abaixo e digite:");
					System.out.println("0 - Para criar uma Conta Corrente");
					System.out.println("1 - Para criar uma Conta Poupanca");
					escolhaTipoConta = leitor.nextInt();

					if(escolhaTipoConta == 0){
						contas.add(conta = new ContaCorrente(escolhaTipoConta));
					}
					else if(escolhaTipoConta == 1){
						contas.add(conta = new ContaPoupanca(escolhaTipoConta));
					}
					else {
						System.out.println("Operacao invalida");
					}
				case 0:
					System.out.println("Obrigado");
					break;
				default:
					break;
			}
			
			if (controle == 1 || controle == 2 || controle == 9) {
				int antControle;
				if(controle == 1) {
					antControle = 2;
				} else {
					antControle = 1;
				}
				movimentacao.chamar(tipoConta.get(controle), tipoConta.get(antControle));
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
