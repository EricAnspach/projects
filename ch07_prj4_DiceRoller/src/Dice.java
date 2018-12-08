public class Dice {

    private Die die1;
    private Die die2;

    public Dice() {
        die1 = new Die();
        die2 = new Die();
    }

    public int getSum() {
        return die1.getValue() + die2.getValue();
    }

    public void roll() {
        die1.roll();
        die2.roll();
    }

    public String printRoll() {
        String str = "\nDie 1: " + die1.getValue() + "\n" +
                    "Die 2: " + die2.getValue() + "\n" +
                    "Total: " + getSum() + "\n";
        if (getSum() == 2) {
            str += "Snake Eyes!";
        } else if (getSum() == 7) {
            str += "Craps!";
        } else if (getSum() == 12) {
            str += "Boxcars!";
        }
        return str;
    }
}
