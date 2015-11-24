package View;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.DAOBanco;
import Controller.DAOClientes;
import Controller.DAOContas;
import Model.Conta;
import Model.Corrente;
import Model.Poupanca;

public class IOperacoes extends JFrame implements ActionListener {
	private JTextField fieldValor;
	private JPanel PainelPrincipal;
	private JComboBox<String> comboBox;
	private Conta conta;
	
	
	
	

	public IOperacoes(DAOContas daoContas, Corrente corrente,Conta conta) {
		
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(392, 325);
		getContentPane().setLayout(null);

		setBounds(100, 100, 350, 300);
		PainelPrincipal = new JPanel();
		PainelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PainelPrincipal);
		PainelPrincipal.setLayout(null);

		JTabbedPane PainelAbas = new JTabbedPane(JTabbedPane.TOP);

		PainelAbas.setBounds(10, 27, 314, 223);
		PainelPrincipal.add(PainelAbas);

		JLayeredPane painelOp = new JLayeredPane();
		PainelAbas.addTab("Operações", null, painelOp, null);

		comboBox = new JComboBox<String>();

		comboBox.addItem("Saque");
		comboBox.addItem("Deposito");
		comboBox.addItem("Extrato");
		add(comboBox);

		comboBox.setBounds(146, 30, 154, 20);
		painelOp.add(comboBox);

		JLabel lblOperaesDeConta = new JLabel("Operacoes de conta:");
		lblOperaesDeConta.setBounds(10, 32, 126, 17);
		painelOp.add(lblOperaesDeConta);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(50, 126, 89, 23);
		painelOp.add(btnConfirmar);
		btnConfirmar.setActionCommand("Confirmar");
		btnConfirmar.addActionListener(this);

		fieldValor = new JTextField();
		fieldValor.setBounds(146, 70, 154, 20);
		painelOp.add(fieldValor);
		fieldValor.setColumns(10);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 73, 46, 14);
		painelOp.add(lblValor);

		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnNewButton_1.setBounds(171, 126, 89, 23);
		painelOp.add(btnNewButton_1);

		JLayeredPane painelEncerrar = new JLayeredPane();
		PainelAbas.addTab("Encerrar Conta", null, painelEncerrar, null);

		JLabel lblDesejaEncerrarA = new JLabel("Deseja encerrar a conta?");
		lblDesejaEncerrarA.setBounds(82, 42, 147, 14);
		painelEncerrar.add(lblDesejaEncerrarA);

		JButton btnNewButton = new JButton("Confirmar");

		btnNewButton.setActionCommand("Confirmar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(40, 106, 89, 23);
		painelEncerrar.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(163, 106, 89, 23);
		painelEncerrar.add(btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = (String) e.getActionCommand();

		switch (command) {
		case ("Confirmar"):

			String valorS = fieldValor.getText();
			double valor = Double.parseDouble(valorS);
			if (comboBox.getSelectedItem().toString().equals("Saque")) {
				System.out.println("entrou");
				
			}
			if (comboBox.getSelectedItem().toString().equals("Deposito")) {
				conta.deposito(valor);
				conta.getSaldo();
			} else {
				System.err.println("Não pode depositar");
			}
			if (comboBox.getSelectedItem().toString().equals("Extrato")) {
				System.out.println("Extrato");
			} else {
			
			}
			break;
		}

	}
}
