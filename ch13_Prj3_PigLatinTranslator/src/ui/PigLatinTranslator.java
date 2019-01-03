package ui;

import util.Console;

public class PigLatinTranslator {

    public static void main(String[] args) {

        Console.displayLine("Pig Latin Translator");

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            String line = Console.getString("\nEnter a line: ");
            String[] words = line.split(" ");
            String pigLine = "";
            String[] symbols = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "@", "#", "$", "%", "^", "&", "*", "(", ")"};

            for (String w : words) {
                w = w.toLowerCase();

                while (w.endsWith(".") || w.endsWith(",") || w.endsWith("!") || w.endsWith("?")) {
                    w = w.substring(0, (w.length()-1));
                }

                // don't translate words with symbols
                boolean runLoop = true;
                while (runLoop) {
                	boolean hasSymbol = false;
                    for (int i = 0; i < symbols.length; i++) {
                        int index = w.indexOf(symbols[i]);
                        if (index > -1) {
                        	pigLine += w + " ";
                            runLoop = false;
                            hasSymbol = true;
                            break;
                        }
                    }
                    
                    if (!hasSymbol) {
                        // words that start with vowels
                        if (w.startsWith("a") || w.startsWith("e") || w.startsWith("i") || w.startsWith("0") || w.startsWith("u")) {
                            w += "way";
                        } else {
                            do {
                                String firstLetter = w.substring(0,1);
                                String restOfWord = w.substring(1);
                                w = restOfWord + firstLetter;
                            } while (!(w.startsWith("a") ||
                                    w.startsWith("e") ||
                                    w.startsWith("i") ||
                                    w.startsWith("o") ||
                                    w.startsWith("u") ||
                                    w.startsWith("y")));

                            w += "ay";
                        }
                        pigLine += w + " ";
                        runLoop = false;
					}                                        
                }                
            }

            Console.displayLine(pigLine);

            choice = Console.getString("\nAnother line? (y/n): ", "y", "n");
        }
    Console.displayLine("Bye!");
    }
}
