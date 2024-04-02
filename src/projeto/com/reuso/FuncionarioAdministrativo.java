package projeto.com.reuso;

/**
 * Representa um funcionário qualquer, que é uma pessoa que exerce uma função
 * administrativa, tem uma matrícula, um salário e um tempo de serviço.
 *
 * @author Raquel Lopes
 *
 */
public class FuncionarioAdministrativo extends Funcionario {
    private Funcao funcao;

    public FuncionarioAdministrativo(String nome, String cpf, String matricula, double salarioBase, int tempoDeServico, Funcao funcao) {
        super(nome, cpf, matricula, salarioBase, tempoDeServico);
        this.funcao = funcao;
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
     * Este método computa o salário do funcionário.
     *
     * @return O salário do funcionário;
     */
    public double computaSalario() {
        return getSalarioBase() + gratificacaoPorTempoDeServico();
    }

    private double gratificacaoPorTempoDeServico() {
        double gratificacaoBase = 1.2 * funcao.getValor();
        return getTempoDeServico() / 3 * gratificacaoBase;
    }

    /**
     * Representa um funcionário como String.
     *
     * @return A string que representa um funcionário.
     */
    public String toString() {
// return super.toString() + ", matricula " + getMatricula();
        return "Nome " + getNome() + ", cpf " + getCPF() + ", matricula " + getMatricula();
    }
}
