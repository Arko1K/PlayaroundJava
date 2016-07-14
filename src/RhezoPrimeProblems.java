// https://www.hackerearth.com/thoughtworks-application-developer-hiring-challenge/algorithm/rhezo-and-prime-problems/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RhezoPrimeProblems {

    static boolean[] primes;
    static long[] cumulSum;
    static int N;
    static Long[][] cache;


    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] pointStr = br.readLine().split(" ");
        cumulSum = new long[N + 1];
        long sum = 0, maxSum = 0;
        for (int i = 0; i < N; ) {
            int point = Integer.parseInt(pointStr[i]);
            sum += point;
            cumulSum[++i] = sum;
        }

        // Generate primes
        primes = new boolean[N + 1];
        Arrays.fill(primes, true);
        for (int p = 2; p * p <= N; p++) {
            if (primes[p]) {
                for (int i = p * 2; i <= N; i += p)
                    primes[i] = false;
            }
        }

        cache = new Long[N][N + 1];
        for (int i = 0; i < N; i++) {
            sum = findMaxSum(i, 2);
            if (sum > maxSum)
                maxSum = sum;
        }
        System.out.println(maxSum);
    }

    static long findMaxSum(int from, int runningLen) {
        if (from + runningLen > N)
            return 0;
        if (cache[from][runningLen] == null) {
            if (primes[runningLen]) {
                long sum = cumulSum[from + runningLen] - cumulSum[from];
                cache[from][runningLen] = from + runningLen == N ? sum
                        : Math.max(sum + findMaxSum(from + runningLen + 1, 2), findMaxSum(from, runningLen + 1));
            } else
                cache[from][runningLen] = from + runningLen == N ? 0 : findMaxSum(from, runningLen + 1);
        }
        return cache[from][runningLen];
    }
}