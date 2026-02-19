import java.util.Scanner;

public class Main1183 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();

        int[] coin = {500, 100, 50, 10, 5, 1};
        int[] coinCnt = new int[6];
        int total = 0;
        int totalCnt = 0;
        int remain;

        for(int i =0; i<6;i++){
            coinCnt[i] = sc.nextInt();
            total += coinCnt[i] * coin[i];
            totalCnt += coinCnt[i];
        }

        remain = total - w;

        int[] notUse = new int[6];

        for(int i = 0; i<6; i++){
            int cnt = Math.min(remain / coin[i], coinCnt[i]);
            remain -= cnt * coin[i];
            notUse[i] = cnt;
            totalCnt -= cnt;

        }

        System.out.println(totalCnt);
        for(int i = 0; i<6; i++){
            System.out.print(coinCnt[i] - notUse[i] + " ");
        }
    }
}
