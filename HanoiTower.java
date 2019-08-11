package com.company;

import java.util.ArrayList;

public class HanoiTower {
    public HanoiTower() {

    }
    class Solution {
        ArrayList<ArrayList<Integer>> tmp;
        public void hanoi(int n,int a, int b, int c) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            if (n == 1) {
                ans.add(a);
                ans.add(c);
                tmp.add(ans);
                return;
            }
            hanoi(n-1,a,c,b);
            ans.add(a);
            ans.add(c);
            tmp.add(ans);
            hanoi(n-1,b,a,c);
        }

        public int[][] solution(int n) {
            tmp = new ArrayList<ArrayList<Integer>>();
            hanoi(n, 1, 2, 3);

            int[][] answer = new int[tmp.size()][tmp.get(0).size()];
            for (int i=0; i<tmp.size(); i++) {
                for (int j=0; j<tmp.get(0).size(); j++) {
                    answer[i][j] = tmp.get(i).get(j);
                }
            }

            return answer;
        }
    }
}
