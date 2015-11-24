package View;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import Controller.DAOContas;
import Model.Conta;
import Model.Corrente;
import Model.Poupanca;

public class ILogin extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnLogin;
	private DAOContas daocontas;
	Corrente cc;
	Poupanca cp;
	Conta conta;

	public ILogin(DAOContas daocontas) {

		super("Operacoes de conta");
		this.daocontas = daocontas;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(400, 300);
		getContentPane().setLayout(null);

		JLabel lblNumeroDaConta = new JLabel("Numero da conta:");
		lblNumeroDaConta.setBounds(26, 49, 109, 14);
		getContentPane().add(lblNumeroDaConta);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(26, 106, 46, 14);
		getContentPane().add(lblSenha);

		textField = new JTextField();
		textField.setBounds(145, 46, 118, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(145, 103, 118, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(114, 169, 89, 23);
		getContentPane().add(btnLogin);
		btnLogin.setActionCommand("Logar");
		btnLogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = (String) e.getActionCommand();

		switch (command) {
		case ("Logar"):
			String senhaS = textField_1.getText();
			int senha = Integer.parseInt(senhaS);
			String loguinS = textField.getText();
			int loguin = Integer.parseInt(loguinS);
			if (daocontas.verificaLoguin(loguin) == true) {
				if (daocontas.verificaSenha(senha) == true) {
					new IOperacoes(daocontas, cc, conta);
				} else {
					JOptionPane.showMessageDialog(null, "Senha Errada  " + daocontas.existeConta(senha));
				}
			} else {
				JOptionPane.showMessageDialog(null, "Loguin Errado  " + daocontas.existeConta(loguin));
			}
			break;
		}
	}
}
