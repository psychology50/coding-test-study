import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
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