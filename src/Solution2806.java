import java.util.Scanner;

public class Solution2806 {
    static int N;
    static int cnt;
    static int[] visited;

    static boolean check(int row) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            if (visited[row] == visited[prevRow] ||
                    Math.abs(row - prevRow) == Math.abs(visited[row] - visited[prevRow])) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int row) {
        if (row == N) {
            cnt++;
        } else {
            for (int i = 0; i < N; i++) {
                visited[row] = i;
                if (check(row)) {
                    dfs(row + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            N = sc.nextInt();
            cnt = 0;
            visited = new int[N];
            dfs(0);

            System.out.println("#" + testCase + " " + cnt);
        }

        sc.close();
    }
}