package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import controller.Inventario;
import personagem.Jogador;
import sistema.MontanhaSagrada;

public class TelaInventario extends JFrame {

	public static final Dimension TAMANHO = new Dimension(550, 300);

	private JPanel painelPrincipal;
	private JPanel painelMenu;
	private JPanel painelConteudo;
	private JPanel contentPane;
	private JButton btnVoltar;
	private JLabel lblIcone;
	InventarioButtons buttons[] = new InventarioButtons[20];

	public TelaInventario() {
		// Mudando o icone da aplicacao
		ImageIcon imgLogin = new ImageIcon("assets\\icone2.png");
		setIconImage(imgLogin.getImage());
		ImageIcon inventario = new ImageIcon("assets\\inventario.png");
		lblIcone = new JLabel(inventario);

		setTitle("A Montanha Sagrada");
		setSize(TAMANHO);
		painelPrincipal = new JPanel();
		setContentPane(painelPrincipal);
		painelPrincipal.setBackground(Color.decode("#BAAC87"));
		painelPrincipal.setLayout(new BorderLayout());
		painelConteudo = new JPanel();
		painelConteudo.setSize(400, 400);
		painelConteudo.setLocation(0, 0);
		painelConteudo.setBackground(null);
		painelPrincipal.add(painelConteudo);

		// add img
		JPanel jpImg = new JPanel();
		jpImg.setLayout(new FlowLayout());
		jpImg.add(lblIcone);
		jpImg.setBackground(null);
		painelPrincipal.add(jpImg, BorderLayout.NORTH);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setLocation(250, 0);
		btnVoltar.setSize(100, 20);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaInventario.this.setVisible(false);
				TelaInventario.this.dispose();
			}
		});

		painelMenu = new JPanel();
		painelMenu.setLayout(new FlowLayout());
		painelMenu.add(btnVoltar);
		painelMenu.setBackground(null);
		painelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		painelPrincipal.add(painelMenu, BorderLayout.SOUTH);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(500, 400));
		JPanel jpListaBtns = new JPanel();
		jpListaBtns.setLayout(new GridLayout(4, 5, 5, 5));
		// Add botoes
		int cont = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[cont] = new InventarioButtons();
				buttons[cont].setName("btnItem");
				buttons[cont].setText("[" + i + "" + j + "]-" + MontanhaSagrada.jogador.getInventario()[i][j].getNome());
				buttons[cont].setEnabled(false);
				jpListaBtns.add(buttons[cont]);
				cont++;	
			}
		}

		scroll.setViewportView(jpListaBtns);
		contentPane.add(scroll);
		painelConteudo.add(contentPane);
		pack();

	}

	public static void main(String[] args) {
		MontanhaSagrada.jogador = new Jogador();
		TelaInventario frame = new TelaInventario();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
