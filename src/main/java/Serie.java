
public class Serie {
    private String nome;
    private int temporadas;
    private double nota;

    public Serie(String nome, int temporadas, double nota) {
        this.nome = nome;
        this.temporadas = temporadas;
        this.nota = nota;
    }

    public String getNome() {
        return this.nome;
    }

    public int getTemporadas() {
        return this.temporadas;
    }

    public double getNota() {
        return this.nota;
    }

    public boolean isFinalizada() {
        return this.temporadas > 0;
    }
}