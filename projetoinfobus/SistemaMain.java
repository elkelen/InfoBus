package projetoinfobus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SistemaMain {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== USUÁRIOS CADASTRADOS PARA ACESSO AO SISTEMA ===\n");
        
        System.out.println("Usuário cadastrado para login:");
        System.out.println("Passageiro - Email: passageiro@info.com | Senha: 123\n");

        System.out.println("Funcionários cadastrados para login:");
        System.out.println("Gerente RH - ID: RH0001 | Senha: rh123");
        System.out.println("Gerente ADM - ID: ADM0001 | Senha: adm123");
        System.out.println("Motorista - ID: MOT0001 | Senha: mot123");
        System.out.println("Atendente - ID: ATD0001 | Senha: atd123");
        System.out.println("Financeiro - ID: FIN0001 | Senha: fin123");
        System.out.println("-------------------------------");
        
        Date dataNascPassageiro = new Date(); // para passageiro

        Login loginPassageiro = new Login("passageiro@info.com", "123");
        Passageiro passageiroPadrao = new Passageiro(
            "123.456.789-00",
            "Carlos Silva",
            "(11)91234-5678",
            dataNascPassageiro,
            loginPassageiro
        );

        // Adicionando ao menu de passageiros
        MenuPassageiro.adicionarPassageiroInicial(passageiroPadrao);

            // Gerente de RH padrão para login inicial
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc = sdf.parse("15/04/1985");

        GerenteRH gerenteRHpadrao = new GerenteRH(
                "RH0001",
                "Ana Souza",
                "000.000.000-00",
                "rh123",
                dataNasc,
                5000.0,
                "Diurno",
                "Gerente de RH",
                "(00)0000-0000",
                "rh@empresa.com"
        );
        ControleFuncionarios.adicionarFuncionario(gerenteRHpadrao);

        // Gerente Administrativo padrão
        GerenteADM gerenteADMpadrao = new GerenteADM(
                "ADM0001",
                "Carlos Silva",
                "111.111.111-11",
                "adm123",
                dataNasc,
                4800.0,
                "Noturno",
                "Gerente ADM",
                "(11)1111-1111",
                "adm@empresa.com"
        );
        ControleFuncionarios.adicionarFuncionario(gerenteADMpadrao);

        // Motorista padrão
        Motorista motoristaPadrao = new Motorista(
                "MOT0001",
                "João Oliveira",
                "222.222.222-22",
                "mot123",
                dataNasc,
                3000.0,
                "Diurno",
                "Motorista",
                "(22)2222-2222",
                "motorista@empresa.com",
                "12345678900",
                "31/12/2027",
                "D"
        );
        ControleFuncionarios.adicionarFuncionario(motoristaPadrao);

        // Atendente padrão
        Atendente atendentePadrao = new Atendente(
                "ATD0001",
                "Maria Santos",
                "333.333.333-33",
                "atd123",
                dataNasc,
                2500.0,
                "Tarde",
                "Atendente",
                "(33)3333-3333",
                "atendente@empresa.com"
        );
        ControleFuncionarios.adicionarFuncionario(atendentePadrao);

        // Financeiro padrão
        Financeiro financeiroPadrao = new Financeiro(
                "FIN0001",
                "Lucas Almeida",
                "444.444.444-44",
                "fin123",
                dataNasc,
                4200.0,
                "Manhã",
                "Financeiro",
                "(44)4444-4444",
                "financeiro@empresa.com"
        );
        ControleFuncionarios.adicionarFuncionario(financeiroPadrao);


            while (true) {
                System.out.println("\n===== LOGIN DO SISTEMA =====");
                System.out.print("Login (ou 'sair' para encerrar): ");
                String login = scanner.nextLine().trim();

                if (login.equalsIgnoreCase("sair")) {
                    System.out.println("Sistema encerrado.");
                    break;
                }

                System.out.print("Senha: ");
                String senha = scanner.nextLine().trim();

                if (login.startsWith("RH") || login.startsWith("ADM") || login.startsWith("FIN") ||
                    login.startsWith("MOT") || login.startsWith("ATD")) {

                    if (ControleFuncionarios.autenticarFuncionario(login, senha)) {
                        Funcionario user = ControleFuncionarios.buscarPorId(login);

                        if (user instanceof GerenteRH gerenteRH) {
                            gerenteRH.menuGerenteRH(scanner);
                        } else if (user instanceof GerenteADM gerenteADM) {
                            gerenteADM.menuGerenteADM(scanner);
                        } else if (user instanceof Financeiro fin) {
                            MenuFinanceiro menuFinanceiro = new MenuFinanceiro();
                            menuFinanceiro.menuFinanceiro(scanner, fin);
                        } else if (user instanceof Motorista mot) {
                            mot.menuMotorista(scanner); 
                        } else if (user instanceof Atendente atd) {
                            atd.menuAtendente(scanner); 
                        } else {
                            System.out.println("Tipo de funcionário não reconhecido.");
                        }

                    } else {
                        System.out.println("ID ou senha inválidos.");
                    }

                } else if (login.contains("@")) {
                    // Tratando login de passageiro (baseado em email)
                    if (login.equals("passageiro@info.com") && senha.equals("123")) {
                        MenuPassageiro menuPassageiro = new MenuPassageiro();
                        menuPassageiro.exibirMenu(scanner);
                    } else {
                        System.out.println("Email ou senha de passageiro incorretos.");
                    }

                } else {
                    System.out.println("Tipo de login não reconhecido. Verifique o ID.");
                }
            }

            scanner.close();
    }
}
