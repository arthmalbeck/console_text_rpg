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
import javax.swing.JTable;

public class TelaCreditos extends JFrame{

public static final Dimension TAMANHO = new Dimension(550,300);
	
	private JPanel painelPrincipal;
	private JPanel painelMBotton;
	private JLabel lblText;
	private JButton btnOk;
	private JLabel lblIcone;
	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;

	Object [][] dados = {
        {"Arthur Malmann Becker", "arthmalbeck@gmail.com"},
        {"Lucas Abner Leal Silva", "lucasabner98@outlook.com "},
	};
     
	String [] colunas = {"Nome", "Email"}; 
	
	
	public TelaCreditos() {
		super ("Contatos");
		
		//Mudando o icone da aplicacao
		ImageIcon imgLogin = new ImageIcon("assets\\icone2.png");
		setIconImage(imgLogin.getImage());
		lblIcone = new JLabel(imgLogin); 
		
		setTitle("A Montanha Sagrada");
		setSize(TAMANHO);
		painelPrincipal = new JPanel();
		setContentPane(painelPrincipal);
		painelPrincipal.setBackground(Color.decode("#BAAC87"));
		
		painelPrincipal.setLayout(new BorderLayout());
		
		//add img
		JPanel jpImg = new JPanel();
		jpImg.add(lblIcone);
		jpImg.setBackground(null);
		painelPrincipal.add(jpImg,BorderLayout.NORTH);
		
		//label
		lblText = new JLabel("Desenvolvedores!");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblText.setSize(500,20);
		lblText.setLocation(90, 30);
		jpImg.add(lblText,BorderLayout.CENTER);
		
		painelFundo = new JPanel();
	    painelFundo.setLayout(new GridLayout(1, 1));
	    tabela = new JTable(dados, colunas);
	    barraRolagem = new JScrollPane(tabela);
	    painelFundo.add(barraRolagem); 
	    painelPrincipal.add(painelFundo,BorderLayout.CENTER);
	    
	  	btnOk = new JButton("Voltar");
	  	btnOk.setLocation(250, 0);
	  	btnOk.setSize(100,20);
//	  	btnOk.setBackground(Color.decode("#20B2AA"));
	  	btnOk.addActionListener(  new ActionListener() {
	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			TelaCreditos.this.setVisible(false);
	  			TelaCreditos.this.dispose();
	  		}}
	  	);
	    JLabel lblUniversidade = new JLabel("Engenharia de Software - UNIPAMPA");
	    painelMBotton = new JPanel();
	    painelMBotton.setLayout(new FlowLayout());
	    painelMBotton.add(btnOk);
	    painelMBotton.add(lblUniversidade);
	    painelMBotton.setBackground(null);
	    painelMBotton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelPrincipal.add(painelMBotton, BorderLayout.SOUTH);

	}
	
	public static void main(String args[]) {
		TelaCreditos frame = new TelaCreditos();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}	
}

