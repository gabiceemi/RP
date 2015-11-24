package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public abstract class Conta {

	protected Cliente cliente;
	protected double saldo;
	protected int numero;
	public static int numeroContas=1;
	protected Data dataEncerramento;
	protected String dataDeAbertura;
	protected String dataDeEncerramento;
	protected boolean situacao;
	protected int senha;

	IListaLigada listaMovimento = new ListaLigada();
	public Conta(Cliente cliente, boolean situacao, int senha) {
		SimpleDateFormat data = new SimpleDateFormat("dd MM yyyy");
		setDataDeAbertura(data.format(new Date()));
		this.cliente=cliente;
		this.situacao = situacao;
		this.senha = senha;
	}
	public int geraNumero(){
		numero = numeroContas;
		numeroContas=numeroContas+1;
		return numero;
	}
	public abstract boolean saque(double valor);


	public boolean deposito(double valor) {
		if (valor > 0) {
			saldo += valor;
			String tipo = "deposito";
			Movimentos move = new Movimentos(tipo, valor);
			listaMovimento.addLast(move);
			return true;
		}
		return false;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public Data getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Data dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public int getNumero() {
		return numero;
	}

	public String getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(String dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}

	public String getDataDeEncerramento() {
		return dataDeEncerramento;
	}

	public void setDataDeEncerramento(String dataDeEncerramento) {
		this.dataDeEncerramento = dataDeEncerramento;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	public abstract double getSaldoTotal();

	

}
