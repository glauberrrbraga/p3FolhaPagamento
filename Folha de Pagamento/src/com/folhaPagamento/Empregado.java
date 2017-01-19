package com.folhaPagamento;

public class Empregado {
	String nome;
	String endereço;
	int tipo; //1 = horista; 2 = assalariado; 3 = comissionado
	double salarioHorario; //Se ele for horista
	double salarioMensal; //Se ele for assalariado
	double salarioComissao; //Se ele for comissionado
	int numeroEmpregado; //Deve ser gerado automaticamente
}
