import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VanyaGCDArray {

    static Integer[][] gcds = new Integer[100][100];
    static int A[];
    static int N;

    public static void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] numbs = br.readLine().split(" ");
        A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(numbs[i]);
        int subsTot = 0;
        for (int i = 0; i < N; i++)
            subsTot += subs(A[i], i + 1);
        System.out.println(subsTot);
    }

    static int subs(int runningGcd, int i) {
        if (i == N) {
            if (runningGcd == 1)
                return 1;
            return 0;
        }
        return (subs(runningGcd, i + 1) + subs(gcd(runningGcd, A[i]), i + 1)) % 1000000007;

    }

    static int gcd(int a, int b) {
        if (gcds[a][b] == null) {
            if (a == 0)
                gcds[a][b] = b;
            else
                gcds[a][b] = gcd(b % a, a);
        }
        return gcds[a][b];
    }
}