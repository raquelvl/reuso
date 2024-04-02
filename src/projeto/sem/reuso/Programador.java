package projeto.sem.reuso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Programador {
    private String nome;
    private String cpf;
    private String matricula;
    private double salarioBase;
    private int tempoDeServico;
    private List<String> linguagensEmQuePrograma;
    private String linguagemDePreferencia;
    private Projeto projetoAtual;

    public Programador(String nome, String cpf, String matricula, int tempoDeServico, String preferencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.tempoDeServico = tempoDeServico;
        linguagensEmQuePrograma = new ArrayList<String>();
        linguagemDePreferencia = preferencia;
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
     * Atribui um novo tempo de serviço ao programador que deve ser maior que o
     * tempo de serviço anterior.
     *
     * @param tempoDeServico Novo valor para tempo de serviço.
     */
    public void setTempoDeServico(int tempoDeServico) {
        if (tempoDeServico > this.tempoDeServico)
            this.tempoDeServico = tempoDeServico;
    }

    /**
     * Adiciona uma nova linguagem de programação conhecida pelo programador.
     *
     * @param lp A nova linguagem de programação que o programador conhece.
     */
    public void adicionaLinguagemConhecida(String lp) {
        if (!linguagensEmQuePrograma.contains(lp))
            linguagensEmQuePrograma.add(lp);
    }

    /**
     * Indica a participação do programador em um projeto.
     *
     * @param projeto O projeto em que o programador está inserido.
     */
    public void atribuiProjeto(Projeto projeto) {
        projetoAtual = projeto;
    }

    /**
     * Este método computa o salário do programador.
     *
     * @return O salário do funcionário;
     */
    public double computaSalario() {
        return getSalarioBase() * adicionalPorExperienciaProgramador();
    }

    private double adicionalPorExperienciaProgramador(){
        return ((double) getTempoDeServico()/4) * 1.5 * linguagensEmQuePrograma.size();
    }

    /**
     * Recupera a linguagem de preferência do programador
     *
     * @return A linguagem de preferência do programador
     */
    public String getLinguagemDePreferencia() {
        return linguagemDePreferencia;
    }

    /**
     * Atribui uma nova linguagem de preferência para o programador
     *
     * @param linguagemDePreferencia Novoa linguagem de preferência do programador
     */
    public void setLinguagemDePreferencia(String linguagemDePreferencia) {
        this.linguagemDePreferencia = linguagemDePreferencia;
    }

    /**
     * Representa um programador como String.
     *
     * @return A string que representa um programdor.
     */
    public String toString() {
        return "Nome " + getNome() + ", cpf " + getCPF() + ", matricula " + getMatricula() + ", projeto " + projetoAtual.getNomeProjeto();
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, matricula, nome);
    }

    /**
     * Testa a igualdade de um objeto com este programador. Dois objetos da classe
     * Programador são iguais se eles são possuem o mesmo nome, mesmo CPF e têm a
     * mesma matrícula.
     *
     * @param obj O objeto a comparar com este programador.
     * @return true se o objeto for igual a este programador, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Programador))
            return false;
        Programador other = (Programador) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(matricula, other.matricula)
                && Objects.equals(nome, other.nome);
    }
}
