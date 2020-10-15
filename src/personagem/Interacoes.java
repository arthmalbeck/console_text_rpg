package personagem;

import java.io.Serializable;

public class Interacoes implements Serializable{
	private boolean espantouAbutre;// 1
	private boolean pegarOvosCeleiro;// 2
	private boolean conversouBilly;// 3
	private boolean visitouTaberna;// 4
	private boolean pegouChaves;// 5
	private boolean conversouPeter;// 6
	private boolean derrotouBilly;// 7
	private boolean encontrouBau;// 8
	private boolean derrotouAnciao;// 9
	private boolean pegouItens;// 10

	
	public Interacoes() {
		//colocar no passado
		this.espantouAbutre = false;
		this.pegarOvosCeleiro = false;
		this.conversouBilly = false;
		this.visitouTaberna = false;
		this.pegarOvosCeleiro = false;
		this.pegouChaves = false;
		this.conversouPeter = false;
		this.derrotouBilly = false;
		this.encontrouBau = false;
		this.derrotouAnciao = false;
		this.pegouItens = false;
	}


	public boolean isPegouItens() {
		return pegouItens;
	}


	public void setPegouItens(boolean pegouItens) {
		this.pegouItens = pegouItens;
	}


	public boolean isDerrotouAnciao() {
		return derrotouAnciao;
	}


	public void setDerrotouAnciao(boolean derrotouAnciao) {
		this.derrotouAnciao = derrotouAnciao;
	}


	public boolean isEncontrouBau() {
		return encontrouBau;
	}


	public void setEncontrouBau(boolean encontrouBau) {
		this.encontrouBau = encontrouBau;
	}


	public boolean isDerrotouBilly() {
		return derrotouBilly;
	}


	public void setDerrotouBilly(boolean derrotouBilly) {
		this.derrotouBilly = derrotouBilly;
	}


	public boolean isConversouPeter() {
		return conversouPeter;
	}


	public void setConversouPeter(boolean conversouPeter) {
		this.conversouPeter = conversouPeter;
	}


	public boolean isEspantouAbutre() {
		return espantouAbutre;
	}


	public void setEspantouAbutre(boolean espantouAbutre) {
		this.espantouAbutre = espantouAbutre;
	}


	public boolean isPegarOvosCeleiro() {
		return pegarOvosCeleiro;
	}


	public void setPegarOvosCeleiro(boolean pegarOvosCeleiro) {
		this.pegarOvosCeleiro = pegarOvosCeleiro;
	}


	public boolean isConversouBilly() {
		return conversouBilly;
	}


	public void setConversouBilly(boolean conversouBilly) {
		this.conversouBilly = conversouBilly;
	}


	public boolean isVisitouTaberna() {
		return visitouTaberna;
	}


	public void setVisitouTaberna(boolean visitouTaberna) {
		this.visitouTaberna = visitouTaberna;
	}


	public boolean isPegouChaves() {
		return pegouChaves;
	}


	public void setPegouChaves(boolean pegouChaves) {
		this.pegouChaves = pegouChaves;
	}
	
	
	
}
