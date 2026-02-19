import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution14510 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {

            int n = Integer.parseInt(br.readLine());

            int[] trees = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(trees);

            int max = trees[n-1];

            int oddCount = 0;
            int evenCount = 0;

            for(int i = 0 ; i< n ;i++) {
                int diff = max - trees[i];
                evenCount += diff/2;
                oddCount += diff % 2;
            }

            int ans = minDay(oddCount, evenCount);
            System.out.println("#"+tc+" "+ans);
        }
    }

    static int minDay(int odd, int even) {
        while(even > odd +1) {
            even--;
            odd += 2;
        }

        if(odd > even) {
            return odd * 2 -1;
        } else {
            return even * 2;
        }
    }
}
