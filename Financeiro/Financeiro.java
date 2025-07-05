/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setor.financeiro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author Maria Antônia
 */
public class Financeiro extends Funcionario {
    private final List<Despesa> despesas = new ArrayList<>(); // lista que GUARDA todas as despesas 
    private final List<PagamentoFuncionario> pagamentos = new ArrayList <>(); 
    
    //construtor 
    public Financeiro(String id, String nome, String cpf, String senha, Date dataNascimento,
                  double salario, String turnoTrab, String cargo, String telefone, String email){
        super(id, nome, cpf, senha, dataNascimento, salario, turnoTrab, cargo, telefone, email);  
    }
    
    // método gerar relatório financeiro 
    public String gerarRelatorioFinanceiro(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- RELATORIO FINANCEIRO ---").append(getId()).append("    \n");
        
        sb.append("\n --- Despesas --- \n"); 
        for (Despesa d : despesas) sb.append(d).append("\n"); 
        
        sb.append("\n --- Pagamentos --- \n"); 
        for (PagamentoFuncionario p : pagamentos) sb.append(p).append("\n"); 
        
        sb.append("\nTotal de Despesas:").append(calcularTotalDesp()); 
        return sb.toString();   
    }
    
    // método para autorização manual de pamento 
    public void autorizarPagamento(Double valor, String destinatario){
        PagamentoFuncionario p = new PagamentoFuncionario("MANUAL", destinatario, "-", "-", valor, valor, "Autorizado");
        pagamentos.add(p); 
        System.out.println("Pagamento autorizado manualmente"); 
    }
    
    // método para cadastrar despesa 
    public void cadastrarDespesa(Scanner sc){
        sc.nextLine(); // limpar 
        System.out.print("ID despesa: "); 
        String id = sc.nextLine(); 
        System.out.print("Categoria: "); 
        String categoria = sc.nextLine(); 
        System.out.print("Valor: "); 
        double valor = sc.nextDouble(); 
        sc.nextLine(); 
        System.out.print("Status: "); 
        String status = sc.nextLine(); 
        System.out.print("Forma de Pagemento: "); 
        String forma = sc.nextLine(); 
        
        despesas.add(new Despesa (id, categoria, valor, LocalDate.now(), status, forma)); 
        System.out.println("Despesa Cadastrada");
        
    }
    
    // método alterar despesa 
    public void alterarDespesas(Scanner sc){
        if(despesas.isEmpty()){
            System.out.println("Sem despesas.");
            return; 
        }
        Despesa d = despesas.get(0); 
        sc.nextLine(); 
        System.out.print("Nova Categoria: ");
        d.setCategoria(sc.nextLine()); 
        System.out.print("Novo Valor: ");
        d.setValorDespesa(sc.nextDouble()); 
        sc.nextLine(); 
        System.out.print("Novo Status: ");
        d.setStatusDespesa(sc.nextLine()); 
        System.out.print("Nova Forma de Pagamento: ");
        d.setFormaPagamento(sc.nextLine()); 
        
        System.out.println("Despesa Alterada.");
    }
    
    // metodo que calcula todas as despesas 
    public double calcularTotalDesp(){
        return despesas.stream().mapToDouble(Despesa :: getValorDespesa).sum(); //  Streams para somar o valor de todas as despesas da lista. 
    }
    
    public List<Despesa> listarDespesa(){
        return despesas; 
    }
    
    public void cadastrarPagamentoFuncionario(Scanner sc){
            sc.nextLine(); // limpar buffer
    System.out.println("\nEscolha o funcionário:");
    System.out.println("1 - Gerente Administrativo");
    System.out.println("2 - Gerente RH");
    System.out.println("3 - Motorista");
    System.out.println("4 - Atendente");
    System.out.print("Opção: ");
    int opcao = sc.nextInt();
    sc.nextLine();

    String nome = "";
    String cargo = "";
    double bruto = 0.0;

    switch (opcao) {
        case 1 -> {
            nome = "Ana Gerente";
            cargo = "Gerente Administrativo";
            bruto = 6000;
        }
        case 2 -> {
            nome = "Carlos RH";
            cargo = "Gerente de RH";
            bruto = 5500;
        }
        case 3 -> {
            nome = "José Motorista";
            cargo = "Motorista";
            bruto = 3200;
        }
        case 4 -> {
            nome = "Maria Atendente";
            cargo = "Atendente";
            bruto = 2200;
        }
        default -> {
            System.out.println("Opção inválida.");
            return;
        }
    }

    System.out.print("Documento do funcionário: ");
    String doc = sc.nextLine();
    double liquido = bruto * 0.85;

    PagamentoFuncionario pf = new PagamentoFuncionario(
            UUID.randomUUID().toString(), nome, doc, cargo, bruto, liquido, "Pendente"
    );
    pagamentos.add(pf);
    System.out.println("Pagamento cadastrado para " + nome);
        
    }
    
    public String listarPagamentos() {
    StringBuilder sb = new StringBuilder();
    for (PagamentoFuncionario p : pagamentos) {
        sb.append(p).append("\n");
    }
    return sb.toString();
    }
    
    public void atualizarStatusPagam() {
    for (PagamentoFuncionario p : pagamentos) {
        if (p.getStatusPagamento().equalsIgnoreCase("Pendente")) {
            p.setStatusPagamento("Pago");
        }
    }
    System.out.println("Pagamentos atualizados.");
    }
}
