package com.company;

public class Joystick {
    public Joystick(String name) {
        Solution sol = new Solution();
        System.out.println(sol.solution(name));
    }

    class Solution {
        public int solution(String name) {
            int answer = name.length()-1;
            int tmp1=0, tmp2=0, max=0, index=-1, tmpIdx=-1;

            for (int i=1; i<name.length(); i++) {

                if (name.charAt(i)=='A') {
                    if (tmpIdx==-1) {
                        tmpIdx=i;
                    }
                    tmp1++;
                } else {
                    if (tmp1 > max) {
                        index = tmpIdx; // A 블록의 시작 인덱스 기억
                        tmpIdx = -1; // 다시 A 블록이 나온다면 인덱스를 기억하기 위해 초기화
                        max = tmp1; // A블록의 사이즈
                        tmp1=0;
                    }
                }

                if (name.charAt(name.length()-i)=='A') {
                    tmp2++;
                } else {
                    tmp2=0;
                }
            }
            answer -= tmp1 > tmp2 ? tmp1 : tmp2;
            if (index != -1) {
                index = index-1 < name.length()-index-max ? index-1 : name.length()-index-max;
                answer = name.length() - 1 - max + index < answer ? name.length() - 1 - max + index : answer;
            }

            for (int i=0; i<name.length(); i++) {
                if (name.charAt(i) == 'A') {
                    continue;
                }

                if (name.charAt(i) > 'A' + 13) {
                    answer += 'Z' - name.charAt(i) + 1;
                } else {
                    answer += name.charAt(i) - 'A';
                }
            }
            return answer;
        }
    }
}
