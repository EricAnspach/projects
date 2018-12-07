package ch09_prj3_ConsoleTester;

import java.util.Scanner;

public class ConsoleIO implements UserIO {
	
	private static Scanner sc = new Scanner(System.in);
	
	public ConsoleIO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print(String s) {
		System.out.print(s);		
	}

	@Override
	public void println() {
		System.out.println();		
	}

	@Override
	public void println(String s) {
		System.out.println(s);		
	}

	@Override
	public int getInt(String prompt) {
        int i = 0;
        while (true) {
            System.out.print(prompt);
            try {
                i = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid integer. Try again.");
            }
        }
        return i;
	}

	@Override
	public int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
            if (i <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (i >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
	}

	@Override
	public double getDouble(String prompt) {
        double d = 0;
        while (true) {
            System.out.print(prompt);
            try {
                d = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid decimal. Try again.");
            }
        }
        return d;
	}

	@Override
	public double getDouble(String prompt, double min, double max) {
        double d = 0.0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(prompt);
            if (d <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (d >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
	}

	@Override
	public String getString(String prompt) {
		String s = "";
        System.out.print(prompt);
		boolean isValid = false;
		while (!isValid) {
			s = sc.nextLine();
			if (s.equals("")) {
				System.out.println("Error! This entry is required. Try again.");				
			} else {			
				isValid = true;				
			}			
		}		
		return s;
	}
	

	@Override
	public String getString(String prompt, String s1, String s2) {
		String s = "";
		System.out.print(prompt);
		
		boolean isValid = false;
		while (!isValid) {	
			s = sc.nextLine();
			if (s.equals("")) {				
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
