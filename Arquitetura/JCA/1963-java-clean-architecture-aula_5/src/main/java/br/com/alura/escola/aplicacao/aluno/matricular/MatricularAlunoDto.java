package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;

public class MatricularAlunoDto {

    private String nomeDoAluno;
    private String cpfDoAluno;
    private String emailDoAluno;

    public MatricularAlunoDto(String nomeDoAluno, String cpfDoAluno, String emailDoAluno) {
        this.nomeDoAluno = nomeDoAluno;
        this.cpfDoAluno = cpfDoAluno;
        this.emailDoAluno = emailDoAluno;
    }

    public Aluno criarAluno() {
        return new Aluno(new CPF(cpfDoAluno), nomeDoAluno, new Email(emailDoAluno));
    }
}
