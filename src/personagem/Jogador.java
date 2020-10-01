package personagem;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import sistema.Vilarejo;




public class Jogador extends Personagem implements Serializable{

//	private Inventario inventario;
	private Interacoes interacoes;
	private int alinhamento;
//	private Item armadura;
//	private Item arma;
	private Sexo sexo;
	private static String classeUltimaLocalizacao;
	private static String metodoUltimaLocalizacao;
	

	public void checkPoint() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class.forName(classeUltimaLocalizacao).getMethod(metodoUltimaLocalizacao, Jogador.class).invoke(null, this);

				System.out.println(Vilarejo.class.getName());
		for (Method i : Vilarejo.class.getDeclaredMethods()) {
			System.out.println(i.getClass().getName());
		}
		
	}

	
	public Jogador() {
//		System.out.print("Digite um nome para seu personagem: ");
//		Scanner entrada = new Scanner(System.in);
		super.setNome("Abner");
//		System.out.println("Digite uma das opcoes abaixo para escolher um sexo:");
//		System.out.println("(1) - MASCULINO");
//		System.out.println("(2) - FEMININO");
//		inventario = new Inventario();
		interacoes = new Interacoes();
//		entrada.close();
	}
	
	public Jogador(String nome, int atk, int def, int hp, int gold){
		this.setNome(nome);
		this.setAtk(atk);
		this.setDef(def);
		this.setHp(hp);
		this.setMaxHp(hp);
//		inventario = new Inventario();
		interacoes = new Interacoes();
//		this.setArma(null);
//		this.setArmadura(null);
		this.alinhamento = 0;
//		this.getInventario().setGold(gold);
	}
	

	public String getClassLocal() {
		return classeUltimaLocalizacao;
	}


	public static void setClassLocal(String classeUltimaLocalizacao) {
		Jogador.classeUltimaLocalizacao = classeUltimaLocalizacao;
	}


	public String getMethod() {
		return metodoUltimaLocalizacao;
	}


	public static void setMethod(String metodoUltimaLocalizacao) {
		Jogador.metodoUltimaLocalizacao = metodoUltimaLocalizacao;
	}
	


	public Interacoes getInteracoes() {
		return interacoes;
	}

	public void setInteracoes(Interacoes interacoes) {
		this.interacoes = interacoes;
	}

	public int getAlinhamento() {
		return alinhamento;
	}

	public void setAlinhamento(int alinhamento) {
		this.alinhamento = alinhamento;
	}
	
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
}
