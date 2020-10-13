package item;

public class Armadura extends Item{

	private int def;
	private int hpExtra;
	
	public static Item pegarArmaduraAntiga() {
		Armadura armaduraAntiga = new Armadura();
		armaduraAntiga.setId(2);
		armaduraAntiga.setNome("Armadura Antiga");
		armaduraAntiga.setDesc("Armadura muito velha utilizada por um guerreiro em tempos antigos de guerra.");
		armaduraAntiga.setDef(5);
		armaduraAntiga.setHpExtra(7);

		return armaduraAntiga;
	}

	public static Item pegarCasacoPele() {
		Armadura casacoPele = new Armadura();
		casacoPele.setId(3);
		casacoPele.setNome("Casaco de Pele");
		casacoPele.setDesc("Casaco de Pele novinho, pode te aquecer durante noites bem frias.");
		casacoPele.setDef(4);
		casacoPele.setHpExtra(4);

		return casacoPele;
	}
	
	public static Item pegarCasacoLa() {
		Armadura casacoPele = new Armadura();
		casacoPele.setId(8);
		casacoPele.setNome("Casaco de Lã");
		casacoPele.setDesc("Um casaco de Lã de ovelha branca das montanhas");
		casacoPele.setDef(3);
		casacoPele.setHpExtra(5);

		return casacoPele;
	}

	public static Item pegarArmaduraElfica() {
		Armadura armaduraElfica = new Armadura();
		armaduraElfica.setId(14);
		armaduraElfica.setNome("Armadura Élfica Sagrada");
		armaduraElfica.setDesc("Armadura embuida com os poderes do Grande Carvalho, usada para defender a terra Élfica em tempos de crise.");
		armaduraElfica.setDef(20);
		armaduraElfica.setHpExtra(20);

		return armaduraElfica;
	}
	
	public static Item pegarTrajeSacerdotal() {
		Armadura trajeSacerdotal = new Armadura();
		trajeSacerdotal.setId(20);
		trajeSacerdotal.setNome("Traje Sacerdotal");
		trajeSacerdotal.setDesc("Aumenta 30 HP e 10 de Defesa");
		trajeSacerdotal.setDef(10);
		trajeSacerdotal.setHpExtra(30);

		return trajeSacerdotal;
	}


	public static Item pegarVestimentaReis() {
		Armadura vestimentaReis = new Armadura();
		vestimentaReis.setId(22);
		vestimentaReis.setNome("Vestimenta dos Reis");
		vestimentaReis.setDesc("Aumenta 40 de HP e 40 de Defesa");
		vestimentaReis.setDef(40);
		vestimentaReis.setHpExtra(40);

		return vestimentaReis;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getHpExtra() {
		return hpExtra;
	}

	public void setHpExtra(int hpExtra) {
		this.hpExtra = hpExtra;
	}
	
}
