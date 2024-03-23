package Week1.Problem7;

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
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    // Write your code here
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            counts.add(0);
            String q = queries.get(i);
            for (String s : strings) {
                if (q.equals(s)) {
                    int j = counts.get(i);
                    counts.set(i, j + 1);
                }
            }
        }
        return counts;
    }

}

public class Solution7 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .collect(toList());
//
//        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .collect(toList());
//
//        List<Integer> res = Result7.matchingStrings(strings, queries);
//
//        bufferedWriter.write(
//            res.stream()
//                .map(Object::toString)
//                .collect(joining("\n"))
//            + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
        List<String> strings = new ArrayList<>();
        // abcde
        // sdaklfj
        //asdjf
        //na
        //basdn
        //sdaklfj
        //asdjf
        //na
        //asdjf
        //na
        //basdn
        //sdaklfj
        //asdjf
        strings.add("abcde");
        strings.add("sdaklfj");
        strings.add("asdjf");
        strings.add("na");
        strings.add("basdn");
        strings.add("sdaklfj");
        strings.add("asdjf");
        strings.add("na");
        strings.add("asdjf");
        strings.add("na");
        strings.add("basdn");
        strings.add("sdaklfj");
        strings.add("asdjf");




        List<String> queries = new ArrayList<>();
        // abcde
        //sdaklfj
        //asdjf
        //na
        //basdn
        queries.add("abcde");
        queries.add("sdaklfj");
        queries.add("asdjf");
        queries.add("na");
        queries.add("basdn");
        System.out.println(Result7.matchingStrings(strings, queries));
    }
}
