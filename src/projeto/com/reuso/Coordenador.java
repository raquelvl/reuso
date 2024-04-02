package projeto.com.reuso;

import java.util.ArrayList;
import java.util.List;

public class Coordenador extends Funcionario {
    private List<Projeto> projetosQueGerencia;

    public Coordenador(String nome, String cpf, String matricula, double salarioBase, int tempoDeServico) {
        super(nome, cpf, matricula, salarioBase, tempoDeServico);
        this.projetosQueGerencia = new ArrayList<>();
    }

    // implemenação **obrigatória** do método abstrado de Funcionario
    @Override
    public double computaSalario() {
        return getSalarioBase() * 2.2 + adicionalPorTempoDeServico();
    }

    double adicionalPorTempoDeServico() {
        return ((double) getTempoDeServico() / 5) * 1.5;
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
        return "Nome " + getNome() + ", cpf " + getCPF() + ", matricula " + getMatricula() + ", projetos que gerencia " + projetosQueGerencia;
    }
}
