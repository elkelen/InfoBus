package projetoinfobus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GerenteRH extends Funcionario {

    public GerenteRH(String id, String nome, String cpf, String senha, Date dataNascimento, double salario,
                     String turnoTrab, String cargo, String telefone, String email) {
        super(id, nome, cpf, senha, dataNascimento, salario, turnoTrab, cargo, telefone, email);
    }

    public String cadastrarFunc(Funcionario f) {
        ControleFuncionarios.adicionarFuncionario(f);
        return "Funcionário cadastrado com sucesso: " + f.getNome();
    }

    public String removerFunc(String cpf) {
        for (Funcionario f : ControleFuncionarios.listaFuncionarios) {
            if (f.getCpf().equals(cpf)) {
                ControleFuncionarios.listaFuncionarios.remove(f);
                return "Funcionário removido com sucesso: " + f.getNome();
            }
        }
        return "Funcionário não encontrado.";
    }

    public String consultarFunc(String cpf) {
        for (Funcionario f : ControleFuncionarios.listaFuncionarios) {
            if (f.getCpf().equals(cpf)) {
                return "Funcionário encontrado: " + f.getNome() + ", Salário: R$" + f.getSalario();
            }
        }
        return "Funcionário não encontrado.";
    }

    public void atualizarDadosFunc(String cpf, String novoNome, double novoSalario) {
        for (Funcionario f : ControleFuncionarios.listaFuncionarios) {
            if (f.getCpf().equals(cpf)) {
                f.setNome(novoNome);
                f.setSalario(novoSalario);
                System.out.println("Dados atualizados com sucesso.");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public double calcularSalarioLiq() {
        double descontoINSS = getSalario() * 0.11;
        return getSalario() - descontoINSS;
    }

    public void listarFuncionarios() {
        System.out.println("--- Lista de Funcionários ---");
        for (Funcionario f : ControleFuncionarios.listaFuncionarios) {
            System.out.println(f.getNome() + " - CPF: " + f.getCpf() + " - Salário: R$" + f.getSalario());
        }
    }

    public void menuGerenteRH(Scanner scanner) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== MENU - GERENTE DE RH =====");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Consultar Funcionário");
            System.out.println("4. Atualizar Dados de Funcionário");
            System.out.println("5. Listar Funcionários");
            System.out.println("6. Calcular Salário Líquido");
            System.out.println("0. Sair e voltar ao login");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    try {
                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();

                        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                        String dataTexto = scanner.nextLine();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataNascimento = sdf.parse(dataTexto);

                        System.out.print("Salário: ");
                        double salario = Double.parseDouble(scanner.nextLine());

                        System.out.print("Turno de Trabalho: ");
                        String turno = scanner.nextLine();

                        System.out.print("Cargo: ");
                        String cargo = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        Funcionario novoFunc;

                        // Cria a subclasse correta baseada no prefixo do ID
                        String prefixo = id.length() >= 3 ? id.substring(0, 3).toUpperCase() : "";
                        switch (prefixo) {
                            case "RH0" -> novoFunc = new GerenteRH(id, nome, cpf, senha, dataNascimento, salario, turno, cargo, telefone, email);
                            case "ADM" -> novoFunc = new GerenteADM(id, nome, cpf, senha, dataNascimento, salario, turno, cargo, telefone, email);
                            case "ATD" -> novoFunc = new Atendente(id, nome, cpf, senha, dataNascimento, salario, turno, cargo, telefone, email);
                            case "MOT" -> {
                                System.out.print("CNH: ");
                                String cnh = scanner.nextLine();
                                System.out.print("Validade CNH: ");
                                String validadeCnh = scanner.nextLine();
                                System.out.print("Tipo CNH: ");
                                String tipoCnh = scanner.nextLine();
                                novoFunc = new Motorista(id, nome, cpf, senha, dataNascimento, salario, turno, cargo, telefone, email, cnh, validadeCnh, tipoCnh);
                            }
                            case "FIN" -> novoFunc = new Financeiro(id, nome, cpf, senha, dataNascimento, salario, turno, cargo, telefone, email);
                            default -> {
                                System.out.println("Prefixo do ID não reconhecido. Cadastro cancelado.");
                                continue;
                            }
                        }

                        String resultado = this.cadastrarFunc(novoFunc);
                        System.out.println(resultado);

                    } catch (ParseException e) {
                        System.out.println("Data inválida! Cadastro cancelado.");
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao ler número. Cadastro cancelado.");
                    }
                }

                case 2 -> {
                    System.out.print("CPF do funcionário a remover: ");
                    String cpfRemover = scanner.nextLine();
                    System.out.println(this.removerFunc(cpfRemover));
                }

                case 3 -> {
                    System.out.print("CPF do funcionário a consultar: ");
                    String cpfConsultar = scanner.nextLine();
                    System.out.println(this.consultarFunc(cpfConsultar));
                }

                case 4 -> {
                    try {
                        System.out.print("CPF do funcionário: ");
                        String cpfAtualizar = scanner.nextLine();

                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();

                        System.out.print("Novo salário: ");
                        double novoSalario = Double.parseDouble(scanner.nextLine());

                        this.atualizarDadosFunc(cpfAtualizar, novoNome, novoSalario);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao ler salário. Atualização cancelada.");
                    }
                }

                case 5 -> this.listarFuncionarios();

                case 6 -> {
                    double salarioLiq = this.calcularSalarioLiq();
                    System.out.println("Salário líquido do gerente RH: R$" + salarioLiq);
                }

                case 0 -> {
                    System.out.println("Saindo do menu RH e voltando ao login...");
                    return;
                }

                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
