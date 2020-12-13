package item;

import personagem.Jogador;

public class Armadura extends Item{

	private int def;
	
	public Armadura() {
		this.setNome("Vazio");
		this.setDef(0);
	}

	public static Item pegarArmadura(Jogador jogador) {
		if (jogador.getClasse().name().equalsIgnoreCase("Guerreiro")) {
			return ArmaduraduraLeve();
		} else if (jogador.getClasse().name().equalsIgnoreCase("Ceifeiro")) {
			return ArmaduraduraMedia();
		} else {
			return ArmaduraduraPesada();
		}
	}

	public static Item ArmaduraduraPesada() {
		Armadura ArmaduraduraPesada = new Armadura();
		ArmaduraduraPesada.setNome("Armadura Pesada");
		ArmaduraduraPesada.setDef(3);

		return ArmaduraduraPesada;
	}

	public static Item ArmaduraduraMedia() {
		Armadura ArmaduraduraMedia = new Armadura();
		ArmaduraduraMedia.setNome("Armadura Media");
		ArmaduraduraMedia.setDef(2);

		return ArmaduraduraMedia ;
	}

	public static Item ArmaduraduraLeve() {
		Armadura ArmaduraduraLeve = new Armadura();
		ArmaduraduraLeve.setNome("Armadura Leve");
		ArmaduraduraLeve.setDef(1);

		return ArmaduraduraLeve;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
}
