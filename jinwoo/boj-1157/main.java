import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 단어(String) 입력 받기
        Scanner in = new Scanner(System.in);
        String word = in.next();
        
        // 1. 배열로 변환
        String upper_word = word.toUpperCase();
        String[] alphabets = upper_word.split("");

        // 2. 중복 제거된 배열 만들기
        List<String> alphabetList = new ArrayList<String>();
        for (String alphabet : alphabets) {
            if (!alphabetList.contains(alphabet)) {
                alphabetList.add(alphabet);
            }
        }

        // 3. 알파벳 당 출현 횟수 구하기
        Integer[] alphabetCnt = new Integer[alphabetList.size()];
        Arrays.fill(alphabetCnt, 0);

        for (int i = 0; i < alphabetList.size(); i++) {
            for (String a : alphabets) {
                if (alphabetList.get(i).equals(a)) {
                    alphabetCnt[i] += 1;
                }
            }
        }

        int max = -2147000000;
        
        // 4. 알파벳 출현 빈도 max 값 구하기
        for (Integer i : alphabetCnt) {
            max = Math.max(max, i);
        }

        // 5. max 값 중복 여부 검사
        boolean isDuplicated = false;
        int duplidateCnt = 0;
        String result = "";
        for (int i = 0; i < alphabetList.size(); i++) {
            if (alphabetCnt[i].equals(max)) {
                result = alphabetList.get(i);
                duplidateCnt += 1;
                if (duplidateCnt >= 2) {
                    isDuplicated = true;
                    break;
                }
            }
        }

        // 6. 결과 출력
        StringBuilder sb = new StringBuilder();

        if (isDuplicated) {
            sb.append("?");
        } else {
            sb.append(result);
        }

        System.out.println(sb);
    }
}