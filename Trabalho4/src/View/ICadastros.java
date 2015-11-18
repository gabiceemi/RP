package View;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.*;
import java.awt.*;

public class ICadastros extends JFrame implements ActionListener {
	private JPanel PainelPrincipal;
	private JButton buttonCadastroPF, buttonCadastroPJ;

	public ICadastros() {
		super("Janela Cadastros");
		setBounds(100, 100, 350, 300);
		PainelPrincipal = new JPanel();
		PainelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PainelPrincipal);
		PainelPrincipal.setLayout(null);

		JTabbedPane PainelAbas = new JTabbedPane(JTabbedPane.TOP);

		PainelAbas.setBounds(10, 27, 297, 202);
		PainelPrincipal.add(PainelAbas);

		JPanel PainelConta = new JPanel();
		PainelAbas.addTab("Conta", PainelConta);
		PainelConta.setLayout(null);

		JButton btnAbrirContaCorrente = new JButton("Conta Corrente");
		btnAbrirContaCorrente.setBounds(10, 11, 150, 23);
		PainelConta.add(btnAbrirContaCorrente);
		btnAbrirContaCorrente.setActionCommand("corrente");
		btnAbrirContaCorrente.addActionListener(this);

		JButton btnAbrirContaPoupanca = new JButton("Conta Poupanca");
		btnAbrirContaPoupanca.setBounds(10, 56, 150, 23);
		PainelConta.add(btnAbrirContaPoupanca);
		btnAbrirContaPoupanca.setActionCommand("poupanca");
		btnAbrirContaPoupanca.addActionListener(this);

		JButton btnContaEspecial = new JButton("Conta Especial");
		btnContaEspecial.setBounds(10, 100, 150, 23);
		PainelConta.add(btnContaEspecial);
		btnContaEspecial.setActionCommand("especial");
		btnContaEspecial.addActionListener(this);

		JPanel PainelCliente = new JPanel();
		PainelAbas.addTab("Cliente", PainelCliente);
		
		
		buttonCadastroPF = new JButton("Pessoa Fisica");
		buttonCadastroPF.setBounds(new Rectangle(10, 11, 150, 23));
		PainelCliente.add(buttonCadastroPF);
		buttonCadastroPF.setActionCommand("cadastrarPF");
		buttonCadastroPF.addActionListener(this);

		buttonCadastroPJ = new JButton("Pessoa Juridica");
		buttonCadastroPJ.setBounds(new Rectangle(10, 56, 150, 23));
		PainelCliente.add(buttonCadastroPJ);
		buttonCadastroPJ.setActionCommand("cadastrarPJ");
		buttonCadastroPJ.addActionListener(this);
		
		setVisible(true);
		setSize(350, 300);
	}

	public void actionPerformed(ActionEvent e) {
		String command = (String) e.getActionCommand();
		switch (command) {
		case ("corrente"):
			
			new IContaCorrente();

			break;
		case ("especial"):
			new IContaEspecial();
			break;
		case ("poupanca"):
			new IContaPoupanca();
			break;
		case("cadastrarPF"):
			new CadastroPFInterface();
		break;
		case("cadastrarPJ"):
			new CadastroPJInterface();
		break;
		default:
			dispose();
		}

	}
}