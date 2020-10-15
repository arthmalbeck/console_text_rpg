package personagem;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

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
	static Scanner scanner = new Scanner(System.in);
	
	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


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
		System.out.print("Digite um nome para seu personagem: ");
		this.setNome(scanner.next());
		this.setSexo();	
		this.setClasse(defineClasse());
		this.setInteracoes(new Interacoes());
		this.setAtk(10);
		this.setLevel(1);
		this.setDef(13);
		this.setHp(18);
		this.setMaxHp(22);
		
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
	
	public void setSexo() {
		int op;
		do {
			System.out.println("Digite uma das opcoes abaixo para escolher um sexo:");
			System.out.println("(1) - MASCULINO   |  (2) - FEMININO");
			op = scanner.nextInt();
			
			if(op != 1 && op != 2)
				System.out.println("Op��o Inv�lida!");
		}while(op != 1 && op != 2);
		
		if(op == 1) {
			sexo =  Sexo.MASCULINO;
		}else {
			sexo = Sexo.FEMININO;
		}		
	}
	
	public Classe defineClasse() {
		int op;
		do {
			System.out.println("Digite uma das opcoes abaixo para escolher sua classe:");
			System.out.println("(1) - GUERREIRO   |  (2) - CEIFEIRO   |  (3) - ARQUEIRO");
			op = scanner.nextInt();
			
			if(op != 1 && op != 2 && op != 3)
				System.out.println("Op��o Inv�lida!");
		}while(op != 1 && op != 2 && op != 3);
		
		if(op != 1) {
			return Classe.GUERREIRO;
		}else if(op != 2) {
			return Classe.CEIFEIRO;
		}else {
			return Classe.ARQUEIRO;
		}
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

	
	public Sexo getSexo() {
		return sexo;
	}

	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
}
