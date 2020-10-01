package fileManipulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import personagem.Jogador;
import personagem.Personagem;

public class Save {
	// serialização: gravando o objetos no arquivo binário "nomeArq"
	protected static boolean gravarArquivoBinario(Jogador jogador, String nomeArq) {
		File arq = new File(nomeArq + ".dat");
		try {
			arq.delete();
			arq.createNewFile();
	

			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
			objOutput.writeObject(jogador);
			objOutput.close();
			gravarNomeArqSalvo(nomeArq);
			return true;

		} catch (IOException erro) {
			System.out.printf("Erro: %s", erro.getMessage());
			return false;
		}
	}

	// desserialização: recuperando o objeto gravados no arquivo binário "nomeArq"
	protected static Jogador lerArquivoBinario(String nomeArq) {
		Jogador jogador = null;
		try {
			File arq = new File(nomeArq);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				jogador = (Jogador) objInput.readObject();
				objInput.close();
			}else {
				System.out.println("Nome do jogo salvo incorreto ou inexistente!");
			}
		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}

		return jogador;
	}
	
	protected static void gravarNomeArqSalvo(String nomeArq) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(System.getProperty("user.dir")));
		buffWrite.append(nomeArq.toUpperCase() + "\n");
		buffWrite.close();
	}
	
	public static void lerNomeJogosSalvos() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(System.getProperty("user.dir")));
		String linha = "";
		System.out.println("Nome dos Jogos Salvos");
		while (true) {
			if (linha != null) {
				System.out.println(linha);
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}
}
