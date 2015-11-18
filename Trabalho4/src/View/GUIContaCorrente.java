package View;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.List;
import java.util.*;
import java.awt.event.*;

import Controller.*;
import Model.*;

@SuppressWarnings("serial")
public class GUIContaCorrente extends JFrame implements ActionListener {

	private JPanel PainelPrincipal;
	private JTextField textFieldnumero, textFieldDataAbertura, textFieldSenha, textFieldCliente, textFieldCPF;

	public GUIContaCorrente() {
		setTitle("Menu Abertura de Conta Corrente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 329);
		PainelPrincipal = new JPanel();
		PainelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PainelPrincipal);
		PainelPrincipal.setLayout(null);

		JPanel PainelLabelEText = new JPanel();
		PainelLabelEText.setBorder(new LineBorder(new Color(0, 0, 0)));
		PainelLabelEText.setBounds(10, 11, 423, 236);
		PainelPrincipal.add(PainelLabelEText);
		PainelLabelEText.setLayout(null);

		JLabel lblNumeroConta = new JLabel("Numero Conta: ");
		lblNumeroConta.setBounds(10, 11, 86, 14);
		PainelLabelEText.add(lblNumeroConta);

		textFieldnumero = new JTextField();
		textFieldnumero.setEditable(false);
		textFieldnumero.setBounds(90, 8, 86, 20);
		PainelLabelEText.add(textFieldnumero);
		textFieldnumero.setColumns(10);

		JLabel lblDataAbertura = new JLabel("Data Abertura :");
		lblDataAbertura.setBounds(196, 11, 86, 14);
		PainelLabelEText.add(lblDataAbertura);

		textFieldDataAbertura = new JTextField();
		textFieldDataAbertura.setEditable(false);
		textFieldDataAbertura.setBounds(280, 8, 133, 20);
		PainelLabelEText.add(textFieldDataAbertura);
		textFieldDataAbertura.setColumns(10);

		JCheckBox chckbxAtiva = new JCheckBox("Ativa");
		chckbxAtiva.setSelected(true);
		chckbxAtiva.setBounds(6, 170, 64, 23);
		PainelLabelEText.add(chckbxAtiva);

		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(10, 135, 46, 14);
		PainelLabelEText.add(lblSenha);

		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(66, 132, 110, 20);
		PainelLabelEText.add(textFieldSenha);
		textFieldSenha.setColumns(10);

		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setBounds(10, 50, 46, 14);
		PainelLabelEText.add(lblCliente);

		textFieldCliente = new JTextField();
		textFieldCliente.setBounds(66, 47, 347, 20);
		PainelLabelEText.add(textFieldCliente);
		textFieldCliente.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 94, 46, 14);
		PainelLabelEText.add(lblCpf);

		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(66, 91, 216, 20);
		PainelLabelEText.add(textFieldCPF);
		textFieldCPF.setColumns(10);

		JButton btnSacar = new JButton("Saque");
		btnSacar.setBounds(87, 170, 89, 23);
		PainelLabelEText.add(btnSacar);
		btnSacar.setActionCommand("Saque");
		btnSacar.addActionListener(this);
		
		JButton btnDeposito = new JButton("Deposito");
		btnDeposito.setBounds(193, 170, 89, 23);
		PainelLabelEText.add(btnDeposito);
		btnDeposito.setActionCommand("Deposito");
		btnDeposito.addActionListener(this);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.setBounds(300, 170, 89, 23);
		PainelLabelEText.add(btnSaldo);
		btnSaldo.setActionCommand("Saldo");
		btnSaldo.addActionListener(this);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 256, 89, 23);
		PainelPrincipal.add(btnSalvar);
		btnSalvar.setActionCommand("SALVAR");
		btnSalvar.addActionListener(this);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(113, 256, 89, 23);
		PainelPrincipal.add(btnSair);
		btnSair.setActionCommand("Sair");
		btnSair.addActionListener(this);
		
		JButton btnRelatorio = new JButton("Relatorio");
		btnRelatorio.setBounds(220, 256, 89, 23);
		PainelPrincipal.add(btnRelatorio);
		btnRelatorio.setActionCommand("Relatorio");
		btnRelatorio.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<Conta> contas = new ArrayList<Conta>();

		DAOBanco daoBanco = new DAOBanco();

		String command = (String) e.getActionCommand();

		switch (command) {
		case ("SALVAR"):
			String nome = "";
			String cpf = "";
			long numero = 0;
			int dataDeAbertura = 0;
			nome = textFieldCliente.getText();

			cpf = textFieldCPF.getText();

			String senhaS = textFieldSenha.getText();
			int senha = Integer.parseInt(senhaS);


			try {
				daoBanco.armazenarContas(contas);
			} catch (Exception e1) {

			}

			JOptionPane.showConfirmDialog(null, "Conta cadastrada! ");

			break;
		case ("Sair"):
			this.dispose();
			break;
		case ("Relatorio"):
		
			try {

			
            daoBanco.exibeContas();
		} catch (Exception e1) {
				
				e1.printStackTrace();
			}

			

			break;
		case ("Saque"):
			this.dispose();
			break;
		
	case ("Deposito"):
		this.dispose();
		break;
	case ("Saldo"):
		this.dispose();
		break;
	}

	
	}
}
