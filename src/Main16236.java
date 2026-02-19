import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main16236 {

    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cx;
    static int cy;
    static int n;
    static int time;
    static int eat;
    static int size = 2;

    static class Fish {
        int x, y, d;
        Fish(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    cx = i;
                    cy = j;
                    map[cx][cy] = 0;
                }
            }
        }

        while(true){
            Fish news = bfs(cx, cy);
            if(news == null) break;
            time += news.d;
            cx = news.x;
            cy = news.y;

            map[cx][cy] = 0;

            eat++;
            if(eat == size) {
                size++;
                eat = 0;
            }
        }
        System.out.println(time);

    }

    static Fish bfs(int cx, int cy){
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) dist[i][j] = -1;

        dist[cx][cy] = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{cx, cy});

        List<Fish> newFish = new ArrayList<>();

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if(dist[nx][ny] != -1) continue;

                if(map[nx][ny] > size) continue;
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});

                if(map[nx][ny] != 0 && map[nx][ny] < size) newFish.add(new Fish(nx, ny, dist[nx][ny]));

            }
        }

        if (newFish.isEmpty()) return null;

        newFish.sort((f1, f2) -> {
            if (f1.d != f2.d) return Integer.compare(f1.d, f2.d);
            if (f1.x != f2.x) return Integer.compare(f1.x, f2.x);
            return Integer.compare(f1.y, f2.y);
        });

        return newFish.get(0);
    }
}
