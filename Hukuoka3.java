package com.company;

import java.util.*;

public class Hukuoka3 {
    public Hukuoka3(String p, int n) {
        Solution sol = new Solution();
        System.out.println(sol.solution(p, n));
    }
    public class Solution {

        public String solution(String p, int n) {
            StringBuilder answer = new StringBuilder();
            String morningAfternoon = p.substring(0,2);
            int hour = Integer.parseInt(p.substring(3,5));
            int minute = Integer.parseInt(p.substring(6,8));
            int second = Integer.parseInt(p.substring(9));

            if (morningAfternoon.equals("PM")) {
                if (hour!=12) {
                    hour += 12;
                }
            } else if (morningAfternoon.equals("AM")) {
                if (hour==12) {
                    hour = 0;
                }
            }

            int Total = hour * 3600 + minute * 60 + second + n;

            second = Total % 60;
            minute = (Total / 60) % 60;
            hour = Total / 3600;

            if (hour > 23) {
                hour = hour % 24;
            }

            if (hour < 10) {
                answer.append("0");
            }
            answer.append(Integer.toString(hour) + ":");

            if (minute < 10) {
                answer.append("0");
            }
            answer.append(Integer.toString(minute) + ":");

            if (second < 10) {
                answer.append("0");
            }
            answer.append(Integer.toString(second));

            return answer.toString();
        }
    }
}
