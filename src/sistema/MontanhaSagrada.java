package sistema;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import fileManipulator.SaveManipulator;
import personagem.Jogador;

public class MontanhaSagrada {
	public static Jogador jogador;
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args)
			throws InterruptedException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

//		MontanhaSagrada.limpaConsole();

		menuPrincipal();
		escolhasMenuPrincipal(args);

	}

	private static void escolhasMenuPrincipal(String[] args)
			throws InterruptedException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		boolean repeat = true;
		do {
			System.out.print("\n Opcao: ");
			int opcao = MontanhaSagrada.entrada();
			switch (opcao) {
			case 1:
//				MontanhaSagrada.limpaConsole();
				MontanhaSagrada.jogador = new Jogador();
				Vilarejo.inicio();
				repeat = false;
				break;
			case 2:
//				MontanhaSagrada.limpaConsole();
				MontanhaSagrada.jogador = SaveManipulator.carregarJogo();
				MontanhaSagrada.jogador.checkPoint();
				MontanhaSagrada.pause();
				repeat = false;
				break;
			case 3:
				MontanhaSagrada.menuComandos();
				main(args);
				repeat = false;
				break;
			case 4:
				MontanhaSagrada.creditos();
				main(args);
				repeat = false;
				break;
			default:
				System.out.println("\nEntrada Invalida!\n");
			}
		} while (repeat);
	}

	private static void menuPrincipal() {
		System.out.print(" +----------------------------------------------------------------------+\n");
		System.out.print(" |   _____                                                               |\n");
		System.out.print(" |  |     |   |\\    /|  _____        _____  _____                _____   |\n");
		System.out.print(" |  | ___ |   | \\  / | |     | |\\  |   |   |     | |\\  | |    | |     |  | \n");
		System.out.print(" |  |     |   |  \\/  | |     | | \\ |   |   | ___ | | \\ | |____| | ___ |  |\n");
		System.out.print(" |  |     |   |      | |_____| |  \\|   |   |     | |  \\| |    | |     |  |\n");
		System.out.print(" |                                                                       |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |         _______                                                       |\n");
		System.out.print(" |        |         _____   _____   ____   _____   ____    _____         |\n");
		System.out.print(" |        |______  |     | |       | ___| |     | |    \\  |     |        |\n");
		System.out.print(" |               | | ___ | |  ___  | \\    | ___ | |     | | ___ |        |\n");
		System.out.print(" |        _______| |     | |_____| |  \\   |     | |____/  |     |        |\n");
		System.out.print(" |                                                                       |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |                                                                       |\n");
		System.out.print(" | (1) Novo Jogo | (2) Continuar | (3) Menu de Comandos | (4) Creditos   |\n");
		System.out.print(" |                                                                       |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |       Engenharia de Software - UNIPAMPA - Grupo 2 RPIII 2019-01       |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n\n");
	}

	public static void limpaConsole() throws InterruptedException, IOException {
		// Limpa a tela no windows, no linux e no MacOS
		if (System.getProperty("os.name").contains("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("hi1");
		} else {
			Runtime.getRuntime().exec("clear");
			System.out.println("hi");
		}

	}

	public static int entrada() {
		Scanner entrada = new Scanner(System.in);
		String opcao = entrada.nextLine();

		if (opcao.matches("^[0-9]")) {
//            entrada.close();
			return Integer.parseInt(opcao);
		} else {
//            entrada.close();
			return -1;
		}
	}

	private static void clearBuffer(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
	}

	public static void menuComandos() throws InterruptedException, IOException {
//		MontanhaSagrada.limpaConsole();
		System.out.print(" +--------------------------------------------------------------+\n");
		System.out.print(" |                Menu de opcoes ocultas do jogo                |\n");
		System.out.print(" +---------------+----------------------------------------------+\n");
		System.out.print(" |     Tecla:    |                   Acao:                      |\n");
		System.out.print(" +---------------+----------------------------------------------+\n");
		System.out.print(" |    Tecla 6    |           Abrir Menu do Jogador              |\n");
		System.out.print(" +---------------+----------------------------------------------+\n");
		System.out.print(" |    Tecla 7    |             Abrir Inventario                 |\n");
		System.out.print(" +---------------+----------------------------------------------+\n");
		System.out.print(" |    Tecla 8    |                Salvar Jogo                   |\n");
		System.out.print(" +---------------+----------------------------------------------+\n\n");
		MontanhaSagrada.pause();
	}

	public static void creditos() throws InterruptedException, IOException {
//		MontanhaSagrada.limpaConsole();
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |                               CREDITOS                                |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |                            DESENVOLVEDORES                            |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |        Arthur Malmann Becker - arthmalbeck@gmail.com                  |\n");
		System.out.print(" |        Lucas Abner Leal Silva - lucasabner98@outlook.com              |\n");
		System.out.print(" |        Lucas Augusto Guterres Garais - lucasgarais@hotmail.com        |\n");
		System.out.print(" |        Wagner Inacio de Oliveira - wagner.inacio16@outlook.com        |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |       Engenharia de Software - UNIPAMPA - Grupo 2 RPIII 2019-01       |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n\n");
		MontanhaSagrada.pause();
	}

	public static void pause() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Pressione ENTER para continuar...");
		scanner.nextLine();
	}

	public static void opcoesAlternativas(int op) {
		switch (op) {
		case 6:
//		menuJogador(jogador);
//			nome, hp, ataque(base+arma),defesa(base+armadura),
// classe, iniciativa, feitiços(as armas de mago aumenta poderes de certos feitiços),level
			break;
		case 7:
//            inventario(jogador);
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
