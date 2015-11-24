package Model;

import java.io.Serializable;

/*
 * @Gabriela e Saimon
 * 
 */
import Model.Conta;

public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nome;
	protected String renda;
	protected String endereco;
	protected int numero;
	protected String complemento;
	protected String bairro;
	protected String cep;
	protected String cidade;
	protected String uf;
	protected String telefone;
	protected boolean situacao;
	protected Conta conta;

	public Cliente(String nome, String renda, String endereco, String bairro, String cep, String cidade, String uf,
			String telefone, boolean situacao) {
		this.nome = nome;
		this.renda = renda;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.telefone = telefone;
		this.situacao = situacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRenda() {
		return renda;
	}

	public void setRenda(String renda) {
		this.renda = renda;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public String toString() {
		String dados;
		dados = "Nome: " + nome + " Renda: " + renda + " Endereco: " + endereco + " Bairro: " + bairro + " CEP: " + cep
				+ " Cidade: " + cidade + " UF : " + uf + " Telefone: " + telefone + " Situação: " + situacao;
		return dados;
	}
}
