package com.folhaPagamento;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int opcao = 0;
		int quantidade = 1;
		System.out.println("Sistema Folha de Pagamento\n\nEscolha a opção desejada:\n");
		while(opcao!=100)
		{
			System.out.println("1: Adicionar um novo empregado\n2: Remover um empregado existente\n3: Lançar um cartão de ponto");
			System.out.println("4: Lançar um resultado de venda\n5: Lançar uma taxa de serviço\n6: Alterar detalhes de um empregado");
			System.out.println("7: Rodar folha de pagamento para hoje\n8: Desfazer ou refazer alguma alteração\n9: Mostrar agenda de pagamento\n10: Criar nova agenda de pagamento");
			
			Scanner user = new Scanner(System.in);
			opcao = Integer.valueOf(user.next());
			if(opcao == 100)
			{
				System.out.println("Até Logo!");
				break;
			}
			else if(opcao == 1)
			{
				System.out.print("Criar um novo empregado.\nDigite o nome: ");
				Empregado empregado = new Empregado();	
				empregado.numeroEmpregado = quantidade;
				quantidade++;				
				empregado.nome = user.nextLine();
				empregado.nome = user.nextLine();
				System.out.print("Digite o endereço completo do empregado (Rua/Av, Num, Bairro e Cidade): ");
				empregado.endereço = user.nextLine();
				System.out.print("Digite o tipo do empregado: (1 -> Horista; 2 -> Assalariado; 3 -> Comissionado): ");
				empregado.tipo = user.nextInt();
				if(empregado.tipo == 1)
				{
					System.out.println("Empregado Horista\nInformações Adicionais..");
					System.out.print("O empregado já possui horas trabalhadas? Se negativo, digite 0, caso contrario, digite o numero de horas trabalhadas: ");
					empregado.horasTabalhadas = Integer.valueOf(user.next());
					System.out.println("O empregado já possui horas extras trabalhadas? Se negativo, digite 0, caso contrario, digite o numero de horas extras trabalhadas: ");
					empregado.horasExtras = Integer.valueOf(user.next());
				}
				System.out.println("Numero do empregado: " + empregado.numeroEmpregado);
				
				

				

				System.out.printf("Nome do empregado: %s\n", empregado.nome);
				System.out.printf("Endereço do empregado: %s\n", empregado.endereço);
				System.out.println("Tipo: " + empregado.tipo);
				System.out.println("\n");

			    
				
				
			}
			
		}
		
		
		

	}

}
