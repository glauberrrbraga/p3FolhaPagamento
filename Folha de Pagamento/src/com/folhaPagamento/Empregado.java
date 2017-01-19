package com.folhaPagamento;

public class Empregado {
	String nome;
	String endereço;
	int tipo; //1 = horista; 2 = assalariado; 3 = comissionado
	double salarioHorario; 
	int horasTabalhadas; //Somente se ele for horista
	int horasExtras; 
	int diaPagamento; 
	int sindicato; //1 -> SIM; 2 -> NAO
	double salarioMensal; 
	double salarioComissao; 
	int numeroEmpregado; //Deve ser gerado automaticamente
}
