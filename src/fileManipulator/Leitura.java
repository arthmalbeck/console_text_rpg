package fileManipulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import personagem.Jogador;

public class Leitura {
	private static File arquivo;
	private static String concat = "";
	

	public static String lerDialogos(Jogador jogador, String txt) throws IOException {
		arquivo = new File("src/historia/" + txt);
		
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));
		String linha = "";
		while (true) {
			if (linha != null) {
				if (linha.startsWith("-") == true) {
					juntarFrases(jogador.getNome() + " " + linha);
				} else {
					juntarFrases(linha);
				}
			} else {
				break;
			}
			linha = reader.readLine();
		}
		reader.close();
		return concat;
	}
	
	
	public static String juntarFrases(String frase) {
		concat += frase + "\n";
		return concat;
	}
	
}
