/*
4^6 * 100 = 1638400이므로 완탐 가능
백트래킹 + 구현 사용
*/
class Solution {
    static final int SALE = 4;
	static int sale[] = {10, 20, 30, 40}; //할인율
	static int resEmo = 0, resEarn = 0, resArr[];
    public int[] solution(int[][] users, int[] emoticons) {
        //1. 기본 정보 입력받기
		int len = emoticons.length;
		int nowSale[] = new int[len];
		resArr = new int[len];
		for (int i = 0; i < len; i++) {
			nowSale[i] = 10; //10% 할인
		}
		
		//2. 백트래킹 사용
		recur(nowSale, 0, users, emoticons);
			
		
        int[] answer = {resEmo, resEarn};
        return answer;
    }
    
    private static void recur(int[] nowSale, int idx, int[][] users, int[] emoticons) {
		//기저조건
		if(idx == nowSale.length) {
			cal(nowSale, users, emoticons); //할인율에 따른 계산 
			return;
		}
		
		
		//전체 경우의 수만큼 반복
		for (int i = 0; i < SALE; i++) {
			//현재 인덱스에 세일값 변환 후 다음 인덱스로 리턴
			recur(setNowSale(nowSale, idx, i), idx + 1, users, emoticons); //할인율
		}
		
	}

	private static void cal(int[] nowSale, int[][] users, int[] emoticons) {
		//할인율 배열에 따른 계산, 얼마나 판매액을 늘릴 수 있는지
		
		int emoPlus = 0;
		int totalEarn = 0;
		int idx = 0;
		
		COUNT:
		while(idx < users.length) { //사람 수만큼 계산
			int percent = users[idx][0]; //할인율 
			int money = users[idx][1];	 //소지금
			int earn = 0;
			
			//이모티콘 개수만큼 계산 후 판단
			for (int i = 0; i < emoticons.length; i++) {
				if(nowSale[i] >= percent) { //할인율이 같거나 높다면 해당 제품을 구매
					earn += emoticons[i] * (100 - nowSale[i]) / 100;
				}
				if(earn >= money) { //최대 소지금을 넘었을 경우 이모티콘 플러스 가입 후 continue
					emoPlus++;
					idx++;
					continue COUNT;
				}
			}
			
			totalEarn += earn; //판매액 계산
			idx++;
		}
		
		//정산
		if(emoPlus > resEmo || (emoPlus == resEmo && totalEarn > resEarn)) {
			resEmo = emoPlus;
			resEarn = totalEarn;
			resArr = nowSale;
		}
	}

	private static int[] setNowSale(int[] nowSale, int idx, int saleCnt) {
		//nowSale을 복사한 새로운 배열을 만들고, 배열에 할인율을 적용하여 리턴
		int len = nowSale.length;
		int[] newArr = new int[len];
		for (int i = 0; i < len; i++) {
			newArr[i] = nowSale[i];
		}
		newArr[idx] = sale[saleCnt]; //해당 위치 인덱스만 세일 변경
		return newArr;
	}

    
}
