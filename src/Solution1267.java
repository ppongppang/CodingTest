import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1267 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            int[] indegree = new int[v+1];

            for(int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < e; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                indegree[to]++;
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 1; i <= v; i++) {
                if(indegree[i] == 0) pq.offer(i);
            }

            sb.append("#").append(tc).append(" ");

            while(!pq.isEmpty()) {
                int cur = pq.poll();
                sb.append(cur).append(" ");
                for(int next : graph.get(cur)) {
                    indegree[next]--;
                    if(indegree[next] == 0) pq.offer(next);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
