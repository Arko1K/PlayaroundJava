import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RodCutting {

    public static void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()), specialCount = 0;
            System.out.println(getSpecialCount(N));
            while (N > 1) {
                if (isSpecial(N))
                    ++specialCount;
                N = N / 2;
            }
            System.out.println(specialCount);
        }
    }

    private static boolean isSpecial(int N) {
        return N == 1 || (N % 2 != 0 && isSpecial(N / 2));
    }

    private static int getSpecialCount(int N) {
        int specialCount = 0;
        while (N > 1) {
            if (N % 2 != 0)
                ++specialCount;
            else
                specialCount = 0;
            N = N / 2;
        }
        return specialCount;
    }
}