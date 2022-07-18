package br.com.alura.escola.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.alura.escola.dominio.Evento;
import br.com.alura.escola.dominio.Ouvinte;

public class LogDeAlunoMatriculado extends Ouvinte {

    public void reageAo(AlunoMatriculado evento) {
        String momentoFormatado = evento.getMomento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
        System.out.println(
                String.format("Aluno com CPF %s matriculado em: $s", evento.getCpfDoAluno(), momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        // TODO Auto-generated method stub
        return false;
    }
}
