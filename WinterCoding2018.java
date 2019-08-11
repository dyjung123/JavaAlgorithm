package com.company;

public class WinterCoding2018 {
    public WinterCoding2018(String direction) {
        Solution sol = new Solution();
        System.out.println(sol.solution(direction));
    }

    class Solution {
        boolean[][] horizontalMapMatrix;
        boolean[][] verticalMapMatrix;
        int x;
        int y;

        public int solution(String dirs) {
            horizontalMapMatrix = new boolean[11][10];
            verticalMapMatrix = new boolean[10][11];
            int answer = 0;
            x=0; //=> 위/아래로가면 45냐 55냐 둘중하나 양옆이면 54냐 55냐
            y=0;


            for (int i=0; i<dirs.length(); i++) {
                if (dirs.charAt(i) == 'U' && y < 5) {
                    if (!verticalMapMatrix[4-y][x+5]) {
                        answer++;
                        verticalMapMatrix[4-y][x+5] = true;
                    }
                    y++;
                } else if (dirs.charAt(i) == 'L' && x > -5) {
                    if (!horizontalMapMatrix[5-y][x+4]) {
                        answer++;
                        horizontalMapMatrix[5-y][x+4] = true;
                    }
                    x--;
                } else if (dirs.charAt(i) == 'D' && y > -5) {
                    if (!verticalMapMatrix[5-y][x+5]) {
                        answer++;
                        verticalMapMatrix[5-y][x+5] = true;
                    }
                    y--;
                } else if (dirs.charAt(i) == 'R' && x < 5) {
                    if (!horizontalMapMatrix[5-y][x+5]) {
                        answer++;
                        horizontalMapMatrix[5-y][x+5] = true;
                    }
                    x++;
                }
            }

            return answer;
        }
    }
}
