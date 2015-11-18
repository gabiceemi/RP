package Controller;

import Model.*;
import View.*;

import java.util.*;

public class DAOContas extends DAOBanco {

	protected Conta conta;
	protected Cliente cliente;
	protected int senha;
	protected int limite;
	protected double rendimento;
	protected int dataBase;

	public boolean existeCliente(Cliente cliente) {
		return clientes.contains(cliente);
	}

	public void abrirContaEspecial(Cliente cliente, int senha, double limite) {

		Especial ce = new Especial(cliente, true, senha, limite);
		contas.add(ce);
		try {
			armazenarContas(contas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void abrirContaCorrente(Cliente cliente, int senha) {

		Corrente cc = new Corrente(cliente, true, senha);
		contas.add(cc);
	}
	public void abrirContaPoupanca(Cliente cliente, int senha, double rendimento, int dataBase) {

		Poupanca cp = new Poupanca(cliente, true, senha,rendimento,dataBase);
		contas.add(cp);
	}

	public Conta pesquisarMaiorSaldoCP() {
		double maiorSaldo = -1;
		int indiceMaior = 0;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof Poupanca) {
				if (maiorSaldo == -1) {
					maiorSaldo = contas.get(i).getSaldo();
					indiceMaior = i;
				} else if (maiorSaldo < contas.get(i).getSaldo()) {
					maiorSaldo = contas.get(i).getSaldo();
					indiceMaior = i;
				}
			}
		}

		return contas.get(indiceMaior);
	}

	public Conta pesquisarMenorSaldoCP() {
		double menorSaldo = -1;
		int indiceMenor = 0;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof Poupanca) {
				if (menorSaldo == -1) {
					menorSaldo = contas.get(i).getSaldo();
					indiceMenor = i;
				} else if (menorSaldo > contas.get(i).getSaldo()) {
					menorSaldo = contas.get(i).getSaldo();
					indiceMenor = i;
				}
			}
		}

		return contas.get(indiceMenor);
	}

	public Conta pesquisarMaiorSaldoCC() {
		double maiorSaldo = -1;
		int indiceMaior = 0;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof Corrente) {
				if (maiorSaldo == -1) {
					maiorSaldo = contas.get(i).getSaldo();
					indiceMaior = i;
				} else if (maiorSaldo < contas.get(i).getSaldo()) {
					maiorSaldo = contas.get(i).getSaldo();
					indiceMaior = i;
				}
			}
		}

		return contas.get(indiceMaior);
	}

	public Conta pesquisarMenorSaldoCC() {
		double menorSaldo = -1;
		int indiceMenor = 0;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof Corrente) {
				if (menorSaldo == -1) {
					menorSaldo = contas.get(i).getSaldo();
					indiceMenor = i;
				} else if (menorSaldo > contas.get(i).getSaldo()) {
					menorSaldo = contas.get(i).getSaldo();
					indiceMenor = i;
				}
			}
		}

		return contas.get(indiceMenor);
	}

	public Conta pesquisarMaiorSaldoCE() {
		double maiorSaldo = -1;
		int indiceMaior = 0;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof Especial) {
				if (maiorSaldo == -1) {
					maiorSaldo = contas.get(i).getSaldoTotal();
					indiceMaior = i;
				} else if (maiorSaldo < contas.get(i).getSaldoTotal()) {
					maiorSaldo = contas.get(i).getSaldoTotal();
					indiceMaior = i;
				}
			}
		}

		return contas.get(indiceMaior);
	}

	public Conta pesquisarMenorSaldoCE() {
		double menorSaldo = -1;
		int indiceMenor = 0;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof Especial) {
				if (menorSaldo == -1) {
					menorSaldo = contas.get(i).getSaldoTotal();
					indiceMenor = i;
				} else if (menorSaldo > contas.get(i).getSaldoTotal()) {
					menorSaldo = contas.get(i).getSaldoTotal();
					indiceMenor = i;
				}
			}
		}

		return contas.get(indiceMenor);
	}

	protected boolean encerrarConta(int numero) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNumero() == numero) {
				contas.get(i).setSituacao(false);
				return true;
			}
		}
		return false;
	}

	protected boolean encerrarContas(Cliente cliente) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getCliente() == cliente) {
				contas.get(i).setSituacao(false);
				return true;
			}
		}
		return false;
	}

	public String verificarSaldo(int numero) {
		String saldo = null;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNumero() == numero) {
				saldo = "Saldo atual: " + contas.get(i).getSaldo();
			}
		}
		return saldo;
	}
	public static void main(String []args){
		DAOContas c = new DAOContas();
		c.abrirContaEspecial(null, 1234, 1.000);
		try {
			c.exibeContas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
