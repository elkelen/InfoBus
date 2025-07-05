/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setor.financeiro;

/**
 *
 * @author Maria Antônia
 */
public class PagamentoFuncionario {
    private final String ID_Pagamento; 
    private final String nomeFunc; 
    private final String docFunc; 
    private final String cargoFunc; 
    private final double salarioBruto; 
    private final double salarioLiq; 
    private String statusPagamento; 
    
    public PagamentoFuncionario(String id, String nome, String doc, String cargo, double bruto, double liq, String status){
        this.ID_Pagamento = id; 
        this.nomeFunc = nome; 
        this.docFunc= doc; 
        this.cargoFunc = cargo; 
        this.salarioBruto = bruto; 
        this.salarioLiq = liq; 
        this.statusPagamento = status; 
        
    }
    
    public String getStatusPagamento(){ return statusPagamento;}
    public void setStatusPagamento(String statusPagamento){this.statusPagamento = statusPagamento;}
    
    @Override
    public String toString(){
        return ID_Pagamento + " | " +nomeFunc + " | "+ cargoFunc+ " | Bruto: R$ "+salarioBruto+ " | Líquido: R$ "+salarioLiq+ "| Status: "+statusPagamento;
        
    }
    
}
