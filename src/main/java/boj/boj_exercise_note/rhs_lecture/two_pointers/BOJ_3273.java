package boj.boj_exercise_note.rhs_lecture.two_pointers;

import java.io.*;
import java.util.*;

public class BOJ_3273 {
    static StringBuilder sb = new StringBuilder();
    static FastReader fr = new FastReader();

    static int n, S;
    static int[] a;

    static void input() {
        // 입력 받기
        n = fr.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = fr.nextInt();
        }
        S = fr.nextInt();

        // 입력 배열 정렬하기
        Arrays.sort(a, 1, n + 1);
    }

    static void solve() {
        int ans = 0, L = 1, R = n;
        // L과 R을 양쪽 끝에서 이동시키면서 정답 계산하기
        while (L < R) {
            if (a[L] + a[R] == S) ans++;
            if (a[L] + a[R] >= S) R--;
            else L++;
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
