
package infobus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SistemaMain {
    
    public static void main(String[] args) throws ParseException{
        Scanner scanner = new Scanner(System.in);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc = sdf.parse("15/04/1985");
        
        GerenteADM gerenteADMpadrao = new GerenteADM( //LEMBRAR DE SUBSTITUIR PELO GERENTE DE RH!!!
        "ADM0001",
        "Nome",
        "000.000.000-00",
        "adm123",
        dataNasc,
        0000.0,
        "Turno",
        "Cargo",
        "0000-0000",
        "email@empresa.com"
    );
        
    ControleFuncionarios.adicionarFuncionario(gerenteADMpadrao);
        
        while(true){
            System.out.println("===== LOGIN DO SISTEMA =====");
            System.out.println("Insira seus dados abaixo. Se for novo usuário, digite 'Cadastrar' no campo."); 
            System.out.println("Login: ");
            String login = scanner.nextLine();
            
            System.out.println("Senha: ");
            String senha = scanner.nextLine();
            
            /*
            if(login.equalsIgnoreCase("Cadastrar")){
                cadastrarPassageiro(scanner); 
            } else if (login.contains("@")) { //é passageiro
                if(autenticarPassageiro(login, senha)){
                    menuPassageiro(scanner, login); 
                } else {
                    System.out.println("Login ou senha inválidos.");
                } 
            }
*/
            if (
                    login.startsWith("RH") ||
                    login.startsWith("ADM") ||
                    login.startsWith("FIN") ||
                    login.startsWith("MOT") ||
                    login.startsWith("ATD")
                ){ //é funcionário
                    if (ControleFuncionarios.autenticarFuncionario(login, senha)){
                        Funcionario user = ControleFuncionarios.buscarPorId(login);
                        
                        /*if (user instanceof GerenteRH) {
                            GerenteRH gerenteRH = (GerenteRH) user;
                            gerenteRH.menuGerenteRH(scanner);
                        } else*/ if (user instanceof GerenteADM) {
                            GerenteADM gerenteADM = (GerenteADM) user;
                            gerenteADM.menuGerenteADM(scanner);
                        } /*else if (user instanceof Financeiro) {
                            Financeiro fin = (Financeiro) user;
                            fin.menuFinanceiro(scanner);
                        } else if (user instanceof Motorista) {
                            Motorista mot = (Motorista) user;
                            mot.menuMotorista(scanner);
                        } else if (user instanceof Atendente) {
                            Atendente atd = (Atendente) user;
                            atd.menuAtendente(scanner);
                        } */else {
                            System.out.println("Tipo de funcionário não reconhecido.");
                        }
                    } else {
                        System.out.println("ID ou senha inválidos.");
                }
            }
        }     
    }
}
