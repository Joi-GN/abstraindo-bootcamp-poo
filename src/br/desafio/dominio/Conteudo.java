package br.desafio.dominio;

public abstract class Conteudo {
	
	protected final int XP_PADRAO = 10; 
	
	private String titulo;
	private String descricao;
	
	public Conteudo(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public abstract int calcularXP();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
