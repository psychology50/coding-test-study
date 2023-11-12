import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class D1_2071
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                int n = Integer.parseInt(st.nextToken());
                sum += n;
            }
            double avg = ((double) sum) / 10;
            System.out.println(String.format("#%d %.0f", i+1, avg));
        }
    }
}