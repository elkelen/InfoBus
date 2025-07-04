
package infobus;

import java.util.List;

public class Rota {
    private String idRota;
    private String origem;
    private String destino;
    private int tempoPercurso; //em minutos
    private List<String> paradas; 

    public Rota(String idRota, String origem, String destino, int tempoPercurso, List<String> paradas) {
        this.idRota = idRota;
        this.origem = origem;
        this.destino = destino;
        this.tempoPercurso = tempoPercurso;
        this.paradas = paradas;
    }

    public String getIdRota() {
        return idRota;
    }

    public void setIdRota(String idRota) {
        this.idRota = idRota;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTempoPercurso() {
        return tempoPercurso;
    }

    public void setTempoPercurso(int tempoPercurso) {
        this.tempoPercurso = tempoPercurso;
    }

    public List<String> getParadas() {
        return paradas;
    }

    public void setParadas(List<String> paradas) {
        this.paradas = paradas;
    }
    
    // Método para exibir dados da rota
    public void exibirDetalhes() {
        System.out.println("====== DADOS DA ROTA ======");
        System.out.println("ID da Rota: " + idRota);
        System.out.println("Origem: " + origem);
        System.out.println("Destino: " + destino);
        System.out.println("Tempo de Percurso: " + tempoPercurso + " minutos");
        System.out.println("Paradas: ");
        if (paradas != null && !paradas.isEmpty()) {
            for (String parada : paradas) {
                System.out.println(" - " + parada);
            }
        } else {
            System.out.println("Sem paradas intermediárias.");
        }
        System.out.println("============================");
    }
}
