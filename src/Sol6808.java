/*⠀⠀
⠀⠀⠀⠀⠀⣠⢤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣠⡀⠀⠹⣎⢧⠀⣤⣄⡀⠀⠀⠀⠀⠀⠀⢀⣠⣤⡄⠀⠀⠀
⠀⠀⠀⠸⢧⡳⣄⠀⠘⣯⡄⣿⠉⠻⢶⡀⢀⣠⠴⠞⠛⠉⣸⠃⠀⠀⠀
⠀⡴⢦⣀⠀⠙⠚⣤⡀⠘⣿⣻⡄⠀⡌⢿⡟⠁⠀⠀⠀⣰⠏⠀⠀⠀⠀
⠀⠉⠓⠮⡟⡳⣄⠙⠻⣤⡘⠷⢻⣤⣽⠾⣏⣁⣀⣠⡾⠋⠀⠀⠀⠀⠀
⠀⠀⠀⢰⡟⠏⢹⡧⣦⡌⢡⠖⠋⠀⠀⠀⠀⠉⠻⣦⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣇⠀⠀⠻⣄⣰⣣⣄⠀⠀⢀⣴⣦⠀⠀⠘⣧⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢹⡄⠀⠀⣽⢁⣛⠋⣠⣄⣀⠙⣯⡤⠀⠀⣻⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢷⡀⠀⡇⠉⠁⠈⠙⠿⠃⠀⠉⠁⠀⢀⡿⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠈⢧⠀⠹⣄⡀⠀⠀⠀⠀⠀⢀⣀⡤⣟⡁⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠈⢷⡀⢸⡏⡿⠳⣖⣺⠿⢻⡅⢰⡏⠙⢶⣄⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠻⣾⣷⠃⠰⣏⡇⠀⠈⢷⣸⣧⣤⣤⣩⣿
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol6808 {
	static int[] gyu = new int[9];
	static int[] in = new int[9];
	
	static boolean[] used = new boolean[9];
	static int win, lose;
	
	static void dfs(int idx, int gyuScore, int inScore) {
		if(idx==9) {
			if(gyuScore > inScore) win++;
			else if(gyuScore < inScore) lose++;
			return;
		}
		for(int i=0; i<9; i++) {
			if(used[i]) continue;
			used[i]= true;
			int a = gyu[idx];
			int b= in[i];
			int sum = a+b;
			
			if(a>b) dfs(idx+1, gyuScore+sum, inScore);
			else dfs(idx+1, gyuScore, inScore+sum);
			
			used[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	boolean[] has = new boolean[19];
        	for(int i=0;i <9;i++) {
        		gyu[i] = Integer.parseInt(st.nextToken());
        		has[gyu[i]] = true;
        	}
        	
        	int idx = 0;
        	for(int x = 1; x <= 18; x++) {
        		if(!has[x]) in[idx++] = x;
        	}
        	
        	Arrays.fill(used, false);
        	win = 0;
        	lose = 0;
        	
        	dfs(0,0,0);
        	
        	sb.append('#').append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
	}

}
