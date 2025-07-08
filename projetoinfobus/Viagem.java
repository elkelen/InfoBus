package projetoinfobus;

import java.time.LocalDateTime;

public class Viagem {
    private String idViagem;
    private String statusViagem;
    private LocalDateTime dataHora;
    private Rota rota;
    private Onibus onibus;  // <== adicionado

    public Viagem(String idViagem, String statusViagem, LocalDateTime dataHora, Rota rota, Onibus onibus) {
        this.idViagem = idViagem;
        this.statusViagem = statusViagem;
        this.dataHora = dataHora;
        this.rota = rota;
        this.onibus = onibus;
    }

    // getters
    public String getIdViagem() {
        return idViagem;
    }

    public String getStatusViagem() {
        return statusViagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Rota getRota() {
        return rota;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    // setters
    public void setStatusViagem(String statusViagem) {
        this.statusViagem = statusViagem;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public void exibirDetalhes() {
        System.out.println("======= DADOS DA VIAGEM =======");
        System.out.println("ID da Viagem: " + idViagem);
        System.out.println("Status: " + statusViagem);
        System.out.println("Data e Hora: " + dataHora);
        System.out.println("--- Rota associada ---");
        rota.exibirDetalhes();
        System.out.println("--- Ônibus associado ---");
        onibus.exibirDetalhes();
        System.out.println("================================");
    }
}
