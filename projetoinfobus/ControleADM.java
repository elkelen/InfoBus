
package projetoinfobus;

import java.util.ArrayList;
import java.util.List;

public class ControleADM {
    
}

class ControleRotas {
    private static List<Rota> rotas = new ArrayList<>();

    public static void cadastrarRota(Rota rota) {
        rotas.add(rota);
    }

    public static boolean removerRota(String idRota) {
        return rotas.removeIf(r -> r.getIdRota().equalsIgnoreCase(idRota));
    }

    public static Rota buscarRotaPorId(String idRota) {
        for (Rota r : rotas) {
            if (r.getIdRota().equalsIgnoreCase(idRota)) {
                return r;
            }
        }
        return null;
    }

    public static void listarRotas() {
        for (Rota r : rotas) {
            r.exibirDetalhes();
        }
    }

    public static List<Rota> getRotas() {
        return rotas;
    }
}

class ControleViagens {
    private static List<Viagem> viagens = new ArrayList<>();

    public static void cadastrarViagem(Viagem viagem) {
        viagens.add(viagem);
    }

    public static boolean removerViagem(String idViagem) {
        return viagens.removeIf(v -> v.getIdViagem().equalsIgnoreCase(idViagem));
    }

    public static Viagem buscarViagemPorId(String idViagem) {
        for (Viagem v : viagens) {
            if (v.getIdViagem().equalsIgnoreCase(idViagem)) {
                return v;
            }
        }
        return null;
    }

    public static void listarViagens() {
        for (Viagem v : viagens) {
            v.exibirDetalhes();
        }
    }

    public static List<Viagem> getViagens() {
        return viagens;
    }
}

class ControleOnibus {
    private static List<Onibus> onibusList = new ArrayList<>();

    // Cadastrar ônibus
    public static void cadastrarOnibus(Onibus onibus) {
        onibusList.add(onibus);
    }

    // Remover ônibus por ID
    public static boolean removerOnibus(String idOnibus) {
        return onibusList.removeIf(o -> o.getIdOnibus().equalsIgnoreCase(idOnibus));
    }

    // Buscar ônibus por ID
    public static Onibus buscarOnibusPorId(String idOnibus) {
        for (Onibus o : onibusList) {
            if (o.getIdOnibus().equalsIgnoreCase(idOnibus)) {
                return o;
            }
        }
        return null;
    }

    // Alterar dados de um ônibus (exemplo simples)
    public static boolean alterarDadosOnibus(String idOnibus, String novoModelo, double novaQuilometragem,
                                             int novaCapacidade, String novaClasse, String novoFabricante) {
        Onibus o = buscarOnibusPorId(idOnibus);
        if (o != null) {
            o.setModelo(novoModelo);
            o.setQuilometragem(novaQuilometragem);
            o.setCapacidade(novaCapacidade);
            o.setTipoClasse(novaClasse);
            o.setFabricante(novoFabricante);
            return true;
        }
        return false;
    }

    // Registrar manutenção (simples — apenas incrementa quilometragem ou mensagem)
    public static boolean registrarManutencao(String idOnibus, double quilometragemAdicional) {
        Onibus o = buscarOnibusPorId(idOnibus);
        if (o != null) {
            double atual = o.getQuilometragem();
            o.setQuilometragem(atual + quilometragemAdicional);
            System.out.println("Manutenção registrada: nova quilometragem = " + o.getQuilometragem());
            return true;
        }
        return false;
    }

    // Emitir relatório de todos os ônibus
    public static void emitirRelatorioOnibus() {
        if (onibusList.isEmpty()) {
            System.out.println("Nenhum ônibus cadastrado.");
            return;
        }
        for (Onibus o : onibusList) {
            o.exibirDetalhes();
        }
    }

    // Getter para acesso externo (se necessário)
    public static List<Onibus> getOnibusList() {
        return onibusList;
    }
}
