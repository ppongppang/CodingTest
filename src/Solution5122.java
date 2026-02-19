import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution5122 {

    private static BufferedReader br;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null; // 입력 끝
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = nextInt();
            int m = nextInt();
            int l = nextInt();

            List<Integer> arr = new ArrayList<>(n + m);

            for (int i = 0; i < n; i++) {
                arr.add(nextInt());
            }

            for (int i = 0; i < m; i++) {
                char op = next().charAt(0);

                if (op == 'I') {
                    int idx = nextInt();
                    int val = nextInt();
                    arr.add(idx, val);
                } else if (op == 'D') {
                    int idx = nextInt();
                    arr.remove(idx);
                } else if (op == 'C') {
                    int idx = nextInt();
                    int val = nextInt();
                    arr.set(idx, val);
                }
            }


            if (l < 0 || l >= arr.size()) {
                sb.append("#").append(tc).append(" ").append(-1).append("\n");
            } else {
                sb.append("#").append(tc).append(" ").append(arr.get(l)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
