import java.io.*;
import java.util.*;

public class Solution5 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Operations");
        System.out.println("S : Split");
        System.out.println("C : Combine");
        System.out.println("Types");
        System.out.println("M : Method");
        System.out.println("C : Class");
        System.out.println("V : Variable");
        System.out.println("Usage : operation;type;phrase");
        System.out.println("Example : S;M;plasticCup() -> plastic cup");
        System.out.println("Start:");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.isBlank() || input.isEmpty()) break;
            String[] parts;
            String operation;
            String type;
            String phrase;
            try {
                parts = input.split(";");
                operation = parts[0];
                type = parts[1];
                phrase = parts[2];
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("invalid input");
                continue;
            }
            // +32 : go to lower case
            // -32 : go to upper case
            switch (operation) {
                case "S" -> {
                    if (phrase.contains(" ")) {
                            System.out.println("invalid phase for operation and type");
                            continue;
                        }
                    switch (type) {
                        case "M", "V" -> {

                            for (char letter : phrase.toCharArray()) {
                                if (96 < letter && letter < 123) {
                                    System.out.print(letter);
                                } else if (64 < letter && letter < 94) {
                                    System.out.print(" " + (char) (letter + 32));
                                }
                            }
                        }
                        case "C" -> {
                            char[] letters = phrase.toCharArray();
                            System.out.print((char) (letters[0] + 32));
                            for (int i = 1; i < letters.length; i++) {
                                char letter = letters[i];
                                if (96 < letter && letter < 123) {
                                    System.out.print(letter);
                                } else if (64 < letter && letter < 94) {
                                    System.out.print(" " + (char) (letter + 32));
                                }
                            }
                        }
                            default -> {
                            System.out.println("invalid type");
                            continue;
                        }
                    }
                }
                case "C" -> {
                    if (!phrase.contains(" ")) {
                        System.out.println("invalid phase for operation and type");
                        continue;
                    }
                    boolean capitalize;
                    boolean perenthasies = false;
                    switch (type) {
                        case "M" -> {
                            capitalize = false;
                            perenthasies = true;
                        }
                        case "C" -> capitalize = true;
                        case "V" -> capitalize = false;
                        default -> {
                            System.out.println("invalid type");
                            continue;
                        }
                    }
                    for (char letter : phrase.toCharArray()) {
                        if (letter == 32) capitalize = true;
                        else {
                            if (capitalize) {
                                System.out.print((char)(letter - 32));
                                capitalize = false;
                            }
                            else {
                                System.out.print(letter);
                            }

                        }
                    }
                    if (perenthasies) System.out.print("()");
                }
                default -> {
                    System.out.println("invalid operation");
                    continue;
                }
            }
            System.out.println();
        }
    }
}