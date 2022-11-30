package br.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
	
	private String nome;
	private String descricao;
	private final LocalDate dataInicial = LocalDate.now();
	private final LocalDate dataFinal = dataInicial.plusDays(45);
	private Set<Aluno> alunosInscritos = new HashSet<>();
	private Set<Conteudo> conteudosAbordados = new LinkedHashSet<>();
	
	public Bootcamp(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public Set<Aluno> getAlunosInscritos() {
		return alunosInscritos;
	}
	
	public void setConteudosAbordados(Conteudo conteudo) {
		this.conteudosAbordados.add(conteudo);
	}
	
	public void setConteudosAbordados(Set<Conteudo> conteudos) {
		this.conteudosAbordados.addAll(conteudos);
	}

	public Set<Conteudo> getConteudosAbordados() {
		return conteudosAbordados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alunosInscritos, conteudosAbordados, dataFinal, dataInicial, descricao, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bootcamp other = (Bootcamp) obj;
		return Objects.equals(alunosInscritos, other.alunosInscritos)
				&& Objects.equals(conteudosAbordados, other.conteudosAbordados)
				&& Objects.equals(dataFinal, other.dataFinal) && Objects.equals(dataInicial, other.dataInicial)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(nome, other.nome);
	}

}
