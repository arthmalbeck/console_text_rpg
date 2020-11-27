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

public class TelaVenceu extends JFrame{

public static final Dimension TAMANHO = new Dimension(550,300);
	
	private JPanel painelPrincipal;
	private JPanel painelConteudo;
	private JLabel lblText;
	private JLabel lblImgVenceu;
	private JButton btnOk;
	private JLabel lblIcone;
	
	public TelaVenceu() {
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
		painelConteudo.setLayout(null);
		
		painelPrincipal.add(painelConteudo);
		
		//add img
		JPanel jpImg = new JPanel();
		jpImg.setLayout(new FlowLayout());
		jpImg.add(lblIcone);
		jpImg.setBackground(null);
		
		//Inicio Img
	  	lblImgVenceu = new JLabel();
	  	lblImgVenceu.setSize(500,250);
	  	lblImgVenceu.setLocation(20, 10);
	  		
	  	ImageIcon imgVenceu = new ImageIcon("assets\\win.png");
	  	imgVenceu.setImage(imgVenceu.getImage().getScaledInstance(lblImgVenceu.getWidth(), lblImgVenceu.getHeight(), 1));
	  	lblImgVenceu.setIcon(imgVenceu);
	  	painelConteudo.add(lblImgVenceu);
	  	//Fim Img
	  	
		
		//btnEntrar
		btnOk = new JButton("OK");
		btnOk.setLocation(250, 0);
		btnOk.setSize(100,20);
//		btnOk.setBackground(Color.decode("#20B2AA"));
		btnOk.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaVenceu.this.setVisible(false);
				TelaVenceu.this.dispose();
			}}
		);
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(btnOk);
		jp.setBackground(null);
		painelPrincipal.add(jp,BorderLayout.SOUTH);
	}
	
	public static void main(String args[]) {
		TelaVenceu frame = new TelaVenceu();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
