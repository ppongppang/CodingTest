import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1227 {

    static int[][] map;
    static boolean[][] visit;
    static int x;
    static int y;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());

            map = new int[100][100];
            visit = new boolean[100][100];

            int x = 0;
            int y = 0;

            for(int i = 0; i < 100; i++) {
                String s = br.readLine();
                for(int j = 0; j < 100; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    if(map[i][j] == 2){
                        x = i;
                        y = j;
                    }
                }
            }
            int answer = bfs(x, y);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];

            if(map[x][y] == 3) {
                return 1;
            }

            for(int d= 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
                if(visit[nx][ny] || map[nx][ny] == 1) continue;

                visit[nx][ny] = true;
                q.add(new int[]{nx, ny});

            }
        }
        return 0;
    }
}
