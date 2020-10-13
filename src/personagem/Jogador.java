package personagem;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import item.Item;
import sistema.Vilarejo;




public class Jogador extends Personagem implements Serializable {

	private Item[][] inventario;
	private Interacoes interacoes;
	private Item armadura;
	private Item arma;
	private Sexo sexo;
	private Classe classe;
	public String classeUltimaLocalizacao;
	public String metodoUltimaLocalizacao;
	private int level;

	public void checkPoint() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Vilarejo.class.getMethod(metodoUltimaLocalizacao).invoke(null);
		
//		String array[] = new String[2];
//System.out.println(classeUltimaLocalizacao.split("$"));
//System.out.println(metodoUltimaLocalizacao);
//				System.out.println(Vilarejo.class.getName());
//		for (Method i : Vilarejo.class.getDeclaredMethods()) {
//			System.out.println(i.getClass().getName());
//		}
		
	}
	
	public Jogador() {

	}
	
	public Jogador(String nome, int atk, int def, int hp, int gold){
		this.setNome(nome);
		this.setAtk(atk);
		this.setDef(def);
		this.setHp(hp);
		this.setMaxHp(hp);
//		inventario = new Inventario();
		interacoes = new Interacoes();
		this.setArma(null);
		this.setArmadura(null);
	}
	
	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}

	public String getClassLocal() {
		return classeUltimaLocalizacao;
	}


	public void setClassLocal(String classeUltimaLocalizacao) {
		this.classeUltimaLocalizacao = classeUltimaLocalizacao;
	}


	public String getMethod() {
		return metodoUltimaLocalizacao;
	}


	public void setMethod(String metodoUltimaLocalizacao) {
		this.metodoUltimaLocalizacao = metodoUltimaLocalizacao;
	}

	public Interacoes getInteracoes() {
		return interacoes;
	}

	public void setInteracoes(Interacoes interacoes) {
		this.interacoes = interacoes;
	}
	
	public Item[][] getInventario() {
		return inventario;
	}

	public void setInventario(Item[][] inventario) {
		this.inventario = inventario;
	}

	public Item getArmadura() {
		return armadura;
	}

	public void setArmadura(Item armadura) {
		this.armadura = armadura;
	}

	public Item getArma() {
		return arma;
	}

	public void setArma(Item arma) {
		this.arma = arma;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
}
