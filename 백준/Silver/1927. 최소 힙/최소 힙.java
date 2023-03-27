import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            long now = Long.parseLong(br.readLine());
            if(now == 0) { //입력값이 0일 경우
                if(pq.isEmpty()) bw.write("0\n");
                else bw.write(pq.poll() + "\n");
                continue;
            }
            pq.offer(now);
        }

        bw.close();
    }
}
