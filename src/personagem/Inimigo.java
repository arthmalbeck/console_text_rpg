package personagem;



public class Inimigo extends Personagem{
	
	private Grau grau;
	
	Inimigo(){
		
	}
	
	Inimigo(String nome, int hp, int atk, int def , Grau grau){
		this.setNome(nome);
		this.setAtk(atk);
		this.setDef(def);
		this.setHp(hp);
		this.setMaxHp(hp);
		this.grau = grau;

	}


	public Grau getGrau() {
		return grau;
	}


	public void setGrau(Grau grau) {
		this.grau = grau;
	}
	
	
	

}
