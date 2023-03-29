class Solution {
    public static String solution(int[] ints, String hand) {
        StringBuilder answer = new StringBuilder("");

        //1 ~ 12 (1~9 * 0 #)
        int left = 10;
        int right = 12;
        for (int i = 0; i < ints.length; i++) {
            int now = ints[i];
            if(now == 0) now = 11;

            if(now % 3 == 1) {
                answer.append("L");
                left = now;
            }
            else if(now % 3 == 0) {
                answer.append("R");
                right = now;
            }
            else {
                //거리 계산
                int distL = Math.abs(left - now);
                distL = (distL % 3) + (distL / 3);

                int distR = Math.abs(right - now);
                distR = (distR % 3) + (distR / 3);

                if(distL < distR) {
                    left = now;
                    answer.append("L");
                }
                else if (distR < distL) {
                    right = now;
                    answer.append("R");
                }
                else {
                    if(hand.equals("right")) {
                        right = now;
                        answer.append("R");
                    } else {
                        left = now;
                        answer.append("L");
                    }
                }

            }
        }

        return answer.toString();
    }
}