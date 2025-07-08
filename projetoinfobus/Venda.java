package projetoinfobus;

import java.time.LocalDateTime;

 public class Venda {
     private String idVenda;
     private LocalDateTime dataHora;
     private double valor;
     private String formaPagamento;
     private Passagem passagem;
     private Atendente atendente;
     
     public Venda(String idVenda, LocalDateTime dataHora, double valor, String formaPagamento, Passagem passagem, Atendente atendente){
         this.idVenda = idVenda;
         this.dataHora = dataHora;
         this.valor = valor;
         this.formaPagamento = formaPagamento;
         this.passagem = passagem;
         this.atendente = atendente;
     }

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
    
    public void exibirResumoVenda(){
          System.out.println("***Resumo da Venda ***");
          System.out.println("ID da Venda: " + idVenda);
          System.out.println("Data/hora: " + dataHora);
          System.out.println("Valor: " + valor);
          System.out.println("Forma de Pagamento: " + formaPagamento);
          System.out.println("Passagem: " + passagem.getIdPassagem());
          System.out.println("Atendente: " + atendente.getNome());
          System.out.println("****************************************");     
    }   
}
