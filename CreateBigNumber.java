package com.company;

public class CreateBigNumber {

    public CreateBigNumber(String num, int k) {
        Solution sol = new Solution();
        System.out.println(sol.solution(num,k));
    }

    class Solution {
        public String solution(String number, int k) {
            int x = k;
            StringBuilder answer = new StringBuilder();
            int len = number.length();
            int maxIdx;

            while (answer.length() < len - x) {
                maxIdx = 0;
                for (int i=1; i<=k; i++) {
                    maxIdx = number.charAt(i) > number.charAt(maxIdx) ? i : maxIdx;
                    if (number.charAt(maxIdx) == '9') {
                        break;
                    }
                }
                k -= maxIdx;
                answer.append(String.valueOf(number.charAt(maxIdx)));
                number = number.substring(maxIdx + 1);
                if (k < 1) {
                    answer.append(number);
                }
            }

            return answer.toString();
        }
    }
}
