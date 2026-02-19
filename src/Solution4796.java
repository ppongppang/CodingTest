import java.util.Scanner;

public class Solution4796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();

            int[] mountain = new int[n];

            for(int i = 0; i < n; i++) {
                mountain[i] = sc.nextInt();
            }

            int[] left = new int[n];
            for(int i=1;i<n;i++) {
                if(mountain[i-1] < mountain[i]) left[i] = left[i-1] + 1;
            }

            int[] right = new int[n];
            for(int i=n-2;i>=0;i--) {
                if(mountain[i+1] < mountain[i]) right[i] = right[i+1] + 1;
            }

            int ans = 0;
            for(int i=1;i<n-1;i++) {
                ans += left[i] * right[i];
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
