import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main14889 {

    static int n;
    static int[][] team;
    static boolean[] peek;
    static int best = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        team = new int[n][n];
        peek = new boolean[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(best);
    }

    static void dfs(int idx, int cnt){
        if(cnt == n / 2 ) {
            best = Math.min(best, diff());
            return;
        }

        if(idx >= n) return;

        int remain = n - idx;
        if(remain + cnt < n / 2) return;

        peek[idx] = false;
        dfs(idx+1, cnt);

        peek[idx] = true;
        dfs(idx+1, cnt+1);

        peek[idx] = false;
    }

    static int diff() {
        int start = 0;
        int link = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(peek[i] && peek[j]) {
                    start += team[i][j];
                }
                else if(!peek[i] && !peek[j]) {
                    link += team[i][j];
                }
            }
        }
        return Math.abs(start - link);
    }
}
