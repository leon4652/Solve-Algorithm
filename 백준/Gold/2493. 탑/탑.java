
import java.io.*;
import java.util.*;

//힙을 통해 검색의 시간 복잡도를 낮추겠다.

public class Main {
    static Tower last;
    static class Tower {
        int height;
        int pos;

        Tower(int height, int pos) {
            this.height = height;
            this.pos = pos;
        }
    }
    public static void main(String[] args) throws IOException {
        Stack<Tower> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine()); //쓰지 않음
        StringTokenizer st = new StringTokenizer(br.readLine());


        //첫 번째 탑 삽입
        stack.add(new Tower(Integer.parseInt(st.nextToken()), 1));
        bw.write("0 ");

        int max = stack.peek().height;  //최대 탑 높이
        int now;                        //현재 값 담을 변수
        int nowPos = 1;                 //탑 번호

        //이후 반복
        while (st.hasMoreTokens()) {
            nowPos++;
            now = Integer.parseInt(st.nextToken());

            //입력값이 최대값인 경우 이전 탑 정보 날려버림.
            if(max < now) {
                max = now;  //최대 값 갱신
                stack.clear();
                stack.add(new Tower(now, nowPos));
                bw.write("0 ");
                continue;
            }

            //아닌 경우 이전 값들과 비교
            while (true) {
                last = stack.pop();
                if(last.height > now) {
                bw.write(last.pos + " ");
                stack.add(last);
                stack.add(new Tower(now, nowPos));
                break;
                }
            }

        }

        bw.close();
    }
}