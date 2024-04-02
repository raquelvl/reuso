package projeto.com.reuso;

import java.util.ArrayList;
import java.util.List;

public class Programador extends Funcionario {
    private List<String> linguagensEmQuePrograma;
    private String linguagemDePreferencia;
    private Projeto projetoAtual;
    public Programador(String nome, String cpf, String matricula, double salarioBase, int tempoDeServico,
                       String linguagemPreferida, Projeto projeto) {
        super(nome, cpf, matricula, salarioBase, tempoDeServico);
        this.linguagensEmQuePrograma = new ArrayList<>();
        this.linguagemDePreferencia = linguagemPreferida;
        this.projetoAtual = projeto;
    }

    /**
     * Este método computa o salário do programador.
     *
     * @return O salário do funcionário;
     */
    public double computaSalario() {
        return getSalarioBase() * adicionalPorExperienciaProgramador();
    }

    private double adicionalPorExperienciaProgramador() {
        return ((double) getTempoDeServico() / 4) * 1.5 * linguagensEmQuePrograma.size();
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
}
