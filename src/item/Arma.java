package item;

import personagem.Jogador;

public class Arma extends Item {

	private int atk;

	public Arma() {
		this.setNome("Vazio");
		this.setAtk(0);
	}

	public static Item pegarEspada(Jogador jogador) {
		if (jogador.getClasse().name().equalsIgnoreCase("Guerreiro")) {
			return espadaLonga();
		} else if (jogador.getClasse().name().equalsIgnoreCase("Ceifeiro")) {
			return espadaMedia();
		} else {
			return espadaCurta();
		}
	}

	public static Item espadaCurta() {
		Arma espadaCurta = new Arma();
		espadaCurta.setNome("Espada Curta");
		espadaCurta.setAtk(1);

		return espadaCurta;
	}

	public static Item espadaMedia() {
		Arma espadaMedia = new Arma();
		espadaMedia.setNome("Foice");
		espadaMedia.setAtk(2);

		return espadaMedia ;
	}

	public static Item espadaLonga() {
		Arma espadaLonga = new Arma();
		espadaLonga.setNome("Espada Longa");
		espadaLonga.setAtk(3);

		return espadaLonga;
	}

	public int getAtk() {
		return this.atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}
}
