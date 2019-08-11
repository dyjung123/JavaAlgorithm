package com.company;

import java.util.ArrayList;

public class Hukuoka4 {
    public Hukuoka4() {
        Solution sol = new Solution();
        System.out.println(sol.solution(7));
    }

    class ExponentNbase {
        int base;
        int exponent;

        public ExponentNbase(int base, int exponent) {
            this.base = base;
            this.exponent = exponent;
        }
    }

    class Solution {
        long[] arr;

        public void getPow(int n) { // arr 배열의 n 인덱스의 요소가 무엇인가
            ArrayList<ExponentNbase> tmp = new ArrayList<>();
            ExponentNbase buffer = new ExponentNbase(0,0);
            int start=0, end=0;
            int nextBase = 4; // 아직은 큐에 들어가지 않은 제곱숫자중 가장 작은 base(밑).

            for (int i=1; i<=n; i++) {

                // 맨처음 큐에는 2의 2승과 3의 2승을 집어 넣는다.
                // 버퍼에는 비교 대상 숫자가 들어감.
                if (i==1) {
                    tmp.add(new ExponentNbase(2,2));
                    tmp.add(new ExponentNbase(3,2));
                    end+=2;
                    buffer = tmp.get(start);
                    start++;
                }

                // 1. 버퍼와 큐의 요소를 비교
                // 1-2. 버퍼가 작거나 같다면 배열에 버퍼의 숫자를 넣음.
                // 1-3. 그리고 버퍼의 exponent(지수)를 증가
                if (Math.pow(buffer.base,buffer.exponent) < Math.pow(tmp.get(start).base,tmp.get(start).exponent)) {
                    arr[i] = (long) Math.pow(buffer.base,buffer.exponent);
                    buffer.exponent++;
                }
                else if (Math.pow(buffer.base,buffer.exponent) == Math.pow(tmp.get(start).base,tmp.get(start).exponent)) {

                }
                // 2-2. 먼저 nextBase의 2승과 버퍼의 값을 비교하여 nextBase쪽이 작다면 nextBase의 2승을 버퍼에 넣고 이를 buffer쪽이 크지 않을 때 까지 반복.
                // 2-2. 큐의 요소가 크다면 큐에 버퍼에 있던 값을 넣음.
                // 2-3. 버퍼는 큐의 요소를 꺼내서 넣음.
                // 2-4. 배열에 버퍼의 숫자를 넣음.
                // 2-5. 버퍼의 exponent(지수)를 증가.
                else {
                    while (Math.pow(nextBase,2)<Math.pow(buffer.base,buffer.exponent)) {
                        tmp.add(new ExponentNbase(nextBase,2));
                        end++;
                        nextBase++;
                    }

                    tmp.add(buffer);
                    end++;
                    buffer = tmp.get(start);
                    start++;
                    arr[i] = (long) Math.pow(buffer.base,buffer.exponent);
                    buffer.exponent++;
                }
            }
        }
        public long solution(int n) {
            arr = new long[1000000];
            arr[0] = 1;
//            arr[1] = 4;
//            arr[2] = 8;
//            arr[3] = 9;
//            arr[4] = 16;
//            arr[5] = 25;
//            arr[6] = 27;
            long answer = 0;

            getPow(n-1);

            answer = arr[n-1];

            return answer;
        }
    }
}
