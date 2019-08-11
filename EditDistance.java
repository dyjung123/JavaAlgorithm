package com.company;

public class EditDistance {
    public EditDistance(String str1, String str2) {
        Solution sol = new Solution();
        System.out.println(sol.solution(str1, str2));
    }

    class Solution {

        public int min(int x, int y, int z) {
            int minNum = x > y ? y : x;
            return minNum > z ? z : minNum;
        }

        public int solution(String a, String b) {
            int answer = 0;
            int row = a.length()+1;
            int col = b.length()+1;
            int[][] arr = new int[row][col];

            //initialize
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if (i==0) {
                        arr[i][j] = j;
                    } else if (j==0) {
                        arr[i][j] = i;
                    } else {
                        arr[i][j] = -1;
                    }
                }
            }

            for (int i=1; i<row; i++) {
                for (int j=1; j<col; j++) {
                    if (a.charAt(i-1) == b.charAt(j-1)) {
                        arr[i][j] = arr[i-1][j-1];
                    } else {
                        arr[i][j] = min(arr[i-1][j]+1, arr[i][j-1]+1, arr[i-1][j-1]+1);
                    }
                }
            }

            answer = arr[row-1][col-1];

            return answer;
        }
    }
}
