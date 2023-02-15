
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> absHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) {
                    if(o1 > o2) return 1;
                    else return -1;
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) {
                if(absHeap.size() == 0) bw.write("0\n");
                else bw.write(absHeap.poll() + "\n");
            }
            else absHeap.add(temp);
        }

        bw.flush();
        bw.close();
       
    }
}