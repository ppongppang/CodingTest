import java.io.*;
import java.util.*;

public class Main2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] pillar = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pillar[i][0] = Integer.parseInt(st.nextToken());
            pillar[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pillar, (a, b) -> a[0] - b[0]);

        int pivot = 0;
        for (int i = 1; i < n; i++) {
            if (pillar[i][1] > pillar[pivot][1]) pivot = i;
        }

        int answer = 0;

        int cur = 0;
        for (int i = 1; i <= pivot; i++) {
            if (pillar[i][1] >= pillar[cur][1]) {
                answer += (pillar[i][0] - pillar[cur][0]) * pillar[cur][1];
                cur = i;
            }
        }

        cur = n - 1;
        for (int i = n - 2; i >= pivot; i--) {
            if (pillar[i][1] >= pillar[cur][1]) {
                answer += (pillar[cur][0] - pillar[i][0]) * pillar[cur][1];
                cur = i;
            }
        }

        // pivot 기둥 자체
        answer += pillar[pivot][1];

        System.out.println(answer);
    }
}