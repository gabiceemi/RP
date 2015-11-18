package Controller;



import java.util.ArrayList;
import java.util.List;

import Model.Cliente;
import Model.PessoaFisica;
import Model.PessoaJuridica;

/*
 * @Gabriela e Saimon
 * 
 */

public class DAOClientes {

	private List<Cliente> clientes = new ArrayList<Cliente>();

	public void incluirClientePF(String nome, String renda, String endereco, int numero, String complemento,
			String bairro, String cep, String cidade, String uf, String telefone, boolean situacao, String sexo,
			String rg, String cpf) {
		Cliente pessoaFisica = new PessoaFisica(nome, renda, endereco, numero, complemento, bairro, cep, cidade, uf,
				telefone, situacao, sexo, rg, cpf);
		clientes.add(pessoaFisica);
	}

	public void incluirClientePJ(String nome, String renda, String endereco, int numero, String complemento,
			String bairro, String cep, String cidade, String uf, String telefone, boolean situacao, String cnpj) {
		Cliente pessoaJuridica = new PessoaJuridica(nome, renda, endereco, numero, complemento, bairro, cep, cidade, uf,
				telefone, situacao, cnpj);
		clientes.add(pessoaJuridica);
	}

	public void editarClientePF(String nome, String renda, String endereco, int numero, String complemento,
			String bairro, String cep, String cidade, String uf, String telefone, boolean situacao, String sexo,
			String rg, String cpf) {
		PessoaFisica pf;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof PessoaFisica) {
				pf = (PessoaFisica) clientes.get(i);
				if (pf.getCpf().equals(cpf)) {
					pf.setNome(nome);
					pf.setRenda(renda);
					pf.setEndereco(endereco);
					pf.setNumero(numero);
					pf.setComplemento(complemento);
					pf.setBairro(bairro);
					pf.setCep(cep);
					pf.setCidade(cidade);
					pf.setUf(uf);
					pf.setTelefone(telefone);
					pf.setSexo(sexo);
					pf.setRg(rg);
				}
			}
		}
	}

	public Cliente consultaDados(String chave) throws Exception {
		PessoaFisica pf;
		PessoaJuridica pj;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof PessoaFisica) {
				pf = (PessoaFisica) clientes.get(i);
				if (pf.getCpf().equals(chave)) {
					return pf;
				}
			} else {
				pj = (PessoaJuridica) clientes.get(i);
				if (pj.getCnpj().equals(chave)) {
					return pj;
				}
			}
		}
		throw new Exception("Cliente não existe");
	}

	public void editarClientePJ(String nome, String renda, String endereco, int numero, String complemento,
			String bairro, String cep, String cidade, String uf, String telefone, boolean situacao, String cnpj) {
		PessoaJuridica pj;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof PessoaJuridica) {
				pj = (PessoaJuridica) clientes.get(i);
				if (pj.getCnpj().equals(cnpj)) {
					pj.setNome(nome);
					pj.setRenda(renda);
					pj.setEndereco(endereco);
					pj.setNumero(numero);
					pj.setComplemento(complemento);
					pj.setBairro(bairro);
					pj.setCep(cep);
					pj.setCidade(cidade);
					pj.setUf(uf);
					pj.setTelefone(telefone);
				}
			}
		}
	}

	public void excluirCliente(String chave) throws Exception {
		boolean ok = false;
		PessoaFisica pf;
		PessoaJuridica pj;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof PessoaFisica) {
				pf = (PessoaFisica) clientes.get(i);
				if (pf.getCpf().equals(chave)) {
					ok = true;
					clientes.remove(i);
				}
			} else {
				pj = (PessoaJuridica) clientes.get(i);
				if (pj.getCnpj().equals(chave)) {
					ok = true;
					clientes.remove(i);
				}
			}
		}
		if (ok == false) {
			throw new Exception("Cliente não existe");
		}
	}

	public String listarClientes() {
		String dados = "";
		for (int i = 0; i < clientes.size(); i++) {
			dados += clientes.get(i).toString() + "\n";
		}
		return dados;
	}

	public boolean existeCliente(String chave) {
		PessoaFisica pf;
		PessoaJuridica pj;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof PessoaFisica) {
				pf = (PessoaFisica) clientes.get(i);
				if (pf.getCpf().equals(chave)) {
					return true;
				}
			} else {
				pj = (PessoaJuridica) clientes.get(i);
				if (pj.getCnpj().equals(chave)) {
					return true;
				}
			}
		}
		return false;

	}
}
