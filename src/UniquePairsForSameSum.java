import java.util.Arrays;

public class UniquePairsForSameSum {

    static int run(int[] a, long k) {
        Arrays.sort(a);
        int l = 0, r = a.length - 1, prevL = Integer.MIN_VALUE, prevR = Integer.MAX_VALUE, count = 0;
        while (l < r) {
            if (a[l] + a[r] == k) {
                if (a[l] != prevL || a[r] != prevR)
                    ++count;
                prevL = a[l];
                prevR = a[r];
                l++;
                r--;
            } else if (a[l] + a[r] < k)
                l++;
            else
                r--;
        }
        return count;
    }
}