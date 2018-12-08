public class AreaCalculatorApp {

    public static void main(String[] args) {

        Console.displayLine("Welcome to the Area Calculator\n");

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            String shapeType = Console.getString
                    ("Calculate the area of a circle, square, or rectangle? (c/s/r): ", "c", "s", "r");

            Shape shape;
            switch (shapeType) {
                case "c":
                case "C":
                    double radius = Console.getDouble("\nEnter radius: ");
                    shape = new Circle(radius);
                    Console.displayLine("\nThe area of the Circle you entered is " + shape.getArea());
                    break;
                case "s":
                case "S":
                    double width = Console.getDouble("\nEnter width: ");
                    shape = new Square(width);
                    Console.displayLine("\nThe area of the Square you entered is " + shape.getArea());
                    break;
                case "r":
                case "R":
                    width = Console.getDouble("\nEnter width: ");
                    double height = Console.getDouble("\nEnter height: ");
                    shape = new Rectangle(width, height);
                    Console.displayLine("\nThe area of the rectangle you entered is " + shape.getArea());
                    break;
            }

            choice = Console.getString("\nContinue? (y/n): ", "y", "n");
            Console.displayLine();
        }

    }
}
