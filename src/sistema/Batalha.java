package sistema;

import java.util.Random;

import item.Consumivel;
import item.Item;
import personagem.Inimigo;
import personagem.Jogador;
import personagem.Personagem;

public abstract class Batalha {
	private static final Random random = new Random();
	private static int numInimigo;
	private static Jogador jogador;
	private static Inimigo inimigo;
	private static boolean penalidadeJogador = false;
	private static boolean penalidadeInimigo = false;

	public static boolean iniciaBatalha(Jogador j, int num) {
		jogador = j;
		numInimigo = num;
		geraOponente();
		batalha();
		penalidadeJogador = false;
		penalidadeInimigo = false;
		if (gameOver()) {
			return false;
		}
		switch (numInimigo) {
		case 1:
			System.out.println("Urubu espantado com sucesso!");
			break;
		case 10:
			System.out.println(
					"Nao quero me sujar lutando com essa coisa nojenta, vou deixar ele acabar de merendar, assim ele vai embora");
			break;
		case 2:
			System.out.println("Mulher estranha espantada com sucesso!");
			System.out.println("~Voltando para a porta de casa~");
			break;
		case 20:
			System.out.println("Jennet - Ainda bem que desistiu da ideia de lutar comigo");
			System.out.println(MontanhaSagrada.jogador.getNome()
					+ " - Nao tenho tempo para isso, mas da proxima vez que eu lhe ver por essas bandas, vai ter confusao");
			System.out.println("~Voltando para a porta de casa~");
			break;
		case 3:
			System.out.println("Anciao derrotado com sucesso!");
			System.out.println(
					"Anciao - como prometido jovem, vou curar seus ferimentos e lhe dar um porcao magica para sua jornada, venha me visitar mais vezes");
			System.out.println("~Voltando para o centro da vila~");
			MontanhaSagrada.jogador.setHp(MontanhaSagrada.jogador.getMaxHp());
			MontanhaSagrada.jogador.adicionarItem(Consumivel.pegarPocaoMagica());
			MontanhaSagrada.jogador.getInteracoes().setDerrotouAnciao(true);
			break;
		case 30:
			System.out.println("Velho louco nao quero lutar com voce agora");
			System.out.println("~Voltando para o centro da vila~");
			break;
		case 4:
			System.out.println("Billy espancado com sucesso!");
			System.out.println(
					MontanhaSagrada.jogador.getNome() + " - Me diga agora billy, aonde estao meus equipamentos");
			System.out.println(
					"Billy - Arggh!! seu verme, sorte sua que estou cansado...Nao estou com suas coisas, voce guardou elas em um bau na taberna Anel da Seperte, antes de nos enfrentarmos ontem");
			System.out.println("~Voltando para o centro da vila~");
			MontanhaSagrada.jogador.getInteracoes().setDerrotouBilly(true);
			break;
		case 40:
			System.out.println("Billy - Corra daqui verme, se eu voltar a te ver vai levar so uma na cabeca ");
			System.out.println("~Voltando para o centro da vila~");
			break;
		case 5:
			System.out.println(
					"Capitao Matsusuke - Parabens jovem, Seja muito bem vindo a Guilda mais forte da Montanha Sagrada");
			System.out.println(
					MontanhaSagrada.jogador.getNome() + " - Obrigado, vou honrar a responsabilidade que carrego!");
			System.out.println("Fim de Jogo");
			break;
		case 50:
			System.out.println(
					MontanhaSagrada.jogador.getNome() + " - Acho que ainda nao estou pronto, voltarei mais tarde");
			System.out.println("~Voltando para o centro da vila~");
			break;
		default:
			break;
		}
		System.out.println();
		return true;
	}

	public static void geraOponente() {
		switch (numInimigo) {
		case 1:
			inimigo = new Inimigo("Abutre", 12, 4, 10);
			break;
		case 2:
			inimigo = new Inimigo("Jennet", 15, 6, 12);
			break;
		case 3:
			inimigo = new Inimigo("Anciao", 17, 9, 13);
			break;
		case 4:
			inimigo = new Inimigo("Billy", 18, 11, 15);
			break;
		case 5:
			inimigo = new Inimigo("Capitao Matsusuke", 25, 11, 16);
			break;
		}
	}

	private static boolean gameOver() {
		if (jogador.getHp() <= 0) {
			System.out.println("Game Over!");
			return true;
		} else {
			return false;
		}
	}

