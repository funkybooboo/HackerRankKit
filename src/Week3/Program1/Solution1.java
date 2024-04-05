package Week3.Program1;

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

class Result1 {

    /*
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        if (A.isEmpty() || B.isEmpty()) return "NO";
        if (A.size() != B.size()) return "NO";
        List<Integer> Ap = new ArrayList<>();
        List<Integer> Bp = new ArrayList<>();
        for (int a : A) {
            int d = k - a;
            // find the minimum in B s.t. its bigger then d
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < B.size(); i++) {
                int b = B.get(i);
                if (b < min && b >= d) {
                    min = b;
                    index = i;
                }
            }
            if (index == -1) return "NO";
            B.remove(index);
            Ap.add(a);
            Bp.add(min);
        }
        // I know I dont need to do this check but why not ya know
        for (int i = 0; i < Ap.size(); i++) {
            if (Ap.get(i) + Bp.get(i) < k) return "NO";
        }
        return "YES";
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result1.twoArrays(k, A, B);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
