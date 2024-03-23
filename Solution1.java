import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void plusMinus(List<Integer> array) {
        if (array.isEmpty()) {
            System.out.println(0);
            System.out.println(0);
            System.out.println(0);
        }
        int n = array.size();
        double positiveCount = 0;
        double zeroCount = 0;
        double negativeCount = 0;
        for (int i : array) {
            if (i < 0) negativeCount++;
            else if (i > 0) positiveCount++;
            else zeroCount++;
        }
        System.out.println(positiveCount / n);
        System.out.println(negativeCount / n);
        System.out.println(zeroCount / n);
    }
}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result1.plusMinus(arr);

        bufferedReader.close();
    }
}