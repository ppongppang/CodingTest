import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        if (K > (long) C * R) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[C + 1][R + 1];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 1;
        int y = 1;
        int dir = 0;
        visited[x][y] = true;

        for(int d = 0; d < K-1; d++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 1 || nx > C || ny < 1 || ny > R || visited[nx][ny]) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
            visited[x][y] = true;
        }
        System.out.println(x + " " + y);
    }
}