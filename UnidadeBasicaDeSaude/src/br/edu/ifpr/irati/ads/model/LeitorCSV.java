package br.edu.ifpr.irati.ads.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {

    private List<Estado> leitorDeEstados() {
        List<Estado> estados = new ArrayList<>();
        String linhaAtual = "";
        try ( BufferedReader br = new BufferedReader(new FileReader("src\\br\\edu\\ifpr\\irati\\ads\\arquivos\\estados.csv"))) {
            while ((linhaAtual = br.readLine()) != null) {
                String[] dados = linhaAtual.split(";");
                Estado estado = new Estado(dados[0], dados[1], dados[2]);
                estados.add(estado);
            }
        } catch (Exception e) {
        }
        estados.remove(0);
        return estados;
    }

    public List<UnidadesDeSaude> leitorDeUnidadeDeSaude() {
        List<UnidadesDeSaude> unidadesDeSaudes = new ArrayList<>();
        String linhaAtual = "";
        try ( BufferedReader br = new BufferedReader(new FileReader("src\\br\\edu\\ifpr\\irati\\ads\\arquivos\\cadastro_estabelecimentos_cnes.csv"))) {
            while ((linhaAtual = br.readLine()) != null) {
                String[] dados = linhaAtual.split(";");
                String nome = dados[3].replace("\"", "");
                String bairro = dados[5].replace("\"", "");
                String logradouro = dados[4].replace("\"", "");
                Endereco endereco = new Endereco(converterUF(dados[1]), logradouro, bairro, dados[6], dados[7]);
                UnidadesDeSaude unidadesDeSaude = new UnidadesDeSaude(dados[0], dados[2], nome, endereco);
                unidadesDeSaudes.add(unidadesDeSaude);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        unidadesDeSaudes.remove(0);
        return unidadesDeSaudes;
    }

    private String converterUF(String idUF) {
        List<Estado> estados = leitorDeEstados();
        for (Estado estado : estados) {
            if (estado.getCodigo().equals(idUF)){
                return estado.getNome();
            }
        }
        return null;
    }
}