	public static void batalha() {
		boolean turnoJogador = false;
		int opc = 0;
		int iniciativaJ = random(1, 20);
		int iniciativaI = random(1, 20);

		boolean repeat = true;
		while (repeat)
			System.out.println(
					"A batalha esta prestes a comecar, Digite (1)- para tentar fugir   (2) - Para continuar a batalha");
		opc = LeitorEntradas.entrada();
		switch (opc) {
		case 1:
			System.out.println("Sorteando valor de 1 a 20, se tirar mais que 10, voce consegue fugir");
			if (random(1, 20) > 10) {
				System.out.println("Voce conseguiu dar uma escapada da batalha");
				numInimigo += 10;
				return;
			} else {
				System.out.println("Voce nao conseguiu fugir da batalha");
				repeat = false;
			}
			break;
		case 2:
			repeat = false;
			break;
		default:
			LeitorEntradas.opcoesAlternativas(opc);
		}

		System.out.println("Sorteando um valor de iniciativa para ver quem começa a batalha");
		System.out.println("Iniciativa do Jogador: " + iniciativaJ);
		System.out.println("Iniciativa do Inimigo: " + iniciativaI);

		if (iniciativaJ >= iniciativaI) {
			turnoJogador = true;
			System.out.println("Voce comeca a batalha!");
		} else {
			System.out.println("O inimigo começa a batalha!");
		}
		while (jogador.getHp() > 0 && inimigo.getHp() > 0) {
			barraVida(jogador);
			barraVida(inimigo);
			if (turnoJogador) {
				if (!penalidadeJogador) {
					System.out.println("Digite uma das opções da batalha ");
					System.out.println("(1) Atacar |  (2) Curar ");
					opc = LeitorEntradas.entrada();
					switch (opc) {
					case 1:
						ataque(jogador, inimigo);
						turnoJogador = false;
						break;
					case 2:
						MontanhaSagrada.jogador.consumiveis();
						turnoJogador = false;
						break;
					default:
						LeitorEntradas.opcoesAlternativas(opc);
					}
				} else {
					penalidadeJogador = false;
					turnoJogador = false;
				}
			} else {
				if (!penalidadeInimigo) {
					ataque(inimigo, jogador);
				} else {
					penalidadeInimigo = false;
				}
				turnoJogador = true;
			}

		}
		System.out.println("Fim da batalha!");
		barraVida(jogador);
		barraVida(inimigo);

	}

	private static void ataque(Personagem x, Personagem y) { // X ataca, Y defende
		int dano, acertarAtaque;
		System.out.println(x.getNome() + " - esta atacando!");
		System.out.println("Sorteando chance de o ataque acertar!");
		acertarAtaque = random(1, 20);
		System.out.println(x.getNome() + " - sorteou o numero: " + acertarAtaque);
		if (acertarAtaque > y.getDef()) {
			if (acertarAtaque == 20) {
				System.out.println(x.getNome() + " - acertou o ataque em cheio!");
				System.out.println(
						x.getNome() + " - causou " + y.sofrerDano(random(1, x.getAtk()) * 2) + " de dano critico!");
			} else
				System.out.println(x.getNome() + " - acertou o ataque, causando " + y.sofrerDano(random(1, x.getAtk()))
						+ " de dano");
		} else if (acertarAtaque < y.getDef()) {
			if (acertarAtaque == 1) {
				System.out.println(x.getNome() + " - errou o ataque desastrosamente e acabou-se exaustando!");
				System.out.println(x.getNome() + " - ficara um turno sem jogar");
				if (x.getNome().equalsIgnoreCase(jogador.getNome()))
					penalidadeJogador = true;
				else
					penalidadeInimigo = true;
			} else
				System.out.println(x.getNome() + " - errou o ataque!");
		}

	}

	// Se o randomizador for usado na historia do jogo para randomizar dialogos vai
	// ter q tirar ele daqui
	public static int random(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	private static void barraVida(Personagem personagem) {
		int cont; // Vai ser interface gráfica, mas as verificações continua
		System.out.println(personagem.getNome());

		System.out.print(personagem.getHp());
		System.out.print("[");
		for (cont = 0; cont < personagem.getHp(); cont++)
			System.out.print("=");

		while (cont++ < personagem.getMaxHp())
			System.out.print(" ");
		System.out.print("]\n");
		System.out.println();
	}

}
