import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution7739 {

    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new char[n][m];
            visited = new boolean[n][m];

            ArrayDeque<int[]> deque = new ArrayDeque<>();

            for(int i = 0; i < n; i++) {
                String s = br.readLine();
                for(int j = 0; j < m; j++) {
                    map[i][j] = s.charAt(j);

                    if(map[i][j] == '*') {
                        deque.addFirst(new int[]{i, j, 1, 0});
                    } else if(map[i][j] == 'S') {
                        deque.addLast(new int[]{i, j, 0, 0});
                        visited[i][j] = true;
                    }
                }
            }

            int answer = -1;

            while(!deque.isEmpty()) {
                int[] cur = deque.poll();
                int x = cur[0];
                int y = cur[1];
                int type = cur[2];
                int dist = cur[3];

                if(type == 0 && map[x][y] == 'D') {
                    answer = dist;
                    break;
                }

                for(int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;

                    if(type == 1) {
                        if(map[nx][ny] == 'D') continue;
                        map[nx][ny] = '*';
                    } else {
                        if(visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                    }

                    deque.addLast(new int[]{nx, ny, type, dist + 1});
                }
            }
            if(answer == -1) {
                sb.append("#").append(tc).append(" ").append("GAME OVER").append("\n");
            } else {
                sb.append("#").append(tc).append(" ").append(answer).append("\n");
            }
        }
        System.out.println(sb);

    }
}

