package item;

public class Arma extends Item{
	
	private int atk;
	
	public Arma() {
		Arma nada = new Arma();
		nada.setNome("Sem Arma");
		nada.setAtk(0);
	}
	
	public static Item pegarSabreReis() {
		Arma sabreReis = new Arma();
		sabreReis.setNome("Sabre dos Reis");
		sabreReis.setAtk(50);

		return sabreReis;
	}
	
	public static Item pegarEspadaElfica() {
		Arma espadaElfica = new Arma();
		espadaElfica.setNome("Espada Sagrada dos Elfos");
		espadaElfica.setAtk(30);

		return espadaElfica;
	}
	
	public static Item pegarEspadaCurta() {
		Arma espadaCurta = new Arma();
		espadaCurta.setNome("Espada Curta");
		espadaCurta.setAtk(4);

		return espadaCurta;
	}
	
	
	public int getAtk() {
		return this.atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
}
