package br.com.alura.escola.infra.selo;

import java.util.List;

import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.selo.Selo;

public interface RepositoriosDeSelos {
    
    void adicionar(Selo selo);
    List<Selo> selosDoAlunoDeCPF (CPF cpf);
}
