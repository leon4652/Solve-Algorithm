import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        //q1 합이 전체 합의 절반이어야 함
	    	long sum1 = 0, sum2 = 0;
	    	Queue<Integer> q1 = new ArrayDeque<>();
	    	Queue<Integer> q2 = new ArrayDeque<>();
	    	for (int i = 0; i < queue1.length; i++) {
	    		q1.add(queue1[i]);
	    		sum1 += queue1[i];
	    	}
	    	for (int i = 0; i < queue2.length; i++) {
	    		q2.add(queue2[i]);
	    		sum2 += queue2[i];
	    	}
	    	
	    	long tSum = sum1 + sum2;
	    	    	
	    	if(tSum % 2 == 1) return -1; //전체 합이 홀수일 경우 나눌 수 없음
	    	if(sum1 == sum2) return 0;	 //같을 경우 그대로 리턴
	    	
	    	int cnt = 0; 	//카운팅
	    	int nowVal = 0; //큐에서 빼낸 변수
	    	while(cnt < (q1.size() + q2.size()) * 3) { //q1과 q2가 완전히 바꿀 때까지 카운팅
	    		if(sum1 == sum2) return cnt;
	    		if(sum1 < sum2) { //값 옮겨주기
	    			nowVal = q2.poll();
	    			q1.offer(nowVal);
	    			sum1 += nowVal; sum2 -= nowVal;
	    		}
	    		else { //sum1 > sum2
	    			nowVal = q1.poll();
	    			q2.offer(nowVal);
	    			sum1 -= nowVal; sum2 += nowVal;
	    		}
	    		
	    		cnt++;
	    	}
	    	
	    	
	        return -1;
    }
}