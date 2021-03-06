package sistema;

import java.io.IOException;
import java.util.Scanner;

import fileManipulator.Leitura;
import item.Arma;
import item.Armadura;
import item.Bugiganga;
import item.Consumivel;

public class Vilarejo {
	static Scanner entrada = new Scanner(System.in);
	private static boolean r = false;

	public static void inicio() throws InterruptedException, IOException {
//		System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "introduction.txt"));
		if(!r) {
		System.out.println("\n Voce recebeu uma carta da guilda localizada na montanha sagrada, os Orizaba \n Quando disponivel o menu de opcoes, digite 7 para abrir o inventario, depois, digite o codigo da carta para ler");
		System.out.println(MontanhaSagrada.jogador.getNome() + " - Cacetada, nao acredito que fui aprovado, "
				+ "logo agora que perdi minha arma e armadura, na noite de ontem,\nParece que minhas coisas"
				+ " n�o estao aqui,tenho que encontrar elas logo, pior que nao me lembro muito bem o que aconteceu "
				+ "ontem\n\n~Barriga Roncando~\n\nCom essa fome ainda, fica dificil lembrar de algo, talvez no celeiro eu encontre alguma coisa para"
				+ " comer\n*Durante sua jornada voce se encontrara com certos desafios, por isso, colete recursos e recupere seus itens\nPara guiar seu personagem escolha uma  "
				+ "entre as alternativas.\nLembre-se de que algumas escolhas sao irreversiveis!");
		MontanhaSagrada.jogador.adicionarItem(Bugiganga.pegarCarta(MontanhaSagrada.jogador));
		Vilarejo.casa();
		r = true;
		}
	}

	public static void casa() throws IOException, InterruptedException {
		System.out.println("\n ~Voce esta em casa~");

		boolean repeat = true;
		while(repeat) {
			System.out.print("\n (1) - Sair da Casa(Batalha Iminente)     (2) - Ir ate a varanda \n");
			System.out.print("\n Opcao: ");
			int op = LeitorEntradas.entrada();
			switch (op) {
			case 1:
				foraCasa();
				repeat = false;
				break;
			case 2:
				System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "varanda.txt"));
				break;
			case 6:
			case 7:
			default:
				LeitorEntradas.opcoesAlternativas(op);
				break;
			}
		}

	}

	public static void foraCasa() throws InterruptedException, IOException {
		boolean repeat = true;
		System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "vilarejo.txt"));
		if (!MontanhaSagrada.jogador.getInteracoes().isEspantouAbutre()) {
			MontanhaSagrada.jogador.getInteracoes().setEspantouAbutre(true);
			System.out.println(
					"~Tem um abutre na porta de sua casa, comendo um rato podre, ele estava lhe olhando de lado, salivando~");
			repeat = BatalhaConsoleTxt.iniciaBatalha(MontanhaSagrada.jogador, 1);
		}
		while (repeat) {
			System.out.println(
					"\n (1) - Ir ao Celeiro(Batalha Iminente)              (2) - Ir ao Centro da Vila             (3) - Voltar para dentro de Casa\n  ");
			System.out.print("\n Opcao: ");
			int op = LeitorEntradas.entrada();
			switch (op) {
			case 1:
				if (!MontanhaSagrada.jogador.getInteracoes().isPegarOvosCeleiro()) {
					System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "celeiro1.txt"));
					MontanhaSagrada.jogador.adicionarItem(Consumivel.pegarOvoGrande());
					MontanhaSagrada.jogador.getInteracoes().setPegarOvosCeleiro(true);
					repeat = BatalhaConsoleTxt.iniciaBatalha(MontanhaSagrada.jogador, 2);
				} else {
					System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "celeiro2.txt"));
				}
				break;
			case 2:
				centroVila();
				repeat = false;
				break;
			case 3:
				casa();
				repeat = false;
				break;
			case 7:
			case 8:
			default:
				LeitorEntradas.opcoesAlternativas(op);
				break;
			}
		}
	}

	public static void centroVila() throws InterruptedException, IOException {
		boolean repeat = true;
		
		while (repeat) {
			System.out.println(
					"\n (1) - Ir Sul(Batalha Iminente)   (2) - Ir ao leste   (3) - ir ao Oeste(Batalha Iminente)  "
							+ " (4) - ir ao Norte(Batalha Iminente)  (5) - Ir a Taberna"
							+ " (6) - Voltar pra porta de casa\n  ");
			System.out.print("\n Opcao: ");
			int op = LeitorEntradas.entrada();
			switch (op) {
			case 1:
				if (!MontanhaSagrada.jogador.getInteracoes().isConversouBilly()) {
				System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "sul.txt"));
				MontanhaSagrada.jogador.getInteracoes().setConversouBilly(true);
				repeat = BatalhaConsoleTxt.iniciaBatalha(MontanhaSagrada.jogador, 4);
			}else if(MontanhaSagrada.jogador.getInteracoes().isConversouBilly() && !MontanhaSagrada.jogador.getInteracoes().isDerrotouBilly()){
				System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "sul2.txt"));
				repeat = BatalhaConsoleTxt.iniciaBatalha(MontanhaSagrada.jogador, 4);
			}else {
				System.out.println("Estou com pressa, ja dei uma surra Billy, volto la pra bater nele denovo quando eu for aceito na Guilda Orizaba ");
			}
				break;
			case 2:
				if (!MontanhaSagrada.jogador.getInteracoes().isEncontrouBau() || MontanhaSagrada.jogador.getInteracoes().isPegouChaves()) {
					System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "leste1.txt"));
				}else {
					System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "leste2.txt"));
					MontanhaSagrada.jogador.getInteracoes().setPegouChaves(true);
				}
				break;
			case 3:
				if(!MontanhaSagrada.jogador.getInteracoes().isDerrotouAnciao()) {
					System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "oeste.txt"));
					MontanhaSagrada.jogador.adicionarItem(Consumivel.pegarPocaoMagica());
					repeat = BatalhaConsoleTxt.iniciaBatalha(MontanhaSagrada.jogador, 3);
			}else {
				System.out.println("Melhor nao ir naquele anciao loco denovo, dessa vez acho que ele ira drenar minha vida");
			}
				break;
			case 4:
				System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "norte.txt"));
				repeat = BatalhaConsoleTxt.iniciaBatalha(MontanhaSagrada.jogador, 5);
				break;
			case 5:
				if (MontanhaSagrada.jogador.getInteracoes().isDerrotouBilly() && !MontanhaSagrada.jogador.getInteracoes().isPegouChaves() ) {
					System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "taberna1.txt"));
					MontanhaSagrada.jogador.getInteracoes().setEncontrouBau(true);;
				}else if(MontanhaSagrada.jogador.getInteracoes().isDerrotouBilly() && !MontanhaSagrada.jogador.getInteracoes().isPegouItens() && MontanhaSagrada.jogador.getInteracoes().isPegouChaves() ){
					System.out.println(Leitura.lerDialogos(MontanhaSagrada.jogador, "taberna2.txt"));
					MontanhaSagrada.jogador.adicionarItem(Arma.pegarEspada(MontanhaSagrada.jogador));
					MontanhaSagrada.jogador.adicionarItem(Armadura.pegarArmadura(MontanhaSagrada.jogador));
					MontanhaSagrada.jogador.getInteracoes().setPegouItens(true);
					
				}else {
					System.out.println("Nao acho uma boa ir na taberna agora!");
				}
				break;
			case 6:
				foraCasa();
				repeat = false;
				break;
			case 7:
			case 8:
			default:
				LeitorEntradas.opcoesAlternativas(op);
				break;
			}
		}
	}

}
