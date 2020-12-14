package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Batalha;
//import controller.BatalhaController;
//import controller.CriaJogadorController;
import personagem.Inimigo;
import personagem.Jogador;
import personagem.Sexo;

public class TelaBatalha extends JFrame {

	public static final Dimension TAMANHO = UIUtil.getFullScreenSize();

	// private Jogador jogador;
	// private Inimigo inimigo;

	private JPanel painelPrincipal;
	private JPanel painelJogador;
	private JPanel painelInimigo;
	private JPanel painelAcoes;

	private JButton btnAtacar;
	private JButton btnDefender;
	private JButton btnCurar;
	private JLabel lblIcone;

	private JLabel lblImgJogador;
	private JLabel lblImgVidaJogador;
	private JLabel lblVidaJogador;
	private JLabel lblImgDefesaJogador;
	private JLabel lblDefesaJogador;
	private JLabel lblImgAtaqueJogador;
	private JLabel lblAtaqueJogador;
	private JLabel lblImgJogadorDefendendo;
	private JLabel lblJogadorDefendendo;

	private JLabel lblImgInimigo;
	private JLabel lblImgVidaInimigo;
	private JLabel lblVidaInimigo;
	private JLabel lblImgDefesaInimigo;
	private JLabel lblDefesaInimigo;
	private JLabel lblImgAtaqueInimigo;
	private JLabel lblAtaqueInimigo;
	private JLabel lblImgInimigoDefendendo;
	private JLabel lblInimigoDefendendo;

	private JLabel lblJogador;
	private JLabel lblInimigo;
	private JLabel lblAcoes;
	private Batalha controller;

