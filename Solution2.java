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

class Result2 {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> array) {
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            int a = array.get(i);
            if (a < array.get(minIndex)) minIndex = i;
            else if (a > array.get(maxIndex)) maxIndex = i;
        }
        long min = 0;
        long max = 0;
        for (int i = 0; i < array.size(); i++) {
            int a = array.get(i);
            if (minIndex != i) max += a;
            if (maxIndex != i) min += a;
        }
        System.out.println(min + " " + max);
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        Result2.miniMaxSum(arr);
//
//        bufferedReader.close();
        List<Integer> array = new ArrayList<>();
        // 256741038 623958417 467905213 714532089 938071625
        array.add(7);
        array.add(1);
        array.add(60);
        array.add(2);
        array.add(1000);
        Result2.miniMaxSum(array);
    }
}
