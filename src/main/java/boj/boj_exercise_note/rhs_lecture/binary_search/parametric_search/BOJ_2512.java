package boj.boj_exercise_note.rhs_lecture.binary_search.parametric_search;

import java.io.*;
import java.util.*;

public class BOJ_2512 {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = fr.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = fr.nextInt();
        }
        M = fr.nextInt();
    }

    static boolean determination(int limit) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(A[i], limit);
        }
        return sum <= M;
    }

    static void solve() {
        int L = 1, R = 0, ans = 0;
        for (int i = 1; i <= N; i++) R = Math.max(R, A[i]);
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer 를 빠르게 구하자!
        while (L <= R) {
            int mid = ((L + R) / 2);
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
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
