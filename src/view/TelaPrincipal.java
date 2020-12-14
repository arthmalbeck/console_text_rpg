package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.VilarejoController;
import fileManipulator.Leitura;
import item.Item;
import personagem.Jogador;
import personagem.Sexo;
import sistema.MontanhaSagrada;

public class TelaPrincipal extends JFrame {

	public static final Dimension TAMANHO = UIUtil.getFullScreenSize();

	private Leitura leitor;
	private JPanel painelPrincipal;
	private JPanel painelJogador;
	private JPanel painelInventario;
	private JPanel painelMenu;
	private JPanel painelHistoria;
	private JPanel painelRodape;

	private JLabel lblIcone;

	private JLabel lblJogador;
	private JLabel lblImgJogador;
	private JLabel lblImgVidaJogador;
	private JLabel lblVidaJogador;
	private JLabel lblImgDefesaJogador;
	private JLabel lblDefesaJogador;
	private JLabel lblImgAtaqueJogador;
	private JLabel lblAtaqueJogador;
	private JLabel lblImgArmaJogador;
	private JLabel lblArmaJogador;
	private JLabel lblImgArmaduraJogador;
	private JLabel lblArmaduraJogador;
	private JLabel lblLocal;

	private JLabel lblInventario;
	private JButton btnInventario;
	private JPanel painelConteudo;
	private JPanel contentPane;
//	InventarioButtons buttons[] = new InventarioButtons[20];

	private JLabel lblCpitulo;
	private JTextPane txtPaneHistoria;
	private JButton btnOpcao1;
	private JButton btnOpcao2;
	private JButton btnOpcao3;
	private JButton btnOpcao4;
	private JButton btnOpcao5;

	private JButton btnSalvar;
	private JButton btnSair;

