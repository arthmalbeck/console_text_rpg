package sistema;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import personagem.Jogador;

public class MontanhaSagrada {
	public static Jogador jogador;
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args)
			throws InterruptedException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		menuPrincipal();
		boolean repeat = true;
		while(repeat) {
			System.out.print("\n Opcao: ");
			int opcao = LeitorEntradas.entrada();
			switch (opcao) {
			case 1:
				MontanhaSagrada.jogador = new Jogador();
				Vilarejo.inicio();
				repeat = false;
				break;
			case 2:
				MontanhaSagrada.menuComandos();
				main(args);
				repeat = false;
				break;
			case 3:
				MontanhaSagrada.creditos();
				main(args);
				repeat = false;
				break;
			default:
				System.out.println("\nEntrada Invalida!\n");
			}
		}
		
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
		System.out.print(" |          (1) Novo Jogo | (2) Menu de Comandos | (3) Creditos          |\n");
		System.out.print(" |                                                                       |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |                   Engenharia de Software - UNIPAMPA                   |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n\n");
	}

	public static void menuComandos() throws InterruptedException, IOException {
		System.out.print(" +--------------------------------------------------------------+\n");
		System.out.print(" |                Menu de opcoes ocultas do jogo                |\n");
		System.out.print(" +---------------+----------------------------------------------+\n");
		System.out.print(" |     Tecla:    |                   Acao:                      |\n");
		System.out.print(" +---------------+----------------------------------------------+\n");
		System.out.print(" |    Tecla 7   |           Abrir Menu do Jogador              |\n");
		System.out.print(" +---------------+----------------------------------------------+\n");
		System.out.print(" |    Tecla 8   |             Abrir Inventario                 |\n");
		System.out.print(" +---------------+----------------------------------------------+\n");
		System.out.print(" +---------------+----------------------------------------------+\n\n");
		LeitorEntradas.pause();
	}

	public static void creditos() throws InterruptedException, IOException {
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |                               CREDITOS                                |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |                            DESENVOLVEDORES                            |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |        Arthur Malmann Becker - arthmalbeck@gmail.com                  |\n");
		System.out.print(" |        Lucas Abner Leal Silva - lucasabner98@outlook.com              |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n");
		System.out.print(" |       Engenharia de Software - UNIPAMPA                               |\n");
		System.out.print(" +-----------------------------------------------------------------------+\n\n");
		LeitorEntradas.pause();
	}

}
