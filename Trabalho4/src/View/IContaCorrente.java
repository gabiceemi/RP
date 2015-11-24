package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Locale;
import java.util.Random;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import Controller.DAOBanco;
import Controller.DAOClientes;
import Controller.DAOContas;
import Model.Cliente;
import Model.Conta;

import Model.PessoaFisica;
import Model.PessoaJuridica;

import java.awt.Color;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class IContaCorrente extends JFrame implements ActionListener {
	Locale localeBR = new Locale("pt", "BR");
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", localeBR);

	private JPanel PainelPrincipal;
	private JTextField textFieldnumero, textFieldDataAbertura, textFieldSenha, textFieldClientecpf,textFieldLimite,textFieldnome;
	private JComboBox<String> comboBoxtipopessoa;

	
	DAOClientes daoclientes;
	DAOContas daocontas;
	DAOBanco daobanco;
	PessoaFisica pf;
	PessoaJuridica pj;
	

	public IContaCorrente(DAOClientes daoClientes, DAOContas daoContas, DAOBanco daoBanco ) {
		this.daobanco = daoBanco;
		this.daoclientes = daoClientes;
		this.daocontas = daoContas;
		Random gerador = new Random();
		 
	  String  numero="0"+gerador.nextInt(10)+""+gerador.nextInt(10)+""+gerador.nextInt(10)+""+gerador.nextInt(10);	

		setTitle("Menu Abertura de Conta Corrente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		comboBoxtipopessoa = new JComboBox<String>();

		comboBoxtipopessoa.addItem("Pessoa Fisica");
		comboBoxtipopessoa.addItem("Pessoa Juridica");
		add(comboBoxtipopessoa);

		comboBoxtipopessoa.setBounds(66, 100, 203, 20);
		PainelLabelEText.add(comboBoxtipopessoa);

		JLabel lblNumeroConta = new JLabel("Numero Conta: ");
		lblNumeroConta.setBounds(10, 11, 90, 14);
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

		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(10, 152, 46, 14);
		PainelLabelEText.add(lblSenha);

		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(66, 149, 203, 20);
		PainelLabelEText.add(textFieldSenha);
		textFieldSenha.setColumns(10);

		JLabel lblCliente = new JLabel("CPF :");
		lblCliente.setBounds(10, 50, 46, 14);
		PainelLabelEText.add(lblCliente);

		textFieldClientecpf = new JTextField();
		textFieldClientecpf.setBounds(66, 47, 203, 20);
		PainelLabelEText.add(textFieldClientecpf);
		textFieldClientecpf.setColumns(10);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 75, 46, 14);
		PainelLabelEText.add(lblNome);

		textFieldnome = new JTextField();
		textFieldnome.setEditable(false);
		textFieldnome.setBounds(66, 72, 203, 20);
		PainelLabelEText.add(textFieldnome);
		textFieldnome.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String busca = textFieldClientecpf.getText();
				String dataDeAbertura = fmt.format(new Date());

				if (daoclientes.existeCliente(busca) == true) {

					System.out.println("ok");

					textFieldClientecpf.setText(busca);

					try {
						textFieldnome.setText(daoclientes.consultaDados(busca).getNome());
		String nome=daoclientes.consultaDados(busca).getNome();
		nome =textFieldnome.getText();
			
					} catch (Exception e) {
						System.err.println("erro ao setar nome");
					}

					textFieldDataAbertura.setText(dataDeAbertura);
					textFieldnumero.setText(numero);

				} else {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado");
					limpaCampos();
				}

			}
		});
		btnPesquisar.setBounds(279, 46, 89, 23);
		PainelLabelEText.add(btnPesquisar);

		JLabel lblLimiteR = new JLabel("Limite R$ :");
		lblLimiteR.setBounds(10, 196, 75, 14);
		PainelLabelEText.add(lblLimiteR);

		textFieldLimite = new JTextField();
		textFieldLimite.setBounds(90, 193, 86, 20);
		PainelLabelEText.add(textFieldLimite);
		textFieldLimite.setColumns(10);

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

		this.setVisible(true);
	}
public void limpaCampos(){
	textFieldClientecpf.setText("");
	textFieldDataAbertura.setText("");
	textFieldnome.setText("");
	textFieldSenha.setText("");
	textFieldnumero.setText("");
	textFieldLimite.setText("");
}
	public void actionPerformed(ActionEvent e) {

		String command = (String) e.getActionCommand();

		switch (command) {
		case ("SALVAR"):

			
				String dataDeAbertura = fmt.format(new Date());
				String cpf = textFieldClientecpf.getText();
				String senhaS = textFieldSenha.getText();
				int senha = Integer.parseInt(senhaS);
				String limiteS = textFieldLimite.getText();
				double limite = Double.parseDouble(limiteS);
				String numeroS = textFieldnumero.getText();
				int numero = Integer.parseInt(numeroS);
				
			try {
				String nome=textFieldnome.getText()+daoclientes.consultaDados(cpf).getNome();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
				if (daoclientes.existeCliente(cpf) == true) {

					if (comboBoxtipopessoa.getSelectedItem().toString().equals("Pessoa Fisica")) {
						if (cpf.length() == 14) {

							

								try {
								
									
									daocontas.abrirContaCorrentePf(pf, true, senha, limite, numero, dataDeAbertura);
									daocontas.armazenarContas();
								} catch (Exception e1) {
									System.err.println("erro salvar :(");
								}
								
								
								JOptionPane.showMessageDialog(null, "Conta Corrente Pessoa Fisica Cadastrada ! "+"\n"+daocontas.listarContas());
							
								daocontas.listarContas().toString().toString();
							
							    limpaCampos();

						} else {
							JOptionPane.showMessageDialog(null, "ERRO DE CPF");
						}
					}
					if (comboBoxtipopessoa.getSelectedItem().toString().equals("Pessoa Juridica")) {
						if (cpf.length() == 12) {

							try {
								daocontas.abrirContaCorrentePj(pj, senha, limite, true, senha, dataDeAbertura);
								daocontas.armazenarContas();
								
								JOptionPane.showMessageDialog(null, "Conta Corrente Pessoa Juridica Cadastrada!");
								
							} catch (Exception e1) {
								
								limpaCampos();
							}

						} else {
							JOptionPane.showMessageDialog(null, "ERRO DE CNPJ");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Cliente Não existe");
				}
			
			break;
		case ("Sair"):
			this.dispose();
			break;

		}

	}
}
