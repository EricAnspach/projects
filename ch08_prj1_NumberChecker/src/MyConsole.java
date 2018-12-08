import java.util.Scanner;

public class MyConsole extends Console {

 //   private static Scanner sc = new Scanner(System.in);

    public MyConsole() {

    }

    @Override
    public String getString(String prompt, String s1, String s2) {

        String s = "";
        System.out.print(prompt);

        boolean isValid = false;
        while (!isValid) {

            s = sc.nextLine();
            if (s.equals("")){
                System.out.println("Error! This entry is required. Try again.");
            } else {
                if(s.equalsIgnoreCase(s1) || s.equalsIgnoreCase(s2)) {
                    isValid = true;
                } else {
                    System.out.println("Error! This entry is required. Try again.");
                }

            }
        }
        return s;
    }
}
