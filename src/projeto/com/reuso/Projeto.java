package projeto.com.reuso;

import java.util.HashSet;
import java.util.Set;

public class Projeto {
    private String nomeProjeto;
    private Set<String> linguagensDeProgramação = new HashSet<>();

    public Projeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public Set<String> getLinguagensDeProgramação() {
        return linguagensDeProgramação;
    }

    public void adicionaLinguagemDeProgramação(String lp) {
        linguagensDeProgramação.add(lp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Projeto projeto)) return false;

        return getNomeProjeto() != null ? getNomeProjeto().equals(projeto.getNomeProjeto()) : projeto.getNomeProjeto() == null;
    }

    @Override
    public int hashCode() {
        return getNomeProjeto() != null ? getNomeProjeto().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "nomeProjeto='" + nomeProjeto + '\'' +
                ", linguagensDeProgramação=" + linguagensDeProgramação +
                '}';
    }
}
