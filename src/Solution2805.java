import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution2805 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=t;tc++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();   // 예: "02032"
                for (int j = 0; j < n; j++) {
                    arr[i][j] = line.charAt(j) - '0';
                }
            }

            int half = n / 2;
            int sum = 0;


            for (int i = 0; i < n; i++) {
                if (i <= half) {
                    for (int j = half - i; j <= half + i; j++) {
                        sum += arr[i][j];
                    }
                } else {
                    for (int j = i- half; j <= n - 1  -i + half; j++) {
                        sum += arr[i][j];
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
