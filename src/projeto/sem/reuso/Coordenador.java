package projeto.sem.reuso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordenador {
    private String nome;
    private String cpf;
    private String matricula;
    private double salarioBase;
    private int tempoDeServico;
    private List<Projeto> projetosQueGerencia;

    public Coordenador(String nome, String cpf, String matricula, int tempoDeServico) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.tempoDeServico = tempoDeServico;
        projetosQueGerencia = new ArrayList<Projeto>();
    }

    /**
     * Recupera o nome do funcionário.
     *
     * @return O nome do funcionário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Recupera o CPF do funcionário.
     *
     * @return O CPF associado ao funcionário.
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * Atribui um novo nome ao funcionário.
     *
     * @param nome Novo nome do funcionário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Atribui um novo CPF ao funcionário.
     *
     * @param cpf Novo CPF associado ao funcionário.
     */
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Recupera a matrícula do funcionário.
     *
     * @return A matrícula do funcionário.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Atribui uma nova matrícula ao funcionário.
     *
     * @param matricula O valor da nova matrícula.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Recupera o salário base do funcionário.
     *
     * @return O salário do funcionário.
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * Atribui um novo salário base ao funcionário.
     *
     * @param salario O novo salário do funcionário.
     */
    public void setSalarioBase(double salario) {
        salarioBase = salario;
    }

    /**
     * Recupera o tempo de serviço em meses do funcionário.
     *
     * @return O tempo de serviço do funcionário.
     */
    public int getTempoDeServico() {
        return tempoDeServico;
    }
    /**
     * Atribui um novo tempo de serviço ao funcionário que deve ser maior que o
     * tempo de serviço anterior.
     *
     * @param tempoDeServico Novo valor para tempo de serviço.
     */
    public void setTempoDeServico(int tempoDeServico) {
        if (tempoDeServico > this.tempoDeServico)
            this.tempoDeServico = tempoDeServico;
    }

    /**
     * Este método computa o salário do coordenador.
     *
     * @return O salário do coordenador;
     */
    public double computaSalario() {
        return getSalarioBase() * 2.2 + adicionalPorTempoDeServico();
    }

    private double adicionalPorTempoDeServico() {
        return ((double) getTempoDeServico()/5) * 1.5;
    }

    /**
     * Faz este coordenador ser gerente de mais um projeto.
     *
     * @param proj O novo projeto que este coordenador irá gerenciar.
     * @return true caso o novo projeto não esteja ainda na lista de projetos e seja
     * adicionado com sucesso; false, caso contrário.
     */
    public boolean adicionaProjeto(Projeto proj) {
        if (projetosQueGerencia.contains(proj))
            return false;
        return projetosQueGerencia.add(proj);
    }

    /**
     * Faz este coordenador deixar de ser gerente de um projeto.
     *
     * @param proj O projeto que este coordenador não irá mais gerenciar.
     * @return true caso o projeto seja removido com sucesso; false, caso contrário.
     */
    public boolean removeProjeto(Projeto proj) {
        return projetosQueGerencia.remove(proj);
    }

    /**
     * Representa um coordenador como String.
     *
     * @return A string que representa este coordenador.
     */
    public String toString() {
        return "Nome " + getNome() + ", cpf " + getCPF() + ", matricula " + getMatricula() + ", projetos que gerencia "
                + projetosQueGerencia;
    }

    /**
     * Testa a igualdade de um objeto com este coordenador. Dois objetos da classe
     * Coordenador são iguais se eles possuem o mesmo nome, mesmo CPF e têm a mesma
     * matrícula.
     *
     * @param objeto O objeto a comparar com este coordenador.
     * @return true se o objeto for igual a este coordenador, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Coordenador))
            return false;
        Coordenador other = (Coordenador) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(matricula, other.matricula)
                && Objects.equals(nome, other.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, matricula, nome);
    }
}
