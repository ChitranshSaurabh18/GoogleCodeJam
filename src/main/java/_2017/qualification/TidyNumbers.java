package _2017.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Id: Problem B
 * Problem Name: Tidy Numbers
 * Problem URL: https://code.google.com/codejam/contest/3264486/dashboard#s=p1
 *
 * Make sure you rename the class to Solution and file to Solution.java before submitting
 * Accepted for both small and large inputs
 *
 * @author Saurabh, Chitransh
 */
public class TidyNumbers {

    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(reader.readLine());
        for (int testCaseNo = 1; testCaseNo <= T; ++testCaseNo) {
            String numString = reader.readLine();

            long lastTidyNumber = lastTidyNumber(numString);
            System.out.println("Case #" + testCaseNo + ": " + lastTidyNumber);
        }
    }

    /**
     * 6231 -> 61,99 -> 60,99 -> 59,99
     * 6099 -> 59,99
     * 680031 -> 679,999
     */
    private static long lastTidyNumber (String string) {
        int n = string.length();
        if (n == 1) {
            return Long.parseLong(string);
        }

        for (int i = 1; i < n; i++) {
            if (string.charAt(i - 1) > string.charAt(i)) {
                String leftPart = String.valueOf(Long.parseLong(string.substring(0, i + 1)) - 1);
                String rightPart = repeat('9', n - i - 1);
                return lastTidyNumber(leftPart + rightPart);
            }
        }

        return Long.parseLong(string);
    }

    private static String repeat (char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
