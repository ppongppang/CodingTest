import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main2491 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int max = 1;
        int inc = 1;
        for(int i = 0; i < n - 1; i++) {
            if(num[i] <= num[i + 1]) {
                inc++;
                if(inc > max) {
                    max = inc;
                }
            } else {
                inc = 1;
            }
        }

        int dec = 1;
        for(int i = 0; i < n - 1; i++) {
            if(num[i] >= num[i + 1]) {
                dec++;
                if(dec > max) {
                    max = dec;
                }
            } else {
                dec = 1;
            }
        }

        System.out.println(max);

    }
}
