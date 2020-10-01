package com.labb1;
import java.util.Scanner;

public class Labb1TarningsSpel {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int antalSpelare;
        int antalKast;
        int antalSidorTarning = 6;
        int tarningKast;
        int indexVinnare;
        int[] highScoreLista = new int[50];
        int arrayIndex = 0;

        while (true) {
            System.out.println("Välkommen till tärningsspelet!");
            System.out.println("Hur många spelare? Tryck 0 för att avsluta");
            antalSpelare = scan.nextInt();

            if (antalSpelare == 0) {
                System.out.print("Spelet avslutas!");
                break;
            }

            System.out.println("Hur många tärningskast?");
            antalKast = scan.nextInt();

            int[] summaSpelare = new int[antalSpelare];

            for (int i = 0; i < antalSpelare; i++) {
                int summaTarningKast = 0;
                System.out.println("Spelare " + (i + 1));

                for (int j = 1; j <= antalKast; j++) {
                    tarningKast = (int) (1 + Math.random() * antalSidorTarning);

                    System.out.println("Kast " + j + ": " + tarningKast);
                    summaTarningKast += tarningKast;
                }
                summaSpelare[i] = summaTarningKast;
                System.out.println("Totalsumma: " + summaSpelare[i]);
                System.out.println("");
            }

            indexVinnare = 0;

            for (int i = 1; i < summaSpelare.length; i++) {
                if (summaSpelare[i] > summaSpelare[indexVinnare]) {
                    indexVinnare = i;
                }
            }

            System.out.println("Vinnare:");

            for (int i = indexVinnare; i < summaSpelare.length ; i++) {
                if (summaSpelare[i] == summaSpelare[indexVinnare]) {

                    System.out.println("Spelare " + (i+1) + " med " + summaSpelare[i] + " poäng");

                    highScoreLista[arrayIndex] = summaSpelare[i];
                    arrayIndex++;
                }
            }
            System.out.println("");

            printHighScore(highScoreLista, arrayIndex);
        }
    }
    static void printHighScore(int[] highScoreLista, int arrayIndex){

        for (int i = arrayIndex; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (highScoreLista[j] < highScoreLista[j + 1]) {
                    int temp = highScoreLista[j];
                    highScoreLista[j] = highScoreLista[j + 1];
                    highScoreLista[j + 1] = temp;
                }
            }
        }
        System.out.println("Highscorelista:");

        for (int i = 0; i < 3; i++) {
            System.out.println(highScoreLista[i]);
        }
        System.out.println("");
    }
}
