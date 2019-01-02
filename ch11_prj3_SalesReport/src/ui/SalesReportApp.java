package ui;

import util.Console;

import java.text.NumberFormat;

public class SalesReportApp {

    public static void main(String[] args) {

        double[][] sales = {
                {1540.0, 2010.0, 2450.0, 1845.0}, // Region 1
                {1130.0, 1168.0, 1847.0, 1491.0}, // Region 2
                {1580.0, 2305.0, 2710.0, 1284.0}, // Region 3
                {1105.0, 4102.0, 2391.0, 1576.0}  // Region 4
        };

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        Console.displayLine("The Sales Report Application\n");

        Console.displayLine("Region\tQ1\t\t\tQ2\t\t\tQ3\t\t\tQ4");
        for (int i = 0; i < sales.length; i++) {
            System.out.print((i+1) + "\t\t");
            for (int j = 0; j < 4; j++) {
                System.out.print(currency.format(sales[i][j]) + "\t");
            }
            System.out.println();
        }

        Console.displayLine("\nSales by region:");
        for (int i = 0; i < sales.length; i++) {
            double sum = 0.0;
            for (int j = 0; j < 4; j++) {
                sum += sales[i][j];
            }
            Console.displayLine("Region " + (i+1) + ": " + currency.format(sum));
        }

        Console.displayLine("\nSales by quarter:");
        for (int j = 0; j < 4; j++) {
            double sum = 0.0;
            for (int i = 0; i < sales.length; i++) {
                sum += sales[i][j];
            }
            Console.displayLine("Q" + (j+1) + ": " + currency.format(sum));
        }

        double totalSales = 0.0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < 4; j++) {
                totalSales += sales[i][j];
            }
        }
        Console.displayLine("\nTotal sales: " + currency.format(totalSales));
    }

}
