package personagem;



public class Inimigo extends Personagem{
	
	
	public Inimigo(){
		
	}
	
	public Inimigo(String nome, int hp, int atk, int def){
		this.setNome(nome);
		this.setAtk(atk);
		this.setDef(def);
		this.setHp(hp);
		this.setMaxHp(hp);

	}

	public void setAtributos(String nome, int hp, int atk, int def) {
		
	}


}
