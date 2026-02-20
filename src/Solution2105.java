import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Solution2105 {

    static int[][] cafe;
    static boolean[] visit;
    static int n;
    static int answer;
    static int sx;
    static int sy;
    static int[] dx = {1, 1, -1,-1};
    static int[] dy = {1,-1,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            cafe = new int[n][n];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = -1;
            visit = new boolean[101];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    sx = i;
                    sy = j;
                    visit[cafe[i][j]] = true;
                    dfs(i, j, 0, 1);
                    visit[cafe[i][j]] = false;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int dir, int cnt){
        for(int d=dir; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            if(nx == sx && ny == sy) {
                if(d == 3 && cnt >= 4) answer = Math.max(answer, cnt);
                break;
            }

            if(visit[cafe[nx][ny]]) continue;

            visit[cafe[nx][ny]] = true;
            dfs(nx, ny, d, cnt+1);
            visit[cafe[nx][ny]] = false;
        }

    }
}
