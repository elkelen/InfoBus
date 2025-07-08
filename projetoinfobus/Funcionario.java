
package projetoinfobus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario {
    private String id; 
    private String nome;
    private String cpf;
    private String senha; 
    private Date dataNascimento;
    private double salario;
    private String turnoTrab;
    private String cargo;
    private String telefone;
    private String email;
    private List<LocalDateTime> pontosRegistrados = new ArrayList<>();
    
    public Funcionario(String id, String nome, String cpf, String senha, Date dataNascimento, double salario, String turnoTrab, String cargo, String telefone, String email){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha; 
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.turnoTrab = turnoTrab;
        this.cargo = cargo;
        this.telefone = telefone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }    
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTurnoTrab() {
        return turnoTrab;
    }

    public void setTurnoTrab(String turnoTrab) {
        this.turnoTrab = turnoTrab;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void registrarPonto(LocalDateTime hora){
        pontosRegistrados.add(hora);
        System.out.println("Ponto registrado em: "+hora);
    }
    
    public void consultarContraCheque(){
        System.out.println("===== CONTRACHEQUE =====");
        System.out.println("Nome: "+this.nome);
        System.out.println("Cargo: "+this.cargo);
        System.out.println("Salário bruto: "+this.salario);
        System.out.println("========================");
    }
}
