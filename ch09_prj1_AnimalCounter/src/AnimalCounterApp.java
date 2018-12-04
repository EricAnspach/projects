public class AnimalCounterApp {

    public static void main(String[] args) {

        System.out.println("Counting alligators...");

        Alligator gator = new Alligator();

        count(gator, 3);

        System.out.println("\nCounting sheep...");

        try {
            Sheep s1 = new Sheep();
            s1.setName("Blackie");

            count(s1, 2);

            Sheep s2 = (Sheep) s1.clone();

            s2.setName("Dolly");

            count(s2, 3);
            count(s1,1);
        }
        catch (CloneNotSupportedException e) {
            System.out.println("Cloning error: " + e);
        }
    }

    public static void count(Countable c, int maxCount) {

        System.out.println();
        for (int i = 1; i <= maxCount; i++) {
            System.out.println(c.getCountString());
            c.incrementCount();
        }
        c.resetCount();
    }
}
