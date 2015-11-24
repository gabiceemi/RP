package Model;

import java.io.Serializable;

public class Especial extends Corrente implements Serializable{
	protected double limite;

	public Especial(Cliente cliente,boolean situacao, int senha, double limite) {
		super(cliente,situacao,senha);
		geraNumero();
		this.limite = limite;
	}
	@Override
	public boolean saque(double valor) {
		if((saldo+limite)>=valor){
			this.saldo=saldo-valor;
			String tipo = "saque";
			Movimentos move = new Movimentos(tipo, valor);
			listaMovimento.addLast(move);
			return true;
		}
		else{
			return false;
		}
	}
	
	public double getSaldoTotal(){
		return saldo+limite;
	}
	public void setLimite(double limite){
		this.limite = limite;
	}
	public double getLimite(){
		return this.limite;
	}

}
