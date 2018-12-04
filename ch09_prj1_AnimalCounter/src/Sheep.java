public class Sheep extends Animal implements Cloneable {
    private String name;

    public Sheep() {
    }

    public Sheep(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return getCount() + " " + getName();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
