package reuso.composicao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComposicaoEInicializacao {
    // Inicialização no momento da definição
    //aqui preciso saber qual é o nome, tenho que instanciar no construtor
    private String nome;
    private LocalDateTime agora = LocalDateTime.now();
    private int numero;

    private List<Integer> numeros = null;

    // Esta classe tem alguns prints fora do método main
// só por questões didáticas!
    public ComposicaoEInicializacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getAgora() {
        return agora;
    }

    public int getNumero() {
        return numero;
    }

    public List<Integer> getNumeros() {
        if(numeros == null) iniciaNumeros();
        return numeros;
    }

    private void iniciaNumeros() {
        numeros = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < 1000; i++) {
            numeros.add(rand.nextInt());
        }
    }

    @Override
    public String toString() {
        return "ComposicaoEInicializacao{" +
                "nome='" + nome + '\'' +
                ", agora=" + agora +
                ", numero=" + numero +
                ", numeros=" + numeros +
                '}';
    }

    public static void main(String[] args) {
        ComposicaoEInicializacao ci = new ComposicaoEInicializacao("Raquel");

        System.out.println(ci);
        System.out.print("\n---------------------------------------------\n");
        ci.getNumeros();//isso inicializa o campo numeros
        System.out.println(ci);
    }
}
