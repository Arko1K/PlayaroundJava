import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DaisyAndThePassword {

    public static void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] words = br.readLine().split(" ");
            System.out.println(getPasswordPossibility(words[0], words[1]));
        }
    }

    static String getPasswordPossibility(String S, String P) {
        int sLength = S.length(), pLength = P.length();
        if (sLength * 2 == pLength)
            for (int i = 0; i <= sLength; i++) {
                if (P.substring(i, i + sLength).equals(S) && (P.substring(0, i) + P.substring(i + sLength)).equals(S))
                    return "Possible";
            }
        return "Impossible";
    }

    static String getPasswordPossibility2(String S, String P) {
        int sLength = S.length(), pLength = P.length();
        if (sLength * 2 == pLength) {
            String replace = P.replace(S, "");
            if (replace.equals("") || replace.equals(S))
                return "Possible";
        }
        return "Impossible";
    }
}