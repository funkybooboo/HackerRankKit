package Week3.Program3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution3 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String[] binaries = getInput();
        String binary1 = binaries[0];
        String binary2 = binaries[1];
        if (binary1.isEmpty() || binary2.isEmpty() || binary1.length() != binary2.length()) return;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < binary1.length(); i++) {
            boolean bit1 = Integer.parseInt(String.valueOf(binary1.charAt(i))) == 1;
            boolean bit2 = Integer.parseInt(String.valueOf(binary2.charAt(i))) == 1;
            stringBuilder.append(bit1 ^ bit2 ? 1 : 0);
        }
        setOutput(stringBuilder.toString());
    }

    private static void setOutput(String output) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
            bufferedWriter.write(output);
            bufferedWriter.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] getInput() {
        String[] binaries = new String[2];
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 2; i++) {
                binaries[i] = bufferedReader.readLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return binaries;
    }

}
