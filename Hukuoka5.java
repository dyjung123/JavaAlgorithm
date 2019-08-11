package com.company;

public class Hukuoka5 {
    public Hukuoka5() {
        Solution sol = new Solution();
        System.out.println(sol.solution(20));
    }
    class Solution {
        long[] arr;
        public long getBigNum(int n) {
            if (arr[n]==0) {
                long tmp1 = 2*getBigNum(n-2), tmp2 = 3*getBigNum(n-3);
                arr[n] = tmp1 > tmp2 ? tmp1 : tmp2;
            }

            return arr[n];
        }

        public long solution(int n) {
            long answer;
            arr = new long[101];
            arr[0] = 1;
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 2;
            arr[4] = 4;
            arr[5] = 6;
            arr[6] = 9;

            answer = getBigNum(n);
//            System.out.println(Math.log10(answer)/Math.log10(2));
            return answer;
        }
    }
}
