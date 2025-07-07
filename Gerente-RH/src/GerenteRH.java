import java.util.ArrayList;
import java.util.Iterator;

public class GerenteRH extends Funcionario {

    
    private ArrayList<Funcionario> listaFuncionarios;

    public GerenteRH(String nome, String cpf, double salarioBruto, String id_rh) {
        super(nome, cpf, salarioBruto);
        this.id_rh = id_rh;
        this.listaFuncionarios = new ArrayList<>();
    }


   
    public String cadastrarFunc(Funcionario f) {
        listaFuncionarios.add(f);
        return "Funcionario cadastrado com sucesso: " + f.getNome();
    }

    
    public String removerFunc(String cpf) {
        Iterator<Funcionario> iterator = listaFuncionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario f = iterator.next();
            if (f.getCpf().equals(cpf)) {
                iterator.remove();
                return "Funcionario removido com sucesso: " + f.getNome();
            }
        }
        return "Funcionario nao encontrado.";
    }

   
    public String consultarFunc(String cpf) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getCpf().equals(cpf)) {
                return "Funcionario encontrado: " + f.getNome() + ", Salario: R$" + f.getSalarioBruto();
            }
        }
        return "Funcionario nao encontrado.";
    }

   
    public void atualizarDadosFunc(String cpf, String novoNome, double novoSalario) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getCpf().equals(cpf)) {
                f.setNome(novoNome);
                f.setSalarioBruto(novoSalario);
                System.out.println("Dados atualizados com sucesso.");
                return;
            }
        }
        System.out.println("Funcionario nao encontrado.");
    }

    
    public double calcularSalarioLiq() {
        double descontoINSS = getSalarioBruto() * 0.11;
        return getSalarioBruto() - descontoINSS;
    }

   
    public void listarFuncionarios() {
        System.out.println("--- Lista de Funcionarios ---");
        for (Funcionario f : listaFuncionarios) {
            System.out.println(f.getNome() + " - CPF: " + f.getCpf() + " - Salario: R$" + f.getSalarioBruto());
        }
    }
}
