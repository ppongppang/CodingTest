import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5644 {

    static int m, a;
    static int[] moveA, moveB;
    static int[][] bc;

    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

            moveA = new int[m];
            moveB = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            bc = new int[a][4];
            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                bc[i][0] = Integer.parseInt(st.nextToken());
                bc[i][1] = Integer.parseInt(st.nextToken());
                bc[i][2] = Integer.parseInt(st.nextToken());
                bc[i][3] = Integer.parseInt(st.nextToken());
            }

            int ax = 1, ay = 1;
            int bx = 10, by = 10;
            int totalCharge = 0;

            for (int t = 0; t <= m; t++) {
                if (t > 0) {
                    ax += dx[moveA[t - 1]];
                    ay += dy[moveA[t - 1]];
                    bx += dx[moveB[t - 1]];
                    by += dy[moveB[t - 1]];
                }

                totalCharge += maxCharge(ax, ay, bx, by);
            }

            sb.append('#').append(tc).append(' ').append(totalCharge).append('\n');
        }
        System.out.print(sb);
    }

    static int maxCharge(int ax, int ay, int bx, int by) {
        int max = 0;

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= a; j++) {
                int sum = 0;

                boolean aCanUse = (i < a && inRange(ax, ay, i));
                boolean bCanUse = (j < a && inRange(bx, by, j));

                if (i == j && i < a) {
                    if (aCanUse && bCanUse) {
                        sum = bc[i][3];
                    }
                } else {
                    if (aCanUse) sum += bc[i][3];
                    if (bCanUse) sum += bc[j][3];
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }

    static boolean inRange(int x, int y, int idx) {
        return Math.abs(x - bc[idx][0]) + Math.abs(y - bc[idx][1]) <= bc[idx][2];
    }
}