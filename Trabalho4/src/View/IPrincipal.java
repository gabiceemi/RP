package View;

import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IPrincipal extends JFrame implements ActionListener {
	private JLabel menu;
	private JButton buttonCadastros,buttonGerenciar, buttonOperacoes, buttonPesquisar, buttonExit;

	public IPrincipal() {

		super("Menu");

		Container content = getContentPane();
		content.setLayout(null);

		menu = new JLabel("MENU");
		menu.setBounds(new Rectangle(100, 10, 130, 25));
		content.add(menu);

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

		IPrincipal janela = new IPrincipal();
		janela.setSize(250, 330);
		

	}

	public void actionPerformed(ActionEvent e) {

		String command = (String) e.getActionCommand();
		switch (command) {
		case ("cadastrar"):
			new ICadastros();
			break;
		case ("gerenciar"):
			new IGerenciar();
			break;
		case ("operacoes"):
			new IOperacoes();
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
