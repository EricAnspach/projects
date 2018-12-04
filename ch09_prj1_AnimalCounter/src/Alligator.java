public class Alligator extends Animal {

    public Alligator() {
    }

    @Override
    public void incrementCount() {
        count++;
    }

    @Override
    public void resetCount() {
        count = 1;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getCountString() {

        return getCount() + " alligator";
    }
}
