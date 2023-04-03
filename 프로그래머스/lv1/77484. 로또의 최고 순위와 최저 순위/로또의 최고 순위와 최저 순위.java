import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        List<Integer> pick = new ArrayList<>();
        int zero = 0;
        int correct = 0;
        
        //1. 입력값 분리
        for (int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0) zero += 1;
			else pick.add(lottos[i]);
		}
        
        //2. 0 제외 후 입력값이 몇 개나 맞는지 확인
        for (int i = 0; i < win_nums.length; i++) {
			if(pick.contains(win_nums[i])) correct += 1;
		}
        
        //3. 최저, 최고 개수 확인
        int worst = correct;
        int best = correct += zero;
        
        System.out.println(worst);
        System.out.println(best);
        
        answer[0] = find(best);
        answer[1] = find(worst);
        
        return answer;
    }

	private static int find(int num) {
		if(num < 2) return 6;
		if(num == 2) return 5;
		if(num == 3) return 4;
		if(num == 4) return 3;
		if(num == 5) return 2;
		else return 1;
	}
}