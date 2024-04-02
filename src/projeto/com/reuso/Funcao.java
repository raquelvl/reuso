package projeto.com.reuso;

public enum Funcao {
    OFFICE_BOY(1), DONO(10), SERVICOS_GERAIS(2), SECRETARIA(2);

    private int valor;

    Funcao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

}
