package personagem;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import item.Arma;
import item.Armadura;
import item.Consumivel;
import item.Item;
import sistema.LeitorEntradas;
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

	public Jogador() {
		System.out.print("Digite um nome para seu personagem: ");
		this.setNome(LeitorEntradas.lerNome());
		this.setSexo(LeitorEntradas.lerSexo());
		this.setClasse(LeitorEntradas.lerClasse());
		this.setInteracoes(new Interacoes());
		this.setAtk(10);
		this.setLevel(1);
		this.setDef(13);
		this.setHp(18);
		this.setMaxHp(22);
		inventario = new Item[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				inventario[i][j] = new Item();
			}
		}
		armadura = new Armadura();
		arma = new Arma();
	}

	public Jogador(String nome, int atk, int def, int hp, int gold) {
		this.setNome(nome);
		this.setAtk(atk);
		this.setDef(def);
		this.setHp(hp);
		this.setMaxHp(hp);
		this.inventario = new Item[3][3];
		interacoes = new Interacoes();
	}

	public void listarItens() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("[" + i + "" + j + "]" + inventario[i][j].getNome() + " | ");
			}
			System.out.println();
		}
		add();
		System.out.println("Inventario");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("[" + i + "" + j + "]" + inventario[i][j].getNome() + " | ");
			}
			System.out.println();
		}
		boolean repeat = true;
		do {
			System.out.println("Digite o codigo do item para usa-lo, ou 9 para sair");
			int op[] = LeitorEntradas.lerItem();
			if (op == null) {
				System.out.println("Entrada Invalida!\n");
			} else if (op[0] == 9) {
				repeat = false;
			} else {
				switch (inventario[op[0]][op[1]].getClass().getName()) {
				case "item.Arma":
					this.arma = inventario[op[0]][op[1]];
					inventario[op[0]][op[1]] = new Item();
					break;
				case "item.Armadura":
					this.armadura = inventario[op[0]][op[1]];
					inventario[op[0]][op[1]] = new Item();
				default:
					Consumivel c = (Consumivel) inventario[op[0]][op[1]];
					this.setHp(this.getHp() + c.getQntAumento());
					inventario[op[0]][op[1]] = new Item();
					break;
				}
				repeat = false;
			}
		} while (repeat);
	}

	public void add() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				inventario[i][j] = Arma.pegarEspadaCurta();
			}
		}

	}

	public int getLevel() {
		return level;
	}

	public void checkPoint() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Vilarejo.class.getMethod(metodoUltimaLocalizacao).invoke(null);

//		String array[] = new String[2];
//System.out.println(classeUltimaLocalizacao.split("$"));
//System.out.println(metodoUltimaLocalizacao);
//				System.out.println(Vilarejo.class.getName());
//		for (Method i : Vilarejo.class.getDeclaredMethods()) {
//			System.out.println(i.getClass().getName());
//		}

	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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
