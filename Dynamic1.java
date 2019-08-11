package com.company;

public class Dynamic1 {
    public Dynamic1(int N) {
        Solution sol = new Solution();
        System.out.println(sol.solution(N));
    }

    class Solution {
        public long[] arr;

        public long getSize(int num) {
            if (arr[num] > 0) {
                return arr[num];
            }

            if (num == 0) {
                return 0;
            } else if (num < 3) {
                return arr[num];
            }

            long ans = 0;
            if (arr[num - 1] > 0) {
                ans += arr[num-1];
            } else {
                arr[num-1] = getSize(num - 1);
                ans += arr[num-1];
            }

            if (arr[num - 2] > 0) {
                ans += arr[num - 2];
            } else {
                arr[num - 2] = getSize(num - 2);
                ans += arr[num - 2];
            }
            return ans;
        }

        public long calculate(int num) {
            return getSize(num) * 4 + getSize(num-1) * 2;
        }

        public long solution(int N) {
            long answer = 0;
            arr = new long[81];
            arr[1] = 1;
            arr[2] = 1;


            answer = calculate(N);

            return answer;
        }
    }
}
