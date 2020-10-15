package item;

public class Armadura extends Item{

	private int def;
	
	public Armadura() {
		Armadura nada = new Armadura();
		nada.setNome("Sem Armadura");
		nada.setDef(0);
	}

	public static Item pegarArmaduraAntiga() {
		Armadura armaduraAntiga = new Armadura();
		armaduraAntiga.setNome("Armadura Antiga");
		armaduraAntiga.setDef(5);

		return armaduraAntiga;
	}

	public static Item pegarCasacoPele() {
		Armadura casacoPele = new Armadura();
		casacoPele.setNome("Casaco de Pele");
		casacoPele.setDef(4);

		return casacoPele;
	}
	
	public static Item pegarCasacoLa() {
		Armadura casacoPele = new Armadura();
		casacoPele.setNome("Casaco de Lã");
		casacoPele.setDef(3);

		return casacoPele;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
}
