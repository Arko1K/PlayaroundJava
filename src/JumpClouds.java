// https://www.hackerrank.com/challenges/jumping-on-the-clouds


import java.util.Scanner;

public class JumpClouds {

    public static void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        int moves = 0;
        for (int c_i = 0; c_i < n; c_i++)
            c[c_i] = in.nextInt();
        for (int i = 0; i < n - 1; i++) {
            if (i < n - 2 && (c[i + 1] == 1 || c[i + 2] == 0))
                ++i;
            ++moves;
        }
        System.out.println(moves);
    }
}