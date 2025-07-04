
package infobus;

import java.util.ArrayList;
import java.util.List;

public class ControleFuncionarios {
    public static List<Funcionario> listaFuncionarios = new ArrayList<>();
    
    public static boolean autenticarFuncionario(String login, String senha){
        for(Funcionario f : listaFuncionarios){
            if (f.getId().equalsIgnoreCase(login) && f.getSenha().equals(senha)){
                return true; 
            }
        }
        return false; 
    }
    
    public static void adicionarFuncionario(Funcionario funcionario){
        listaFuncionarios.add(funcionario); 
    }
    
    public static Funcionario buscarPorId(String id){
        for (Funcionario f : listaFuncionarios) {
            if (f.getId().equalsIgnoreCase(id)){
                return f;
            }
        }
        return null; 
    }
    
    public static String identificarTipoFuncionario(String id) {
        if (id.startsWith("RH")) return "RH";
        if (id.startsWith("ADM")) return "ADM";
        if (id.startsWith("FIN")) return "FIN";
        if (id.startsWith("MOT")) return "MOT";
        if (id.startsWith("ATD")) return "ATD";
        return "DESCONHECIDO";
    }
}