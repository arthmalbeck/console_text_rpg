package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextPane;

import fileManipulator.Leitura;
import personagem.Jogador;



public class TelaIntroducao extends JFrame{
	
	public static final Dimension TAMANHO = UIUtil.getFullScreenSize();
	
	
	private JPanel painelPrincipal;
	private JPanel painelMenu;
	private JPanel painelHistoria;
	private JPanel painelRodape;
	private Leitura leitor;
	
	private JLabel lblIcone;
	
	InventarioButtons buttons[]=new InventarioButtons[20];
	
	private JTextPane txtPaneHistoria;
	private JButton btnProsseguir;
	private JButton btnProximo;
	
	public TelaIntroducao(Jogador jogador) throws IOException{
		
		//Mudando o icone da aplicacao
		ImageIcon imgLogin = new ImageIcon("assets\\icone2.png");
		setIconImage(imgLogin.getImage());
		
		setTitle("A Montanha Sagrada");
		setSize(TAMANHO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painelPrincipal = new JPanel();
		setContentPane(painelPrincipal);
		painelPrincipal.setBackground(Color.decode("#A79566"));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //InicioPainel Rodape
        painelRodape = new javax.swing.JPanel();
        painelRodape.setBackground(Color.decode("#BAAC87"));
        
        javax.swing.GroupLayout rodapeLayout = new javax.swing.GroupLayout(painelRodape);
        painelRodape.setLayout(rodapeLayout);
        rodapeLayout.setHorizontalGroup(rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        rodapeLayout.setVerticalGroup(rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 22, Short.MAX_VALUE));
        

		JLabel lblUniversidade = new JLabel("Engenharia de Software - UNIPAMPA - Grupo 2 RPIII 2019-01");
		lblUniversidade.setSize(500,20);
		lblUniversidade.setLocation(500,0);
		painelRodape.add(lblUniversidade);
		painelPrincipal.add(painelRodape);
        
        //Fim Painel Rodape
        
        
        //Inicio Painel Histria
        painelHistoria = new javax.swing.JPanel();
        painelHistoria.setBackground(Color.decode("#BAAC87"));
        
        javax.swing.GroupLayout historiaLayout = new javax.swing.GroupLayout(painelHistoria);
        painelHistoria.setLayout(historiaLayout);
        historiaLayout.setHorizontalGroup(historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 494, Short.MAX_VALUE));
        historiaLayout.setVerticalGroup(historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        
        ImageIcon imgIntro = new ImageIcon("assets\\intro.png");
        lblIcone = new JLabel(imgIntro);
        JPanel jpImg = new JPanel();
		jpImg.setLayout(new FlowLayout());
		jpImg.add(lblIcone);
		jpImg.setBackground(null);
		jpImg.setLocation(400,5);
		jpImg.setSize(500, 120);
		painelHistoria.add(jpImg);
        
		leitor = new Leitura();
		String introducao = leitor.lerDialogos(jogador, "introduction.txt");
        txtPaneHistoria = new JTextPane();
	  	txtPaneHistoria.setSize(800, 400);
	  	txtPaneHistoria.setLocation(285, 150);
	  	txtPaneHistoria.setFont(new Font("Tahoma", Font.PLAIN, 19)); 
	  	txtPaneHistoria.setText(introducao);
	  	txtPaneHistoria.setEditable(false);
	  	painelHistoria.add(txtPaneHistoria);
        
        painelPrincipal.add(painelHistoria);
        //Fim Painel HIstria
		
		
		//Inicio Painel Menu
        painelMenu = new javax.swing.JPanel();
        painelMenu.setBackground(Color.decode("#BAAC87"));

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(painelMenu);
        painelMenu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        menuLayout.setVerticalGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 91, Short.MAX_VALUE));
        
        btnProsseguir = new JButton("Prosseguir >");
        btnProsseguir.setSize(150,50);
        btnProsseguir.setLocation(575, 22);
//		btnAnterior.setBackground(Color.decode("#F0FFFF"));
	  	btnProsseguir.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal frame = null;
				try {
					frame = new TelaPrincipal(jogador, null);
				} catch (IOException o) {
					// TODO Auto-generated catch block
					o.printStackTrace();
				}
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				setVisible(false);
				frame.setVisible(true);
			}}
		);
	  	painelMenu.add(btnProsseguir);
	
    
        painelPrincipal.add(painelMenu);
        //Fim Painel Menu
        
        
        
        //MontarPaineis
        layoutPagina();
	}
	    
	public static void main(String[] args) throws IOException{
		Jogador j = new Jogador();
		TelaIntroducao frame = new TelaIntroducao(j);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	public void layoutPagina() {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
            		
               
                
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelHistoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelHistoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
	}
	
	    
}