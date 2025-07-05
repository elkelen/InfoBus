/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setor.financeiro;

import java.util.Scanner;

/**
 *
 * @author Maria Antônia
 */
public class MenuFinanceiro {
    public void menuFinanceiro(Scanner sc, Financeiro financeiro){
         int opcaoPrincipal;
        do {
            System.out.println("\n**** MENU FINANCEIRO ****");
            System.out.println("1 - Gerar Relatório Financeiro");
            System.out.println("2 - Pagamentos");
            System.out.println("3 - Despesas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = sc.nextInt();

            switch (opcaoPrincipal) {
                case 1:
                    System.out.println(financeiro.gerarRelatorioFinanceiro());
                    break;
                case 2:
                    menuPagamentos(sc, financeiro);
                    break;
                case 3:
                    menuDespesas(sc, financeiro);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoPrincipal != 0);
        sc.close();
    }
    
     public static void menuPagamentos(Scanner sc, Financeiro financeiro) {
        int opcao;
        do {
            System.out.println("\n--- MENU PAGAMENTOS ---");
            System.out.println("1 - Cadastrar Pagamento de Funcionário");
            System.out.println("2 - Listar Pagamentos");
            System.out.println("3 - Atualizar Status de Pagamentos");
            System.out.println("4 - Autorizar Pagamento Manual");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    financeiro.cadastrarPagamentoFuncionario(sc);
                    break;
                case 2:
                    System.out.println(financeiro.listarPagamentos());
                    break;
                case 3:
                    financeiro.atualizarStatusPagam();
                    break;
                case 4:
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Destinatário: ");
                    String destinatario = sc.nextLine();
                    financeiro.autorizarPagamento(valor, destinatario);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void menuDespesas(Scanner sc, Financeiro financeiro) {
        int opcao;
        do {
            System.out.println("\n--- MENU DESPESAS ---");
            System.out.println("1 - Cadastrar Despesa");
            System.out.println("2 - Alterar Primeira Despesa");
            System.out.println("3 - Calcular Total das Despesas");
            System.out.println("4 - Listar Despesas");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    financeiro.cadastrarDespesa(sc);
                    break;
                case 2:
                    financeiro.alterarDespesas(sc);
                    break;
                case 3:
                    System.out.println("Total: R$" + financeiro.calcularTotalDesp());
                    break;
                case 4:
                    financeiro.listarDespesa().forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
