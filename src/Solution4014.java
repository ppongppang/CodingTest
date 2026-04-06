import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4014 {

    static int n;
    static int x;
    static int[][] cliff;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            cliff = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    cliff[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for(int i = 0; i < n; i++) {
                if(check(i, 0)) result++;
                if(check(i, 1)) result++;
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static boolean check(int idx, int dir) {
        boolean[] install = new boolean[n];
        int flat = 1;

        for(int i = 1; i < n; i++) {
            int next = dir == 0 ? cliff[idx][i-1] : cliff[i-1][idx];
            int curr = dir == 0 ? cliff[idx][i] : cliff[i][idx];
            int diff = next - curr;

            if(diff == 0){
                flat++;
            } else if(diff == -1) {
                if(flat < x) return false;
                for(int j = i-1 ; j >= i - x; j--) {
                    if(install[j]) return false;
                    install[j] = true;
                }
                flat = 1;
            } else if(diff == 1) {
                for(int j = i; j < i + x; j++) {
                    if(j >= n) return false;
                    int h = dir == 0 ? cliff[idx][j] : cliff[j][idx];
                    if(h != curr) return false;
                    if(install[j]) return false;
                    install[j] = true;
                }
                flat = 0;
                i += x-1;
            } else {
                return false;
            }
        }
        return true;
    }
}
