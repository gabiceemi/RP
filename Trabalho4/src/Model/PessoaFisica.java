package Model;

public class PessoaFisica extends Cliente{
	private int cpf; 
	private int rg;
	
	public PessoaFisica(String nome, String endereco, int cep, int telefone, double renda, Boolean situacao, int cpf, int rg) {
		super(nome, endereco, cep, telefone, renda, situacao); 
		
		this.cpf = cpf; 
		this.rg = rg; 
	}
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getrg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	}


