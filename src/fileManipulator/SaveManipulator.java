package fileManipulator;

import java.io.IOException;
import java.util.Scanner;

import personagem.Jogador;
import sistema.MontanhaSagrada;

public abstract class SaveManipulator {

	public static boolean salvarJogo(String nomeArq) {
		return Save.gravarArquivoBinario(MontanhaSagrada.jogador, nomeArq);
	}

	public static Jogador carregarJogo() throws IOException {
		Scanner entrada = new Scanner(System.in);
		Save.lerNomeJogosSalvos();
		System.out.print("Escreva o nome do jogo salvo que deseja continuar: ");
		String nomeArq = entrada.nextLine().toUpperCase();
		entrada.close();
		return Save.lerArquivoBinario(nomeArq);
	}

}
