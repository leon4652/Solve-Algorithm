import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> s = new Stack<>();
		int answer = 0;
        
        for (int i = 0; i < moves.length; i++) {
        	int doll = 0; 			//목표 인형
        	int col = moves[i] - 1; //뽑을 열
        	int row = 0; 			//뽑을 행
        	
        	//1. 인형이 있는 행 찾기
        	while(true) {
        		if(row >= board.length) break; 	//기저조건 1 : 아무것도 뽑을 수 없을 경우
        		if(board[row][col] != 0) { 		//기저조건 2 : 무언가 뽑은 경우 
        			doll = board[row][col];		//인형에 값 대입
        			board[row][col] = 0;		//해당 위치 공백으로 설정
        			break;
        		}
        		row += 1; //공백일 경우 다음 행 탐색
        	}
        	
        	//2. 뽑은 인형을 스택에 담아 비교하기
        	if(doll != 0) {
        		if(s.isEmpty()) s.push(doll); //인형이 없을 경우 삽입
        		else { //아닐 경우 이전값과 비교하여 제거 or 삽입
        			if(s.peek() == doll) {
        				s.pop();
        				answer += 2; //점수 증가
        			}
        			else s.push(doll);
        		}
        	}
		}
        return answer;
    }
}