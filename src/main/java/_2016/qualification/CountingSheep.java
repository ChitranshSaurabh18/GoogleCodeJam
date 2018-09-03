package _2016.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem Id: Problem A
 * Problem Name: Counting Sheep
 * Year and round: 2016, Qualification Round
 * Problem URL: https://code.google.com/codejam/contest/6254486/dashboard#s=p0
 *
 * Make sure you rename the class to Solution and file to Solution.java before submitting
 * Accepted for both small and large inputs
 *
 * @author <a href="mailto:chitransh.saurabh18@gmail.com"> Saurabh, Chitransh </a>
 */
public class CountingSheep {

    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int testCaseNo = 1; testCaseNo <= T; ++testCaseNo) {
            int n = Integer.parseInt(reader.readLine());

            long lastNumber = lastNumber(n);
            if (lastNumber == -1) {
                System.out.println("Case #" + testCaseNo + ": INSOMNIA");
            } else {
                System.out.println("Case #" + testCaseNo + ": " + lastNumber);
            }
        }
    }

    private static long lastNumber (int n) {
        if (n == 0) {
            return -1;
        }

        int increment = n;
        Set<Integer> allDigits = new HashSet<Integer>();
        while (true) {
            allDigits.addAll(digits(n));
            if (allDigits.size() == 10) {
                return n;
            }
            n = n + increment;
        }
    }

    private static Set<Integer> digits (int n) {
        Set<Integer> digits = new HashSet<Integer>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        return digits;
    }
}
