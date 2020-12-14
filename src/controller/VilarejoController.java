package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;

import fileManipulator.Leitura;
import item.Arma;
import item.Armadura;
import item.Consumivel;
import sistema.BatalhaConsoleTxt;
import sistema.MontanhaSagrada;
import view.TelaBatalha;
import view.TelaPrincipal;

public class VilarejoController implements MouseListener {
	private TelaPrincipal tela;
	private String local;
	private Leitura leitor;
	private String dialogo;

	public VilarejoController(TelaPrincipal tela, String local) {
		this.tela = tela;
		this.local = local;
		leitor = new Leitura();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		switch (local) {
		case "casa":
			dialogoCasa();
			break;
		case "varanda":
			dialogoVaranda();
			break;
		case "fora_casa": // Batalha
			dialogoForaDeCasa();
			break;
		case "celeiro": // Batalha
			dialogoCeleiro();
			break;
		case "centro_vilarejo":
			dialogoCentroVila();
			break;
		case "sul":
			dialogoSul(); // Batalha
			break;
		case "oeste":
			dialogoOeste(); // Batalha
			break;
		case "leste":
			dialogoLeste();
			break;
		case "norte":
			dialogoNorte(); // Batalha
			break;
		case "taberna":
			dialogoTaberna();
		default:
			break;
		}
	}

