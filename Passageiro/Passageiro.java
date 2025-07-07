package infobus;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Passageiro {
    private String cpf;
    private String nome;
    private String contato;
    private Date dataNascimento;
    private Login login;

    public Passageiro(String cpf, String nome, String contato, Date dataNascimento, Login login) {
        this.cpf = cpf;
        this.nome = nome;
        this.contato = contato;
        this.dataNascimento = dataNascimento;
        this.login = login;
    }

    public void cadastrarPassageiro() {
        System.out.println("Confirmação: Passageiro " + this.nome + " cadastrado no sistema.");
    }

    public void consultarPassagem() {
        System.out.println("\n--- Consultando Suas Passagens, " + this.nome + " ---");
    }

    public void editarCadastro(Scanner sc) {
        System.out.println("\n--- Editar Cadastro ---");
        System.out.println("O que você deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Contato");
        System.out.print("Escolha: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch(opcao) {
            case 1:
                System.out.print("Digite o novo nome: ");
                this.setNome(sc.nextLine());
                System.out.println("Nome alterado com sucesso para: " + this.nome);
                break;
            case 2:
                System.out.print("Digite o novo contato: ");
                this.setContato(sc.nextLine());
                System.out.println("Contato alterado com sucesso para: " + this.contato);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
    public Login getLogin() { return login; }
}