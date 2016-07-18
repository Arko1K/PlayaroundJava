// https://www.hackerrank.com/challenges/bigger-is-greater


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BiggerIsGreater {

    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String w = br.readLine();
            boolean swap = false;
            // Find position where previous character is smaller than current character
            // This means that a lexicographically greater string is possible
            for (int i = w.length() - 1; i > 0; i--) {
                if (w.charAt(i - 1) < w.charAt(i)) {
                    char[] remaining = w.substring(i - 1).toCharArray();
                    Arrays.sort(remaining);
                    int pivot = -2;
                    StringBuilder result = new StringBuilder();
                    for (int j = 0; j < remaining.length; j++) {
                        // Pivot holds position of character which can be replaced by the next immediately greater character in the remaining set
                        if (remaining[j] == w.charAt(i - 1))
                            pivot = j;
                        if (j != pivot + 1)
                            result.append(remaining[j]);
                    }
                    // Final result is string before pivot + next greater character at pivot + remaining characters sorted in ascending order
                    System.out.println(w.substring(0, i - 1) + remaining[pivot + 1] + result);
                    swap = true;
                    break;
                }
            }
            if (!swap)
                System.out.println("no answer");
        }
    }
}
