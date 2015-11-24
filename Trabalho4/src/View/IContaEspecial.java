package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IContaEspecial extends JFrame implements ActionListener{
	private JTextField fieldNome;
	private JTextField fieldSenha;
	private JTextField textField;
	public IContaEspecial() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do cliente:");
		lblNomeDoCliente.setBounds(20, 22, 86, 14);
		getContentPane().add(lblNomeDoCliente);
		
		fieldNome = new JTextField();
		fieldNome.setBounds(110, 19, 189, 20);
		getContentPane().add(fieldNome);
		fieldNome.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(309, 20, 77, 19);
		getContentPane().add(btnBuscar);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(20, 62, 46, 14);
		getContentPane().add(lblSenha);
		
		fieldSenha = new JTextField();
		fieldSenha.setBounds(110, 59, 86, 20);
		getContentPane().add(fieldSenha);
		fieldSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar ");
		btnCadastrar.setBounds(151, 169, 89, 23);
		getContentPane().add(btnCadastrar);
		
		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setBounds(20, 100, 46, 14);
		getContentPane().add(lblLimite);
		
		textField = new JTextField();
		textField.setBounds(110, 97, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		setSize(400,300);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
