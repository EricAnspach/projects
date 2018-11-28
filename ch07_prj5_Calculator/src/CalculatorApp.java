public class CalculatorApp {

    public static void main(String[] args) {

        Console.displayLine("Calculator App");
        Console.displayLine();

        Calculator calculator = new Calculator();
        boolean runApp = true;

        do {
            Console.displayLine("Menu:\n" +
                                "1 - Add 2 integer values\n" +
                                "2 - Add 3 integer values\n" +
                                "3 - Add 2 double values\n" +
                                "4 - Add 3 double values\n" +
                                "5 - Exit\n\n");

            int option = Console.getInt("Enter menu choice: ", 1, 5);
            int int1 = 0;
            int int2 = 0;
            int int3 = 0;
            double double1 = 0;
            double double2 = 0;
            double double3 = 0;

            switch (option) {
                case 1:
                    int1 = Console.getInt("Enter first integer: ");
                    calculator.setInt1(int1);
                    int2 = Console.getInt("Enter second integer: ");
                    calculator.setInt2(int2);
                    Console.displayLine("The sum of " + calculator.getInt1() + " and " + calculator.getInt2() + " is "
                            + calculator.getSum(calculator.getInt1(), calculator.getInt2()) + ".");
                    break;
                case 2:
                    int1 = Console.getInt("Enter first integer: ");
                    calculator.setInt1(int1);
                    int2 = Console.getInt("Enter second integer: ");
                    calculator.setInt2(int2);
                    int3 = Console.getInt("Enter third integer: ");
                    calculator.setInt3(int3);
                    Console.displayLine("The sum of " + calculator.getInt1() + ", " + calculator.getInt2()
                            + ", and " + calculator.getInt3() + " is "
                            + calculator.getSum(calculator.getInt1(), calculator.getInt2(), calculator.getInt3()) + ".");
                    break;
                case 3:
                    double1 = Console.getDouble("Enter first double value: ");
                    calculator.setDouble1(double1);
                    double2 = Console.getDouble("Enter second double value: ");
                    calculator.setDouble2(double2);
                    Console.displayLine("The sum of " + calculator.getDouble1() + " and " + calculator.getDouble2() + " is "
                            + calculator.getSum(calculator.getDouble1(), calculator.getDouble2()) + ".");
                    break;
                case 4:
                    double1 = Console.getDouble("Enter first double value: ");
                    calculator.setDouble1(double1);
                    double2 = Console.getDouble("Enter second double value: ");
                    calculator.setDouble2(double2);
                    double3 = Console.getDouble("Enter third double value: ");
                    calculator.setDouble3(double3);
                    Console.displayLine("The sum of " + calculator.getDouble1() + ", " + calculator.getDouble2()
                            + ", and " + calculator.getDouble3() + " is "
                            + calculator.getSum(calculator.getDouble1(), calculator.getDouble2(), calculator.getDouble3()) + ".");
                    break;
                case 5:
                    runApp = false;
                    break;
            }
            Console.displayLine();

        } while (runApp);

        Console.displayLine("Bye!");
    }

}
