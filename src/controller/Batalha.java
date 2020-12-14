package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

import item.Consumivel;
import item.Item;
import personagem.Inimigo;
import personagem.Jogador;
import personagem.Personagem;
import sistema.LeitorEntradas;
import sistema.MontanhaSagrada;
import view.TelaBatalha;
import view.TelaInventario;
import view.TelaPrincipal;

public class Batalha implements ActionListener {
	private TelaBatalha telaBatalha;
	private TelaInventario telaInventario;
	private static final Random random = new Random();
	private static Jogador jogador;
	private static Inimigo inimigo;
	private static boolean penalidadeJogador = false;
	private static boolean penalidadeInimigo = false;
	private Boolean turnoJogador;
	private TelaPrincipal telaPrincipal;
	private int numInimigo;
	
	public Batalha() {}

	public Batalha(TelaBatalha telaBatalha, TelaPrincipal telaPrincipal, int numInimigo) {
		this.numInimigo = numInimigo;
		telaPrincipal.setVisible(false);
		this.telaBatalha = telaBatalha;
		this.telaInventario = new TelaInventario();
		int iniciativaJ = random(1, 20);
		int iniciativaI = random(1, 20);

		if (iniciativaJ >= iniciativaI) {
			this.setTurnoJogador(true);
			this.telaBatalha.notifyIniciativa(iniciativaJ, iniciativaI, "Voce comeca a batalha!");
		} else {
			this.setTurnoJogador(false);
			this.telaBatalha.notifyIniciativa(iniciativaJ, iniciativaI, "O inimigo comeca a batalha!");
		}
		if (!turnoJogador) {
			ataque(telaBatalha, inimigo, jogador);
			turnoJogador = true;
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton source = (JButton) arg0.getSource();
		if (source.getName() == "btnCurar") {
			lerCodItemConsumivel(telaInventario);
			if (!penalidadeInimigo) {
				ataque(telaBatalha, inimigo, jogador);
				confereVida();
			} else {
				penalidadeInimigo = false;
			}
		}

		if (source.getName() == "btnAtacar") {
			// Jogador Ataca
			ataque(telaBatalha, jogador, inimigo);

			// Se o inimigo n estiver penalizado ele ataca
			if (!penalidadeInimigo) {
				ataque(telaBatalha, inimigo, jogador);
			} else {
				penalidadeInimigo = false;
			}

			// Se o Jogador estiver penalizado inimigo ataca denovo
			if (penalidadeJogador) {
				ataque(telaBatalha, inimigo, jogador);
				penalidadeJogador = false;
			}
		}
		this.telaBatalha.setVisible(false);
		this.telaBatalha.setVisible(true);
	}

	private void confereVida() {
		if (jogador.getHp() <= 0) {
			this.telaBatalha.setVisible(false);
			this.telaPrincipal.setVisible(true);
		}
	}

	public static void lerCodItemConsumivel(TelaInventario telaInventario) {
		String entrada = telaInventario.getTxtCodigo().getText();
		int op[] = LeitorEntradas.lerItem(entrada);
		if (op == null) {
			telaInventario.notifyItemInvalido();
		} else if (op[0] == 9) {
			telaInventario.notifyItemInvalido();
		} else {
			switch (MontanhaSagrada.jogador.getInventario()[op[0]][op[1]].getClass().getName()) {
			case "item.Arma":
			case "item.Armadura":
			case "item.Bugiganga":
				telaInventario.notifyItemInvalido();
				break;
			case "item.Consumivel":
				Consumivel c = (Consumivel) MontanhaSagrada.jogador.getInventario()[op[0]][op[1]];
				System.out.println("Voce Utiizou o item " + c.getNome());
				MontanhaSagrada.jogador.setHp(MontanhaSagrada.jogador.getHp() + c.getQntAumento());
				MontanhaSagrada.jogador.getInventario()[op[0]][op[1]] = new Item();
				telaInventario.notifyUsarConsumivel(c.getNome());
				telaInventario.setVisible(false);
				break;
			default:
				telaInventario.notifyItemInvalido();
			}
		}
	}

	public static String dialogoBatalha(int numInimigo) {
		switch (numInimigo) {
		case 1:
			return "Abutre espantado com sucesso!";
		case 10:
			return "Nao quero me sujar lutando com essa coisa nojenta,\n vou deixar ele acabar de merendar, assim ele vai embora";
		case 2:
			return "Mulher estranha espantada com sucesso!\n~Voltando para a porta de casa~";
		case 20:
			return "Jennet - Ainda bem que desistiu da ideia de lutar comigo\n" + MontanhaSagrada.jogador.getNome()
					+ " - Nao tenho tempo para isso, mas da proxima vez que eu lhe ver, vai ter confusao\n~Voltando para a porta de casa~";
		case 3:
			MontanhaSagrada.jogador.setHp(MontanhaSagrada.jogador.getMaxHp());
			MontanhaSagrada.jogador.adicionarItem(Consumivel.pegarPocaoMagica());
			MontanhaSagrada.jogador.getInteracoes().setDerrotouAnciao(true);
			return "Anciao derrotado com sucesso!\n"
					+ "Anciao - como prometido jovem, vou curar seus ferimentos e lhe dar um porcao magica(Regenera 10Hp) para sua jornada\n"
					+ "~Voltando para o centro da vila~";
		case 30:
			return "Velho louco nao quero lutar com voce agora\n" + "~Voltando para o centro da vila~";
		case 4:
			MontanhaSagrada.jogador.getInteracoes().setDerrotouBilly(true);
			return "Billy espancado com sucesso!\n" + MontanhaSagrada.jogador.getNome()
					+ " - Me diga agora billy, aonde estao meus equipamentos\n"
					+ "Billy - Arggh!! seu verme, sorte sua que estou cansado...Nao estou com suas coisas\nBilly - voce guardou elas em um bau na taberna Anel da Seperte, antes de nos enfrentarmos ontem\n"
					+ "~Voltando para o centro da vila~";
		case 40:
			return "Billy - Corra daqui verme, se eu voltar a te ver, vai levar so uma na cabeca\n"
					+ "~Voltando para o centro da vila~";
		case 5:
			return "Capitao Matsusuke - Parabens jovem, Seja muito bem vindo a Guilda mais forte da Montanha Sagrada\n"
					+ MontanhaSagrada.jogador.getNome() + " - Obrigado, vou honrar a responsabilidade que carrego!\n"
					+ "Fim de Jogo";
		case 50:
			return MontanhaSagrada.jogador.getNome()
					+ " - Acho que ainda nao estou pronto, voltarei mais tarde\n~Voltando para o centro da vila~";
		default:
			break;
		}
		return null;
	}

	public static Inimigo geraOponente(int numInimigo) {
		switch (numInimigo) {
		case 1:
			return new Inimigo("Abutre", 12, 4, 10, "assets\\urubu.png");
		case 2:
			return new Inimigo("Jennet", 13, 6, 12, "assets\\mulher2.png");
		case 3:
			return new Inimigo("Anciao", 14, 9, 13, "assets\\anciao.png");
		case 4:
			return new Inimigo("Billy", 15, 11, 15, "assets\\homem5.png");
		case 5:
			return new Inimigo("Capitao Matsusuke", 20, 12, 16, "assets\\homem1.png");
		}
		return null;
	}

	private static void ataque(TelaBatalha telaBatalha, Personagem x, Personagem y) { // X ataca, Y defende
		int acertarAtaque;
		System.out.println(x.getNome() + " - esta atacando!");
		System.out.println("Sorteando chance de o ataque acertar!");
		acertarAtaque = random(1, 20);
		System.out.println(x.getNome() + " - sorteou o numero: " + acertarAtaque);
		telaBatalha.notifyAtaque(x.getNome() + " - esta atacando!\n" + "Sorteando chance de o ataque acertar!\n"
				+ x.getNome() + " - sorteou o numero: " + acertarAtaque + "\n" + posAtaque(x, y, acertarAtaque));
	}

	private static String posAtaque(Personagem x, Personagem y, int acertarAtaque) {
		if (acertarAtaque > y.getDef()) {
			if (acertarAtaque == 20) {
				return x.getNome() + " - acertou o ataque em cheio!\n" + x.getNome() + " - causou "
						+ y.sofrerDano(random(1, x.getAtk()) * 2) + " de dano critico!";
			} else {
				return x.getNome() + " - acertou o ataque, causando " + y.sofrerDano(random(1, x.getAtk()))
						+ " de dano";
			}
		} else if (acertarAtaque < y.getDef()) {
			if (acertarAtaque == 1) {
				if (x.getNome().equalsIgnoreCase(jogador.getNome()))
					penalidadeJogador = true;
				else
					penalidadeInimigo = true;
				return x.getNome() + " - errou o ataque desastrosamente e acabou-se exaustando!\n" + x.getNome()
						+ " - ficara um turno sem jogar";
			}
		}
		return x.getNome() + " - errou o ataque!";
	}

	public boolean decisaoBatalha(int num) {
		if (num == 0) {
			int r = random(1, 20);
			this.telaPrincipal.notifyBatalha("Sorteando valor de 1 a 20, se tirar mais que 10, voce consegue fugir\n"
					+ (r > 10 ? "Voce conseguiu dar uma escapada da batalha" : "Voce nao conseguiu fugir da batalha"));
			if (r > 10) {
				numInimigo += 10;
				this.telaPrincipal.notifyBatalha(dialogoBatalha(numInimigo));
				return true;
			} else
				return false;
		}
		return true;
	}

	public static int random(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	public Boolean getTurnoJogador() {
		return turnoJogador;
	}

	public void setTurnoJogador(Boolean turnoJogador) {
		this.turnoJogador = turnoJogador;
	}

}
