package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class TelaInicial extends JFrame{
	
	public static final Dimension TAMANHO = UIUtil.getFullScreenSize();
	
	private JPanel painelPrincipal;
	private JPanel painelMenu;
	private JPanel painelConteudo;
	private JPanel contentPane;
	
	private JButton btnNovoJogo;
	private JButton btnContinuar;
	private JButton btnComandos;
	private JButton btnCreditos;
	private JButton btnSair;
	private JLabel lblIcone;

	public TelaInicial(){
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
		painelConteudo = new JPanel();
		painelConteudo.setSize(400,400);
		painelConteudo.setLocation(0, 0);
		painelConteudo.setBackground(null);
		painelPrincipal.add(painelConteudo);
		
		//add img
		JPanel jpImg = new JPanel();
		jpImg.setLayout(new FlowLayout());
		jpImg.add(lblIcone);
		jpImg.setBackground(null);
		painelPrincipal.add(jpImg,BorderLayout.NORTH);
		
		btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.setLocation(250, 0);
		btnNovoJogo.setSize(100,20);
//		btnNovoJogo.setBackground(Color.decode("#F0FFFF"));
		btnNovoJogo.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCriaJogador tcj = new TelaCriaJogador();
				TelaInicial.this.dispose();
				tcj.setLocationRelativeTo(null);
				tcj.setResizable(false);
				tcj.setVisible(true);
			}}
		);
		
//		btnContinuar = new JButton("Continuar");
//		btnContinuar.setLocation(250, 0);
//		btnContinuar.setSize(100,20);
////		btnContinuar.setBackground(Color.decode("#F0FFFF"));
//		btnContinuar.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				TelaContinuar tcont = new TelaContinuar();
//				tcont.setLocationRelativeTo(null);
//				tcont.setResizable(false);
//				tcont.setVisible(true);
//			}}
//		);
		
		btnComandos = new JButton("Menu de Comandos");
		btnComandos.setLocation(250, 0);
		btnComandos.setSize(100,20);
//		btnComandos.setBackground(Color.decode("#F0FFFF"));
		btnComandos.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaComandos tcomand = new TelaComandos();
				tcomand.setLocationRelativeTo(null);
				tcomand.setResizable(false);
				tcomand.setVisible(true);
			}}
		);
		
		btnCreditos = new JButton("Créditos");
		btnCreditos.setLocation(250, 0);
		btnCreditos.setSize(100,20);
//		btnCreditos.setBackground(Color.decode("#F0FFFF")); 
		btnCreditos.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCreditos tcredit = new TelaCreditos();
				tcredit.setLocationRelativeTo(null);
				tcredit.setResizable(false);
				tcredit.setVisible(true);
			}}
		);
		
		btnSair = new JButton("Sair");
		btnSair.setLocation(250, 0);
		btnSair.setSize(100,20);
//		btnSair.setBackground(Color.decode("#F0FFFF"));
		btnSair.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaInicial.this.setVisible(false);
				System.exit(0);
			}}
		);
		
		JLabel lblUniversidade = new JLabel("Engenharia de Software - UNIPAMPA");
		painelMenu = new JPanel();
		painelMenu.setLayout(new FlowLayout());
		painelMenu.add(lblUniversidade);
		painelMenu.setBackground(null);
		painelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelPrincipal.add(painelMenu, BorderLayout.SOUTH);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblTitListBtns = new JLabel("A Montanha Sagrada");
		JPanel jpTitListBtns = new JPanel();
		lblTitListBtns.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTitListBtns.setSize(200,20);
		lblTitListBtns.setLocation(0, 0);
		jpTitListBtns.add(lblTitListBtns);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(400, 285));		
		JPanel jpListaBtns = new JPanel();
		jpListaBtns.setLayout(new GridLayout(0, 1, 5, 5));
		jpListaBtns.add(jpTitListBtns);
		//Add botoes
		jpListaBtns.add(btnNovoJogo);	
//		jpListaBtns.add(btnContinuar);	
		jpListaBtns.add(btnComandos);	
		jpListaBtns.add(btnCreditos);	
		jpListaBtns.add(btnSair);	
		
		scroll.setViewportView(jpListaBtns);
		contentPane.add(scroll);
		painelConteudo.add(contentPane);
		pack();
	}
	    
	public static void main(String[] args){
		TelaInicial frame = new TelaInicial();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
	    
}
