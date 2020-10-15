package personagem;

import java.io.Serializable;
import java.util.Scanner;

import item.Arma;
import item.Armadura;
import item.Bugiganga;
import item.Consumivel;
import item.Item;
import sistema.LeitorEntradas;

public class Jogador extends Personagem implements Serializable {

	private Item[][] inventario;
	private Interacoes interacoes;
	private Item armadura;
	private Item arma;
	private Sexo sexo;
	private Classe classe;
	static Scanner scanner = new Scanner(System.in);

	public Jogador() {
		this.setNome(LeitorEntradas.lerNome());
		this.setSexo(LeitorEntradas.lerSexo());
		this.setClasse(LeitorEntradas.lerClasse());
		this.setInteracoes(new Interacoes());
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
					Arma arma = (Arma) inventario[op[0]][op[1]];
					System.out.println("Voce Equipou o item" + arma.getNome());
					this.arma = inventario[op[0]][op[1]];
					inventario[op[0]][op[1]] = new Item();
					this.setAtk(getAtk() +  arma.getAtk());
					repeat = false;
					break;
				case "item.Armadura":
					Armadura armadura =  (Armadura) inventario[op[0]][op[1]];
					System.out.println("Voce Equipou o item" + armadura.getNome());
					this.armadura = armadura;
					inventario[op[0]][op[1]] = new Item();
					this.setDef(getDef() +  armadura.getDef());
					repeat = false;
					break;
				case "item.Consumivel":
					Consumivel c = (Consumivel) inventario[op[0]][op[1]];
					System.out.println("Voce Utiizou o item" + c.getNome());
					this.setHp(this.getHp() + c.getQntAumento());
					inventario[op[0]][op[1]] = new Item();
					repeat = false;
					break;
				case "item.Bugiganga":
					Bugiganga b = (Bugiganga) inventario[op[0]][op[1]];
					System.out.println(b.getDescricao());
					repeat = false;
					break;
				default:
					System.out.println("Nao contem itens neste espaco");
					repeat = true;
				}
				
			}
		} while (repeat);
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

	public void adicionarItem(Item item) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(inventario[i][j].getNome().equals("Vazio")) {
				inventario[i][j] = item;
				return;
				}
			}
		}
	}

	
	
	public void consumiveis() {
		System.out.println("Inventario");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("[" + i + "" + j + "]" + inventario[i][j].getNome() + " | ");
			}
			System.out.println();
		}
		boolean repeat = true;
		do {
			System.out.println("Digite o codigo do item CONSUMIVEL, para usa-lo, ou 9 para sair");
			int op[] = LeitorEntradas.lerItem();
			if (op == null) {
				System.out.println("Entrada Invalida!\n");
			} else if (op[0] == 9) {
				repeat = false;
			} else {
				switch (inventario[op[0]][op[1]].getClass().getName()) {
				case "item.Consumivel":
					Consumivel c = (Consumivel) inventario[op[0]][op[1]];
					System.out.println("Voce Utiizou o item" + c.getNome());
					this.setHp(this.getHp() + c.getQntAumento());
					inventario[op[0]][op[1]] = new Item();
					repeat = false;
					break;
				default:
					System.out.println("Item invalido\n");
				}
			}
		} while (repeat);
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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
		if(classe.name().equalsIgnoreCase("Guerreiro")){
			this.setAtk(12);// +3 espada
			this.setDef(10);// +1 defesa
		}else if(classe.name().equalsIgnoreCase("Ceifeiro")){
			this.setAtk(11);// +2 espada
			this.setDef(11);// +2 defesa
		}else {
			this.setAtk(11);// +1 espada
			this.setDef(12);// +3 defesa
		}
		this.setHp(20);
		this.setMaxHp(25);
		this.classe = classe;
	}

}
