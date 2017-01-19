package com.folhaPagamento;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Fazendo o menu
		System.out.println("Sistema Folha de Pagamento\n\nEscolha a opção desejada:\n");
		System.out.println("1: Adicionar um novo empregado\n2: Remover um empregado existente\n3: Lançar um cartão de ponto");
		System.out.println("4: Lançar um resultado de venda\n5: Lançar uma taxa de serviço\n6: Alterar detalhes de um empregado");
		System.out.println("7: Rodar folha de pagamento para hoje\n8: Desfazer ou refazer alguma alteração\n9: Mostrar agenda de pagamento\n10: Criar nova agenda de pagamento");
		// A classe "Scanner" é usada para receber dados do usuario
		Scanner user = new Scanner(System.in);
		int opcao = Integer.valueOf(user.next());
		if(opcao == 1)
		{
			System.out.println("Criar um novo empregado.\nDigite o nome:");
			Empregado empregado = new Empregado();		
			empregado.nome = user.nextLine();
			empregado.nome = user.nextLine();
			System.out.println("Digite o endereço completo do empregado (Rua/Av, Num, Bairro e Cidade)");
			empregado.endereço = user.nextLine();


			

			System.out.printf("Nome do empregado: %s\n", empregado.nome);
			System.out.printf("Endereço do empregado: %s\n", empregado.endereço);

		    
			
			
		}
		
		
		

	}

}
