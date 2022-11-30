package br.desafio;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import br.desafio.dominio.Aluno;
import br.desafio.dominio.Bootcamp;
import br.desafio.dominio.Conteudo;
import br.desafio.dominio.Curso;
import br.desafio.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {

		// Criando os conteúdos
		Conteudo collections = new Curso("Trabalhando com Collections - Java", "Aprendendo sobre o Framework Collections da linguagem de programação Java", 4);
		Conteudo debug = new Curso("Debugging Java", "Aprendendo a depurar - Java", 1);
		Conteudo mentoria = new Mentoria("Tira dúvidas", "Tire suas dúvidas com o mentor", LocalDate.now());
		
		// Criando Set para juntar conteúdos sobre Java
		Set<Conteudo> assuntosJava = new LinkedHashSet<>() {{
			add(collections);
			add(debug);
		}};
		
		// Criando bootcamp de Java e adicionando os conteúdos
		Bootcamp bootcampJava = new Bootcamp("Bootcamp Java Dev", "Estude para ser um desenvolvedor Java aqui");
		bootcampJava.setConteudosAbordados(assuntosJava);
		bootcampJava.setConteudosAbordados(mentoria);
		
		// Criando alunos e matriculando-as em um bootcamp
		Aluno ana = new Aluno("Ana");
		ana.inscreverBootcamp(bootcampJava);
		Aluno bia = new Aluno("Bia");
		bia.inscreverBootcamp(bootcampJava);
		
		System.out.println(ana);
		bia.progredir();
		bia.progredir();
		System.out.println(bia);
		
	}

}
