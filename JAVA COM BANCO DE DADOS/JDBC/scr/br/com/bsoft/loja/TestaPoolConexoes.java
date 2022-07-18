package scr.br.com.bsoft.loja;

import java.sql.SQLException;

public class TestaPoolConexoes {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();

        for (int index = 0; index < 20; index++) {
            factory.recuperarConexao();
            System.out.println("Conexão de número: " + (index+1));
        }
    }
}
