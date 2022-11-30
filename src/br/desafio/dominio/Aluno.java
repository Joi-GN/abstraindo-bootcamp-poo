package br.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Aluno {
	
	private static int qtdTotal = 0;
	private int id;
	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

	public Aluno(String nome) {
		this.nome = nome;
		this.id = ++qtdTotal;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}	
	
	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudosInscritos.addAll(bootcamp.getConteudosAbordados());
		bootcamp.getAlunosInscritos().add(this);
	}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			this.conteudosInscritos.remove(conteudo.get());
			this.conteudosConcluidos.add(conteudo.get());
		} else {
			System.err.println("Não há nenhum conteúdo");
		}
	}
	
	public int calcularXp() {
		return this.conteudosConcluidos.stream().mapToInt(Conteudo::calcularXP).sum();
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && id == other.id
				&& Objects.equals(nome, other.nome);
	}
	
	@Override
	public String toString() {
		return  nome + " id " + id +", Conteúdos Inscritos: " + conteudosInscritos + ", Total Xp adquirida = " + calcularXp();
	}
	
}