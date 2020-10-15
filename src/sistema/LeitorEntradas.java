package sistema;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import fileManipulator.SaveManipulator;
import personagem.Classe;
import personagem.Jogador;
import personagem.Sexo;

public class LeitorEntradas {
	public static Jogador jogador;
	static Scanner entrada = new Scanner(System.in);

	public static int entrada() {
		entrada = new Scanner(System.in);
		String opcao = entrada.nextLine();

		if (opcao.matches("^[0-9]")) {
			return Integer.parseInt(opcao);
		} else {
			return -1;
		}
	}

	public static Sexo lerSexo() {
		boolean repeat = true;
		while (repeat) {
			System.out.println("Digite uma das opcoes abaixo para escolher um sexo:");
			System.out.println("(1) - MASCULINO   |  (2) - FEMININO");
			int op = entrada();
			switch (op) {
			case 1:
				return Sexo.MASCULINO;
			case 2:
				return Sexo.FEMININO;
			default:
				System.out.println("Entrada Invalida!\n");
				break;
			}
		}
		return null;
	}
	
	public static String lerNome() {
		boolean repeat = true;
		do {
			System.out.println("Escolha um nome para seu Heroi!");
			System.out.print("\n Opcao: ");
			String op = entrada.nextLine();
			System.out.println("Nome escolhido: " + op);
			System.out.println("Digite (1) - Para confirmar   (Qualquer outro caractere) - Para trocar o nome");
			int opInt = entrada();
			switch (opInt) {
			case 1:
				return op;
			case 2: 
				repeat = true;
			default:
				System.out.println("Entrada Invalida!\n");
			}
		}while(repeat);
		return null;
	}
	

	public static Classe lerClasse() {
		int op;
		boolean repeat = true;
		while(repeat) {
			System.out.println("Digite uma das opcoes abaixo para escolher sua classe:");
			System.out.println("(1) - GUERREIRO   |  (2) - CEIFEIRO   |  (3) - ARQUEIRO");
			op = entrada();
			switch (op) {
			case 1:
				return Classe.GUERREIRO;
			case 2:
				return Classe.CEIFEIRO;
			case 3: 
				return Classe.ARQUEIRO;
			default:
				System.out.println("Entrada Invalida!\n");
				break;
			}
		}
		return null;
	}
	
	public static int[] lerItem() {
		entrada = new Scanner(System.in);
		String opcao = entrada.nextLine();
		String num1 = opcao.substring(0, 1);
		String num2 = opcao.substring(1);
		int op[] = new int[2];
		if (opcao.length() == 2 && num1.matches("^[0-2]") && num2.matches("^[0-2]")) {
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			op[0] = n1;
			op[1] = n2;
			System.out.println(op[0] +"" + op[1]);
			return op;
		}else if(opcao.length() == 1 && num1.equals("9")) {
			op[0] = 9;
			return op;
		}
		System.out.println(opcao.length());
		System.out.println(num1 +" " + num2);
		return null;
	}

	public static void opcoesAlternativas(int op) {
		switch (op) {
		case 6:
//		menuJogador(jogador);
//			nome, hp, ataque(base+arma),defesa(base+armadura),
// classe, iniciativa, feitiços(as armas de mago aumenta poderes de certos feitiços),level
			break;
		case 7:
            MontanhaSagrada.jogador.listarItens();
			break;
		case 8:
			System.out.println("Escreva um nome para salvar o jogo");
			Scanner entrada = new Scanner(System.in);
			String nomeArq = entrada.nextLine();
//			entrada.close();
			if (SaveManipulator.salvarJogo(nomeArq))
				System.out.println("Jogo Salvo com sucesso!");
			else
				System.out.println("\nFalha no Salvamento!");
			break;
		default:
			System.out.println("Entrada Invalida!\n");
		}
	}

}
