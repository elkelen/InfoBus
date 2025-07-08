package projetoinfobus;

import java.util.Date;

public class Passagem {
    private Integer idPassagem;
    private Date dataEmissao;
    private String situacao;            // Exemplo: "Vendida", "Cancelada"
    private Integer numeroPoltrona;
    private Float valor; 
    private Passageiro passageiro; 
    private Viagem viagem;        

    public Passagem(Integer idPassagem, String situacao, Passageiro passageiro, Viagem viagem, Integer numeroPoltrona, Float valor) {
        this.idPassagem = idPassagem;
        this.situacao = situacao;
        this.passageiro = passageiro;
        this.viagem = viagem;
        this.numeroPoltrona = numeroPoltrona;
        this.valor = valor; 
        this.dataEmissao = new Date();
    }

    public void imprimirDetalhes() {
        System.out.println("\n--- Detalhes da Passagem ---");
        System.out.println("ID: " + this.idPassagem);
        System.out.println("Passageiro: " + this.passageiro.getNome() + " (CPF: " + this.passageiro.getCpf() + ")");
        System.out.println("Situação: " + this.situacao);
        System.out.println("Poltrona: " + this.numeroPoltrona);
        System.out.println("--- Viagem ---");
        System.out.println("Origem: " + this.viagem.getRota().getOrigem());
        System.out.println("Destino: " + this.viagem.getRota().getDestino());
        System.out.println("Data/Hora: " + this.viagem.getDataHora());
        System.out.println("Ônibus: " + this.viagem.getOnibus().getModelo() + " | Placa: " + this.viagem.getOnibus().getPlaca());
        System.out.printf("Valor da Passagem: R$ %.2f%n", this.valor); 
        System.out.println("----------------------------");
    }

    // Getters
    public Integer getIdPassagem() { return idPassagem; }
    public Passageiro getPassageiro() { return passageiro; }
    public Viagem getViagem() { return viagem; }
    public Integer getNumeroPoltrona() { return numeroPoltrona; }
    public Float getValor() { return valor; }
    public String getSituacao() { return situacao; }

    // Setters
    public void setSituacao(String situacao) { this.situacao = situacao; }
}
