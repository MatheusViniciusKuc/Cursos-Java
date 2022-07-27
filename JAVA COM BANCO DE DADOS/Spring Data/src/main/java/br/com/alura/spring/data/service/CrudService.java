package br.com.alura.spring.data.service;

import java.util.Scanner;

public abstract class CrudService {

    public void inicial(Scanner scanner) {
        boolean system = true;
        while (system) {
            System.out.println("Qual acao de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar(scanner);
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    protected abstract void salvar(Scanner scanner);

    protected abstract void atualizar(Scanner scanner);

    protected abstract void visualizar(Scanner scanner);

    protected abstract void deletar(Scanner scanner);
}
