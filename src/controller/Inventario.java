package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import item.Arma;
import item.Armadura;
import item.Bugiganga;
import item.Consumivel;
import item.Item;
import sistema.LeitorEntradas;
import sistema.MontanhaSagrada;
import view.TelaInventario;
import view.TelaPrincipal;

public class Inventario implements ActionListener {
	private TelaInventario tela;

	public Inventario(TelaInventario tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton source = (JButton) arg0.getSource();
		if (source.getName() == "btnEnviar") {
			lerCodItem(tela, this.tela.getTxtCodigo().getText());
		}
		this.tela.setVisible(false);
		this.tela.setVisible(true);
	}

	public static void lerCodItem(TelaInventario tela, String entrada) {
		int op[] = LeitorEntradas.lerItem(entrada);
		if (op == null) {
			tela.notifyItemInvalido();
		} else if (op[0] == 9) {
			tela.notifyItemInvalido();
		} else {
			switch (MontanhaSagrada.jogador.getInventario()[op[0]][op[1]].getClass().getName()) {
			case "item.Arma":
				Arma arma = (Arma) MontanhaSagrada.jogador.getInventario()[op[0]][op[1]];
				System.out.println("Voce Equipou o item " + arma.getNome());
				MontanhaSagrada.jogador.setArma(arma);
				MontanhaSagrada.jogador.getInventario()[op[0]][op[1]] = new Item();
				MontanhaSagrada.jogador.setAtk(	MontanhaSagrada.jogador.getAtk() +  arma.getAtk());
				tela.notifyEquiparItem(arma.getNome());
				break;
			case "item.Armadura":
				Armadura armadura =  (Armadura) MontanhaSagrada.jogador.getInventario()[op[0]][op[1]];
				System.out.println("Voce Equipou o item " + armadura.getNome());
				MontanhaSagrada.jogador.setArmadura(armadura);
				MontanhaSagrada.jogador.getInventario()[op[0]][op[1]] = new Item();
				MontanhaSagrada.jogador.setDef(MontanhaSagrada.jogador.getDef() +  armadura.getDef());
				tela.notifyEquiparItem(armadura.getNome());
				break;
			case "item.Consumivel":
				Consumivel c = (Consumivel) MontanhaSagrada.jogador.getInventario()[op[0]][op[1]];
				System.out.println("Voce Utiizou o item " + c.getNome());
				MontanhaSagrada.jogador.setHp(MontanhaSagrada.jogador.getHp() + c.getQntAumento());
				MontanhaSagrada.jogador.getInventario()[op[0]][op[1]] = new Item();
				tela.notifyUsarConsumivel(c.getNome());
				break;
			case "item.Bugiganga":
				Bugiganga b = (Bugiganga) MontanhaSagrada.jogador.getInventario()[op[0]][op[1]];
				tela.notifyCartaGuilda();
				break;
			default:
				tela.notifyItemInvalido();
			}
		}
	}
}


