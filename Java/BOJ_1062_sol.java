package algo_0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ_1062_1 {
    static int N,K;
    static int max = 0;
    static boolean visit[] = new boolean[26];
    static String[] strArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        strArr = new String[N];
        if(K<5) {
            System.out.println(0);
            return;
        }else if(K==26) { 
            System.out.println(N);
            return;
        }else {
            for(int n=0; n<N; n++) {
                String str = br.readLine();
                strArr[n] = str.substring(4, str.length()-4);
            }
            K-=5;
            visit['a'-97]=true;
            visit['n'-97]=true;
            visit['t'-97]=true;
            visit['i'-97]=true;
            visit['c'-97]=true;
            comb(0, 0);
            System.out.println(max);
        }
        
    }
    private static void comb(int start, int cnt) {
        // TODO Auto-generated method stub
        if(cnt == K) {
            int count = 0;
            for(int i=0; i<N; i++) {
                boolean flag = true;
                for(int j=0; j<strArr[i].length(); j++) {
                    if(!visit[strArr[i].charAt(j)-97]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                	count++;
                }
            }
            max = Math.max(max, count);
            return;
        }
        
        for(int i=start; i<26; i++) {
            if(!visit[i]) {
                visit[i]=true;
                comb(i, cnt+1);
                visit[i]=false;
            }
        }
    }
}