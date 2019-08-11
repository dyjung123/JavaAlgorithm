package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Hukuoka2 {
    public Hukuoka2(int[] bombs) {
        Solution sol = new Solution();
        System.out.println(sol.solution(bombs));
    }
    class Solution {
        public int solution(int[] bombs) {
            ArrayList<Integer> arr = new ArrayList<>();
            int answer = 0, time = 1;
            for (int x: bombs) {
                arr.add(x);
            }

            arr.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1>o2?1:-1;
                }
            });
            for (int x: arr) {
                if (time>x) {
                    break;
                }
                answer++;
                time++;
            }
            return answer;
        }
    }
}
