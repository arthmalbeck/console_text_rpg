package item;

public class Consumivel extends Item{
	private int qntAumento;
	
	public static Item pegarOvoGrande() {
		Consumivel ovoGrande = new Consumivel();
		ovoGrande.setNome("Ovo Grande");
		ovoGrande.setQntAumento(5);

		return ovoGrande;
	}
	
	public static Item pegarPocaoMagica() {
		Consumivel pocaoMagica = new Consumivel();
		pocaoMagica.setNome("Poção Mágica");
		pocaoMagica.setQntAumento(10);

		return pocaoMagica;
	}


	public int getQntAumento() {
		return qntAumento;
	}

	public void setQntAumento(int qntAumento) {
		this.qntAumento = qntAumento;
	}
	
}
