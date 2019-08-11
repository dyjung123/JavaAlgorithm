package com.company;

import java.util.Arrays;

public class FindPrimeNum {
    public FindPrimeNum(String numbers) {
        Solution sol = new Solution();
        System.out.println(sol.solution(numbers));
    }

    class Solution {
        public int isPrimeNum(int min,int max,String cardNum) {
            int amount = 0;
            boolean[] prime = new boolean[max+1];

            for (int i=min; i<=max; i++) {
                if (i<2) {
                    prime[i] = true;
                    continue;
                }
                if (!prime[i]) {
                    String num = Integer.toString(i);
                    String temp = cardNum;
                    boolean isPossibleNum = true;
                    for (int x=0; x< num.length(); x++) {
                        if (temp.indexOf(num.charAt(x)) > -1) {
                            temp = temp.replaceFirst(String.valueOf(num.charAt(x)),"");
                        } else {
                            isPossibleNum = false;
                            break;
                        }
                    }
                    if (isPossibleNum) {
                        amount++;
                    }

                    for (int j=i*2; j<=max; j+=i) {
                        prime[j] = true;
                    }
                }
            }

            return amount;
        }

        public int solution(String numbers) {
            int answer = 0;
            int max = 0, min = 0;
            int[] cardNum = new int[numbers.length()];
            for (int i=0; i<numbers.length(); i++) {
                cardNum[i] = (int)numbers.charAt(i);
                min = min > (int)numbers.charAt(i) ? (int)numbers.charAt(i) : min ;
            }
            Arrays.sort(cardNum);
            for (int i=cardNum.length-1; i>=0; i--) {
                max += Math.pow(10,i) * cardNum[i];
            }

            answer = isPrimeNum(min,max,numbers);

            return answer;
        }
    }
}
