package projetoinfobus;

import java.util.ArrayList;
import java.util.List;

public class ControleVendas {
    private static List<Venda> vendas = new ArrayList<>();
    public static void registrarVenda(Venda venda){
        vendas.add(venda);
    }
    
    public static void listarVendas(){
         System.out.println("**** Lista de Vendas ****");
         for (Venda v : vendas){
             v.exibirResumoVenda();
         }
    }
    
    public static Venda buscarVendaPorId(String idVenda){
        for (Venda v : vendas){
            if(v.getIdVenda().equals(idVenda)){
                return v;
            }
        }
        return null;
    } 
    
    public static boolean removerVenda(String idVenda){
        Venda venda = buscarVendaPorId(idVenda);
        if (venda != null){
            vendas.remove(venda);
            return true;
        }
        return false;
    }
}

