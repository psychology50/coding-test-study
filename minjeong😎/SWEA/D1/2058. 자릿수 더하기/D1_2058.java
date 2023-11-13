import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class D1_2058 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // ���۸� �� ��α� ����,, Array�� ArrayList�� ���� ����ϱ�
        ArrayList<Integer> numList = new ArrayList<Integer>();
        while (T > 0) {
            numList.add(T % 10);
            T /= 10;
        }
        int sum = 0;
        for (int i = 0; i < numList.toArray().length; i++) {
            sum += numList.get(i);
        }
        System.out.println(sum);
    }
}
