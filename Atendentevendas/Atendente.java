package infobus;

import java.util.List;
import java.util.Date;
import java.time.LocalDateTime;

public class Atendente extends Funcionario {
    public Atendente(String id, String nome, String cpf, String senha, Date dataNascimento, double salario, String turnoTrab, String cargo, String telefone, String email){
        super(id, nome, cpf, senha, dataNascimento, salario, turnoTrab, cargo, telefone, email);  
    }
    
    public void venderPassagem(Passagem passagem){
        Passagem passagem = new Passagem(...);
        venderPassagem(passagem);
        
        System.out.print("Valor da passagem: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Forma de pagamento: ");
        String formaPagamento = scanner.nextLine();
        String idVenda = UUID.randomUUID().toString();
        
        Venda venda = new Venda(isVenda, LocalDateTime.now(), valor, formaPagamento, passagem, this);
        ControleVendas.registrarVenda(venda);
        System.out.println("Venda registrada com sucesso.");
  }
    
    public void listarPassagens(){
        ControlePassagens.listarPassagens();
    }
    
    public void cancelarPassagem(String idPassagem){
        boolean sucesso = ControlePassagens.removerPassagem(idPassagem);
        if(sucesso){
            System.out.println("Passagem cancelada com sucesso.");
        }else{
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
           System.out.println("Escolha uma opção");
           opcao = scanner.nextInt();
           scanner.nextLine();
           
           switch(opcao){
               case 1 -> {
                   System.out.print("ID da Passagem:");
                   String id = scanner.nextLine();
                   System.out.print("Nome do Passageiro:");
                   String nomePassageiro = scanner.nextLine();
                   System.out.print("ID da Viagem:");
                   String idViagem = scanner.nextLine();
                   System.out.print("Assento:");
                   int assento = scanner.nextInt();
                   
                   Viagem viagem = ControleViagens.buscarViagemPorId(idViagem);
                   if(viagem != null){
                       Passagem passagem = new Passagem(id, nomePassageiro,viagem,assento, localDateTime.now());
                       venderPassagem(passagem);
                   }else{
                         System.out.println("Viagem não encontrada.");
                   }
               }
               case 2 -> listarPassagens();
               case 3 -> {
                     System.out.print("ID da Passagem a cancelar:");
                     String id = scanner.nextLine();
                     cancelarPassagem(id);
               }
                case 0 ->  System.out.println("Saindo do Menu...");
                default -> System.out.println("Opção inválida. Por favor, tente novamente.");
           }  
        } while(opcao != 0);
    }
}
;