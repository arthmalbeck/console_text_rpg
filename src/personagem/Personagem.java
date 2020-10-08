package personagem;

import java.io.Serializable;

public class Personagem implements Serializable{
	private String nome = "";
	private int atk = 0;
	private int def = 0;
	private int hp = 0;
	private int maxHp = 0;
	
	public Personagem(){}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAtk() {
		return atk;
	}
	
	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	public int getDef() {
		return def;
	}
	
	public void setDef(int def) {
		this.def = def;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	
}
