package boj.boj_exercise_note.rhs_lecture.two_pointers;

import java.io.*;
import java.util.*;

public class BOJ_2559 {
    static StringBuilder sb = new StringBuilder();
    static FastReader fr = new FastReader();

    static int n, k;
    static int[] a;

    static void input() {
        n = fr.nextInt();
        k = fr.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = fr.nextInt();
        }
    }

    static void solve() {
        int R = 0, sum = 0, ans = -100 * n;
        for (int L = 1; L + k - 1 <= n; L++) {
            // L - 1 을 구간에서 제외하기
            sum -= a[L - 1];

            // R 을 옮길 수 있을 때 까지 옮기기
            while (R + 1 <= L + k - 1) {
                sum += a[++R];
            }

            // [L ... R] 의 합, 즉 sum 이 조건을 만족하면 정답 갱신하기
            ans = Math.max(sum, ans);
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
