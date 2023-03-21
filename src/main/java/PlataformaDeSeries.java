import java.util.ArrayList;
import java.util.Scanner;

public class PlataformaDeSeries {
    private ArrayList<Serie> series;

    public PlataformaDeSeries() {
        this.series = new ArrayList<Serie>();
    }

    public void adicionarSerie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da série:");
        String nome = sc.nextLine();
        System.out.println("Digite o número de temporadas:");
        int temporadas = sc.nextInt();
        System.out.println("Digite a nota da série (de 0 a 10):");
        double nota = sc.nextDouble();
        Serie novaSerie = new Serie(nome, temporadas, nota);
        this.series.add(novaSerie);
        System.out.println("Série adicionada com sucesso!");
    }

    public void mostrarInformacoes() {
        System.out.println("=== Informações da plataforma ===");
        System.out.printf("Número total de séries: %d\n", this.series.size());
        double somaNotas = 0;
        int numSeriesComTresOuMaisTemporadas = 0;
        for (Serie serie : this.series) {
            System.out.printf("Série: %s\n", serie.getNome());
            System.out.printf("Número de temporadas: %d\n", serie.getTemporadas());
            System.out.printf("Nota: %.1f\n", serie.getNota());
            if (serie.isFinalizada() && serie.getTemporadas() > numSeriesComTresOuMaisTemporadas) {
                numSeriesComTresOuMaisTemporadas = serie.getTemporadas();
            }
            if (serie.getTemporadas() >= 3) {
                somaNotas += serie.getNota();
            }
        }
        System.out.printf("Número de séries com 3 ou mais temporadas: %d\n", numSeriesComTresOuMaisTemporadas);
        if (numSeriesComTresOuMaisTemporadas == 0) {
            System.out.println("Não há séries finalizadas com 3 ou mais temporadas.");
        } else {
            System.out.printf("Série com mais temporadas finalizadas: %s (%d temporadas)\n",
                    this.getSerieComMaisTemporadasFinalizadas(numSeriesComTresOuMaisTemporadas),
                    numSeriesComTresOuMaisTemporadas);
        }
        if (somaNotas == 0) {
            System.out.println("Não há séries com 3 ou mais temporadas.");
        } else {
            double media = somaNotas / this.getNumSeriesComTresOuMaisTemporadas();
            System.out.printf("Média aritmética de notas das séries com 3 ou mais temporadas: %.1f\n", media);
        }
    }

    private String getSerieComMaisTemporadasFinalizadas(int numTemporadas) {
        String nomeSerie = "";
        for (Serie serie : this.series) {
            if (serie.isFinalizada() && serie.getTemporadas() == numTemporadas) {
                nomeSerie = serie.getNome();
            }
        }
        return nomeSerie;
    }

    private int getNumSeriesComTresOuMaisTemporadas() {
        int numSeries = 0;
        for (Serie serie : this.series) {
            if (serie.getTemporadas() >= 3) {
                numSeries++;
            }
        }
        return numSeries;
    }
}