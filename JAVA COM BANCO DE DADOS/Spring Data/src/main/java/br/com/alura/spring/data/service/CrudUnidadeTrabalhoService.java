package br.com.alura.spring.data.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService extends CrudService {

	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}

	protected void salvar(Scanner scanner) {
		System.out.println("Digite o nome da unidade");
		String nome = scanner.next();

		System.out.println("Digite o endereco");
		String endereco = scanner.next();

		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setDescricao(nome);
		unidadeTrabalho.setEndereco(endereco);

		unidadeTrabalhoRepository.save(unidadeTrabalho);
		System.out.println("Salvo");
	}

	protected void atualizar(Scanner scanner) {
		System.out.println("Digite o id");
		Integer id = scanner.nextInt();

		Optional<UnidadeTrabalho> unidadeTrabalhoOpt = unidadeTrabalhoRepository.findById(id);
		if (unidadeTrabalhoOpt.isPresent()) {
			System.out.println("Não encontrado esse id da unidade de Trabalho");
			return;
		}

		System.out.println("Digite o nome da unidade");
		String nome = scanner.next();

		System.out.println("Digite o endereco");
		String endereco = scanner.next();

		UnidadeTrabalho unidadeTrabalho = unidadeTrabalhoOpt.get();
		unidadeTrabalho.setId(id);
		unidadeTrabalho.setDescricao(nome);
		unidadeTrabalho.setEndereco(endereco);

		unidadeTrabalhoRepository.save(unidadeTrabalho);
		System.out.println("Alterado");
	}

	protected void visualizar(Scanner scanner) {
		unidadeTrabalhoRepository.findAll().forEach(unidade -> System.out.println(unidade));
	}

	protected void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		unidadeTrabalhoRepository.deleteById(id);
		System.out.println("Deletado");
	}

}
