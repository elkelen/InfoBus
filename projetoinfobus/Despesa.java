/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoinfobus;

import java.time.LocalDate;

/**
 *
 * @author Maria Antônia
 */
public class Despesa {
    private String ID_despesa; 
    private String categoria; 
    private double valorDespesa; 
    private LocalDate data; 
    private String statusDespesa; 
    private String formaPagamento; 
    
    public Despesa(String id, String categoria, double valor, LocalDate data, String status, String forma ){
        this.ID_despesa = id; 
        this.categoria = categoria; 
        this.valorDespesa = valor; 
        this.data = data; 
        this.statusDespesa = status; 
        this.formaPagamento = forma; 
    }
    
    public String getCategoria(){return categoria;}
    public void setCategoria (String categoria){this.categoria = categoria;}
    
    public double getValorDespesa(){return valorDespesa;}
    public void setValorDespesa(double valorDespesa){this.valorDespesa = valorDespesa;}
    
    public String getStatusDespesa(){return statusDespesa;}
    public void setStatusDespesa(String statusDespesa){this.statusDespesa = statusDespesa;}
    
    public String getFormaPagamento(){return formaPagamento;}
    public void setFormaPagamento(String formaPagamento){this.formaPagamento = formaPagamento;}
    
    @Override
    public String toString(){
    return ID_despesa + " - "+categoria+ " - R$ "+valorDespesa+ " - "+data+ " - "+statusDespesa+" - "+formaPagamento; 
    }    
    
}
