package _2016.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Id: Problem B
 * Problem Name: Revenge of the Pancakes
 * Year and round: 2016, Qualification Round
 * Problem URL: https://code.google.com/codejam/contest/6254486/dashboard#s=p1
 *
 * Make sure you rename the class to Solution and file to Solution.java before submitting
 * Accepted for both small and large inputs
 *
 * @author <a href="mailto:chitransh.saurabh18@gmail.com"> Saurabh, Chitransh </a>
 */
public class RevengeOfThePancakes {

    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int testCaseNo = 1; testCaseNo <= T; ++testCaseNo) {
            String s = reader.readLine();
            boolean[] pancakes = new boolean[s.length()];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                pancakes[i] = c == '+';
            }

            int noOfFlips = noOfFlips(pancakes, 0);
            System.out.println("Case #" + testCaseNo + ": " + noOfFlips);
        }
    }

    /**
     * Idea: Start traversing the boolean array from left side (index = 1) and whenever we see that the values changes the first time, we stop
     * Let's say this happens at firstValueChangeIndex
     * Now, we invert all the values from index = 0 to firstValueChangeIndex - 1, and reverse them as per the stack rules
     * If the value never changes, and all pancakes are happy side facing up, then we return 0
     * If the value never changes, and all pancakes are blank side facing up, then we return 1, to invert all of them at once
     */
    private static int noOfFlips (boolean[] pancakes, int previousFlips) {
        int firstValueChangeIndex = -1;

        for (int i = 1; i < pancakes.length; i++) {
            if (pancakes[i] != pancakes[0]) {
                firstValueChangeIndex = i;
                break;
            }
        }

        if (firstValueChangeIndex == -1) {
            if (pancakes[0]) {
                return previousFlips;           // if all pancakes are happy side up
            } else {
                return previousFlips + 1;       // if all pancakes are blank side up
            }
        }

        // invert value of pancakes[0 ..... firstValueChangeIndex-1] and then reverse
        for (int i = 0; i < firstValueChangeIndex; i++) {
            pancakes[i] = !pancakes[i];
        }

        int left = 0, right = firstValueChangeIndex - 1;
        while (left < right) {
            boolean temp = pancakes[left];
            pancakes[left] = pancakes[right];
            pancakes[right] = temp;
            left++;
            right--;
        }

        return noOfFlips(pancakes, previousFlips + 1);
    }
}
