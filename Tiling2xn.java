package com.company;

public class Tiling2xn {
    class Solution {
        int[] recordCaseNum;

        public void getCaseNum(int n) {
            for (int i=0; i<=n; i++) {
                if (i <= 2) {
                    recordCaseNum[i] = i;
                } else {
                    recordCaseNum[i] = (recordCaseNum[i-1] + recordCaseNum[i-2]) % 1000000007;
                }
            }
        }

        public int solution(int n) {
            int answer = 0;
            recordCaseNum = new int[n+1];

            getCaseNum(n);

            answer = recordCaseNum[n];
            return answer;
        }
    }
}
