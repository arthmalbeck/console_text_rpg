package item;

import personagem.Jogador;

public class Bugiganga extends Item{
	private String descricao;
	
	public static Item pegarCarta(Jogador jogador) {
		Bugiganga carta = new Bugiganga();
		carta.setNome("Carta Guilda");
		carta.setDescricao("** Carta de aceitcao **\n" +
				"Prezado " + jogador.getNome() + "\n" + 
				"Temos o prazer de informar que você foi aceito na Guilda Orizaba.\n" + 
				"Os soldados da classe " + jogador.getClasse().name() + " sao obrigados a realizar a prova final, entao, certifique-se de que a maior atencao possivel seja prestada a sua lista de objetivo:\n" + 
				"- Ir para o norte do vilarejo Oishy\n" + 
				"- Derrotar o capitão Matsusuke.\n" + 
				"Atensiosamente Seu Novo Mestre!");
		return carta;
	}
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
