import java.util.*;
import java.io.*;

public class Sol8275 {
    static int N, X, M;
    static int[][] records;
    static int[] cage;
    static int[] answer;
    static int maxTotal;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            records = new int[M][3];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                records[i][0] = Integer.parseInt(st.nextToken()) - 1;
                records[i][1] = Integer.parseInt(st.nextToken()) - 1;
                records[i][2] = Integer.parseInt(st.nextToken());
            }
            
            cage = new int[N];
            answer = null;
            maxTotal = -1;
            
            backtrack(0, 0);
            
            System.out.print("#" + tc + " ");
            if (answer == null) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < N; i++) {
                    System.out.print(answer[i] + " ");
                }
                System.out.println();
            }
        }
    }
    
    static void backtrack(int idx, int total) {
        if (idx == N) {
            if (isValid()) {
                if (total > maxTotal || 
                    (total == maxTotal && isSmaller())) {
                    maxTotal = total;
                    answer = cage.clone();
                }
            }
            return;
        }
        
        for (int count = 0; count <= X; count++) {
            cage[idx] = count;
            backtrack(idx + 1, total + count);
        }
    }
    
    static boolean isValid() {
        for (int i = 0; i < M; i++) {
            int l = records[i][0];
            int r = records[i][1];
            int s = records[i][2];
            
            int sum = 0;
            for (int j = l; j <= r; j++) {
                sum += cage[j];
            }
            
            if (sum != s) return false;
        }
        return true;
    }
    
    static boolean isSmaller() {
        if (answer == null) return true;
        
        for (int i = 0; i < N; i++) {
            if (cage[i] < answer[i]) return true;
            if (cage[i] > answer[i]) return false;
        }
        return false;
    }
}