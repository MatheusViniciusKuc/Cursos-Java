package br.com.alura.escola.dominio;

import br.com.alura.escola.dominio.aluno.AlunoMatriculado;

public abstract class Ouvinte {
    
    public void processa(Evento evento) {
        if(this.deveProcessar(evento)){
            this.reageAo(evento);
        }
    }

    protected abstract void reageAo(AlunoMatriculado evento);

    protected abstract boolean deveProcessar(Evento evento);
}
