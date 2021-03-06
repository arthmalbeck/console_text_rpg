package personagem;

import java.io.Serializable;

public class Personagem implements Serializable{
	private String nome = "";
	private int atk = 0;
	private int def = 0;
	private int hp = 0;
	private int maxHp = 0;
	private boolean defendido;
	private String pathImagem;
	
	public Personagem(){}

	public String getNome() {
		return nome;
	}
	
	public String getPathImagem() {
		return pathImagem;
	}

	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
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
	public int sofrerDano(int dano) {
		if(hp - dano < 0) {
			hp = 0;
		}else {
			hp = hp - dano;
		}
		return dano;
		
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

	public boolean isDefendido() {
		return defendido;
	}

	public void setDefendido(boolean defendido) {
		this.defendido = defendido;
	}
	
}
