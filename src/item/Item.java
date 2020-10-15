package item;

public abstract class Item {

	private int id;
	private String nome;
	private String desc;
	private Efeito efeito;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Efeito getEfeito() {
		return efeito;
	}
	public void setEfeito(Efeito efeito) {
		this.efeito = efeito;
	}
	
}
