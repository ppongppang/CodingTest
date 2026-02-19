import java.io.*;
import java.util.*;

public class Sol1210 {
    static final int N = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

       
        for (int tc = 1; tc <= 10; tc++) {
        		
        	int T = Integer.parseInt(br.readLine());
        	
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int col = -1;
            for (int j = 0; j < N; j++) {
                if (map[N - 1][j] == 2) {
                    col = j;
                    break;
                }
            }

            int row = N - 1;
            while (row > 0) {
                if (col - 1 >= 0 && map[row][col - 1] == 1) {
                    while (col - 1 >= 0 && map[row][col - 1] == 1) col--;
                    row--;
                } else if (col + 1 < N && map[row][col + 1] == 1) {
                    while (col + 1 < N && map[row][col + 1] == 1) col++;
                    row--;
                } else {
                    row--;
                }
            }

            sb.append("#").append(tc).append(" ").append(col).append("\n");
        }

        System.out.print(sb.toString());
    }
}
