package infobus;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class MenuPassageiro {

    private static ArrayList<Passageiro> passageiros = new ArrayList<>();
    private static ArrayList<Viagem> viagens = new ArrayList<>();
    private static ArrayList<Passagem> passagensCompradas = new ArrayList<>();
    private static Passageiro passageiroLogado = null;

    public void exibirMenu(Scanner sc) {
        setupInicial();

        int opcao;
        do {
            System.out.println("\n**** MENU DO PASSAGEIRO ****");
            if (passageiroLogado != null) { System.out.println("Usuário: " + passageiroLogado.getNome()); } 
            else { System.out.println("Usuário: Nenhum usuário logado"); }
            System.out.println("---------------------------------");
            System.out.println("1 - Cadastrar Novo Passageiro");
            System.out.println("2 - Fazer Login");
            System.out.println("3 - Comprar Passagem");
            System.out.println("4 - Consultar Minhas Passagens");
            System.out.println("5 - Editar Meu Cadastro");
            System.out.println("6 - Cancelar Passagem");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPassageiro(sc);
                    break;
                case 2:
                    fazerLogin(sc);
                    break;
                case 3:
                    comprarPassagem(sc);
                    break;
                case 4:
                    consultarMinhasPassagens();
                    break;
                case 5:
                    if (passageiroLogado != null) { passageiroLogado.editarCadastro(sc); } 
                    else { System.out.println("Faça o login primeiro."); }
                    break;
                case 6:
                     cancelarPassagem(sc); // Chama o método de cancelamento do menu
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrarPassageiro(Scanner sc) {
        System.out.println("\n--- Cadastro de Novo Passageiro ---");
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("CPF: "); String cpf = sc.nextLine();
        System.out.print("Contato: "); String contato = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Senha: "); String senha = sc.nextLine();

        Login novoLogin = new Login(email, senha);
        Passageiro novoPassageiro = new Passageiro(cpf, nome, contato, new Date(), novoLogin);
        passageiros.add(novoPassageiro);
        novoPassageiro.cadastrarPassageiro();
    }

    private void fazerLogin(Scanner sc) {
        System.out.println("\n--- Login ---");
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Senha: "); String senha = sc.nextLine();

        for (Passageiro p : passageiros) {
            if (p.getLogin().getEmail().equals(email) && p.getLogin().verificarSenha(senha)) {
                passageiroLogado = p;
                System.out.println("Login realizado com sucesso!");
                return;
            }
        }
        System.out.println("Email ou senha incorretos.");
    }

    private void comprarPassagem(Scanner sc) {
        if (passageiroLogado == null) { System.out.println("Faça o login primeiro."); return; }

        System.out.println("\n--- Viagens Disponíveis ---");
        for (int i = 0; i < viagens.size(); i++) {
            Viagem v = viagens.get(i);
            System.out.printf("%d. %s -> %s (%s)\n", (i + 1), v.getRota().getOrigem(), v.getRota().getDestino(), v.getDataHoraPartida());
        }
        System.out.print("Escolha a viagem: ");
        int escolhaViagem = sc.nextInt() - 1;
        Viagem viagemEscolhida = viagens.get(escolhaViagem);

        System.out.println("\n--- Poltronas Disponíveis ---");
        int capacidade = viagemEscolhida.getOnibus().getCapacidade();
        ArrayList<Integer> poltronasOcupadas = new ArrayList<>();
        for (Passagem p : passagensCompradas) {
            if (p.getViagem() == viagemEscolhida) {
                poltronasOcupadas.add(p.getNumeroPoltrona());
            }
        }
        for (int i = 1; i <= capacidade; i++) {
            if (!poltronasOcupadas.contains(i)) { System.out.print(i + " "); }
        }

        System.out.print("\nEscolha a poltrona: ");
        int escolhaPoltrona = sc.nextInt();
        sc.nextLine();

        if (escolhaPoltrona < 1 || escolhaPoltrona > capacidade || poltronasOcupadas.contains(escolhaPoltrona)) {
            System.out.println("Poltrona inválida ou ocupada.");
            return;
        }

        float valor = 210.50f;
        int id = passagensCompradas.size() + 1;
        Passagem nova = new Passagem(id, "Confirmada", passageiroLogado, viagemEscolhida, escolhaPoltrona, valor);
        passagensCompradas.add(nova);
        System.out.println("\nPassagem comprada com sucesso!");
        nova.imprimirDetalhes();
    }
    
    private void consultarMinhasPassagens() {
        if (passageiroLogado == null) {
            System.out.println("Faça o login primeiro.");
            return;
        }
        passageiroLogado.consultarPassagem(); // Chama o método do passageiro para exibir o cabeçalho
        
        boolean encontrou = false;
        for (Passagem p : passagensCompradas) {
            if (p.getPassageiro().getCpf().equals(passageiroLogado.getCpf())) {
                p.imprimirDetalhes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma passagem encontrada para este usuário.");
        }
    }
    
    private void cancelarPassagem(Scanner sc) {
        if (passageiroLogado == null) {
            System.out.println("Faça o login primeiro.");
            return;
        }
        
        System.out.println("\n--- Cancelar Passagem ---");
        ArrayList<Passagem> minhasPassagens = new ArrayList<>();
        for (Passagem p : passagensCompradas) {
            if (p.getPassageiro().getCpf().equals(passageiroLogado.getCpf())) {
                minhasPassagens.add(p);
            }
        }

        if (minhasPassagens.isEmpty()) {
            System.out.println("Você não possui passagens para cancelar.");
            return;
        }

        System.out.println("Selecione a passagem que deseja cancelar:");
        for (int i = 0; i < minhasPassagens.size(); i++) {
            Passagem p = minhasPassagens.get(i);
            System.out.printf("%d. Viagem para %s, Poltrona %d (ID: %d)\n", (i + 1), p.getViagem().getRota().getDestino(), p.getNumeroPoltrona(), p.getIdPassagem());
        }
        
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt() - 1;
        sc.nextLine();

        if (escolha >= 0 && escolha < minhasPassagens.size()) {
            Passagem passagemParaRemover = minhasPassagens.get(escolha);
            passagensCompradas.remove(passagemParaRemover);
            System.out.println("Passagem ID " + passagemParaRemover.getIdPassagem() + " foi cancelada (removida) com sucesso!");
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    private void setupInicial() {
        if (viagens.isEmpty()) {
            Rota r = new Rota("São Paulo", "Rio de Janeiro");
            Onibus o = new Onibus("XYZ-9876", "Volksbus 18.330", 40);
            viagens.add(new Viagem("08/07/2025 23:00", r, o));
        }
    }
}

