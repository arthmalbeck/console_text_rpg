package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import personagem.Classe;

//import controller.CriaJogadorController;
//import model.item.Item;
//import model.personagem.Jogador;
//import model.personagem.Sexo;


public class TelaCriaJogador extends JFrame{
	
	public static final Dimension TAMANHO = UIUtil.getFullScreenSize();
	
//	private CriaJogadorController controller;
//	private Jogador jogador;
	private JPanel painelPrincipal;
	private JPanel painelFemino;
	private JPanel painelMasculino;
	private JPanel painelNome;
	
	private JLabel lblFeminino;
	private JLabel lblMasculino;
	private JLabel lblNome;
	
	private JLabel lblIcone;
	
	
	private ButtonGroup btnSexo;
	private JLabel lblImgFeminino;
	private JCheckBox cbxFeminino;
	private JCheckBox cbxMasculino;
	private JLabel lblImgMasculino;
	private JLabel lblNomeJogador;
	private JTextField txtNomeJogador;
	private JButton btnCriar;


	public TelaCriaJogador(){
		
//		jogador = new Jogador();
		
		//Mudando o icone da aplicacao
		ImageIcon imgLogin = new ImageIcon("assets\\icone2.png");
		setIconImage(imgLogin.getImage());
		lblIcone = new JLabel(imgLogin);
		
		setTitle("A Montanha Sagrada");
		setSize(TAMANHO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painelPrincipal = new JPanel();
		setContentPane(painelPrincipal);
		painelPrincipal.setBackground(Color.decode("#BAAC87"));
		
		painelPrincipal.setLayout(new BorderLayout());
		
		//Inicio Feminino
		painelFemino = new JPanel();
		painelFemino.setLayout(null);
		painelFemino.setSize(680, 460);
		painelFemino.setLocation(0, 0);
		painelFemino.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelFemino.setBackground(null);
		painelPrincipal.add(painelFemino);
		
		lblFeminino = new JLabel("Feminino");
		lblFeminino.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFeminino.setSize(200,20);
		lblFeminino.setLocation(300, 30);
		painelFemino.add(lblFeminino);
		
		//Inicio Img Feminina
		lblImgFeminino = new JLabel();
		lblImgFeminino.setSize(200,300);
		lblImgFeminino.setLocation(250, 100);
		
		ImageIcon imgJogador = new ImageIcon("assets\\jogador.png");
		imgJogador.setImage(imgJogador.getImage().getScaledInstance(lblImgFeminino.getWidth(), lblImgFeminino.getHeight(), 1));
		lblImgFeminino.setIcon(imgJogador);
		painelFemino.add(lblImgFeminino);
		//Fim Img Feminina
		
		cbxFeminino = new JCheckBox("Feminino");
		cbxFeminino.setSize(100,50);
		cbxFeminino.setBackground(null);
		cbxFeminino.setLocation(310, 400);
		painelFemino.add(cbxFeminino);
		//Fim Feminino
		
		
		//Inicio Masculino
		painelMasculino = new JPanel();
		painelMasculino.setLayout(null);
		painelMasculino.setSize(785,460);
		painelMasculino.setLocation(681, 0);
		painelMasculino.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelMasculino.setBackground(null);
	  	painelPrincipal.add(painelMasculino);
		
	  	lblMasculino = new JLabel("Masculino");
	  	lblMasculino.setFont(new Font("Tahoma", Font.PLAIN, 22));
	  	lblMasculino.setSize(300,20);
	  	lblMasculino.setLocation(315, 30);
	  	painelMasculino.add(lblMasculino);
	  	
	  	//Inicio Img Masculina
	  	lblImgMasculino = new JLabel();
	  	lblImgMasculino.setSize(200,300);
	  	lblImgMasculino.setLocation(250, 100);
	  		
	  	ImageIcon imgInimigo = new ImageIcon("assets\\inimigo.png");
	  	imgInimigo.setImage(imgInimigo.getImage().getScaledInstance(lblImgMasculino.getWidth(), lblImgMasculino.getHeight(), 1));
	  	lblImgMasculino.setIcon(imgInimigo);
	  	painelMasculino.add(lblImgMasculino);
	  	//Fim Img Masculina
	  	
	  	cbxMasculino = new JCheckBox("Masculino");
	  	cbxMasculino.setSize(100,50);
	  	cbxMasculino.setBackground(null);
	  	cbxMasculino.setLocation(310, 400);
	  	painelMasculino.add(cbxMasculino);
		//Fim Maculino
	  	
	    //Colocando os Buttons em um ButtonGroup
	  	btnSexo = new ButtonGroup();
	  	btnSexo.add(cbxMasculino);
	  	btnSexo.add(cbxFeminino);
	  	//Fim do ButtonGroup
		
		//Inicio Nome 	
	  	painelNome = new JPanel();
	  	painelNome.setLayout(null);
		painelNome.setSize(50,50);
		painelNome.setLocation(0, 250);
		painelNome.setBackground(null);
		painelNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelPrincipal.add(painelNome);
			
		lblNome = new JLabel("Nome & Classe");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNome.setSize(200,20);
		lblNome.setLocation(600, 495);
		painelNome.add(lblNome);
		
		lblNomeJogador = new JLabel("Nome:");
		lblNomeJogador.setSize(100,50);
		lblNomeJogador.setLocation(490, 530);
		painelNome.add(lblNomeJogador);
		
		txtNomeJogador = new JTextField();
		txtNomeJogador.setSize(300,30);
		txtNomeJogador.setLocation(540, 540);
		painelNome.add(txtNomeJogador);
		
		JLabel lblClasse = new JLabel("Classe:");
		lblClasse.setSize(100,50);
		lblClasse.setLocation(490, 575);
		painelNome.add(lblClasse);		
		
		JComboBox<Classe> cbxClasse = new JComboBox<>(Classe.values());
		cbxClasse.setLocation(540, 585);
		cbxClasse.setSize(300,30);
		painelNome.add(cbxClasse);
		
//		ActionListener us = new CriaJogadorController(this, jogador); 
		btnCriar = new JButton("Criar");
//		btnCriar.addActionListener(us);
		btnCriar.setSize(100,30);
		btnCriar.setLocation(630, 630);
//		btnCurar.setBackground(Color.decode("#F0FFFF"));
		
		painelNome.add(btnCriar);

		//Fim Nome
		
		JLabel lblUniversidade = new JLabel("Engenharia de Software - UNIPAMPA");
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(lblUniversidade);
		jp.setBackground(null);
		jp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelPrincipal.add(jp,BorderLayout.SOUTH);
	}
	
	
	    
	public static void main(String[] args){
		TelaCriaJogador frame = new TelaCriaJogador();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		
	}
	
	public void notifyCriacaoSucesso() {
			JOptionPane.showMessageDialog(this,"Seu personagem foi criado com sucesso!! \n \n Aperte \"Ok\" para iniciar a aventura.");
		
		
	}
	
	public void notifyPreencherCampos() {
		JOptionPane.showMessageDialog(this,"Escolha o SEXO e o NOME do seu personagem antes de prosseguir!");
	
	
}




	public JCheckBox getCbxFeminino() {
		return cbxFeminino;
	}

	public void setCbxFeminino(JCheckBox cbxFeminino) {
		this.cbxFeminino = cbxFeminino;
	}

	public JCheckBox getCbxMasculino() {
		return cbxMasculino;
	}

	public void setCbxMasculino(JCheckBox cbxMasculino) {
		this.cbxMasculino = cbxMasculino;
	}

	public JTextField getTxtNomeJogador() {
		return txtNomeJogador;
	}

	public void setTxtNomeJogador(JTextField txtNomeJogador) {
		this.txtNomeJogador = txtNomeJogador;
	}


	
	
	
	
	    
}
