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

public class TelaContinuar extends JFrame{

public static final Dimension TAMANHO = new Dimension(550,300);
	
	private JPanel painelPrincipal;
	private JPanel painelConteudo;
	private JPanel contentPane;
	private JLabel lblIcone;
	private JButton save1;
	private JButton save2;
	private JButton save3;
	private JButton btnVoltar;
	
	public TelaContinuar() {
		//Mudando o icone da aplicacao
		ImageIcon imgLogin = new ImageIcon("assets\\icone2.png");
		setIconImage(imgLogin.getImage());
		ImageIcon imgFlag = new ImageIcon("assets\\flag.png");
		lblIcone = new JLabel(imgFlag);
		
		setTitle("A Montanha Sagrada");
		setSize(TAMANHO);
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

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblTitListBtns = new JLabel("Jogos Salvos:");
		JPanel jpTitListBtns = new JPanel();
		lblTitListBtns.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTitListBtns.setSize(200,20);
		lblTitListBtns.setLocation(0, 0);
		jpTitListBtns.add(lblTitListBtns);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(400, 300));		
		JPanel jpListaBtns = new JPanel();
		jpListaBtns.setLayout(new GridLayout(0, 1, 5, 5));
		jpListaBtns.add(jpTitListBtns);
		//Add botoes
		
		save1 = new JButton("SAVE 1");
		save1.setLocation(250, 0);
		save1.setSize(100,20);
		save1.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}}
		);
		jpListaBtns.add(save1);
		
		save2 = new JButton("SAVE 2");
		save2.setLocation(250, 0);
		save2.setSize(100,20);
		save2.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}}
		);
		jpListaBtns.add(save2);
		
		save3 = new JButton("SAVE 3");
		save3.setLocation(250, 0);
		save3.setSize(100,20);
		save3.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}}
		);
		jpListaBtns.add(save3);	
		
		scroll.setViewportView(jpListaBtns);
		contentPane.add(scroll);
		painelConteudo.add(contentPane);
		pack();
		
		
		btnVoltar = new JButton("< Volar");
		btnVoltar.setLocation(250, 0);
		btnVoltar.setSize(100,20);
		btnVoltar.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaContinuar.this.setVisible(false);
				TelaContinuar.this.dispose();
			}}
		);
		jpListaBtns.add(btnVoltar);	
	}
	
	public static void main(String args[]) {
		TelaContinuar frame = new TelaContinuar();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
