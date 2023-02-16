
import java.io.*;
import java.util.*;

public class Main {
   static int Y, X;
   static boolean[][] isvisited;
   static char[][] map;
   static Queue<int[]> q1 = new ArrayDeque<>();
   static int[][] shift = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; //LURD;
   static int[] Node = {0, 0, 0};
   static int res = Integer.MAX_VALUE;
   
   public static void main(String[] args) throws Exception, IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   Y = Integer.parseInt(st.nextToken());
	   X = Integer.parseInt(st.nextToken());
	   map = new char[Y][X];
	   isvisited = new boolean[Y][X];

	   for (int i = 0; i < Y; i++) {
		map[i] = br.readLine().toCharArray();
	}
	  
	   q1.add(Node);
	   bfs();
   }
   
   static void bfs() {

	   while(!q1.isEmpty()) {
		   int[] tempNode = q1.poll();
		   int x = tempNode[0];
		   int y = tempNode[1];
		   int dist = tempNode[2];

		   
		   if(x == X - 1 && y == Y - 1) {
			   System.out.println(tempNode[2] + 1);
			   return;
		   }
		   
		   for (int i = 0; i < shift.length; i++) {
			   int newX = x + shift[i][1];
			   int newY = y + shift[i][0];
			   
			   if (newX < 0 || newY < 0 || newX >= X || newY >= Y) continue;
			   if (map[newY][newX] == '0' || isvisited[newY][newX]) continue;
			   
			   isvisited[newY][newX] = true;
			   q1.add(new int[] {newX, newY, dist + 1});
		   }
	   }
   }
   
}