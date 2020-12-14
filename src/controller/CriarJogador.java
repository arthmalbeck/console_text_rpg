package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import item.Bugiganga;
import personagem.Jogador;
import sistema.MontanhaSagrada;
import view.TelaCriaJogador;
import view.TelaPrincipal;

public class CriarJogador implements ActionListener {
	private TelaCriaJogador tela;

	public CriarJogador(TelaCriaJogador tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.tela.getTxtNomeJogador().getText().isEmpty() || !this.tela.getCbxFeminino().isSelected() && !this.tela.getCbxMasculino().isSelected() ) {
			this.tela.notifyPreencherCampos();
			return;
		}
		JButton source = (JButton) arg0.getSource();
		if (source.getName() == "btnCriar") {
			MontanhaSagrada.jogador = new Jogador(this.tela.getTxtNomeJogador().getText(),
					this.tela.getBtnSexo().getSelection().toString(),
					this.tela.getCbxClasse().getSelectedItem().toString());
			MontanhaSagrada.jogador.adicionarItem(Bugiganga.pegarCarta(MontanhaSagrada.jogador));
		}
		this.tela.notifyCriacaoSucesso();
		TelaPrincipal frame = null;
		try {
			frame = new TelaPrincipal(MontanhaSagrada.jogador, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.tela.setVisible(false);
		frame.setVisible(true);
	}
}
