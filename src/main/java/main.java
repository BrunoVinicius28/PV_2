import java.util.Scanner;
public class main {
public static void main(String[] args) {
        PlataformaDeSeries plataforma = new PlataformaDeSeries();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        do {
        System.out.println("=== Menu ===");
        System.out.println("1 - Adicionar série");
        System.out.println("2 - Mostrar informações");
        System.out.println("3 - Sair");
        System.out.println("Digite a opção desejada:");
        opcao = sc.nextInt();
        switch (opcao) {
        case 1:
        plataforma.adicionarSerie();
        break;
        case 2:
        plataforma.mostrarInformacoes();
        break;
        case 3:
        System.out.println("Saindo...");
        break;
default:
        System.out.println("Opção inválida. Digite novamente.");
        }
        } while (opcao != 3);
        }
}
