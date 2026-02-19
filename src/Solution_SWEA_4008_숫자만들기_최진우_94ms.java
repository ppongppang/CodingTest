import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4008_숫자만들기_최진우_94ms {

    static int n;
    static int[] opCnt;
    static int[] nums;
    static int minVal;
    static int maxVal;

    static void dfs(int idx, int cur){
        if(idx == n) {
            maxVal = Math.max(maxVal, cur);
            minVal = Math.min(minVal, cur);
            return;
        }

        int b = nums[idx];

        if(opCnt[0] > 0) {
            opCnt[0]--;
            dfs(idx+1, cur + b);
            opCnt[0]++;
        }

        if(opCnt[1] > 0) {
            opCnt[1]--;
            dfs(idx+1, cur - b);
            opCnt[1]++;
        }

        if(opCnt[2] > 0) {
            opCnt[2]--;
            dfs(idx+1, cur * b);
            opCnt[2]++;
        }

        if(opCnt[3] > 0) {
            opCnt[3]--;
            dfs(idx+1, cur / b);
            opCnt[3]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=t;tc++) {
            n = Integer.parseInt(br.readLine());

            opCnt = new int[4];
            nums = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i ++) opCnt[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i ++) nums[i] = Integer.parseInt(st.nextToken());

            minVal = Integer.MAX_VALUE;
            maxVal = Integer.MIN_VALUE;

            dfs(1, nums[0]);

            sb.append("#").append(tc).append(" ").append(maxVal - minVal).append("\n");
        }

        System.out.println(sb);
    }
}
