import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class D1_2072
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;

            for (int j = 0; j < 10; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n % 2 != 0)
                    sum += n;
            }
            
            System.out.println(String.format("#%d %d", i+1, sum));
        }
    }
}
