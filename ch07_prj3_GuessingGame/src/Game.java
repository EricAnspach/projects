public class Game {

    private int number;
    private int guess;

    public Game() {
        this.number = 0;
        this.guess = 0;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFinishMessage(int tries) {

        String message = "You got it in " + tries + " tries.\n";

        if (tries <= 3) {
            message += "Great work! You are a mathmatical wizard!";
        } else if (tries <= 7) {
            message += "Not too bad! You've got some potential.";
        } else {
            message += "What took you so long? Maybe you should take some lessons.";
        }
        return message;
    }

    public int checkGuess(int min, int max) {
        int tries = 0;

        do {
            guess = Console.getInt("\nEnter number: ", min, max);
            String message = "";

            if (guess < number) {
                if (guess < number - 10) {
                    message += "Way too low!";
                } else {
                    message += "Too low!";
                }
            } else if (guess > number) {
                if (guess > number + 10) {
                    message += "Way too high!";
                } else {
                    message += "Too high!";
                }
            }

            Console.displayLine(message);
            tries++;
        } while (guess != number);

        return tries;
    }

}