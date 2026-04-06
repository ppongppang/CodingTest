import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2015 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());

        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        long prefixSum = 0L;
        long answer = 0L;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            prefixSum += Long.parseLong(st.nextToken());

            answer += map.getOrDefault(prefixSum - k, 0L);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0L) + 1L);
        }

        System.out.println(answer);
    }
}
