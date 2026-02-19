import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution1861 {
    static int n;
    static int[][] room;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException { BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));StringBuilder sb = new StringBuilder();int t = Integer.parseInt(br.readLine());for(int tc = 1; tc <= t; tc++) {n = Integer.parseInt(br.readLine());dp = new int[n][n];room = new int[n][n];for(int i = 0; i < n; i++) {StringTokenizer st = new StringTokenizer(br.readLine());for(int j = 0; j < n; j++) {room[i][j] = Integer.parseInt(st.nextToken());}}int maxCount = 0;int startRoom = Integer.MAX_VALUE;for (int i = 0; i < n; i++) {for (int j = 0; j < n; j++) {int count = dfs(i, j);if (count > maxCount || (count == maxCount && room[i][j] < startRoom)) {maxCount = count;startRoom = room[i][j];}}}sb.append("#").append(tc).append(" ").append(startRoom).append(" ").append(maxCount).append("\n");}System.out.println(sb);}
    static int dfs(int x, int y) {if (dp[x][y] != 0) return dp[x][y];dp[x][y] = 1;for (int i = 0; i < 4; i++) {int nx = x + dx[i];int ny = y + dy[i];if (nx >= 0 && nx < n && ny >= 0 && ny < n && room[nx][ny] == room[x][y] + 1)  {dp[x][y] = 1 + dfs(nx, ny);break;}}return dp[x][y];}}
