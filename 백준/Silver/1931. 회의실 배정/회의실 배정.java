import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 회의의 수

        // 회의 시간을 저장하는 배열
        int[][] meetings = new int[n][2];

        // 입력받은 회의 시간을 meetings 배열에 저장
        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt(); // 시작 시간
            meetings[i][1] = sc.nextInt(); // 종료 시간
        }

        // 끝나는 시간을 기준으로 오름차순 정렬
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { // 끝나는 시간이 같으면 시작 시간이 빠른 순으로
                    return Integer.compare(o1[0], o2[0]);
                } else { // 끝나는 시간이 빠른 순으로
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

        int cnt = 0; // 배정된 회의 수
        int end = 0; // 이전에 선택한 회의의 종료 시간
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= end) { // 이전에 선택한 회의와 겹치지 않는 경우
                end = meetings[i][1]; // 선택한 회의의 종료 시간으로 갱신
                cnt++; // 회의 수 증가
            }
        }

        System.out.println(cnt); // 결과 출력
    }
}
