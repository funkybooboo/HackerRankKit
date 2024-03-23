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

class Result3 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String string) {
        String[] times = string.split(":");
        String h = times[0];
        String m = times[1];
        String t = times[2];
        String s = String.valueOf(t.charAt(0)) + t.charAt(1);
        String x = String.valueOf(t.charAt(2));
        if (x.equals("A") && h.equals("12")) {
            h = "00";
        }
        else if (x.equals("P") && !h.equals("12")) {
            h = String.valueOf(Integer.parseInt(h) + 12);
        }
        return h + ":" + m + ":" + s;
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result3.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
