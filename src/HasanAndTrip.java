// https://www.hackerearth.com/problem/algorithm/hasan-and-trip-1/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class HasanAndTrip {

    static int N;
    static int[][] coords;
    static Double score[][];

    public static void run() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coords = new int[N][3];
        score = new Double[N][N - 1];
        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            coords[i][0] = Integer.parseInt(nums[0]);
            coords[i][1] = Integer.parseInt(nums[1]);
            coords[i][2] = Integer.parseInt(nums[2]);
        }
        System.out.println(new DecimalFormat("#.######").format(coords[0][2] + getMaxScore(1, 0)));
    }

    static double getMaxScore(int index, int previousIndex) {
        if (index == N)
            return 0;
        if (score[index][previousIndex] == null) {
            if (index == N - 1)
                score[index][previousIndex] = coords[index][2] - cartesianDist(previousIndex, index);
            else {
                double gain = coords[index][2] - cartesianDist(previousIndex, index);
                if (true)
                    score[index][previousIndex] = Math.max(getMaxScore(index + 1, previousIndex), gain + getMaxScore(index + 1, index));
                else
                    score[index][previousIndex] = getMaxScore(index + 1, previousIndex);
            }
        }
        return score[index][previousIndex];
    }

    static double cartesianDist(int index1, int index2) {
        return Math.sqrt(Math.pow(coords[index1][0] - coords[index2][0], 2) + Math.pow(coords[index1][1] - coords[index2][1], 2));
    }
}