package youngseok.binary;

import java.io.*;

public class beakjoon_3896 {
    static int MAX = 1299709; // 문제에서 주어진 최대 k 범위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 에라토스테네스의 체로 소수 리스트 생성
        boolean[] isPrime = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) isPrime[i] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            if (isPrime[k]) { // k가 소수인 경우 길이 0
                bw.write("0\n");
                continue;
            }

            // 이전 소수 찾기
            int prev = k - 1;
            while (prev >= 2 && !isPrime[prev]) prev--;

            // 다음 소수 찾기
            int next = k + 1;
            while (next <= MAX && !isPrime[next]) next++;

            bw.write((next - prev) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
