package sistema;

import java.util.Random;

import personagem.Inimigo;
import personagem.Jogador;
import personagem.Personagem;

public abstract class Batalha {
	private static final int RAND_MAX = 100;
	private static final Random random = new Random();
	private static int numInimigo;
	private static Jogador jogador;
	private static Inimigo inimigo;
	private static boolean penalidadeJogador = false;
	private static boolean penalidadeInimigo = false;

//	public static void inicializa(Personagem personagem) {
//		personagem.setHp(personagem.getMaxHp());
//		personagem.setDefendido(false);
//	}

	public static boolean iniciaBatalha(Jogador j, int numInimigo) {
		jogador = j;
		jogador.setDefendido(false);
		batalha();
		if(gameOver()) {
			return false;
		}
		return true;
	}

	public static void geraOponente() {
		// Dialogo ao fim da bataha sejogador vencer ou morrer
		// Voce espantou a raposa, pena q já havia comido os ovos

		switch (numInimigo) {
		case 1:
			inimigo.setAtributos("Raposa", 12, 4, 10);
			break;
		case 2:
			break;
		case 3:

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
			if (turnoJogador) {
				if (!penalidadeJogador) {
					barraVida(jogador);
					barraVida(inimigo);
					System.out.println("Digite uma das opções da batalha ");
					System.out.println("(1) Atacar |  (2) Curar ");
					opc = MontanhaSagrada.entrada();

					switch (opc) {
					case 1:
						ataque(jogador, inimigo);
						turnoJogador = false;
						break;
					case 2:
//	                   curar();
						turnoJogador = false;
						break;
					default:
						MontanhaSagrada.opcoesAlternativas(opc);
					}
				} else {
					penalidadeJogador = false;
					turnoJogador = false;
				}
			} else {
				if (!penalidadeInimigo)
					ataque(inimigo, jogador);
				else
					penalidadeInimigo = false;
			}
			turnoJogador = true;
		}
		System.out.println("Fim da batalha!");
		barraVida(jogador);
		barraVida(inimigo);

		if (jogador.getHp() <= 0) {
//	    gameOver(                        
		} else {
//	                                                  Inimigo foi aniquilado!                         
//	        Item.dropBatalha(jogador, inimigo);
		}
	}

	private static void ataque(Personagem x, Personagem y) { // X ataca, Y defende
		int dano, acertarAtaque;
		System.out.println(x.getNome() + " esta atacando!");
		System.out.println("Sorteando chance de o ataque acertar!");
		acertarAtaque = random(1, 20);
		System.out.println(x.getNome() + " sorteou o numero: " + acertarAtaque);
		if (acertarAtaque > y.getDef())
			System.out.println(x.getNome() + " acertou o ataque, causando " + random(1, x.getAtk()) + " de dano");
		else if (acertarAtaque < y.getDef())
			System.out.println(x.getNome() + " errou o ataque!");
		else if (acertarAtaque == 1) {
			System.out.println(x.getNome() + " errou o ataque desastrosamente e acabou-se exaustando!");
			System.out.println(x.getNome() + " ficara um turno sem jogar");
			if (x.getNome().equalsIgnoreCase(jogador.getNome()))
				penalidadeJogador = true;
			else
				penalidadeInimigo = true;
		} else if (acertarAtaque == 20) {
			System.out.println(x.getNome() + " acertou o ataque em cheio!");
			System.out.println(x.getNome() + " causou " + random(1, x.getAtk()) * 2 + " de dano critico!");
		}

	}
//	public boolean curar() {
//		int opcInt = 0;
//		int escolha = 0;
//		int cont = 0;
//		int curado = 0;
//		boolean vidaCheia= false;// = verifica_hp_hs(jogador->status.hp, jogador->status.maxHp);
//		boolean repeat; // se n tiver itens aparecer q n tem itens e voltar pra op?oes de batalha
//		if (vidaCheia) {
//			// Sua barra de HP já está cheia.");
//			return false;
//		}
//		int i = 0;
//
//		if (jogador.getInventario().getNumElementos() == 0) {
//			// Você não possui itens de cura!
//			return false;
//		}
//
//		for (i = 0; i < jogador.getInventario().getNumElementos(); i++) {
//			if (jogador.getInventario().getItens().get(i).getEfeito() == Efeito.CURA_BAIXA
//					|| jogador.getInventario().getItens().get(i).getEfeito() == Efeito.CURA_MEDIA
//					|| jogador.getInventario().getItens().get(i).getEfeito() == Efeito.CURA_ALTA) {
//				// Exibe as pocoes ITEM: - QNT: - DESC
//				jogador.getInventario().getItens().get(i).getNome();
//				jogador.getInventario().getItens().get(i).getQtd();
//				jogador.getInventario().getItens().get(i).getDesc();
//
//			}
//		}
//
//		if (escolha == jogador.getInventario().getItens().get(i).getId()) {
//			int hpInicial = jogador.getHp();
//			int cura = 0; // = item_cura_hs(jogador.getInventario().getItens().get(escolha).getEfeito(),
//							// jogador.getHp(), jogador.getMaxHp()); // calcula o quanto deve curar atraves
//							// do atributo EFEITO
//			jogador.getInventario().removeQuantidadeItem(escolha, 1);
//			// curado = item_cura_hs(jogador.getHp(),jogador.getMaxHp(), cura); //
//			// notifica a cura ao jogador.
//			curado = cura + jogador.getHp();
//			if (curado >= jogador.getMaxHp()) {
//				// Voce restaurou todo o seu HP!
//				jogador.setHp(jogador.getMaxHp());
//			} else {
//				// Voce restaurou de HP!" +curado - hpInicial
//				// jogador.getHp(curado); // efetua a cura.
//			}
//		}
//		return true;
//
//		// Retornando para as opções de batalha..!
//
//	}

	// Se o randomizador for usado na historia do jogo para randomizar dialogos vai
	// ter q tirar ele daqui
	public static int random(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	private static void barraVida(Personagem personagem) {
		int cont; // Vai ser interface gráfica, mas as verificações continua
		System.out.println(personagem.getNome());
		if (personagem.isDefendido())
			System.out.println("[Defendendo]");

		System.out.println(personagem.getHp());
		for (cont = 0; cont < personagem.getHp(); cont++)
			System.out.println("=");

		while (cont++ < personagem.getMaxHp())
			System.out.println(" ");
		System.out.println("]\n");
	}

}