	private void dialogoTaberna() {
		if (MontanhaSagrada.jogador.getInteracoes().isDerrotouBilly()
				&& !MontanhaSagrada.jogador.getInteracoes().isPegouChaves()) {
			try {
				dialogo = Leitura.lerDialogos(MontanhaSagrada.jogador, "taberna1.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MontanhaSagrada.jogador.getInteracoes().setEncontrouBau(true);
		} else if (MontanhaSagrada.jogador.getInteracoes().isDerrotouBilly()
				&& !MontanhaSagrada.jogador.getInteracoes().isPegouItens()
				&& MontanhaSagrada.jogador.getInteracoes().isPegouChaves()) {
			try {
				dialogo = Leitura.lerDialogos(MontanhaSagrada.jogador, "taberna2.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MontanhaSagrada.jogador.adicionarItem(Arma.pegarEspada(MontanhaSagrada.jogador));
			MontanhaSagrada.jogador.adicionarItem(Armadura.pegarArmadura(MontanhaSagrada.jogador));
			MontanhaSagrada.jogador.getInteracoes().setPegouItens(true);
		} else {
			dialogo = "Nao acho uma boa ir na taberna agora!";
		}
		dialogoCentroVila();
	}

	private void dialogoNorte() {
		try {
			dialogo = Leitura.lerDialogos(MontanhaSagrada.jogador, "norte.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Batalha b = new Batalha(tela);
		if (b.decisaoBatalha(this.tela.notifyConfronto(
				"Enfrentar o velho Ancião??"))) {
			try {
				TelaBatalha tb = new TelaBatalha(tela, 3);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dialogoCentroVila();
	}

	private void dialogoLeste() {
		if (!MontanhaSagrada.jogador.getInteracoes().isEncontrouBau()
				|| MontanhaSagrada.jogador.getInteracoes().isPegouChaves()) {
			try {
				dialogo = Leitura.lerDialogos(MontanhaSagrada.jogador, "leste1.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				dialogo = Leitura.lerDialogos(MontanhaSagrada.jogador, "leste2.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MontanhaSagrada.jogador.getInteracoes().setPegouChaves(true);
		}
		dialogoCentroVila();
	}

	private void dialogoOeste() {
		if (!MontanhaSagrada.jogador.getInteracoes().isDerrotouAnciao()) {
			try {
				dialogo = Leitura.lerDialogos(MontanhaSagrada.jogador, "oeste.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MontanhaSagrada.jogador.adicionarItem(Consumivel.pegarPocaoMagica());
			Batalha b = new Batalha(tela);
			if (b.decisaoBatalha(this.tela.notifyConfronto(
					"Enfrentar o velho Ancião??"))) {
				try {
					TelaBatalha tb = new TelaBatalha(tela, 3);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			dialogo = "Melhor nao ir naquele anciao loco denovo, dessa vez acho que ele ira drenar minha vida";
		}
		dialogoCentroVila();
	}

	private void dialogoSul() {
		if (!MontanhaSagrada.jogador.getInteracoes().isConversouBilly()) {
			try {
				dialogo = Leitura.lerDialogos(MontanhaSagrada.jogador, "sul.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MontanhaSagrada.jogador.getInteracoes().setConversouBilly(true);
			Batalha b = new Batalha(tela);
			if (b.decisaoBatalha(this.tela.notifyConfronto("Brigar com Billy??"))) {
				try {
					TelaBatalha tb = new TelaBatalha(tela, 4);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (MontanhaSagrada.jogador.getInteracoes().isConversouBilly()
				&& !MontanhaSagrada.jogador.getInteracoes().isDerrotouBilly()) {
			try {
				dialogo = Leitura.lerDialogos(MontanhaSagrada.jogador, "sul2.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Batalha b = new Batalha(tela);
			if (b.decisaoBatalha(this.tela.notifyConfronto("Brigar com Billy??"))) {
				try {
					TelaBatalha tb = new TelaBatalha( tela, 4);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			dialogo = "Estou com pressa, ja dei uma surra Billy, volto la pra bater nele denovo quando eu for aceito na Guilda Orizaba ";
		}
		dialogoCentroVila();
	}

	private void dialogoCentroVila() {
		try {
			dialogo = "~~~~| Voce esta no Centro do Vilarejo de Oishy|~~~~";
			if (!MontanhaSagrada.jogador.getInteracoes().isConversouPeter()) {
				dialogo = leitor.lerDialogos(MontanhaSagrada.jogador, "centroVilarejo.txt");
				MontanhaSagrada.jogador.getInteracoes().setConversouPeter(true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tela.getBtnOpcao4().setVisible(true);
		this.tela.getBtnOpcao3().setVisible(true);
		this.tela.getBtnOpcao5().setVisible(true);
		this.tela.getBtnOpcao1().setText("Ir para o SUL");
		this.tela.getBtnOpcao2().setText("Ir para o OESTE");
		this.tela.getBtnOpcao3().setText("Ir para o LESTE");
		this.tela.getBtnOpcao4().setText("Ir para o NORTE");
		this.tela.getBtnOpcao5().setText("Retornar p/ porta de Casa");
//			this.tela.getBtnOpcao6().setText("ir a Taberna");
		this.tela.escolhaCentroVilarejo(MontanhaSagrada.jogador, dialogo);
	}

	private void dialogoCeleiro() {
		if (!MontanhaSagrada.jogador.getInteracoes().isPegarOvosCeleiro()) {
			try {
				dialogo = leitor.lerDialogos(MontanhaSagrada.jogador, "celeiro1.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MontanhaSagrada.jogador.adicionarItem(Consumivel.pegarOvoGrande());
			MontanhaSagrada.jogador.getInteracoes().setPegarOvosCeleiro(true);
			Batalha b = new Batalha(tela);
			if (b.decisaoBatalha(this.tela.notifyConfronto(
					"~A mulher de grande porte e musculos, pega algo da mochila e toma postura de batalha~"))) {
				try {
					TelaBatalha tb = new TelaBatalha( tela, 2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			try {
				dialogo = leitor.lerDialogos(MontanhaSagrada.jogador, "celeiro2.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.tela.getBtnOpcao3().setVisible(true);
		this.tela.getBtnOpcao1().setText("Ir ao Celeiro");
		this.tela.getBtnOpcao2().setText("Ir ao Centro da Vila");
		this.tela.getBtnOpcao3().setText("Voltar para Casa");
		this.tela.getBtnOpcao4().setVisible(false);
		this.tela.getBtnOpcao5().setVisible(false);
		this.tela.escolhaVilarejo(MontanhaSagrada.jogador, dialogo);
	}

	private void dialogoForaDeCasa() {
		try {
			dialogo = leitor.lerDialogos(MontanhaSagrada.jogador, "vilarejo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!MontanhaSagrada.jogador.getInteracoes().isEspantouAbutre()) {
			MontanhaSagrada.jogador.getInteracoes().setEspantouAbutre(true);
			Batalha b = new Batalha(tela);
			int aceite = this.tela.notifyConfronto("~Tem um abutre na porta de sua casa, comendo um rato podre,\nele esta te olhando de lado, salivando~");
			System.out.println(aceite);
			if (b.decisaoBatalha(aceite)) {
				try {
					TelaBatalha tb = new TelaBatalha(tela, 1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		this.tela.getBtnOpcao3().setVisible(true);
		this.tela.getBtnOpcao1().setText("Ir ao Celeiro");
		this.tela.getBtnOpcao2().setText("Ir ao Centro da Vila");
		this.tela.getBtnOpcao3().setText("Voltar para Casa");
		this.tela.getBtnOpcao4().setVisible(false);
		this.tela.getBtnOpcao5().setVisible(false);
		this.tela.escolhaVilarejo(MontanhaSagrada.jogador, dialogo);
	}

	private void dialogoVaranda() {
		try {
			dialogo = leitor.lerDialogos(MontanhaSagrada.jogador, "varanda.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tela.getBtnOpcao1().setText("Ir até a Varanda");
		this.tela.getBtnOpcao2().setText("Sair da Casa");
		this.tela.getBtnOpcao3().setVisible(false);
		this.tela.getBtnOpcao4().setVisible(false);
		this.tela.getBtnOpcao5().setVisible(false);
		this.tela.escolhaCasa(MontanhaSagrada.jogador, dialogo);
	}

	private void dialogoCasa() {
		try {
			dialogo = leitor.lerDialogos(MontanhaSagrada.jogador, "reflexao_frame.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tela.getBtnOpcao3().setVisible(false);
		this.tela.getBtnOpcao2().setVisible(true);
		this.tela.getBtnOpcao5().setVisible(false);
		this.tela.getBtnOpcao4().setVisible(false);
		this.tela.getBtnOpcao1().setText("Ir até a Varanda");
		this.tela.getBtnOpcao2().setText("Sair da Casa");
		this.tela.escolhaCasa(MontanhaSagrada.jogador, dialogo);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
