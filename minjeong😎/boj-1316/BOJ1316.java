import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (check(word)) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    static boolean check(String word) {
        boolean[] alphabet = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            int now = word.charAt(i); // 단어의 현재 알파벳
            int pre = (i == 0) ? 0 : word.charAt(i-1);

            if ( now != pre ) {
                if (!alphabet[now-97]) // 한 번 나온 단어인지 체크
                    alphabet[now-97] = true;
                else return false;
            }
        }
        return true;
    }
}
