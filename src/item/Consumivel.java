package item;

public class Consumivel extends Item{

	private int qntAumento;
	
	public static Item pegarOvoGrande() {
		Consumivel ovoGrande = new Consumivel();
		ovoGrande.setId(1);
		ovoGrande.setNome("Ovo Grande");
		ovoGrande.setDesc("Apenas um ovo grande de galinha caipira.");
		ovoGrande.setEfeito(Efeito.valueOf("CURA_BAIXA"));

		return ovoGrande;
	}
	
	public static Item pegarPocaoMagica() {
		Consumivel pocaoMagica = new Consumivel();
		pocaoMagica.setId(9);
		pocaoMagica.setNome("Po��o M�gica");
		pocaoMagica.setDesc("Uma po��o mag�ca esquisita, com partes de animais mortos dentro");
		pocaoMagica.setQntAumento(5);

		return pocaoMagica;
	}

	public static Item pegarAmbarVermelho() {
		Consumivel ambarVermelho = new Consumivel();
		ambarVermelho.setId(11);
		ambarVermelho.setNome("�mbar Vermelho");
		ambarVermelho.setDesc("Resina f�ssil de cor avermelhada, capaz de trazer for�a para o portador.");
		ambarVermelho.setEfeito(Efeito.valueOf("AUMENTA_ATAQUE"));

		return ambarVermelho;
	}
	
	public static Item pegarAmbarAzul() {
		Consumivel ambarAzul = new Consumivel();
		ambarAzul.setId(12);
		ambarAzul.setNome("�mbar Azul");
		ambarAzul.setDesc("Resina f�ssil de cor azulada, capaz de trazer resist�ncia para o portador.");
		ambarAzul.setEfeito(Efeito.valueOf("AUMENTA_DEFESA"));
	
		return ambarAzul;
	}

	public static Item pegarAmbarVerde() {
		Consumivel ambarVerde = new Consumivel();
		ambarVerde.setId(13);
		ambarVerde.setNome("�mbar Azul");
		ambarVerde.setDesc("Resina f�ssil de cor esverdeada, capaz de trazer vitalidade para o portador.");
		ambarVerde.setEfeito(Efeito.valueOf("AUMENTA_HP"));

		return ambarVerde;
	}
	
	public static Item pegarGotaMagica() {
		Consumivel gotaMagica = new Consumivel();
		gotaMagica.setId(16);
		gotaMagica.setNome("Gota M�gica do Grande Carvalho");
		gotaMagica.setDesc("Gota repleta de energia M�gica, capaz de fortalecer seu ATAQUE.");
		gotaMagica.setEfeito(Efeito.valueOf("AUMENTA_ATAQUE"));

		return gotaMagica;
	}
	
	public static Item pegarPocaoElfica() {
		Consumivel pocaoElfica = new Consumivel();
		pocaoElfica.setId(18);
		pocaoElfica.setNome("Por��o Elfica");
		pocaoElfica.setDesc("Recupera 30 de HP");
		pocaoElfica.setEfeito(Efeito.valueOf("CURA_MEDIA"));
		pocaoElfica.setQntAumento(30);

		return pocaoElfica;
	}

	public int getQntAumento() {
		return qntAumento;
	}

	public void setQntAumento(int qntAumento) {
		this.qntAumento = qntAumento;
	}
	
}
