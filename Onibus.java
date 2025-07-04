
package infobus;

public class Onibus {
    private String idOnibus;
    private String placa;
    private String modelo;
    private double quilometragem;
    private int capacidade;
    private String tipoClasse;
    private String fabricante;

    public Onibus(String idOnibus, String placa, String modelo, double quilometragem,
                  int capacidade, String tipoClasse, String fabricante) {
        this.idOnibus = idOnibus;
        this.placa = placa;
        this.modelo = modelo;
        this.quilometragem = quilometragem;
        this.capacidade = capacidade;
        this.tipoClasse = tipoClasse;
        this.fabricante = fabricante;
    }

    public String getIdOnibus() {
        return idOnibus;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getTipoClasse() {
        return tipoClasse;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setTipoClasse(String tipoClasse) {
        this.tipoClasse = tipoClasse;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Método para exibir dados do ônibus
    public void exibirDetalhes() {
        System.out.println("======= DADOS DO ÔNIBUS =======");
        System.out.println("ID do Ônibus: " + idOnibus);
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Classe: " + tipoClasse);
        System.out.println("Capacidade: " + capacidade + " passageiros");
        System.out.println("Quilometragem: " + quilometragem + " km");
        System.out.println("================================");
    }
}

