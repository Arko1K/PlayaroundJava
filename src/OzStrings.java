import java.io.BufferedReader;
        import java.io.InputStreamReader;

public class OzStrings {

    static int[] os, zs;
    static int N;

    public static void run() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] nums = br.readLine().split(" ");
            N = Integer.parseInt(nums[0]);
            int o = Integer.parseInt(nums[1]), z = Integer.parseInt(nums[2]);
            String[] strings = br.readLine().split(" ");
            os = new int[N];
            zs = new int[N];
            for (int i = 0; i < N; i++) {
                String s = strings[i];
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == 'O')
                        os[i]++;
                    else
                        zs[i]++;
                }
            }
            System.out.println(getMaxScore(0, o, z));
        }
    }

    static int getMaxScore(int start, int remO, int remZ) {
        if (start == N || (remO <= 0 && remZ <= 0))
            return 0;
        if (os[start] > remO || zs[start] > remZ)
            return getMaxScore(start + 1, remO, remZ);
        return Math.max(1 + getMaxScore(start + 1, remO - os[start], remZ - zs[start]), getMaxScore(start + 1, remO, remZ));
    }
}