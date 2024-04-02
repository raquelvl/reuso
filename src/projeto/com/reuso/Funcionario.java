package projeto.com.reuso;

import java.util.Objects;

/**
 * Funcionário base da empresa.
 * @author raquelvigolvinolopes
 *
 */
public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected String matricula;
    private double salarioBase;
    protected int tempoDeServico;

    public Funcionario(String nome, String cpf, String matricula, double salarioBase, int tempoDeServico) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.salarioBase = salarioBase;
        this.tempoDeServico = tempoDeServico;
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
    public abstract double computaSalario();
    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", matricula=" + matricula + ", salarioBase=" + salarioBase + ", tempoDeServico=" + tempoDeServico + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;

        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }
}
