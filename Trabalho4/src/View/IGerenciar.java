package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.DAOClientes;
import Model.Cliente;
import Model.PessoaFisica;
import Model.PessoaJuridica;

public class IGerenciar extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton buttonOK, buttonEditar, buttonExcluir;
	private DAOClientes cliente;
	@SuppressWarnings("unused")
	private PessoaFisica pf;

	public IGerenciar(DAOClientes cliente, PessoaFisica pf) {
		this.cliente = cliente;
		this.pf = pf;
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNomeDoCliente = new JLabel("CPF ou CNPJ:");
		lblNomeDoCliente.setBounds(70, 45, 106, 14);
		getContentPane().add(lblNomeDoCliente);

		textField = new JTextField();
		textField.setBounds(181, 40, 130, 25);
		getContentPane().add(textField);
		textField.setColumns(10);

		buttonOK = new JButton("Consultar");
		buttonOK.setBounds(new Rectangle(50, 100, 80, 25));
		getContentPane().add(buttonOK, null);
		buttonOK.setActionCommand("buscar");
		buttonOK.addActionListener(this);
		
		buttonEditar = new JButton("Editar");
		buttonEditar.setBounds(new Rectangle(150, 100, 80, 25));
		getContentPane().add(buttonEditar, null);
		buttonEditar.setActionCommand("editar");
		buttonEditar.addActionListener(this);
		
		buttonExcluir = new JButton("Excluir");
		buttonExcluir.setBounds(new Rectangle(250, 100, 80, 25));
		getContentPane().add(buttonExcluir, null);
		buttonExcluir.setActionCommand("excluir");
		buttonExcluir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = (String) e.getActionCommand();
		switch (command) {
		case ("buscar"):
			String chave = textField.getText();
				Cliente c;
			try {
				JOptionPane.showMessageDialog(this, cliente.consultaDados(chave).toString());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
			break;
		case ("editar"):
			chave = textField.getText();
			try {
				c = cliente.consultaDados(chave);
				if (c instanceof PessoaFisica) {
					new IEditarClientePF(cliente, (PessoaFisica) c);
				} else {
					new IEditarClientePJ(cliente, (PessoaJuridica) c);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				;
			}
			break;
		case ("excluir"):
		chave = textField.getText();
			try {
				cliente.excluirCliente(chave);
				JOptionPane.showMessageDialog(null, "Cliente excluído!");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			break;
		}
	}
}
