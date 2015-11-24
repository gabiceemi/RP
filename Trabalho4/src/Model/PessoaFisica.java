package Model;

public class PessoaFisica extends Cliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String sexo;
	protected String rg;
	protected String cpf;

	public PessoaFisica(String nome, String renda, String endereco,
			String bairro, String cep, String cidade, String uf, String telefone, boolean situacao, 
			String sexo, String rg, String cpf) {
		super(nome, renda, endereco, bairro, cep, cidade, uf, telefone, situacao);
		this.sexo = sexo;
		this.rg = rg;
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String toString(){
		String dados = super.toString()+ " Sexo: "+sexo + " RG: "+ rg + " CPF: "+ cpf;
		return dados;
	}

}
