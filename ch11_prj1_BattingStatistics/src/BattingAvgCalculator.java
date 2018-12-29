import java.text.NumberFormat;

public class BattingAvgCalculator {

    public static void main(String[] args) {

        Console.displayLine("Welcome to the Batting Average Calculator");

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            int timesAtBat = Console.getInt("\nEnter number of times at bat: ", 1, 30);
            Console.displayLine("\n0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");

            int[] results = new int[timesAtBat];
            double baseHits = 0.0;
            double totalBases = 0.0;

            for(int i = 0; i < timesAtBat; i++) {
                int resultEntry = Console.getInt("Result for at-bat " + (i+1) + ": ", 0, 4);
                results[i] = resultEntry;
            }

            for(int result : results) {
                if (result > 0) {
                    baseHits++;
                }
                totalBases += result;
            }

            double battingAvg = (baseHits / timesAtBat);
            double sluggingPercent = (totalBases / timesAtBat);

            NumberFormat number = NumberFormat.getNumberInstance();
            number.setMinimumFractionDigits(3);

            String battingAvgString = number.format(battingAvg);
            String sluggingPercentString = number.format(sluggingPercent);

            Console.displayLine("\nBatting average: " + battingAvgString);
            Console.displayLine("Slugging percent: " + sluggingPercentString);

            choice = Console.getString("\nAnother player? (y/n): ", "y", "n");

        }
        Console.displayLine("\nBye!");

    }

}
