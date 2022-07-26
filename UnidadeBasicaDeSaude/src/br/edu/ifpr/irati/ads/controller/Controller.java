package br.edu.ifpr.irati.ads.controller;

import br.edu.ifpr.irati.ads.dao.BancoDeDados;
import br.edu.ifpr.irati.ads.model.UnidadesDeSaude;
import br.edu.ifpr.irati.ads.view.UnidadesDeSaudoGUI;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Controller {

    private BancoDeDados bancoDeDados;
    private UnidadesDeSaudoGUI unidadesDeSaudoGUI;

    public Controller() {
        bancoDeDados = new BancoDeDados();
        unidadesDeSaudoGUI = new UnidadesDeSaudoGUI(this);
    }

    public DefaultTableModel modelo(String filtro) {
        List<UnidadesDeSaude> unidades = bancoDeDados.filtrar(filtro);
        String titulos[] = new String[4];
        titulos[0] = "Nome";
        titulos[1] = "Estado";
        titulos[2] = "Logradouro";
        titulos[3] = "Bairro";
        String dados[][] = new String[unidades.size()][4];
        for (int i = 0; i < unidades.size(); i++) {
            dados[i][0] = unidades.get(i).getNome();
            dados[i][1] = unidades.get(i).getEndereco().getEstado();
            dados[i][2] = unidades.get(i).getEndereco().getLogradouro();
            dados[i][3] = unidades.get(i).getEndereco().getBairro();
        }
        return new DefaultTableModel(dados, titulos);
    }

    public void abrirTela() {
        unidadesDeSaudoGUI.setVisible(true);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.abrirTela();
    }

}
