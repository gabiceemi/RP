package Model;

public class PessoaJuridica extends Cliente {
	
	private int cnpj;
		
	public PessoaJuridica(String nome, String endereco, int cep, int telefone, double renda, Boolean situacao, int cnpj) {
	super(nome, endereco, cep, telefone, renda, situacao);
		
		this.cnpj = cnpj; 
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	}


