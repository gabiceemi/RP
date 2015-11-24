package Controller;

import Model.*;
import View.*;

import java.util.*;

public class DAOContas {

	protected Conta conta;
	protected Cliente cliente;
	protected int senha;
	protected int limite;
	protected double rendimento;
	protected int dataBase;
	protected DAOBanco daoBanco;
	protected DAOClientes daoClientes;
	List<Conta> contas = new ArrayList<Conta>();
	
	public boolean existeConta(int chave) {
		Corrente cc;
		Poupanca cp;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof Corrente) {
				cc = (Corrente) contas.get(i);
				if (cc.getNumero() == chave) {

					return true;

				}
			} else {
				cp = (Poupanca) contas.get(i);
				if (cp.getNumero() == chave) {

					return true;

				}
			}
		}
		return false;

	}
	
	public boolean verificaLogin(int chave) {
		Conta conta;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof Conta) {
				conta = (Conta) contas.get(i);
				if (conta.getNumero() == chave) {

					return true;

				}
			}
		}
		return false;
	}

	public boolean verificaSenha(int chave) {
		Conta conta;
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i) instanceof Conta) {
				conta = (Conta) contas.get(i);
				if (conta.getSenha() == chave) {

					return true;

				}
			}
		}
		return false;
	}

	public boolean existeCliente(Cliente cliente) {
		return daoClientes.clientes.contains(cliente);
	}
/**
 * metodos de abertura de conta para pessoa fisica
 * 
 */
	public void abrirContaEspecialPF(PessoaFisica pf, int senha, double limite) {

		Especial ce = new Especial(pf, true, senha, limite);
		contas.add(ce);
		try {
			daoBanco.armazenarContas(contas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void abrirContaCorrentePF(PessoaFisica pf, int senha) {

		Corrente cc = new Corrente(pf, true, senha);
		contas.add(cc);
	}
	public void abrirContaPoupancaPF(PessoaFisica pf, int senha, double rendimento, int dataBase) {

		Poupanca cp = new Poupanca(pf, true, senha,rendimento,dataBase);
		contas.add(cp);
	}
	/**
	 * Metodos de abertura de conta para pessoa juridica
	 * 
	 */
	public void abrirContaEspecialPJ(PessoaJuridica pj, int senha, double limite) {

		Especial ce = new Especial(pj, true, senha, limite);
		contas.add(ce);
		try {
			daoBanco.armazenarContas(contas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void abrirContaCorrentePJ(PessoaJuridica pj, int senha) {

		Corrente cc = new Corrente(pj, true, senha);
		contas.add(cc);
	}
	public void abrirContaPoupancaPJ(PessoaJuridica pj, int senha, double rendimento, int dataBase) {

		Poupanca cp = new Poupanca(pj, true, senha,rendimento,dataBase);
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

	
	
}
