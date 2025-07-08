
package projetoinfobus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GerenteADM extends Funcionario {

    public GerenteADM(String id, String nome, String cpf, String senha, Date dataNascimento, double salario,
                      String turnoTrab, String cargo, String telefone, String email) {
        super(id, nome, cpf, senha, dataNascimento, salario, turnoTrab, cargo, telefone, email);
    }

    // === ROTAS ===
    public void cadastrarRota(Rota rota) {
        ControleRotas.cadastrarRota(rota);
    }

    public void removerRota(String idRota) {
        if (!ControleRotas.removerRota(idRota)) {
            System.out.println("Rota não encontrada.");
        } else {
            System.out.println("Rota removida com sucesso.");
        }
    }


    public void alterarRota(String idRota, String novaOrigem, String novoDestino, int novoTempo, List<String> novasParadas) {
        Rota rota = ControleRotas.buscarRotaPorId(idRota);
        if (rota != null) {
            rota.setOrigem(novaOrigem);
            rota.setDestino(novoDestino);
            rota.setTempoPercurso(novoTempo);
            rota.setParadas(novasParadas);
        } else {
            System.out.println("Rota não encontrada.");
        }
    }

    // === VIAGENS ===
    public void cadastrarViagem(Viagem viagem) {
        ControleViagens.cadastrarViagem(viagem);
    }

    public void removerViagem(String idViagem) {
        if (!ControleViagens.removerViagem(idViagem)) {
            System.out.println("Viagem não encontrada.");
        } else {
            System.out.println("Viagem removida com sucesso.");
        }
    }

    public void alterarDadosViagem(String idViagem, String novoStatus, LocalDateTime novaDataHora, Rota novaRota) {
        Viagem viagem = ControleViagens.buscarViagemPorId(idViagem);
        if (viagem != null) {
            viagem.setStatusViagem(novoStatus);
            viagem.setDataHora(novaDataHora);
            viagem.setRota(novaRota);
        } else {
            System.out.println("Viagem não encontrada.");
        }
    }

    public void emitirRelatorioViagem() {
        ControleViagens.listarViagens();
    }

    // === ÔNIBUS ===
    public void cadastrarOnibus(Onibus onibus) {
        ControleOnibus.cadastrarOnibus(onibus);
    }

    public void removerOnibus(String idOnibus) {
        if (!ControleOnibus.removerOnibus(idOnibus)) {
            System.out.println("Ônibus não encontrado.");
        }
    }

    public void alterarDadosOnibus(String idOnibus, String novoModelo, double novaKm, int novaCapacidade, String novaClasse, String novoFabricante) {
        if (!ControleOnibus.alterarDadosOnibus(idOnibus, novoModelo, novaKm, novaCapacidade, novaClasse, novoFabricante)) {
            System.out.println("Ônibus não encontrado.");
        }
    }

    public void registrarManutencao(String idOnibus, double kmAdicional) {
        if (!ControleOnibus.registrarManutencao(idOnibus, kmAdicional)) {
            System.out.println("Ônibus não encontrado.");
        }
    }

    public void emitirRelatorioOnibus() {
        ControleOnibus.emitirRelatorioOnibus();
    }

    // === Cálculo de distância (exemplo simples, pode ser melhorado depois)
    public void calcularDistanciaPercorrida(String idOnibus) {
        Onibus o = ControleOnibus.buscarOnibusPorId(idOnibus);
        if (o != null) {
            System.out.println("Ônibus " + o.getIdOnibus() + " percorreu " + o.getQuilometragem() + " km.");
        } else {
            System.out.println("Ônibus não encontrado.");
        }
    }
    
    // === MENU ABAIXO ===
    
    public void menuGerenteADM(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n===== MENU - GERENTE ADMINISTRATIVO =====");
            System.out.println("1. Cadastrar Rota");
            System.out.println("2. Alterar Rota");
            System.out.println("3. Remover Rota");
            System.out.println("4. Listar Rotas");
            System.out.println("5. Cadastrar Viagem");
            System.out.println("6. Alterar Viagem");
            System.out.println("7. Remover Viagem");
            System.out.println("8. Listar Viagens");
            System.out.println("9. Cadastrar Ônibus");
            System.out.println("10. Alterar Ônibus");
            System.out.println("11. Remover Ônibus");
            System.out.println("12. Registrar Manutenção");
            System.out.println("13. Emitir Relatório de Ônibus");
            System.out.println("14. Calcular Distância Percorrida");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID da Rota: ");
                    String id = scanner.nextLine();
                    System.out.print("Origem: ");
                    String origem = scanner.nextLine();
                    System.out.print("Destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Tempo de percurso (min): ");
                    int tempo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Paradas (separadas por vírgula): ");
                    List<String> paradas = Arrays.asList(scanner.nextLine().split(",\\s*"));
                    Rota rota = new Rota(id, origem, destino, tempo, paradas);
                    this.cadastrarRota(rota);
                    System.out.println("Rota cadastrada com sucesso.");
                }
                case 2 -> {
                    System.out.print("ID da Rota para alterar: ");
                    String id = scanner.nextLine();
                    System.out.print("Nova origem: ");
                    String origem = scanner.nextLine();
                    System.out.print("Novo destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Novo tempo de percurso (min): ");
                    int tempo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novas paradas (separadas por vírgula): ");
                    List<String> paradas = Arrays.asList(scanner.nextLine().split(",\\s*"));
                    this.alterarRota(id, origem, destino, tempo, paradas);
                }
                case 3 -> {
                    System.out.print("ID da Rota para remover: ");
                    String id = scanner.nextLine();
                    this.removerRota(id);
                }
                case 4 -> ControleRotas.listarRotas();
                case 5 -> {
                    System.out.print("ID da Viagem: ");
                    String id = scanner.nextLine();
                    System.out.print("Status da Viagem: ");
                    String status = scanner.nextLine();
                    System.out.print("Data (AAAA-MM-DD): ");
                    String data = scanner.nextLine();
                    System.out.print("Hora (HH:MM): ");
                    String hora = scanner.nextLine();
                    LocalDateTime dataHora = LocalDateTime.parse(data + "T" + hora);

                    System.out.print("ID da Rota associada: ");
                    String idRota = scanner.nextLine();
                    Rota rota = ControleRotas.buscarRotaPorId(idRota);

                    System.out.print("ID do Ônibus associado: ");
                    String idOnibus = scanner.nextLine();
                    Onibus onibus = ControleOnibus.buscarOnibusPorId(idOnibus);

                    if (rota != null && onibus != null) {
                        Viagem viagem = new Viagem(id, status, dataHora, rota, onibus);
                        this.cadastrarViagem(viagem);
                        System.out.println("Viagem cadastrada com sucesso.");
                    } else {
                        if (rota == null) System.out.println("Rota não encontrada.");
                        if (onibus == null) System.out.println("Ônibus não encontrado.");
                    }
                }

                case 6 -> {
                    System.out.print("ID da Viagem para alterar: ");
                    String id = scanner.nextLine();
                    System.out.print("Novo status: ");
                    String status = scanner.nextLine();
                    System.out.print("Nova data (AAAA-MM-DD): ");
                    String data = scanner.nextLine();
                    System.out.print("Nova hora (HH:MM): ");
                    String hora = scanner.nextLine();
                    LocalDateTime dataHora = LocalDateTime.parse(data + "T" + hora);
                    System.out.print("ID da nova Rota: ");
                    String idRota = scanner.nextLine();
                    Rota novaRota = ControleRotas.buscarRotaPorId(idRota);
                    this.alterarDadosViagem(id, status, dataHora, novaRota);
                }
                case 7 -> {
                    System.out.print("ID da Viagem para remover: ");
                    String id = scanner.nextLine();
                    this.removerViagem(id);
                }
                case 8 -> ControleViagens.listarViagens();
                case 9 -> {
                    System.out.print("ID do Ônibus: ");
                    String id = scanner.nextLine();
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Quilometragem: ");
                    double km = scanner.nextDouble();
                    System.out.print("Capacidade: ");
                    int cap = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Classe (Executivo, Convencional, Leito...): ");
                    String classe = scanner.nextLine();
                    System.out.print("Fabricante: ");
                    String fabricante = scanner.nextLine();
                    Onibus onibus = new Onibus(id, placa, modelo, km, cap, classe, fabricante);
                    this.cadastrarOnibus(onibus);
                    System.out.println("Ônibus cadastrado com sucesso.");
                }
                case 10 -> {
                    System.out.print("ID do Ônibus para alterar: ");
                    String id = scanner.nextLine();
                    System.out.print("Novo modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Nova quilometragem: ");
                    double km = scanner.nextDouble();
                    System.out.print("Nova capacidade: ");
                    int cap = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nova classe: ");
                    String classe = scanner.nextLine();
                    System.out.print("Novo fabricante: ");
                    String fabricante = scanner.nextLine();
                    this.alterarDadosOnibus(id, modelo, km, cap, classe, fabricante);
                }
                case 11 -> {
                    System.out.print("ID do Ônibus para remover: ");
                    String id = scanner.nextLine();
                    this.removerOnibus(id);
                }
                case 12 -> {
                    System.out.print("ID do Ônibus para registrar manutenção: ");
                    String id = scanner.nextLine();
                    System.out.print("Quilometragem adicionada: ");
                    double kmAdicional = scanner.nextDouble();
                    scanner.nextLine();
                    this.registrarManutencao(id, kmAdicional);
                }
                case 13 -> this.emitirRelatorioOnibus();
                case 14 -> {
                    System.out.print("ID do Ônibus: ");
                    String id = scanner.nextLine();
                    this.calcularDistanciaPercorrida(id);
                }
                case 0 -> System.out.println("Saindo do menu...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

}

