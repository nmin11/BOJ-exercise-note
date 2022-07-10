package boj.boj_exercise_note.rhs_lecture.two_pointers;

import java.io.*;
import java.util.*;

public class BOJ_15565 {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] A;

    static void input() {
        N = fr.nextInt();
        K = fr.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = fr.nextInt();
        }
    }

    static void solve() {
        int right = 0, ans = -1, sum = 0;
        for (int left = 1; left <= N; left++) {
            // [left ... ] 와 같이 left 부터 시작하는 연속 부분 수열 중에서
            // 라이언 인형이 K 개가 되는 최소 right 위치까지 right 를 이동 시키기
            while (right < N && sum < K) {
                right++;
                if (A[right] == 1) sum++;
            }

            if (sum == K) {
                if (ans == -1) ans = right - left + 1;
                ans = Math.min(ans, right - left + 1);
            }

            // 이후에 left 를 오른쪽으로 한 칸 이동시킬 것이므로 라이언 인형 개수 조정하기
            if (A[left] == 1) sum--;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
