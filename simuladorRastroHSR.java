import java.util.Locale;
import java.util.Scanner;


public class SimuladorRastroHSR {
    
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        char resp;
        /*processo*/
        double tentativas = 0, tempoRastro = 0, qtdPoderNec = 0, tempoEspera = 0;
        /*entrada de dados*/
        int materRoxo, materAzul, qtdPoder, qtdCombus, qtdReserva, poderTotal = 0, horas = 0;
        char respMaisInfo;

        do{ 
            System.out.println();
            System.out.println("SIMULADOR DE RASTRO HSR");
            System.out.println();

            System.out.println("Quantidade de material roxo necessario: ");
            materRoxo = sc.nextInt();
            System.out.println("Quantidade de material azul necessario: ");
            materAzul = sc.nextInt();

            materRoxo += materAzul / 3;
            tentativas = Math.ceil(materRoxo / 3.5);
            double tempoTotalSeg = tentativas * 90;
            horas = (int) tempoTotalSeg / 3600;
            tempoRastro = ((int) tempoTotalSeg % 3600) / 60;
            qtdPoderNec = tentativas * 60;
            tempoEspera = Math.ceil((qtdPoderNec - poderTotal) * 6) / 60;

            System.out.println("Gostaria de colocar mais informacoes sobre a quantidade de P. de Desbravemnto que voce tem disponivel? (s/n)");
            respMaisInfo = sc.next().toLowerCase().charAt(0);
            System.out.println("---------------------------------------------");

            if (respMaisInfo == 's') {
                System.out.println("---------------------------------------------");
                System.out.println("Quantidade de poder de desbravamento: ");
                qtdPoder = sc.nextInt();
                System.out.println("Quantidade de combustivel: ");
                qtdCombus = sc.nextInt();
                System.out.println("Quantidade de reserva (de poder de desbravamento): ");
                qtdReserva = sc.nextInt();
                System.out.println("---------------------------------------------");

                poderTotal = qtdPoder + qtdReserva + (qtdCombus * 60);
                
                if (poderTotal < qtdPoderNec) {
                    System.out.printf("Poder de desbravamento total %d%n", poderTotal );
                    System.out.printf("Poder de desbravamento necessario %d%n", (int) qtdPoderNec );
                    System.out.printf("Tempo de espera: %.2fhoras%n", tempoEspera);
                    System.out.println("---------------------------------------------");
                    System.out.printf("Tentativas: %d%n", (int) tentativas );
                    System.out.printf("Tempo necessário: %dh e %dmin%n", horas, (int) tempoRastro);
                    System.out.println("---------------------------------------------");
                } else {
                    System.out.printf("Cálices necessários: %d%n", (int) tentativas );
                    System.out.printf("Qtd. de P. de Desbravamento %d%n", (int) qtdPoderNec );
                    System.out.printf("Tempo necessário: %dh e %dmin%n", horas, (int) tempoRastro);
                    System.out.println("---------------------------------------------");
                }
            } else {
                System.out.printf("Cálices necessários: %d%n", (int) tentativas );
                System.out.printf("Qtd. de P. de Desbravamento %d%n", (int) qtdPoderNec );
                System.out.printf("Tempo necessário: %dh e %dmin%n", horas, (int) tempoRastro);
                System.out.println("---------------------------------------------");
            }

            System.out.print("Deseja repetir? (s/n): ");
            resp = sc.next().charAt(0);
            System.out.println();

        } while(Character.toLowerCase(resp) == 's');
        sc.close();
    }
}

