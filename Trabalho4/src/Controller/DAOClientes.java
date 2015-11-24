package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.filechooser.FileSystemView;

import Model.Cliente;
import Model.Conta;
import Model.PessoaFisica;
import Model.PessoaJuridica;

public class DAOClientes extends DAOBanco {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DAOBanco banco;
	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	public void ordena() {
		Cliente aux = null;
		for (int i = 0; i < clientes.size(); i++) {
			for (int j = 0; j < clientes.size() - 1; j++) {
				Cliente cli = (Cliente) clientes.get(j);
				Cliente outro = (Cliente) clientes.get(j + 1);
				if (cli.getNome().compareToIgnoreCase(outro.getNome()) > 0) {
					aux = cli;
					clientes.set(j, outro);
					clientes.set(j + 1, aux);
				}
			}
		}
	}
		
	public void imprimindoClientes(){
		DAOContas conta;
		String saida = "";
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cli = (Cliente) clientes.get(i);
			saida = saida + cli.getNome() + "\n" + "Telefone: " + cli.getTelefone() + "\n";
			Conta contas = contas.getNumero();
			if(contas!=null){
			for (int j = 0; j < contas.size(); j++) {
				Conta c = (Conta) contas.get(j);
				saida = saida + c.contaToString()  + "saldo:" + c.getSaldo() + "\n";
			}
			}
			saida = saida + "-------------------------------------------------\n";
		}
		String nomeArquivo = "ListaDeClientes.txt";
		gravarArquivo(nomeArquivo, saida);
	}
	
	public void gravarArquivo(String nomeArquivo, String informacao) {

		File arquivo = new File(nomeArquivo);
		try {
			FileWriter fw = new FileWriter(arquivo, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(informacao);
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void incluirClientePF(String nome, String renda, String endereco, String bairro, String cep, String cidade,
			String uf, String telefone, boolean situacao, String sexo, String rg, String cpf) {
		Cliente pessoaFisica = new PessoaFisica(nome, renda, endereco, bairro, cep, cidade, uf, telefone, situacao,
				sexo, rg, cpf);
		clientes.add(pessoaFisica);
		try {
			armazenarClientes();
		} catch (Exception e) {

		}
	}

	public void incluirClientePJ(String nome, String renda, String endereco, String bairro, String cep, String cidade,
			String uf, String telefone, boolean situacao, String cnpj) {
		Cliente pessoaJuridica = new PessoaJuridica(nome, renda, endereco, bairro, cep, cidade, uf, telefone, situacao,
				cnpj);
		clientes.add(pessoaJuridica);
		try {
			armazenarClientes();
		} catch (Exception e) {

		}
	}

	public void editarClientePF(String nome, String renda, String endereco, String bairro, String cep, String cidade,
			String uf, boolean situacao, String telefone, String sexo, String rg, String cpf) {
		PessoaFisica pf;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof PessoaFisica) {
				pf = (PessoaFisica) clientes.get(i);
				if (pf.getCpf().equals(cpf)) {
					pf.setNome(nome);
					pf.setRenda(renda);
					pf.setEndereco(endereco);
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
		throw new Exception("Cliente n�o existe");
	}

	public void editarClientePJ(String nome, String renda, String endereco, String bairro, String cep, String cidade,
			String uf, String telefone, boolean situacao, String cnpj) {
		PessoaJuridica pj;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof PessoaJuridica) {
				pj = (PessoaJuridica) clientes.get(i);
				if (pj.getCnpj().equals(cnpj)) {
					pj.setNome(nome);
					pj.setRenda(renda);
					pj.setEndereco(endereco);
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
			throw new Exception("Cliente n�o existe");
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

	public boolean validaDigitoCpf(String cpf) {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;
		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);
			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return (true);
			else
				throw new Exception("CPF inv�lido");
		} catch (Exception e) {
			return (false);
		}
	}

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	public static boolean isValidCNPJ(String ent) {
		if ((ent == null) || (ent.length() != 14))
			return false;

		Integer digito1 = calcularDigito(ent.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(ent.substring(0, 12) + digito1, pesoCNPJ);
		return ent.equals(ent.substring(0, 12) + digito1.toString() + digito2.toString());
	}

	public void armazenarClientes() throws Exception {
		DAOBanco.criaPastaNoDesktop();
		String diretorioUsuario = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
		File dir = new File(diretorioUsuario + File.separator + "Trabalho" + File.separator + "cliente.bin");
		try (FileOutputStream fos = new FileOutputStream(dir, true)) {
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(clientes);
				oos.close();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void recuperaCliente() throws IOException, ClassNotFoundException {
		String diretorioUsuario = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
		File dir = new File(diretorioUsuario + File.separator + "Trabalho" + File.separator + "cliente.bin");
		try (FileInputStream fis = new FileInputStream(dir)) {
			try (ObjectInputStream ois = new ObjectInputStream(fis)) {
				clientes = (ArrayList<Cliente>) ois.readObject();

			} catch (Exception e) {
				clientes = new ArrayList<Cliente>();
			}
		}

	}
}