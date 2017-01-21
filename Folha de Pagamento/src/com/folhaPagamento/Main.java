package com.folhaPagamento;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int opcao = 0, quantidade = 0, numero = 1, aux, i, horas, cadastrados = 0, entrada, saida;
		double auxD;
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

		Scanner user = new Scanner(System.in);
		Empregado[] empregado = new Empregado[100];
		System.out.println("Data: " + sdf.format(currentDate));

		System.out.println("TESTE DATA:");

		try {
			String userDate;
			userDate = user.nextLine();
			SimpleDateFormat sdfBirthday = new SimpleDateFormat("dd/MM/YYYY");
			Date birthday = sdfBirthday.parse(userDate);
			System.out.println(userDate);

		} catch (Exception e) {
			// TODO: handle exception
		}
				
		System.out.println("Sistema Folha de Pagamento\nEscolha a opção desejada:\n");
		while(opcao!=12)
		{
			System.out.println("1: Adicionar um novo empregado\n2: Remover um empregado existente\n3: Lançar um cartão de ponto");
			System.out.println("4: Lançar um resultado de venda\n5: (em breve)Lançar uma taxa de serviço\n6: Alterar detalhes de um empregado");
			System.out.println("7: (em breve)Rodar folha de pagamento para hoje \n8: (em breve)Desfazer ou refazer alguma alteração\n9: (em breve)Mostrar agenda de pagamento \n10: (em breve)Criar nova agenda de pagamento");
			System.out.println("11: Vizualizar detalhes sobre um funcionario expecifico\n12: Sair");
			
			opcao = Integer.valueOf(user.next());
			if(opcao == 12)
			{
				System.out.println("Até Logo!");
				break;
			}
			else if(opcao == 1)
			{
				empregado[quantidade] = new Empregado();
				empregado[quantidade].numeroEmpregado = numero;						
				System.out.print("Criar um novo empregado.\nDigite o nome: ");										
				empregado[quantidade].nome = user.nextLine();
				empregado[quantidade].nome = user.nextLine();

				System.out.print("Digite o endereço completo do empregado (Rua/Av, Num, Bairro e Cidade): ");
				empregado[quantidade].endereço = user.nextLine();
				System.out.print("Digite o tipo do empregado (1: Horista; 2: Assalariado; 3: Comissionado): ");
				empregado[quantidade].tipo = user.nextInt();
				if(empregado[quantidade].tipo == 1){
					System.out.println("Empregado Horista\nPagamento é realizado todas às sextas-feiras");
					empregado[quantidade].diaPagamento = 1;
					System.out.print("O empregado já possui horas trabalhadas? Se negativo, digite 0, caso contrario, digite o numero de horas trabalhadas: ");
					empregado[quantidade].horasTabalhadas = Integer.valueOf(user.next());
					System.out.print("O empregado já possui horas extras trabalhadas? Se negativo, digite 0, caso contrario, digite o numero de horas extras trabalhadas: ");
					empregado[quantidade].horasExtras = Integer.valueOf(user.next());
				}
				else if (empregado[quantidade].tipo == 2) {
					System.out.print("Funcionario Assalariado não comissionado\nPagamento é realizado a cada 2 sextas-feiras.\nDigite o salario do funcionario: ");
					empregado[quantidade].diaPagamento = 2;
					empregado[quantidade].salarioMensal = Double.valueOf(user.next());
				}
				else if (empregado[quantidade].tipo == 3)
				{
					System.out.print("Funcionario Assalariado Comissionado\nPagamento realizando sempre no ultimo dia do mês\nDigite o salario do funcionario: ");
					empregado[quantidade].salarioMensal = Double.valueOf(user.next());
					System.out.print("Digite o percentual de comissão que o funcionario recebe (Exemplo: 0.5): ");
					empregado[quantidade].percentual = Double.valueOf(user.next());
				}
				System.out.print("Digite a forma como o funcionario prefere receber o salario (1: Cheque via Correios; 2: Cheque entregue em mãos; 3: Deposito bancario): ");
				empregado[quantidade].pagamento = Integer.valueOf(user.next());
				System.out.print("Quase pronto...\nCaso o funcionario pertença a algum sindicato, digite a taxa descontada pelo sindicato, caso contrario, digite 0 (Exemplo: 0.5): ");
				empregado[quantidade].taxaSindicato = Double.valueOf(user.next());
				System.out.println("\nFuncionario adicionado com sucesso.\n");
				quantidade++; 
				numero++;
				cadastrados++;
				
				
			}
			else if (opcao == 2) {
				if (cadastrados > 0) {
					System.out.println("Remover um funcionario do sistema.");	
					System.out.println("Funcionarios cadastrados atualmente:");
					for (i = 0; i < quantidade; i++) {
						if (empregado[i].nome != null) {
							System.out.println(empregado[i].numeroEmpregado + " : " + empregado[i].nome + "\n");
						}
					}
					System.out.print("Digite o codigo do funcionario desejado: ");
					aux = Integer.valueOf(user.next());
					for (i = 0; i < quantidade; i++) {
						if (aux == empregado[i].numeroEmpregado) {

							empregado[i].nome = null;
							empregado[i].endereço = null;
							empregado[i].tipo = 0;
							empregado[i].salarioMensal = 0;
							empregado[i].percentual = 0;
							empregado[i].taxaSindicato = 0;
							empregado[i].salarioComissao = 0;
							empregado[i].salarioHorario = 0;
							empregado[i].horasTabalhadas = 0;
							empregado[i].diaPagamento = 0;
							empregado[i].pagamento = 0;
							cadastrados--;
							System.out.println("Removido com sucesso.");
						}
					}
				}
				else{
					System.out.println("Não há funcionarios cadastrados. Opção inválida.\n");
				}
				

			}
			else if (opcao == 3) {
				
				if (cadastrados > 0) {
					System.out.println("Lançar um cartão de ponto.");
					System.out.println("Funcionarios cadastrados atualmente:");
					for (i = 0; i < quantidade; i++) {
						if (empregado[i].nome != null) {
							System.out.println(empregado[i].numeroEmpregado + " : " + empregado[i].nome + "\n");
						}
					}
					System.out.print("Digite o codigo do funcionario desejado: ");
					aux = Integer.valueOf(user.next());
					for (i = 0; i < quantidade; i++) {
						if (aux == empregado[i].numeroEmpregado) {

							System.out.printf("Nome do empregado: %s\n", empregado[i].nome);
							if (empregado[i].tipo == 1) {
								System.out.print("Empregado Horista.\nDigite a hora de entrada: ");
								entrada = Integer.valueOf(user.next());
								System.out.print("Digite a hora de saída: ");
								saida = Integer.valueOf(user.next());
								
								horas = saida - entrada;
								if (horas > 8) {
									horas = horas - 8;
									empregado[i].horasExtras += horas;
									empregado[i].horasTabalhadas += 8;
								} else {
									empregado[i].horasTabalhadas += aux;
								}
								i = quantidade;
							} else {
								System.out.println("Empregado não horista, opção não disponível.\n");
							}
						}
					}
				} else {
					System.out.println("Não há funcionarios cadastrados. Opção inválida.\n");
				}
				

				
				
			} else if (opcao == 4) {
				if (cadastrados > 0) {
					System.out.println("Lançar uma venda.");
					System.out.println("Funcionarios cadastrados atualmente:");
					for (i = 0; i < quantidade; i++) {
						if (empregado[i].nome != null) {
							System.out.println(empregado[i].numeroEmpregado + " : " + empregado[i].nome + "\n");
						}
					}
					System.out.print("Digite o codigo do funcionario desejado: ");
					aux = Integer.valueOf(user.next());
					
					for (i = 0; i < quantidade; i++) {
						if (aux == empregado[i].numeroEmpregado) {
							if (empregado[i].tipo == 3) {
								System.out.print("Empregado Assalariado Comissionado.\n Digite o valor da venda realizada (Ex.: 500.00): ");
								auxD = Double.valueOf(user.next());
								empregado[i].vendaMes += auxD;
								i = quantidade;
							} else {
								System.out.println("Empregado não comissionado, opção não disponível.\n");
							}
						}
					}
				} else {
					System.out.println("Não há funcionarios cadastrados. Opção inválida.\n");
				}
			}
			
			else if (opcao == 5) {
				if (cadastrados > 0) {
					System.out.println("Lançar uma taxa de serviço.");	
					System.out.println("Funcionarios cadastrados atualmente:");
					for (i = 0; i < quantidade; i++) {
						if (empregado[i].nome != null) {
							System.out.println(empregado[i].numeroEmpregado + " : " + empregado[i].nome + "\n");
						}
					}
					System.out.print("Digite o codigo do funcionario desejado: ");
					aux = Integer.valueOf(user.next());
					System.out.println("");
				}
			}
			
			
			
			
			
			else if (opcao == 6) {
				if (cadastrados > 0) {
					System.out.println("Alterar detalhes de um funcionário cadastrado.");	
					System.out.println("Funcionarios cadastrados atualmente:");
					for (i = 0; i < quantidade; i++) {
						if (empregado[i].nome != null) {
							System.out.println(empregado[i].numeroEmpregado + " : " + empregado[i].nome + "\n");
						}
					}
					System.out.print("Digite o codigo do funcionario desejado: ");
					aux = Integer.valueOf(user.next());
					for (i = 0; i < quantidade; i++) {
						if (aux == empregado[i].numeroEmpregado && empregado[i].nome != null) {
							System.out.println("Nome do empregado: "+ empregado[i].nome);
							System.out.print("Digite o codigo da informação que deseja alterar (1: Nome; 2: Endereço; 3: Tipo; 4: Forma de pagamento; 5: Sindicato): ");
							horas = Integer.valueOf(user.next());
							if (horas == 1) {
								System.out.print("Digite o nome do funcionario: ");
								empregado[i].nome = user.nextLine();
								empregado[i].nome = user.nextLine();
							} else if (horas == 2) {
								System.out.print("Digite o endereço do funcionario: ");
								empregado[i].endereço = user.nextLine();
								empregado[i].endereço = user.nextLine();
							} else if (horas == 3) {
								System.out.print("Digite o tipo do empregado (1: Horista; 2: Assalariado; 3: Comissionado): ");
								empregado[i].tipo = user.nextInt();
							} else if (horas == 4) {
								System.out.print("Digite a forma de pagamento preferida pelo funcionario (1: Cheque via Correios; 2: Cheque entregue em mãos; 3: Deposito bancario): ");
								empregado[i].pagamento = user.nextInt();
							}
							else if (horas == 5) {
								System.out.print("Se o funcionario pertence a um sindicato, digite a taxa que o mesmo cobra. Caso contrário, digite 0: ");
								empregado[i].taxaSindicato = Double.valueOf(user.next());
							}
						} else if(empregado[i].nome == null) {
							System.out.println("Funcionario não encontrado.");
						}
					}
				}
				else {
					System.out.println("Não há funcionarios cadastrados. Opção inválida.\n");
				}
				
			}
			
			
			else if(opcao == 11)
			{
				System.out.print("Digite o codigo do funcionario: ");
				aux = Integer.valueOf(user.next());
				
				for(i = 0; i < quantidade; i++){
					if(aux == empregado[i].numeroEmpregado)
					{

						System.out.printf("Nome do empregado: %s\n", empregado[i].nome);
						System.out.printf("Endereço do empregado: %s\n", empregado[i].endereço);
						System.out.println("Tipo: " + empregado[i].tipo);
						System.out.println("Valor do Salario Mensal: R$" + empregado[i].salarioMensal);
						System.out.println("Percentual: "+empregado[i].percentual + "%");
						System.out.println("Taxa sindicato: " + empregado[i].taxaSindicato + "%");
						System.out.println("Horas trabalhadas: "+empregado[i].horasTabalhadas);
						System.out.println("Horas extras: " + empregado[i].horasExtras);
						System.out.println("\n");
					}
				}
			}
			else{
				System.out.println("Opção inválida. Tente novamente.\n");
			}
			

		}

}

}
