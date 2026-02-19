import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1767 {
    static int[][] map;
    static int n;
    static List<int[]> core;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int bestConnect, bestLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
             n = Integer.parseInt(br.readLine());

             map = new int[n][n];
             core = new ArrayList<>();


             for(int i = 0; i < n; i++) {
                 StringTokenizer st = new StringTokenizer(br.readLine());
                 for(int j = 0; j < n; j++) {
                     map[i][j] = Integer.parseInt(st.nextToken());
                     if(map[i][j] == 1){
                         if(i != 0 && j != 0 && i != n-1 && j != n-1) {
                             core.add(new int[]{i, j});
                         }
                     }
                 }
             }
            bestConnect = 0;
            bestLen = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(bestLen).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int idx, int connect, int len) {
        if(connect + (core.size() - idx) < bestConnect) return;

        if(idx == core.size()) {
            if(connect > bestConnect) {
                bestConnect = connect;
                bestLen = len;
            } else if(connect == bestConnect) {
                bestLen = Math.min(bestLen, len);
            }
            return;
        }

        int x = core.get(idx)[0];
        int y = core.get(idx)[1];

        for(int i = 0; i < 4; i++) {
            int wire = canConnect(x, y, i);
            if(wire == -1) continue;

            lay(x, y, i, 2);
            dfs(idx+1, connect+1, len+wire);
            lay(x, y, i, 0);
        }
        dfs(idx+1, connect, len);
    }

    static int canConnect(int x, int y, int d){
        int nx = x + dx[d];
        int ny = y + dy[d];
        int cnt = 0;
        while(nx >= 0 && nx < n && ny >= 0 && ny < n){
            if(map[nx][ny] != 0) return -1;
            cnt++;
            nx += dx[d];
            ny += dy[d];
        }
        return cnt;
    }

    static void lay(int x, int y, int d, int val){
        int nx = x + dx[d];
        int ny = y + dy[d];

        while(nx >= 0 && nx < n && ny >= 0 && ny < n){
            map[nx][ny] = val;
            nx += dx[d];
            ny += dy[d];
        }
    }
}
