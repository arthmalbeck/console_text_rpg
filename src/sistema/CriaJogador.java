package sistema;

import java.util.Scanner;

import personagem.Classe;
import personagem.Interacoes;
import personagem.Jogador;
import personagem.Sexo;

public class CriaJogador {

	static Scanner scanner = new Scanner(System.in);
	
	public Jogador criar() {
		Jogador j = new Jogador();
		
		j.setNome(defineNome());
		j.setSexo(defineSexo());	
		j.setClasse(defineClasse());
		j.setInteracoes(new Interacoes());
				
		return j;
	}
	
	public String defineNome() {
		System.out.print("Digite um nome para seu personagem: ");
		return scanner.next();
	}
	
	public Sexo defineSexo() {
		int op;
		do {
			System.out.println("Digite uma das opcoes abaixo para escolher um sexo:");
			System.out.println("(1) - MASCULINO   |  (2) - FEMININO");
			op = scanner.nextInt();
			
			if(op != 1 && op != 2)
				System.out.println("Opção Inválida!");
		}while(op != 1 && op != 2);
		
		if(op == 1) {
			return Sexo.MASCULINO;
		}else {
			return Sexo.FEMININO;
		}		
	}
	
	public Classe defineClasse() {
		int op;
		do {
			System.out.println("Digite uma das opcoes abaixo para escolher sua classe:");
			System.out.println("(1) - GUERREIRO   |  (2) - CEIFEIRO   |  (3) - ARQUEIRO");
			op = scanner.nextInt();
			
			if(op != 1 && op != 2 && op != 3)
				System.out.println("Opção Inválida!");
		}while(op != 1 && op != 2 && op != 3);
		
		if(op != 1) {
			return Classe.GUERREIRO;
		}else if(op != 2) {
			return Classe.CEIFEIRO;
		}else {
			return Classe.ARQUEIRO;
		}
	}
	
}
