package com.company;

import java.util.Arrays;

public class DevelopmentFunction {
    public DevelopmentFunction(int[] progresses, int[] speeds) {
        Solution sol = new Solution();
        System.out.println(sol.solution(progresses, speeds));
    }

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            int pointer = 0;
            int numOfDev = 1;
            int cur=0, temp=0;
            int[] tmp = new int[100];

            for (int i=0; i<progresses.length; i++) {
                temp = (int)Math.ceil((double)(100-progresses[i]) / speeds[i]);

                if (i == 0) {
                    cur = temp;
                    continue;
                }

                if (cur >= temp) {
                    numOfDev++;
                } else {
                    tmp[pointer++] = numOfDev;
                    numOfDev = 1;
                    cur = temp;
                }

                if(i==progresses.length-1) {
                    tmp[pointer++] = numOfDev;
                }
            }

            answer = Arrays.copyOfRange(tmp,0,pointer);


            return answer;
        }
    }
}
