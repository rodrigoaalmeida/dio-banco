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
		int controle = 1;
		
		List<Conta> tipoConta = new ArrayList<>();
		
		tipoConta.add(null);
		tipoConta.add(cc);
		tipoConta.add(poupanca);
		
		while(controle != 0) {
			System.out.println(" === Bem vindo ao Banco Aqui! === ");
			System.out.println("Para uma operção escolha o menu abaixo e digite:");
			System.out.println("1 - Para conta Corrente");
			System.out.println("2 - Para conta Poupanca");
			controle = leitor.nextInt();
			
			if (controle == 1 || controle == 2) {
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
