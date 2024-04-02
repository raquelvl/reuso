package projeto.com.reuso;

import java.util.ArrayList;
import java.util.List;

public class FolhaDePagamento {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public boolean adicionaFuncionario(Funcionario funcionario) {
        return funcionarios.add(funcionario);
    }

    public double valorTotalDoPagamento() {
        double salarios = 0;
        for (Funcionario funcionario : funcionarios) {
//chamada abaixo é polimórfica 
            salarios += funcionario.computaSalario();
        }
        return salarios;
    }

    public String geraRelatorioDePagamentoDaFolha() {
        String str = "";
        for (Funcionario funcionario : funcionarios) {
            str += geraRegistroDePagamento(str, funcionario);
        }
        str += ("Valor total do pagamento: R$ " + valorTotalDoPagamento());
        return str;
    }
    private String geraRegistroDePagamento(String str, Funcionario funcionario) {
        str += funcionario.getMatricula();
        str += " - ";
        str += funcionario.getNome();
        str += " - R$ ";
//chamada abaixo é polimórfica
        str += funcionario.computaSalario();
        str += "\n";
        return str;
    }
}
