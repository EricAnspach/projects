public class Calculator {

    private int int1;
    private int int2;
    private int int3;
    private double double1;
    private double double2;
    private double double3;

    public Calculator() {
        int1 = 0;
        int2 = 0;
        int3 = 0;
        double1 = 0;
        double2 = 0;
        double3 = 0;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public int getInt3() {
        return int3;
    }

    public void setInt3(int int3) {
        this.int3 = int3;
    }

    public double getDouble1() {
        return double1;
    }

    public void setDouble1(double double1) {
        this.double1 = double1;
    }

    public double getDouble2() {
        return double2;
    }

    public void setDouble2(double double2) {
        this.double2 = double2;
    }

    public double getDouble3() {
        return double3;
    }

    public void setDouble3(double double3) {
        this.double3 = double3;
    }

    public int getSum(int int1, int int2) {
        return int1 + int2;
    }

    public int getSum(int int1, int int2, int int3) {
        return int1 + int2 + int3;
    }

    public double getSum(double double1, double double2) {
        return double1 + double2;
    }

    public double getSum(double double1, double double2, double double3) {
        return double1 + double2 + double3;
    }
}
