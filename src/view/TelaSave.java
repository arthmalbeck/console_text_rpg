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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaSave extends JFrame{

public static final Dimension TAMANHO = new Dimension(550,300);
	
	private JPanel painelPrincipal;
	private JPanel painelConteudo;
	private JLabel lblIcone;
	private JLabel lblNomeSave;
	private JTextField txtNomeSave;
	private JButton btnCancelar;
	private JButton btnSalvar;
	
	public TelaSave() {
		//Mudando o icone da aplicacao
		ImageIcon imgLogin = new ImageIcon("assets\\icone2.png");
		setIconImage(imgLogin.getImage());
		ImageIcon imgFlag = new ImageIcon("assets\\flag.png");
		lblIcone = new JLabel(imgFlag);
		
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

		lblNomeSave = new JLabel("Nome:");
		lblNomeSave.setSize(100,50);
		lblNomeSave.setLocation(285, 565);
		painelConteudo.add(lblNomeSave);
		
		txtNomeSave = new JTextField();
		txtNomeSave.setSize(300,30);
		txtNomeSave.setLocation(327, 575);
		painelConteudo.add(txtNomeSave);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setLocation(250, 0);
		btnCancelar.setSize(100,20);
		btnCancelar.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaSave.this.setVisible(false);
				TelaSave.this.dispose();
			}}
		);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setLocation(250, 0);
		btnSalvar.setSize(100,20);
		btnSalvar.addActionListener(  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaSave.this.setVisible(false);
				TelaSave.this.dispose();
			}}
		);
	
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(btnCancelar);
		jp.add(btnSalvar);
		jp.setBackground(null);
		painelPrincipal.add(jp,BorderLayout.SOUTH);
		
	}
	
	public static void main(String args[]) {
		TelaSave frame = new TelaSave();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
