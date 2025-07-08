package projetoinfobus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Atendente extends Funcionario {
    private List<Passagem> listaPassagens = new ArrayList<>();
    private Scanner scanner;

    public Atendente(String id, String nome, String cpf, String senha, Date dataNascimento, double salario, String turnoTrab, String cargo, String telefone, String email) {
        super(id, nome, cpf, senha, dataNascimento, salario, turnoTrab, cargo, telefone, email);
    }

    public void venderPassagem(Passagem passagem){
        listaPassagens.add(passagem);

        System.out.print("Valor da passagem: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Forma de pagamento: ");
        String formaPagamento = scanner.nextLine();

        String idVenda = UUID.randomUUID().toString();

        // Venda venda = new Venda(idVenda, LocalDateTime.now(), valor, formaPagamento, passagem, this);
        // ControleVendas.registrarVenda(venda); 
        // Assumindo que Venda e ControleVendas existam e funcionem. Se não, remova ou implemente.

        System.out.println("Venda registrada com sucesso.");
    }

    public void listarPassagens(){
        if(listaPassagens.isEmpty()){
            System.out.println("Nenhuma passagem cadastrada.");
        } else {
            for(Passagem p : listaPassagens){
                p.imprimirDetalhes();
            }
        }
    }

    public void cancelarPassagem(Integer idPassagem){
        boolean removido = listaPassagens.removeIf(p -> p.getIdPassagem().equals(idPassagem));
        if(removido){
            System.out.println("Passagem cancelada com sucesso.");
        } else {
            System.out.println("Passagem não encontrada.");
        }
    }

    public void menuAtendente(Scanner scanner){
        int opcao;
        do{
           System.out.println("\n**** Menu ATENDENTE ****");
           System.out.println("1. Vender Passagem");
           System.out.println("2. Listar Passagens");
           System.out.println("3. Cancelar Passagem");
           System.out.println("0. Sair");
           System.out.print("Escolha uma opção: ");
           opcao = scanner.nextInt();
           scanner.nextLine();

           switch(opcao){
               case 1 -> {
                   System.out.print("ID da Passagem (número inteiro): ");
                   Integer id = scanner.nextInt();
                   scanner.nextLine();

                   System.out.print("Nome do Passageiro: ");
                   String nomePassageiro = scanner.nextLine();

                   System.out.print("CPF do Passageiro: ");
                   String cpfPassageiro = scanner.nextLine();

                   // Crie um Passageiro simples só com nome e cpf para a passagem (ou adapte conforme seu sistema)
                   Passageiro passageiro = new Passageiro(cpfPassageiro, nomePassageiro, "", null, null);

                   System.out.print("ID da Viagem: ");
                   String idViagem = scanner.nextLine();

                   Viagem viagem = ControleViagens.buscarViagemPorId(idViagem);
                   if(viagem != null){
                       System.out.print("Número do Assento: ");
                       Integer assento = scanner.nextInt();
                       scanner.nextLine();

                       System.out.print("Valor da passagem (ex: 50.00): ");
                       Float valor = scanner.nextFloat();
                       scanner.nextLine();

                       Passagem passagem = new Passagem(id, "Vendida", passageiro, viagem, assento, valor);
                       venderPassagem(passagem);
                   } else {
                       System.out.println("Viagem não encontrada.");
                   }
               }
               case 2 -> listarPassagens();
               case 3 -> {
                   System.out.print("ID da Passagem a cancelar: ");
                   Integer idCancela = scanner.nextInt();
                   scanner.nextLine();
                   cancelarPassagem(idCancela);
               }
               case 0 -> System.out.println("Saindo do Menu...");
               default -> System.out.println("Opção inválida. Por favor, tente novamente.");
           }
        } while(opcao != 0);
    }
}
