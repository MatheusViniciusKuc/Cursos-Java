package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.model.LeitorCSV;
import br.edu.ifpr.irati.ads.model.UnidadesDeSaude;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private List<UnidadesDeSaude> unidadesDeSaude;
    private LeitorCSV leitorCSV;

    public BancoDeDados() {
        this.leitorCSV = new LeitorCSV();
        this.unidadesDeSaude = leitorCSV.leitorDeUnidadeDeSaude();
    }

    public List<UnidadesDeSaude> getUnidadesDeSaude() {
        return unidadesDeSaude;
    }

    public List<UnidadesDeSaude> filtrar(String filtro) {
        if (!filtro.isEmpty()) {
            List<UnidadesDeSaude> unidadesFiltradas = new ArrayList<>();
            for (UnidadesDeSaude unidades : unidadesDeSaude) {
                if (nomeFilter(unidades.getNome(), filtro) == filtro.length()) {
                    unidadesFiltradas.add(unidades);
                }
            }
            return unidadesFiltradas;
        }
        return this.unidadesDeSaude;
    }

    private int nomeFilter(String nome, String filtro) {
        int qtd = 0;
        for (int i = 0; i < filtro.length(); i++) {
            String uniNome = nome.toUpperCase();
            char unidCarac = uniNome.charAt(i);
            String filter = filtro.toUpperCase();
            char filtroCarac = filter.charAt(i);
            if (unidCarac == filtroCarac) {
                qtd++;
            }
        }
        return qtd;
    }
}

/*for (int i = 0; i < texto.length(); i++) {;
        char caractere = texto.charAt(i);

        if (caractere == '?'){
            System.out.println("Você não pode adicionar ao texto interrogação.");

        } else if (caractere == ' ') {
            System.out.println("Você não pode adicionar ao texto espaços.");
        }
    }
  }*/
