package Model;

public class PessoaJuridica extends Cliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String cnpj;

	public PessoaJuridica(String nome, String renda, String endereco,
		String bairro, String cep, String cidade, String uf, String telefone, boolean situacao, String cnpj) {
		super(nome, renda, endereco, bairro, cep, cidade, uf, telefone, situacao);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String toString(){
		String dados = super.toString()+ " CNPJ: "+ cnpj;
		return dados;
	}

}
