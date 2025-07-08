package projetoinfobus;

import java.util.Date;
import java.util.Scanner;

public class Motorista extends Funcionario {
    private String cnh;
    private String validadeCnh;
    private String tipoCnh;

    public Motorista(String id, String nome, String cpf, String senha, Date dataNascimento, double salario,
                     String turnoTrab, String cargo, String telefone, String email,
                     String cnh, String validadeCnh, String tipoCnh) {
        super(id, nome, cpf, senha, dataNascimento, salario, turnoTrab, cargo, telefone, email);
        this.cnh = cnh;
        this.validadeCnh = validadeCnh;
        this.tipoCnh = tipoCnh;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getValidadeCnh() {
        return validadeCnh;
    }

    public void setValidadeCnh(String validadeCnh) {
        this.validadeCnh = validadeCnh;
    }

    public String getTipoCnh() {
        return tipoCnh;
    }

    public void setTipoCnh(String tipoCnh) {
        this.tipoCnh = tipoCnh;
    }


    public void menuMotorista(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n===== MENU - MOTORISTA =====");
            System.out.println("1. Visualizar Escala");
            System.out.println("2. Registrar Ocorrência");
            System.out.println("3. Registrar Ponto");
            System.out.println("4. Consultar Contracheque");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> visualizarEscala();
                case 2 -> {
                    System.out.print("Descreva a ocorrência: ");
                    String descricao = scanner.nextLine();
                    registrarOcorrencia(descricao);
                }
                case 3 -> {
                    registrarPonto(java.time.LocalDateTime.now());
                }
                case 4 -> consultarContraCheque();
                case 0 -> System.out.println("Saindo do menu do motorista...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    public void visualizarEscala() {
    }

    public void registrarOcorrencia(String descricao) {
    }
}
