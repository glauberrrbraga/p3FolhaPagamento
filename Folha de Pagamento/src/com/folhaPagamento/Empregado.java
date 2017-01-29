package com.folhaPagamento;

public class Empregado {
	String nome;
	String endereço;
	int tipo; 
	double salarioHorario; 
	double horasTabalhadas;
	double horasExtras;
	double vendaMes;
	int diaPagamento; 
	double taxaSindicato;
	double percentual;
	int pagamento; //1 -> correio; 2 -> em maos; 3 -> deposito 
	double salarioMensal; 
	int dia; //Se o funcionario quiser trocar o dia de pagamento, vai ser salvo ai 
	double salarioTotal = 0;
	int numeroEmpregado; //Deve ser gerado automaticamente
}
