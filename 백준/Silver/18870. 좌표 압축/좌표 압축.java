import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long firstArr[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        while (st.hasMoreTokens()) firstArr[cnt++] = Long.parseLong(st.nextToken());

        // TreeSet을 사용하여 오름차순 변환
        TreeSet<Long> treeSet = new TreeSet<>();
        cnt = 0;
        while (cnt < n) treeSet.add(firstArr[cnt++]);

        // 이를 새로운 해시맵에 매핑
        long level = 0;
        HashMap<Long, Long> levels = new HashMap<>();
        for (Long element : treeSet) {
            levels.put(element, level++);
        }

        // 최종 출력
        for (int i = 0; i < n; i++) {
            bw.write(levels.get(firstArr[i]) + " ");
        }

        bw.close();
    }
}
