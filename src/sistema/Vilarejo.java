package sistema;

import java.io.IOException;
import java.util.Scanner;

import fileManipulator.Leitura;
import personagem.Jogador;

public class Vilarejo {
	

	static Scanner entrada = new Scanner(System.in);
	
	

	public static void inicio() throws InterruptedException, IOException {
		System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "introducao.txt"));
		MontanhaSagrada.pause();
		System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "sonho.txt"));
		MontanhaSagrada.pause();
		Vilarejo.casa();
	}

	public static void casa() throws InterruptedException, IOException {
		Jogador.setClassLocal(new Object(){}.getClass().getName());
		Jogador.setMethod(new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "casa.txt"));
		boolean repeat = true;
		do {
			System.out.print("\n (1) - Ir ate a janela               (2) - Sair da Casa\n");
			System.out.print("\n Opcao: ");
			int op = MontanhaSagrada.entrada();
			switch (op) {
			case 1:
				System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "janela.txt"));
				break;
			case 2:
		            vila();
				repeat = false;
				break;
			case 6:
			case 7:
			case 8:
			default:
				MontanhaSagrada.opcoesAlternativas(op);
				break;
			}
		} while (repeat);

	}

	public static void vila() throws InterruptedException, IOException {
		System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "vilarejo.txt"));
		boolean repeat = true;
		do {
			System.out.println(
					"\n (1) - Ir ao Celeiro              (2) - Ir ao Centro da Vila             (3) - Voltar para dentro de Casa\n  ");
			System.out.print("\n Opcao: ");
			int op = MontanhaSagrada.entrada();
			switch (op) {
			case 1:
//		           celeiro(MontanhaSagrada.jogador);
				break;
			case 2:
//		            centroVila(MontanhaSagrada.jogador);
				repeat = false;
				break;
			case 3:
				casa();
				break;
			case 6:
			case 7:
			case 8:
			default:
				MontanhaSagrada.opcoesAlternativas(op);
				break;
			}
		} while (repeat);
	}

}