	public TelaBatalha(Jogador jogador,TelaPrincipal telaPrincipal,int numInimigo) throws ParseException {
		Inimigo inimigo = Batalha.geraOponente(numInimigo);
		controller = new Batalha(this, telaPrincipal, numInimigo);
		
		// Mudando o icone da aplicacao
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

		// Inicio Jogador
		painelJogador = new JPanel();
		painelJogador.setLayout(null);
		painelJogador.setSize(680, 460);
		painelJogador.setLocation(0, 0);
		painelJogador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelJogador.setBackground(null);
		painelPrincipal.add(painelJogador);

		lblJogador = new JLabel("JOGADOR");
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblJogador.setSize(200, 20);
		lblJogador.setLocation(300, 30);
		painelJogador.add(lblJogador);

		// Inicio Img Jogador
		lblImgJogador = new JLabel();
		lblImgJogador.setSize(200, 300);
		lblImgJogador.setLocation(40, 100);

		if (jogador.getSexo().equals(Sexo.FEMININO) == true) {
			ImageIcon imgJogador = new ImageIcon("assets\\jogador.png");
			imgJogador.setImage(
					imgJogador.getImage().getScaledInstance(lblImgJogador.getWidth(), lblImgJogador.getHeight(), 1));
			lblImgJogador.setIcon(imgJogador);
			painelJogador.add(lblImgJogador);
		} else {
			ImageIcon imgJogador = new ImageIcon("assets\\inimigo.png");
			imgJogador.setImage(
					imgJogador.getImage().getScaledInstance(lblImgJogador.getWidth(), lblImgJogador.getHeight(), 1));
			lblImgJogador.setIcon(imgJogador);
			painelJogador.add(lblImgJogador);
		}
		// Fim Img Jogador

		// Inicio Vida Jogador
		lblImgVidaJogador = new JLabel();
		lblImgVidaJogador.setSize(50, 50);
		lblImgVidaJogador.setLocation(320, 120);

		ImageIcon imgHeart = new ImageIcon("assets\\heart.png");
		imgHeart.setImage(
				imgHeart.getImage().getScaledInstance(lblImgVidaJogador.getWidth(), lblImgVidaJogador.getHeight(), 1));
		lblImgVidaJogador.setIcon(imgHeart);
		painelJogador.add(lblImgVidaJogador);

		lblVidaJogador = new JLabel(Integer.toString(jogador.getHp()));
		lblVidaJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVidaJogador.setSize(200, 20);
		lblVidaJogador.setLocation(385, 135);
		painelJogador.add(lblVidaJogador);
		// Fim Vida Jogador

		// Inicio Defesa Jogador
		lblImgDefesaJogador = new JLabel();
		lblImgDefesaJogador.setSize(50, 50);
		lblImgDefesaJogador.setLocation(320, 200);

		ImageIcon imgEscudo = new ImageIcon("assets\\escudo.png");
		imgEscudo.setImage(imgEscudo.getImage().getScaledInstance(lblImgDefesaJogador.getWidth(),
				lblImgDefesaJogador.getHeight(), 1));
		lblImgDefesaJogador.setIcon(imgEscudo);
		painelJogador.add(lblImgDefesaJogador);

		lblDefesaJogador = new JLabel(Integer.toString(jogador.getDef()));
		lblDefesaJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDefesaJogador.setSize(200, 20);
		lblDefesaJogador.setLocation(385, 215);
		painelJogador.add(lblDefesaJogador);
		// Fim Defesa Jogador

		// Inicio Ataque Jogador
		lblImgAtaqueJogador = new JLabel();
		lblImgAtaqueJogador.setSize(50, 50);
		lblImgAtaqueJogador.setLocation(320, 280);

		ImageIcon imgAtaque = new ImageIcon("assets\\ataque2.png");
		imgAtaque.setImage(imgAtaque.getImage().getScaledInstance(lblImgAtaqueJogador.getWidth(),
				lblImgAtaqueJogador.getHeight(), 1));
		lblImgAtaqueJogador.setIcon(imgAtaque);
		painelJogador.add(lblImgAtaqueJogador);

		lblAtaqueJogador = new JLabel(Integer.toString(jogador.getAtk()));
		lblAtaqueJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAtaqueJogador.setSize(200, 20);
		lblAtaqueJogador.setLocation(385, 295);
		painelJogador.add(lblAtaqueJogador);
		// Fim Ataque Jogador

		// Inicio Defendendo Jogador
		lblImgJogadorDefendendo = new JLabel();
		lblImgJogadorDefendendo.setSize(50, 50);
		lblImgJogadorDefendendo.setLocation(320, 360);

		// Fim Jogador

		// Inicio Inimigo
		painelInimigo = new JPanel();
		painelInimigo.setLayout(null);
		painelInimigo.setSize(785, 460);
		painelInimigo.setLocation(681, 0);
		painelInimigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelInimigo.setBackground(null);
		painelPrincipal.add(painelInimigo);

		lblInimigo = new JLabel("INIMIGO");
		lblInimigo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblInimigo.setSize(300, 20);
		lblInimigo.setLocation(315, 30);
		painelInimigo.add(lblInimigo);

		// Inicio Img Inimigo
		lblImgInimigo = new JLabel();
		lblImgInimigo.setSize(200, 300);
		lblImgInimigo.setLocation(40, 100);

		ImageIcon imgInimigo = new ImageIcon(inimigo.getPathImagem());
		imgInimigo.setImage(
				imgInimigo.getImage().getScaledInstance(lblImgInimigo.getWidth(), lblImgInimigo.getHeight(), 1));
		lblImgInimigo.setIcon(imgInimigo);
		painelInimigo.add(lblImgInimigo);
		// Fim Img Inimigo

		// Inicio Vida Inimigo
		lblImgVidaInimigo = new JLabel();
		lblImgVidaInimigo.setSize(50, 50);
		lblImgVidaInimigo.setLocation(320, 120);

		imgHeart.setImage(
				imgHeart.getImage().getScaledInstance(lblImgVidaInimigo.getWidth(), lblImgVidaInimigo.getHeight(), 1));
		lblImgVidaInimigo.setIcon(imgHeart);
		painelInimigo.add(lblImgVidaInimigo);

		lblVidaInimigo = new JLabel(Integer.toString(inimigo.getHp()));
		lblVidaInimigo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVidaInimigo.setSize(200, 20);
		lblVidaInimigo.setLocation(385, 135);
		painelInimigo.add(lblVidaInimigo);
		// Fim Vida Inimigo

		// Inicio Defesa Inimigo
		lblImgDefesaInimigo = new JLabel();
		lblImgDefesaInimigo.setSize(50, 50);
		lblImgDefesaInimigo.setLocation(320, 200);

		imgEscudo.setImage(imgEscudo.getImage().getScaledInstance(lblImgDefesaInimigo.getWidth(),
				lblImgDefesaInimigo.getHeight(), 1));
		lblImgDefesaInimigo.setIcon(imgEscudo);
		painelInimigo.add(lblImgDefesaInimigo);

		lblDefesaInimigo = new JLabel(Integer.toString(inimigo.getDef()));
		lblDefesaInimigo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDefesaInimigo.setSize(200, 20);
		lblDefesaInimigo.setLocation(385, 215);
		painelInimigo.add(lblDefesaInimigo);
		// Fim Defesa Inimigo

		// Inicio Defendendo Inimigo
		lblImgAtaqueInimigo = new JLabel();
		lblImgAtaqueInimigo.setSize(50, 50);
		lblImgAtaqueInimigo.setLocation(320, 280);

//	  	ImageIcon imgAtaque = new ImageIcon("assets\\ataque.png");
		imgAtaque.setImage(imgAtaque.getImage().getScaledInstance(lblImgAtaqueInimigo.getWidth(),
				lblImgAtaqueInimigo.getHeight(), 1));
		lblImgAtaqueInimigo.setIcon(imgAtaque);
		painelInimigo.add(lblImgAtaqueInimigo);

		lblAtaqueInimigo = new JLabel(Integer.toString(inimigo.getAtk()));
		lblAtaqueInimigo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAtaqueInimigo.setSize(200, 20);
		lblAtaqueInimigo.setLocation(385, 295);
		painelInimigo.add(lblAtaqueInimigo);
		// Fim Defendendo Inimigo

		// Inicio Defendendo Inimigo
		lblImgInimigoDefendendo = new JLabel();
		lblImgInimigoDefendendo.setSize(50, 50);
		lblImgInimigoDefendendo.setLocation(320, 360);

		// Fim Inimigo

		// Inicio Acoes
		painelAcoes = new JPanel();
		painelAcoes.setLayout(null);
		painelAcoes.setSize(50, 50);
		painelAcoes.setLocation(0, 250);
		painelAcoes.setBackground(null);
		painelAcoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelPrincipal.add(painelAcoes);

		lblAcoes = new JLabel("A��ES");
		lblAcoes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAcoes.setSize(200, 20);
		lblAcoes.setLocation(645, 495);
		painelAcoes.add(lblAcoes);

//		ActionListener atk = new BatalhaController(this, jogador); 
		btnAtacar = new JButton("Atacar");
		btnAtacar.setName("btnAtacar");
//		btnAtacar.addActionListener(atk);
		btnAtacar.setSize(100, 50);
		btnAtacar.setLocation(500, 570);
		painelAcoes.add(btnAtacar);

//		ActionListener curar = new BatalhaController(this, jogador); 
		btnCurar = new JButton("Inventario");
		btnCurar.setName("btnCurar");
//		btnCurar.addActionListener(curar);
		btnCurar.setSize(100, 50);
		btnCurar.setLocation(750, 570);
		painelAcoes.add(btnCurar);
		// Fim Acoes

		JLabel lblUniversidade = new JLabel("Engenharia de Software - UNIPAMPA");

		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(lblUniversidade);
		jp.setBackground(null);
		jp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelPrincipal.add(jp, BorderLayout.SOUTH);
	}

	public void notifyIniciativa(int iniciativaJogador, int iniciativaInimigo, String iniciativa) {
		JOptionPane.showMessageDialog(this,
				"Sorteando um valor de iniciativa para ver quem come�a a batalha\n" + "Iniciativa do Jogador: "
						+ iniciativaJogador + "\nIniciativa do Inimigo: " + iniciativaInimigo + "\n" + iniciativa,
				"Sorteio de Iniciativa", JOptionPane.INFORMATION_MESSAGE, null);
	}

	public void bindJogador() throws ParseException {

	}

	public void bindInimigo() throws ParseException {

	}

	public void notifyAtaque(String string) {
		JOptionPane.showMessageDialog(this,
			string, "Ataque", JOptionPane.INFORMATION_MESSAGE, null);
	}

}
