package br.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo{
	
	private LocalDate dataMarcada;

	public Mentoria(String titulo, String descricao, LocalDate data) {
		super(titulo, descricao);
		this.dataMarcada = data;
	}

	@Override
	public int calcularXP() {
		return XP_PADRAO * 2;
	}

	public LocalDate getDataMarcada() {
		return dataMarcada;
	}

	public void setDataMarcada(LocalDate dataMarcada) {
		this.dataMarcada = dataMarcada;
	}

	@Override
	public String toString() {
		return "Mentoria: " + getTitulo() + ", " + getDescricao() + ", " + getDataMarcada();
	}

}
