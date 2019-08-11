package com.company;

import java.util.Arrays;

public class Dynamic2 {
    public Dynamic2(int[] left, int[] right) {
        Solution sol = new Solution();
        System.out.println(sol.solution(left, right));
    }

    class Solution {
        int[][] arr;

        public int getScore(int[] left, int[] right, int le, int ri) {
            if (arr[le][ri] > -1) {
                return arr[le][ri];
            }
            int lp = le;
            int rp = ri;
            int answer = 0;
            while (lp < left.length && rp < right.length) {
                if (left[lp] > right[rp]) {
                    answer += right[rp];
                    rp++;
                } else {
                    int two = getScore(left, right, lp + 1, rp + 1);
                    int one = getScore(left, right, lp + 1, rp);
                    answer += two > one ? two : one;
                    break;
                }
            }
            arr[le][ri] = answer;
            return answer;
        }

        public int solution(int[] left, int[] right) {
            int answer = 0;
            arr = new int[2000][2000];
            for (int[] row: arr) {
                Arrays.fill(row, -1);
            }

            answer = getScore(left, right, 0, 0);

            return answer;
        }
    }
}
