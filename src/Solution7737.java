import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7737 {

    static int[][] map;
    static int count;
    static int day;
    static int n;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int answer = 1;
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(day = 1; day <= 100 ; day++){
                eat(day);
                visited = new int[n][n];
                count = 0;
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(map[i][j] != -1 && visited[i][j] == 0) {
                            bfs(i, j);
                            count++;
                        }
                    }
                }
                if (count > answer) {
                    answer = count;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] != -1){
                    if(visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void eat(int day) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == day) map[i][j] = -1;
            }
        }
    }
}
