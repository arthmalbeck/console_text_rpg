package item;

public class Consumivel extends Item{
	private int qntAumento;
	
	public static Item pegarOvoGrande() {
		Consumivel ovoGrande = new Consumivel();
		ovoGrande.setNome("Ovo Grande");

		return ovoGrande;
	}
	
	public static Item pegarPocaoMagica() {
		Consumivel pocaoMagica = new Consumivel();
		pocaoMagica.setNome("Poção Mágica");
		pocaoMagica.setQntAumento(5);

		return pocaoMagica;
	}

	public static Item pegarCarnePassaro() {
		Consumivel carnePassaro = new Consumivel();
		carnePassaro.setNome("Carne Passaro");
		carnePassaro.setQntAumento(4);

		return carnePassaro;
	}

	public int getQntAumento() {
		return qntAumento;
	}

	public void setQntAumento(int qntAumento) {
		this.qntAumento = qntAumento;
	}
	
}
