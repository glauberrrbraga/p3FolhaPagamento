package com.folhaPagamento;

public class Empregado {
	String nome;
	String endereço;
	int tipo; //1 = horista; 2 = assalariado; 3 = comissionado
	double salarioHorario; 
	int horasTabalhadas; //Somente se ele for horista
	int horasExtras;
	double vendaMes;
	int diaPagamento; 
	double taxaSindicato;
	double percentual;
	int pagamento; //1 -> correio; 2 -> em maos; 3 -> deposito 
	double salarioMensal; 
	double salarioComissao; 
	int numeroEmpregado; //Deve ser gerado automaticamente
}
