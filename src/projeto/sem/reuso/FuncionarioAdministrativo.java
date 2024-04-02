package projeto.sem.reuso;

import java.util.Objects;

/**
 * Representa um funcionário qualquer, que é uma pessoa que exerce
 * uma função administrativa, tem uma matrícula, um salário e um
 * tempo de serviço.
 *
 * @author Raquel Lopes
 *
 */
public class FuncionarioAdministrativo {
    private String nome;
    private String cpf;
    private String matricula;
    private double salarioBase;
    private int tempoDeServico;
    private Funcao funcao;

    /**
     * Cria um funcionário.
     *
     * @param nome O nome do funcionário.
     * @param cpf O CPF do funcionário.
     * @param matricula A matrícula do funcionário.
     * @param tempoDeServico O tempo de serviço (em meses) do funcionário.
     */
    public FuncionarioAdministrativo(String nome, String cpf, String matricula, int tempoDeServico, Funcao funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.tempoDeServico = tempoDeServico;
        this.funcao = funcao;
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
     * Recupera a função do funcionário.
     *
     * @return A função atual do funcionário.
     */
    public Funcao getFuncao() {
        return funcao;
    }

    /**
     * Atribui uma nova função ao funcionário.
     *
     * @param funcao Nova função do funcionário.
     */
    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
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
     * Este método computa o salário do funcionário.
     *
     * @return O salário do funcionário;
     */
    public double computaSalario() {
        return salarioBase + gratificacaoPorTempoDeServico();
    }

    private double gratificacaoPorTempoDeServico() {
        double gratificacaoBase = 1.2 * funcao.getValor();
        return getTempoDeServico() * gratificacaoBase;
    }

    /**
     * Representa um funcionário como String.
     *
     * @return A string que representa um funcionário.
     */
    public String toString() {
        return "Nome " + getNome() + ", cpf " + getCPF() + ", matricula " + getMatricula();
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, matricula, nome);
    }

    /**
     * Testa a igualdade de um objeto com este funcionário. Dois objetos da classe
     * FuncionarioAdministrativo são iguais se eles possuem o mesmo nome, mesmo cpf
     * e têm a mesma matrícula.
     *
     * @param obj O objeto a comparar com este funcionário.
     * @return true se o objeto for igual a este funcionario, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof FuncionarioAdministrativo))
            return false;
        FuncionarioAdministrativo other = (FuncionarioAdministrativo) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(matricula, other.matricula)
                && Objects.equals(nome, other.nome);
    }
}
