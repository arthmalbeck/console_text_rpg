package item;

public class Arma extends Item{
	
	private int atk;
	
	public static Item pegarSabreReis() {
		Arma sabreReis = new Arma();
		sabreReis.setId(21);
		sabreReis.setNome("Sabre dos Reis");
		sabreReis.setDesc("Aumenta 50 de Ataque");
		sabreReis.setAtk(50);

		return sabreReis;
	}
	
	public static Item pegarEspadaElfica() {
		Arma espadaElfica = new Arma();
		espadaElfica.setId(15);
		espadaElfica.setNome("Espada Sagrada dos Elfos");
		espadaElfica.setDesc("Espada Sagrada embuida com os poderes do Grande Carvalho, leve e extremamente afiada.");
		espadaElfica.setAtk(30);

		return espadaElfica;
	}
	
	public static Item pegarEspadaCurta() {
		Arma espadaCurta = new Arma();
		espadaCurta.setId(17);
		espadaCurta.setNome("Espada Curta");
		espadaCurta.setDesc("Uma espada curta e bem afiada");
		espadaCurta.setAtk(4);

		return espadaCurta;
	}
	
	public static Item pegarLaminaAssassina() {
		Arma laminaAssasina = new Arma();
		laminaAssasina.setId(19);
		laminaAssasina.setNome("Lámina Assassina");
		laminaAssasina.setDesc("Aumenta 20 de Ataque");
		laminaAssasina.setAtk(20);

		return laminaAssasina;
	}
	
	public int getAtk() {
		return this.atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
}
