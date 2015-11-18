package Model;

public abstract class Cliente {

		private String nome, endereco;
		private int cep, telefone;
		private boolean situacao;
		private double renda;
		public Cliente(String nome, String endereco, int cep,int telefone, double renda, boolean situacao){
	
			this.nome = nome; 
			this.endereco = endereco; 
			this.cep = cep; 
			this.telefone = telefone; 
			this.renda = renda; 
			this.situacao = situacao; 
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			nome = nome;
		}

		public String getendereco() {
			return endereco;
		}

		public void setcep(int cep) {
			cep = cep;
		}

		public int getcep() {
			return cep;
		}

		public void setTelefone(int telefone) {
			telefone = telefone;
		}
		public int getTelefone() {
			return telefone;
		}
		public double getRenda() {
			return renda;
		}

		public void setRenda(double renda) {
			renda = renda;
		}

		public boolean getSituacao() {
			return situacao;
		}

		public void setSituacao(boolean situacao) {
			situacao = situacao;
		}	
	}