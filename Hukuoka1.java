package com.company;

public class Hukuoka1 {
    class Solution {
        public int solution(int[] fence) {
            int answer = 0;
            int tmp1=0, tmp2=0;

            for (int i=0; i<fence.length; i++) {
                if (i%2 == 0) {
                    if (fence[i]==0) {
                        tmp1++;
                    }
                } else {
                    if (fence[i]==1) {
                        tmp1++;
                    }
                }

                if (i%2 == 1) {
                    if (fence[i]==0) {
                        tmp2++;
                    }
                } else {
                    if (fence[i]==1) {
                        tmp2++;
                    }
                }
            }
            answer = tmp1 < tmp2 ? tmp1 : tmp2;

            return answer;
        }
    }
}
