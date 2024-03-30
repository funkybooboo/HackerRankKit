package Week2.Problem7;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result7 {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here

        int[] n = new int[26];

        for (int c : s.toCharArray()) {
            if (64 < c && c < 91) {
                c = c + 32;
            }
            if (96 < c && c < 123) {
                n[c-97] = n[c-97] + 1;
            }
        }
        boolean is_good = true;
        for (int i : n) {
            if (i == 0) {
                is_good = false;
                break;
            }
        }
        if (is_good) {
            return "pangram";
        }
        else {
            return "not pangram";
        }


    }

}

public class Solution7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result7.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
