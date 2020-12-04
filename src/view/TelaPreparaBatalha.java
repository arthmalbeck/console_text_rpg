package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TelaPreparaBatalha extends JFrame{

public static final Dimension TAMANHO = new Dimension(550,300);
	
	private JPanel painelPrincipal;
	private JPanel painelConteudo;
	private JLabel lblText;
	private JButton btnOk;
	private JButton btnFugir;
	private JLabel lblIcone;
	
	public TelaPreparaBatalha() {
		//Mudando o icone da aplicacao
		ImageIcon imgLogin = new ImageIcon("assets\\icone2.png");
		setIconImage(imgLogin.getImage());
		ImageIcon imgBattle = new ImageIcon("assets\\battle.png");
		lblIcone = new JLabel(imgBattle);
		
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
		painelConteudo.setLayout(null);
		
		painelPrincipal.add(painelConteudo);
		
		//add img
		JPanel jpImg = new JPanel();
		jpImg.setLayout(new FlowLayout());
		jpImg.add(lblIcone);
		jpImg.setBackground(null);
		painelPrincipal.add(jpImg,BorderLayout.NORTH);
		
		
		
		//labelNick
		lblText = new JLabel("Batalha Eminente!");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblText.setSize(500,20);
		lblText.setLocation(110, 30);	
		painelConteudo.add(lblText);
		
		
		
		
		//btnEntrar
		btnOk = new JButton("Batalhar");
		btnOk.setLocation(200, 0);
		btnOk.setSize(100,20);
//		btnOk.setBackground(Color.decode("#20B2AA"));
		btnOk.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPreparaBatalha.this.setVisible(false);
				TelaPreparaBatalha.this.dispose();
				TelaBatalha tb = new TelaBatalha();
				tb.setExtendedState(JFrame.MAXIMIZED_BOTH);
				tb.setVisible(true);
			}}
		);
		
		//btnEntrar
		btnFugir = new JButton("Tentar Fugir");
		btnFugir.setLocation(300, 0);
		btnFugir.setSize(100,20);
//				btnOk.setBackground(Color.decode("#20B2AA"));
		btnFugir.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(btnOk);
		jp.add(btnFugir);
		jp.setBackground(null);
		painelPrincipal.add(jp,BorderLayout.SOUTH);
//		painelConteudo.add(jp,BorderLayout.SOUTH);
	}
	
	public static void main(String args[]) {
		TelaPreparaBatalha frame = new TelaPreparaBatalha();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
