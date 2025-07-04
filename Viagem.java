
package infobus;

import java.time.LocalDateTime;

public class Viagem {
    private String idViagem;
    private String statusViagem;
    private LocalDateTime dataHora;
    private Rota rota;

    // Construtor
    public Viagem(String idViagem, String statusViagem, LocalDateTime dataHora, Rota rota) {
        this.idViagem = idViagem;
        this.statusViagem = statusViagem;
        this.dataHora = dataHora;
        this.rota = rota;
    }

    // Getters
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

    // Setters
    public void setStatusViagem(String statusViagem) {
        this.statusViagem = statusViagem;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    // Método para exibir dados da viagem
    public void exibirDetalhes() {
        System.out.println("======= DADOS DA VIAGEM =======");
        System.out.println("ID da Viagem: " + idViagem);
        System.out.println("Status: " + statusViagem);
        System.out.println("Data e Hora: " + dataHora);
        System.out.println("--- Rota associada ---");
        rota.exibirDetalhes(); // reutiliza o método da classe Rota
        System.out.println("================================");
    }
}

