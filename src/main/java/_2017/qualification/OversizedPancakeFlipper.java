package _2017.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Id: Problem A
 * Problem Name: Oversized Pancake Flipper
 * Problem URL: https://code.google.com/codejam/contest/3264486/dashboard
 *
 * Make sure you rename the class to Solution and file to Solution.java before submitting
 * Accepted for both small and large inputs
 *
 * @author Saurabh, Chitransh
 */
public class OversizedPancakeFlipper {

    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int testCaseNo = 1; testCaseNo <= T; ++testCaseNo) {
            String[] split = reader.readLine().split("\\s+");

            // pancakes[i] = true denotes happy side facing up
            String pancakeString = split[0];
            boolean[] pancakes = new boolean[pancakeString.length()];
            for (int i = 0; i < pancakeString.length(); i++) {
                pancakes[i] = pancakeString.charAt(i) == '+';
            }

            int k = Integer.parseInt(split[1]);

            int flipsRequired = flipsRequired(pancakes, k);
            if (flipsRequired == -1) {
                System.out.println("Case #" + testCaseNo + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCaseNo + ": " + flipsRequired);
            }
        }
    }

    private static int flipsRequired (boolean[] pancakes, int k) {
        int flipsRequired = 0;
        for (int i = 0; i < pancakes.length; i++) {
            if (!pancakes[i]) {
                if (i + k <= pancakes.length) {
                    for (int j = i; j < i + k; j++) {
                        pancakes[j] = !pancakes[j];
                    }
                    flipsRequired++;
                } else {
                    return -1;
                }
            }
        }
        return flipsRequired;
    }
}
