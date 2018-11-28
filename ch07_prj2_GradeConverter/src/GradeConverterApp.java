public class GradeConverterApp {

    public static void main(String[] args) {

        String choice = "y";

        Console.displayLine("Welcome to the Letter Grade Converter\n");

        while (choice.equalsIgnoreCase("y")) {

            Grade grade = new Grade();

            int userEntry = Console.getInt("Enter numerical grade: ", 0, 100);
            grade.setNumber(userEntry);

            String letter = grade.getLetter(grade.getNumber());

            Console.displayLine("Letter grade: " + letter + "\n");

            choice = Console.getString("Continue? (y/n): ", "y", "n");
            Console.displayLine();
        }
    }

}