	public TelaPrincipal(Jogador jogador, String acao) throws IOException {

		// Mudando o icone da aplicacao
		ImageIcon imgLogin = new ImageIcon("assets\\icone2.png");
		setIconImage(imgLogin.getImage());
		lblIcone = new JLabel(imgLogin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("A Montanha Sagrada");
		setSize(TAMANHO);
		painelPrincipal = new JPanel();
		setContentPane(painelPrincipal);
		painelPrincipal.setBackground(Color.decode("#A79566"));
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Inicio Painel Jogador
		painelJogador = new javax.swing.JPanel();
		painelJogador.setBackground(Color.decode("#BAAC87"));

		javax.swing.GroupLayout jogadorLayout = new javax.swing.GroupLayout(painelJogador);
		painelJogador.setLayout(jogadorLayout);
		jogadorLayout.setHorizontalGroup(jogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		jogadorLayout.setVerticalGroup(jogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 245, Short.MAX_VALUE));

		lblJogador = new JLabel(jogador.getNome() + " (" + jogador.getClasse() + ")");
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblJogador.setSize(500, 20);
		lblJogador.setLocation(75, 30);
		painelJogador.add(lblJogador);

		// Inicio Img Jogador
		lblImgJogador = new JLabel();
		lblImgJogador.setSize(200, 300);
		lblImgJogador.setLocation(25, 75);
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
		lblImgVidaJogador.setLocation(230, 80);

		ImageIcon imgHeart = new ImageIcon("assets\\heart.png");
		imgHeart.setImage(
				imgHeart.getImage().getScaledInstance(lblImgVidaJogador.getWidth(), lblImgVidaJogador.getHeight(), 1));
		lblImgVidaJogador.setIcon(imgHeart);
		painelJogador.add(lblImgVidaJogador);

		lblVidaJogador = new JLabel(Integer.toString(jogador.getHp()) + "/" + Integer.toString(jogador.getMaxHp())); // mostrando o HP atual do jogador
		lblVidaJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVidaJogador.setSize(200, 20);
		lblVidaJogador.setLocation(295, 95);
		painelJogador.add(lblVidaJogador);
		// Fim Vida Jogador

		// Inicio Defesa Jogador
		lblImgDefesaJogador = new JLabel();
		lblImgDefesaJogador.setSize(50, 50);
		lblImgDefesaJogador.setLocation(230, 140);

		ImageIcon imgEscudo = new ImageIcon("assets\\escudo.png");
		imgEscudo.setImage(imgEscudo.getImage().getScaledInstance(lblImgDefesaJogador.getWidth(),
				lblImgDefesaJogador.getHeight(), 1));
		lblImgDefesaJogador.setIcon(imgEscudo);
		painelJogador.add(lblImgDefesaJogador);

		lblDefesaJogador = new JLabel(Integer.toString(jogador.getDef())); // mostrando a defesa atual do jogador
		lblDefesaJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDefesaJogador.setSize(200, 20);
		lblDefesaJogador.setLocation(295, 155);
		painelJogador.add(lblDefesaJogador);
		// Fim Defesa Jogador

		// Inicio Ataque Jogador
		lblImgAtaqueJogador = new JLabel();
		lblImgAtaqueJogador.setSize(50, 50);
		lblImgAtaqueJogador.setLocation(230, 200);

		ImageIcon imgAtaque = new ImageIcon("assets\\ataque2.png");
		imgAtaque.setImage(imgAtaque.getImage().getScaledInstance(lblImgAtaqueJogador.getWidth(),
				lblImgAtaqueJogador.getHeight(), 1));
		lblImgAtaqueJogador.setIcon(imgAtaque);
		painelJogador.add(lblImgAtaqueJogador);

		lblAtaqueJogador = new JLabel(Integer.toString(jogador.getAtk())); // mostrando o ataque atual do jogador
		lblAtaqueJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAtaqueJogador.setSize(200, 20);
		lblAtaqueJogador.setLocation(295, 215);
		painelJogador.add(lblAtaqueJogador);
		// Fim Ataque Jogador

		// Inicio Espada Jogador
		lblImgArmaJogador = new JLabel();
		lblImgArmaJogador.setSize(50, 50);
		lblImgArmaJogador.setLocation(230, 260);

		ImageIcon imgEspada = new ImageIcon("assets\\espada.png");
		imgEspada.setImage(
				imgEspada.getImage().getScaledInstance(lblImgArmaJogador.getWidth(), lblImgArmaJogador.getHeight(), 1));
		lblImgArmaJogador.setIcon(imgEspada);
		painelJogador.add(lblImgArmaJogador);

		lblArmaJogador = new JLabel(jogador.getArma().getNome()); // mostrando nome da arma do jogador
		lblArmaJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblArmaJogador.setSize(500, 20);
		lblArmaJogador.setLocation(295, 275);
		painelJogador.add(lblArmaJogador);
		// Fim Espada Jogador

		// Inicio Armadura Jogador
		lblImgArmaduraJogador = new JLabel();
		lblImgArmaduraJogador.setSize(50, 50);
		lblImgArmaduraJogador.setLocation(230, 320);

		ImageIcon imgArmadura = new ImageIcon("assets\\armadura.png");
		imgArmadura.setImage(imgArmadura.getImage().getScaledInstance(lblImgArmaduraJogador.getWidth(),
				lblImgArmaduraJogador.getHeight(), 1));
		lblImgArmaduraJogador.setIcon(imgArmadura);
		painelJogador.add(lblImgArmaduraJogador);

		lblArmaduraJogador = new JLabel(jogador.getArmadura().getNome()); // mostrando armadura do jogador
		lblArmaduraJogador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblArmaduraJogador.setSize(500, 20);
		lblArmaduraJogador.setLocation(295, 335);
		painelJogador.add(lblArmaduraJogador);
		// Fim Armadura Jogador

		painelPrincipal.add(painelJogador);
		// Fim Painel Jogador

		// Inicio Painel Inventario
		painelInventario = new javax.swing.JPanel();
		painelInventario.setBackground(Color.decode("#BAAC87"));

		javax.swing.GroupLayout inventarioLayout = new javax.swing.GroupLayout(painelInventario);
		painelInventario.setLayout(inventarioLayout);
		inventarioLayout.setHorizontalGroup(inventarioLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		inventarioLayout.setVerticalGroup(inventarioLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 158, Short.MAX_VALUE));

		lblInventario = new JLabel("INVENTÁRIO");
		lblInventario.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblInventario.setSize(200, 20);
		lblInventario.setLocation(145, 25);
		painelInventario.add(lblInventario);

		btnInventario = new JButton("Abrir Inventario");
		btnInventario.setLocation(70, 100);
		btnInventario.setSize(300, 40);
		btnInventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaInventario tInventario = new TelaInventario();
				tInventario.setLocationRelativeTo(null);
				tInventario.setResizable(false);
				tInventario.setVisible(true);
			}
		});
		painelInventario.add(btnInventario);

