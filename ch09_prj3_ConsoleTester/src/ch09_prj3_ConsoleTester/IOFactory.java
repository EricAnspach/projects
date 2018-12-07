package ch09_prj3_ConsoleTester;

public class IOFactory {

	public IOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ConsoleIO getUserIO() {
		ConsoleIO consoleIO = new ConsoleIO();
		return consoleIO;
	}

}
