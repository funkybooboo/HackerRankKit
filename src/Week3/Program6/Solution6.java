package Week3.Program6;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result6 {

    /*
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        List<Integer> r = new ArrayList<>();
        r.add(-1);
        List<List<Integer>> valid = new ArrayList<>();
        if (sticks.size() < 3) return r;
        fillValid(sticks, valid);
        if (valid.isEmpty()) return r;
        if (valid.size() == 1) return valid.get(0);
        int max = getMax(valid);
        if (max == -1) return r;
        List<List<Integer>> biggest = getBiggest(valid, max);
        if (biggest.isEmpty()) return r;
        if (biggest.size() == 1) return biggest.get(0);
        int longestSide = getLongestSide(biggest);
        if (longestSide == -1) return r;
        List<List<Integer>> longest = getLongest(biggest, longestSide);
        if (longest.isEmpty()) return r;
        if (longest.size() == 1) return longest.get(0);
        int smallestSide = getSmallest(longest);
        if (smallestSide == Integer.MAX_VALUE) return r;
        List<List<Integer>> smallest = getSmallest(longest, smallestSide);
        if (smallest.isEmpty()) return r;
        return smallest.get(0);

    }

    private static List<List<Integer>> getSmallest(List<List<Integer>> longest, int smallestSide) {
        List<List<Integer>> smallest = new ArrayList<>();
        for (List<Integer> t : longest) {
            int a = t.get(0);
            int b = t.get(1);
            int c = t.get(2);
            if (a == smallestSide || b == smallestSide || c == smallestSide) {
                List<Integer> o = new ArrayList<>();
                o.add(a);
                o.add(b);
                o.add(c);
                smallest.add(o);
            }
        }
        return smallest;
    }

    private static int getSmallest(List<List<Integer>> longest) {
        int smallest = Integer.MAX_VALUE;
        for (List<Integer> t : longest) {
            int a = t.get(0);
            int b = t.get(1);
            int c = t.get(2);
            if (a < smallest) smallest = a;
            if (b < smallest) smallest = b;
            if (c < smallest) smallest = c;
        }
        return smallest;
    }

    private static List<List<Integer>> getLongest(List<List<Integer>> biggest, int longestSide) {
        List<List<Integer>> longest = new ArrayList<>();
        for (List<Integer> t : biggest) {
            int a = t.get(0);
            int b = t.get(1);
            int c = t.get(2);
            if (a == longestSide || b == longestSide || c == longestSide) {
                List<Integer> o = new ArrayList<>();
                o.add(a);
                o.add(b);
                o.add(c);
                longest.add(o);
            }
        }
        return longest;
    }

    private static int getLongestSide(List<List<Integer>> biggest) {
        int longestSide = -1;
        for (List<Integer> t : biggest) {
            int a = t.get(0);
            int b = t.get(1);
            int c = t.get(2);
            if (a > longestSide) longestSide = a;
            if (b > longestSide) longestSide = b;
            if (c > longestSide) longestSide = c;
        }
        return longestSide;
    }

    private static List<List<Integer>> getBiggest(List<List<Integer>> valid, int max) {
        List<List<Integer>> biggest = new ArrayList<>();
        for (List<Integer> t : valid) {
            int a = t.get(0);
            int b = t.get(1);
            int c = t.get(2);
            int p = a + b + c;
            if (p == max) {
                List<Integer> o = new ArrayList<>();
                o.add(a);
                o.add(b);
                o.add(c);
                biggest.add(o);
            }
        }
        return biggest;
    }

    private static int getMax(List<List<Integer>> valid) {
        int max = -1;

        for (List<Integer> t : valid) {
            int a = t.get(0);
            int b = t.get(1);
            int c = t.get(2);
            int p = a + b + c;
            if (p > max) max = p;
        }
        return max;
    }

    private static void fillValid(List<Integer> sticks, List<List<Integer>> valid) {
        for (int i = 0; i < sticks.size(); i++) {
            for (int j = 0; j < sticks.size(); j++) {
                for (int k = 0; k < sticks.size(); k++) {
                    if ((j == k) || (i == k) || (i == j)) continue;
                    int a = sticks.get(i);
                    int b = sticks.get(j);
                    int c = sticks.get(k);
                    if (a + b > c && a + c > b && b + c > a) {
                        List<Integer> o = new ArrayList<>();
                        o.add(a);
                        o.add(b);
                        o.add(c);
                        Collections.sort(o);
                        valid.add(o);
                    }
                }
            }
        }
    }

}

public class Solution6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result6.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
