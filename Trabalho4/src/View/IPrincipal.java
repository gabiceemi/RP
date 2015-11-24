package View;

import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.*;

import Controller.DAOBanco;
import Controller.DAOClientes;
import Controller.DAOContas;
import Model.PessoaFisica;

@SuppressWarnings("serial")
public class IPrincipal extends JFrame implements ActionListener {
	private JButton buttonCadastros,buttonGerenciar, buttonOperacoes, buttonPesquisar, buttonExit;
	private DAOClientes cliente;
	private PessoaFisica pf;
	private DAOContas daoContas ;
	private  DAOBanco daoBanco;
	public IPrincipal(DAOClientes cliente, DAOContas daoContas, DAOBanco daoBanco) {

		super("Menu");
		this.cliente = cliente;
		this.daoBanco = daoBanco;
		this.daoContas = daoContas;
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		   
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container content = getContentPane();
		content.setLayout(null);

		buttonCadastros = new JButton("Cadastros");
		buttonCadastros.setBounds(new Rectangle(40, 40, 150, 40));
		content.add(buttonCadastros, null);
		buttonCadastros.setActionCommand("cadastrar");
		buttonCadastros.addActionListener(this);

		buttonGerenciar = new JButton("Gerenciar");
		buttonGerenciar.setBounds(new Rectangle(40, 100, 150, 40));
		content.add(buttonGerenciar, null);
		buttonGerenciar.setActionCommand("gerenciar");
		buttonGerenciar.addActionListener(this);

		buttonOperacoes = new JButton("Operacoes");
		buttonOperacoes.setBounds(new Rectangle(40, 160, 150, 40));
		content.add(buttonOperacoes, null);
		buttonOperacoes.setActionCommand("operacoes");
		buttonOperacoes.addActionListener(this);
		
		buttonPesquisar = new JButton("Pesquisar");
		buttonPesquisar.setBounds(new Rectangle(40, 220, 150, 40));
		content.add(buttonPesquisar, null);
		buttonPesquisar.setActionCommand("pesquisar");
		buttonPesquisar.addActionListener(this);

		buttonExit = new JButton("Sair");
		buttonExit.setBounds(new Rectangle(40, 280, 150, 40));
		content.add(buttonExit, null);
		buttonExit.setActionCommand("sair");
		buttonExit.addActionListener(this);

		setVisible(true);
	}

	public static void main(String[] args) {
		DAOClientes cliente = new DAOClientes();
		DAOContas daoContas = new DAOContas();
		DAOBanco daoBanco = new DAOBanco();
		
		IPrincipal janela = new IPrincipal(cliente,daoContas,daoBanco);
		janela.setSize(250, 370);

	}

	public void actionPerformed(ActionEvent e) {

		String command = (String) e.getActionCommand();
		switch (command) {
		case ("cadastrar"):
			new ICadastros(cliente, daoContas, daoBanco);
			break;
		case ("gerenciar"):
			new IGerenciar(cliente,pf);
			break;
		case ("operacoes"):
			new ILogin(daoContas);
		break;
		case ("pesquisar"):
			new IPesquisar();
			break;
		case ("sair"):
			System.exit(0);
			break;
		default:
			System.exit(0);
		}

	}

}
