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

	public static boolean iniciaBatalha(Jogador j, int num) {
		jogador = j;
		numInimigo = num;
		geraOponente();
		batalha();
		if(gameOver()) {
			return false;
		}
		switch (num) {
		case 1:
			System.out.println("Urubu espantado com sucesso!");
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
			barraVida(jogador);
			barraVida(inimigo);
			if (turnoJogador) {
				if (!penalidadeJogador) {
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
				if (!penalidadeInimigo) {
					ataque(inimigo, jogador);
				}
				else {
					penalidadeInimigo = false;
				}
				turnoJogador = true;
			}
			
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
		System.out.println(x.getNome() + " - esta atacando!");
		System.out.println("Sorteando chance de o ataque acertar!");
		acertarAtaque = random(1, 20);
		System.out.println(x.getNome() + " - sorteou o numero: " + acertarAtaque);
		if (acertarAtaque > y.getDef()) {
			if (acertarAtaque == 20) {
				System.out.println(x.getNome() + " - acertou o ataque em cheio!");
				System.out.println(x.getNome() + " - causou " + y.sofrerDano(random(1, x.getAtk()) * 2) + " de dano critico!");
			}else
			System.out.println(x.getNome() + " - acertou o ataque, causando " + y.sofrerDano(random(1, x.getAtk())) + " de dano");
		}else if (acertarAtaque < y.getDef()) {
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
