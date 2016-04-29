import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class DifficultCharacters {

    static Integer[] counts = new Integer[26];

    public static void run() throws Exception {

        Integer[] chars = new Integer[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = 0;
            chars[i] = i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++)
                counts[(int) input.charAt(i) - 97]++;

            Arrays.sort(chars, new DiffComparator());

            for (Integer c : chars)
                System.out.print((char) (c + 97) + " ");
            System.out.println();

            if (T > 0)
                for (int i = 0; i < 26; i++)
                    counts[i] = 0;
        }
    }

    static class DiffComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer c1, Integer c2) {
            int compare = counts[c1].compareTo(counts[c2]);
            if (compare == 0)
                return c2.compareTo(c1);
            return compare;
        }
    }
}