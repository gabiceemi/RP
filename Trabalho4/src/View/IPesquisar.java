package View;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class IPesquisar extends JFrame implements ActionListener {
	public IPesquisar(){
		super("Pesquisas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container content = getContentPane();
		content.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Escolha uma opção", "Conta Corrente com maior saldo", "Conta Corrente com menor saldo", "Conta Poupan\u00E7a com maior saldo", "Conta Poupan\u00E7a com menor saldo", "Conta Especial com maior saldo", "Conta Especial com menor saldo", "Pessoa F\u00EDsica com maior saldo", "Pessoa F\u00EDsica com menor saldo", "Pessoa Jur\u00EDdica com maior saldo", "Pessoa Jur\u00EDdica com menor saldo"}));
		comboBox.setBounds(137, 51, 237, 20);
		content.add(comboBox);
		
		JLabel lblTipoDePesquisa = new JLabel("Tipo de pesquisa:");
		lblTipoDePesquisa.setBounds(16, 54, 111, 14);
		content.add(lblTipoDePesquisa);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(142, 125, 89, 23);
		content.add(btnPesquisar);
		
		setVisible(true);
		setSize(400,250);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