//        painelConteudo = new JPanel();
//		painelConteudo.setSize(300,300);
//		painelConteudo.setLocation(60, 55);
//		painelConteudo.setBackground(null);
//        
//        contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	
//		JScrollPane scroll = new JScrollPane();
//		scroll.setPreferredSize(new Dimension(250, 200));		
//		JPanel jpListaBtns = new JPanel();
//		jpListaBtns.setLayout(new GridLayout(4, 5, 5, 5));
//		//Add botoes
//		for(int i=0;i<20;i++){
//			buttons[i]=new InventarioButtons();
//			jpListaBtns.add(buttons[i]);
//		}
//		
//		scroll.setViewportView(jpListaBtns);
//		contentPane.add(scroll);
//		painelConteudo.add(contentPane);
//		pack();
//		painelInventario.add(painelConteudo); 
		painelPrincipal.add(painelInventario);
		// Fim Painel Inventario

		// Inicio Painel Histï¿½ria
		painelHistoria = new javax.swing.JPanel();
		painelHistoria.setBackground(Color.decode("#BAAC87"));
		
		
		lblLocal = new JLabel("Localização: LOCAL");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLocal.setSize(200, 20);
		lblLocal.setLocation(75, 30);
		painelHistoria.add(lblLocal);
		

		javax.swing.GroupLayout historiaLayout = new javax.swing.GroupLayout(painelHistoria);
		painelHistoria.setLayout(historiaLayout);
		historiaLayout.setHorizontalGroup(historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 494, Short.MAX_VALUE));
		historiaLayout.setVerticalGroup(historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));

		// Painel de Dialogos //
		leitor = new Leitura();
		String dialogo = leitor.lerDialogos(jogador, "introduction_frame.txt");
		this.refreshTextPane().setText(dialogo);
		txtPaneHistoria = new JTextPane();
		txtPaneHistoria.setSize(800, 400);
		txtPaneHistoria.setLocation(75, 80);
		txtPaneHistoria.setText(dialogo);
		txtPaneHistoria.setEditable(true);
		painelHistoria.add(txtPaneHistoria);

		MouseListener action = new VilarejoController(this, "casa");
		btnOpcao1 = new JButton("Prosseguir  >");
		btnOpcao1.setSize(160, 50);
		btnOpcao1.setLocation(75, 500);
		btnOpcao1.addMouseListener(action);
		painelHistoria.add(btnOpcao1);

		btnOpcao2 = new JButton();
		btnOpcao2.setSize(160, 50);
		btnOpcao2.setLocation(250, 500);
		btnOpcao2.setVisible(false); // comeï¿½a invisivel

		painelHistoria.add(btnOpcao2);

		btnOpcao3 = new JButton();
		btnOpcao3.setSize(160, 50);
		btnOpcao3.setLocation(425, 500);
		btnOpcao3.setVisible(false); // comeï¿½a invisivel

		painelHistoria.add(btnOpcao3);

		btnOpcao4 = new JButton();
		btnOpcao4.setSize(160, 50);
		btnOpcao4.setLocation(600, 500);
		btnOpcao4.setVisible(false); // comeï¿½a invisivel

		painelHistoria.add(btnOpcao4);

		btnOpcao5 = new JButton();
		btnOpcao5.setSize(100, 50);
		btnOpcao5.setLocation(780, 500);
		btnOpcao5.setVisible(false); // comeï¿½a invisivel

		painelHistoria.add(btnOpcao5);

		painelPrincipal.add(painelHistoria);
		// Fim Painel HIstï¿½ria

		// Inicio Painel Menu
		painelMenu = new javax.swing.JPanel();
		painelMenu.setBackground(Color.decode("#BAAC87"));

		javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(painelMenu);
		painelMenu.setLayout(menuLayout);
		menuLayout.setHorizontalGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		menuLayout.setVerticalGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
				91, Short.MAX_VALUE));

//		btnSalvar = new JButton("Salvar");
//		btnSalvar.setSize(100, 50);
//		btnSalvar.setLocation(75, 22);
////		btnSalvar.setBackground(Color.decode("#F0FFFF"));
//		btnSalvar.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//			}
//		});
//		painelMenu.add(btnSalvar);

		btnSair = new JButton("Sair");
		btnSair.setSize(100, 50);
		btnSair.setLocation(75, 22);
