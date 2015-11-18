package Model;

public class Corrente extends Conta {
	
	public Corrente(Cliente cliente,boolean situacao, int senha) {
		super(cliente,situacao,senha);
		geraNumero();
		
	}


	public boolean saque(double valor) {
		if(saldo>=valor){
			saldo=saldo-valor;
			return true;
		}
		return false;
	}


	@Override
	public double getSaldoTotal() {
		return getSaldo();
	}


	
}
