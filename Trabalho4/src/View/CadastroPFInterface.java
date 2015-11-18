package View;

import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroPFInterface extends JFrame implements ActionListener {

	private JLabel labelInformacoes, labelNome, labelRenda, labelEndereco, labelBairro, labelCep, labelCidade, labelUf, labelTelefone,
			labelSexo, labelRg, labelCpf;
	private JCheckBox checkFeminino, checkMasculino;
	private JComboBox<String> comboRenda, comboUf;
	private JFormattedTextField ffieldCep, ffieldTelefone, ffieldCpf;
	private JTextField fieldNome, fieldEndereco, fieldBairro, fieldCidade, fieldRg;
	private JButton buttonOK, buttonVoltar;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CadastroPFInterface() {

		super("Pessoa F�sica");

		Container content = getContentPane();
		content.setLayout(null);
		
		labelInformacoes = new JLabel("Informa��es");
		labelInformacoes.setBounds(new Rectangle(20, 10, 125, 25));
		content.add(labelInformacoes);

		labelNome = new JLabel("Nome*:");
		labelNome.setBounds(new Rectangle(20, 45, 50, 25));
		content.add(labelNome);

		fieldNome = new JTextField();
		fieldNome.setBounds(new Rectangle(70, 45, 300, 25));
		content.add(fieldNome, null);

		labelSexo = new JLabel("Sexo*:");
		labelSexo.setBounds(new Rectangle(20, 150, 50, 25));
		content.add(labelSexo);

		checkFeminino = new JCheckBox("Feminino");
		checkFeminino.setBounds(60, 150, 80, 25);
		add(checkFeminino);
		checkMasculino = new JCheckBox("Masculino");
		checkMasculino.setBounds(60, 185, 90, 25);
		add(checkMasculino);
		
		labelRg = new JLabel("RG*:");
		labelRg.setBounds(new Rectangle(245, 150, 40, 25));
		content.add(labelRg);

		fieldRg = new JTextField();
		fieldRg.setBounds(new Rectangle(270, 150, 100, 25));
		content.add(fieldRg, null);
		
		labelRenda = new JLabel("Renda*:");
		labelRenda.setBounds(new Rectangle(20, 80, 50, 25));
		content.add(labelRenda);

		comboRenda = new JComboBox<String>();
		comboRenda.addItem("Menos que 1 sal�rio m�nimo");
		comboRenda.addItem("1 sal�rio m�nimo");
		comboRenda.addItem("1 a 3 sal�rios m�nimos");
		comboRenda.addItem("Mais que 3 sal�rios m�nimos");
		comboRenda.setBounds(70, 80, 300, 25);
		add(comboRenda);
		
		labelEndereco = new JLabel("Endere�o*:");
		labelEndereco.setBounds(new Rectangle(400, 45, 230, 25));
		content.add(labelEndereco);

		fieldEndereco = new JTextField();
		fieldEndereco.setBounds(new Rectangle(480, 45, 300, 25));
		content.add(fieldEndereco, null);
		
		labelBairro = new JLabel("Bairro:");
		labelBairro.setBounds(new Rectangle(520, 115, 60, 25));
		content.add(labelBairro);

		fieldBairro = new JTextField();
		fieldBairro.setBounds(new Rectangle(565, 115, 215, 25));
		content.add(fieldBairro, null);
		
		labelCep = new JLabel("CEP*:");
		labelCep.setBounds(new Rectangle(400, 115, 230, 25));
		content.add(labelCep);
		
		try {
			MaskFormatter mk = new MaskFormatter("#####-###");
			mk.setPlaceholderCharacter('_');
			ffieldCep = new JFormattedTextField(mk);
			ffieldCep.setBounds(435, 115, 75, 25);
			add(ffieldCep);
		} catch (Exception e) {
		}

		labelCidade = new JLabel("Cidade*:");
		labelCidade.setBounds(new Rectangle(400, 80, 80, 25));
		content.add(labelCidade);

		fieldCidade = new JTextField();
		fieldCidade.setBounds(new Rectangle(455, 80, 230, 25));
		content.add(fieldCidade, null);

		labelUf = new JLabel("UF*:");
		labelUf.setBounds(new Rectangle(695, 80, 25, 25));
		content.add(labelUf);

		comboUf = new JComboBox<String>();
		comboUf.addItem("AC");
		comboUf.addItem("AL");
		comboUf.addItem("AP");
		comboUf.addItem("AM");
		comboUf.addItem("BA");
		comboUf.addItem("CE");
		comboUf.addItem("DF");
		comboUf.addItem("ES");
		comboUf.addItem("GO");
		comboUf.addItem("MA");
		comboUf.addItem("MT");
		comboUf.addItem("MS");
		comboUf.addItem("MG");
		comboUf.addItem("PR");
		comboUf.addItem("PB");
		comboUf.addItem("PA");
		comboUf.addItem("PE");
		comboUf.addItem("PI");
		comboUf.addItem("RJ");
		comboUf.addItem("RN");
		comboUf.addItem("RS");
		comboUf.addItem("RO");
		comboUf.addItem("RR");
		comboUf.addItem("SC");
		comboUf.addItem("SE");
		comboUf.addItem("SP");
		comboUf.addItem("TO");
		comboUf.setBounds(730, 80, 54, 25);
		add(comboUf);
		
		labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(new Rectangle(205, 115, 90, 25));
		content.add(labelTelefone);

		try {
			MaskFormatter mk = new MaskFormatter("(##) ####-####");
			mk.setPlaceholderCharacter('_');
			ffieldTelefone = new JFormattedTextField(mk);
			ffieldTelefone.setBounds(275, 115, 95, 25);
			add(ffieldTelefone);
		} catch (Exception e) {
		}
		
		labelCpf = new JLabel("CPF*:");
		labelCpf.setBounds(new Rectangle(20, 115, 130, 25));
		content.add(labelCpf);
		
		try {
			MaskFormatter mk = new MaskFormatter("###.###.###-##");
			mk.setPlaceholderCharacter('_');
			ffieldCpf = new JFormattedTextField(mk);
			ffieldCpf.setBounds(70, 115, 95, 25);
			add(ffieldCpf);
		} catch (Exception e) {
		}
		
		buttonOK = new JButton("Cadastrar");
		buttonOK.setBounds(new Rectangle(220, 220, 100, 25));
		content.add(buttonOK, null);
		buttonOK.setActionCommand("Cadastrar");
		buttonOK.addActionListener(this);

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(new Rectangle(460, 220, 100, 25));
		content.add(buttonVoltar, null);
		buttonVoltar.setActionCommand("Voltar");
		buttonVoltar.addActionListener(this);

		setSize(830, 310);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
