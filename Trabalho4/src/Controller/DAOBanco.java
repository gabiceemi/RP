package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import Model.Cliente;
import Model.Conta;

public class DAOBanco implements Serializable {

	List<Conta> contas = new ArrayList<Conta>();
	List<Cliente> clientes = new ArrayList<Cliente>();

	public static void criaPastaNoDesktop() {
		String pastaUsuario = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
		File pasta = new File(pastaUsuario + File.separator + "Trabalho");

		if (pasta.mkdirs()) {
			System.out.println("Novo diretorio criado em: " + pasta.getAbsolutePath());
		} else {
			System.out.println("Diretorio ja existe");
		}

	}

	public void armazenarContas(List<Conta> contas) throws Exception {
		/**
		 * CLASSE PRA GRAVAR OBJETOS
		 */
		criaPastaNoDesktop();
		String diretorioUsuario = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
		File dir = new File(diretorioUsuario + File.separator + "Trabalho" + File.separator + "conta.bin");
		try (FileOutputStream fos = new FileOutputStream(dir)) {
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(contas);// todo o objeto porque array e
				oos.close(); // serealizavel
			}
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Conta> recuperaContas() throws IOException, ClassNotFoundException {
		String diretorioUsuario = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
		File dir = new File(diretorioUsuario + File.separator + "Trabalho" + File.separator + "conta.bin");
		try (FileInputStream fis = new FileInputStream(dir)) {
			try (ObjectInputStream ois = new ObjectInputStream(fis)) {
				return (ArrayList<Conta>) ois.readObject();

			}
		}

	}

	public ArrayList<Conta> exibeContas() throws Exception {

		DAOBanco operacao = new DAOBanco();

		ArrayList<Conta> contas = operacao.recuperaContas();
		for (Conta conta : contas) {
			JOptionPane.showMessageDialog(null, "Nome : " + conta.getCliente() + "\n" + " Numero : "
					+ conta.getNumero() + "\n" + " Data De Abertura: " + conta.getDataDeAbertura());

		}
		return contas;

	}

	public void armazenarClientes(List<Cliente> clientes) throws Exception {
		/**
		 * CLASSE PRA GRAVAR OBJETOS
		 */
		criaPastaNoDesktop();
		String diretorioUsuario = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
		File dir = new File(diretorioUsuario + File.separator + "Trabalho" + File.separator + "cliente.bin");
		try (FileOutputStream fos = new FileOutputStream(dir)) {
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(clientes);// todo o objeto porque array e
				oos.close(); // serealizavel
			}
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> recuperaClientes() throws Exception {

		String diretorioUsuario = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
		File dir = new File(diretorioUsuario + File.separator + "Trabalho" + File.separator + "cliente.bin");
		try (FileInputStream fis = new FileInputStream(dir)) {
			try (ObjectInputStream ois = new ObjectInputStream(fis)) {

				return (ArrayList<Cliente>) ois.readObject();
			}
		}

	}

}