//		btnSair.setBackground(Color.decode("#F0FFFF"));
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		painelMenu.add(btnSair);

		painelPrincipal.add(painelMenu);
		// Fim Painel Menu

		// InicioPainel Rodape
		painelRodape = new javax.swing.JPanel();
		painelRodape.setBackground(Color.decode("#BAAC87"));

		javax.swing.GroupLayout rodapeLayout = new javax.swing.GroupLayout(painelRodape);
		painelRodape.setLayout(rodapeLayout);
		rodapeLayout.setHorizontalGroup(rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		rodapeLayout.setVerticalGroup(rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 22, Short.MAX_VALUE));

		JLabel lblUniversidade = new JLabel("Engenharia de Software - UNIPAMPA");
		lblUniversidade.setSize(500, 20);
		lblUniversidade.setLocation(600, 0);
		painelRodape.add(lblUniversidade);
		painelPrincipal.add(painelRodape);

		// Fim Painel Rodape

		// MontarPaineis
		layoutPagina();
	}

	public static void main(String[] args) throws IOException {
		Item arma = new Item();
		arma.setNome("Punhos");
		Item armadura = new Item();
		armadura.setNome("Blusa");
		Jogador j = new Jogador("Lucas", 10, 10, 10, 10);
		j.setSexo(personagem.Sexo.MASCULINO);
		j.setArma(arma);
		j.setArmadura(armadura);
		TelaPrincipal frame = new TelaPrincipal(j, "casa");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void escolhaCasa(Jogador jogador, String dialogo) {
		this.refreshTextPane();
		this.txtPaneHistoria.setText(dialogo);
		MouseListener opc1 = new VilarejoController(this, "varanda"); // olha pela janela
		MouseListener opc2 = new VilarejoController(this, "fora_casa"); // sai de casa
		this.btnOpcao1.addMouseListener(opc1);
		this.btnOpcao2.addMouseListener(opc2);
	}

	public void escolhaVilarejo(Jogador jogador, String dialogo) {

		this.refreshTextPane();
		this.txtPaneHistoria.setText(dialogo);
		MouseListener opc1 = new VilarejoController(this, "celeiro"); // vai para o celeiro
		MouseListener opc2 = new VilarejoController(this, "centro_vilarejo"); // vai para o centro
		MouseListener opc3 = new VilarejoController(this, "casa"); // volta para casa
		this.btnOpcao1.addMouseListener(opc1);
		this.btnOpcao2.addMouseListener(opc2);
		this.btnOpcao3.addMouseListener(opc3);
	}

	public void escolhaCentroVilarejo(Jogador jogador, String dialogo) {
		this.refreshTextPane();
		this.txtPaneHistoria.setFont(new Font("Tahoma", Font.PLAIN, 22)); 
																			
		this.txtPaneHistoria.setText(dialogo);
		MouseListener opc1 = new VilarejoController(this, "sul"); 
		MouseListener opc2 = new VilarejoController(this, "oeste"); 
		MouseListener opc3 = new VilarejoController(this, "leste"); 
		MouseListener opc4 = new VilarejoController(this, "norte"); 
		MouseListener opc5 = new VilarejoController(this, "fora_casa");
		MouseListener opc6 = new VilarejoController(this, "taberna"); // ?
		this.btnOpcao1.addMouseListener(opc1);
		this.btnOpcao2.addMouseListener(opc2);
		this.btnOpcao3.addMouseListener(opc3);
		this.btnOpcao4.addMouseListener(opc4);
		this.btnOpcao5.addMouseListener(opc5);
		//criar sexto botao
	}
	
	public int notifyConfronto(String string) {
		Object[] options = { "Batalhar", "Tentar Fugir" };
		 return JOptionPane.showOptionDialog(this, string, "Confronto Iminente", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
	}
	
	public void notifyBatalha(String string) {
		JOptionPane.showMessageDialog(this, string,"Batalha"
				, JOptionPane.INFORMATION_MESSAGE, null);
	}

	public JTextPane refreshTextPane() {
		txtPaneHistoria = new JTextPane();
		txtPaneHistoria.setSize(800, 400);
		txtPaneHistoria.setLocation(75, 80);
		txtPaneHistoria.setEditable(false);
		painelHistoria.add(txtPaneHistoria);

		return txtPaneHistoria;
	}

	public JTextPane getTxtPaneHistoria() {
		return txtPaneHistoria;
	}

	public void setTxtPaneHistoria(JTextPane txtPaneHistoria) {
		this.txtPaneHistoria = txtPaneHistoria;
	}

	public JButton getBtnOpcao1() {
		return btnOpcao1;
	}

	public void setBtnOpcao1(JButton btnOpcao1) {
		this.btnOpcao1 = btnOpcao1;
	}

	public JButton getBtnOpcao2() {
		return btnOpcao2;
	}

	public void setBtnOpcao2(JButton btnOpcao2) {
		this.btnOpcao2 = btnOpcao2;
	}

	public JButton getBtnOpcao3() {
		return btnOpcao3;
	}

	public void setBtnOpcao3(JButton btnOpcao3) {
		this.btnOpcao3 = btnOpcao3;
	}

	public JButton getBtnOpcao4() {
		return btnOpcao4;
	}

	public void setBtnOpcao4(JButton btnOpcao4) {
		this.btnOpcao4 = btnOpcao4;
	}

	public JButton getBtnOpcao5() {
		return btnOpcao5;
	}

	public void setBtnOpcao5(JButton btnOpcao5) {
		this.btnOpcao5 = btnOpcao5;
	}

	public void layoutPagina() {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(painelRodape, GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(painelJogador, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
								.addComponent(painelInventario, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(painelHistoria, GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(painelMenu, GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
										.addContainerGap()))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(painelJogador, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(painelInventario, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(painelHistoria, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(painelMenu,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(painelRodape,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		getContentPane().setLayout(layout);
	}

}
