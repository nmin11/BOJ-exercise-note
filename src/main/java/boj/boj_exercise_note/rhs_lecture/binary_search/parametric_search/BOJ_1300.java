package boj.boj_exercise_note.rhs_lecture.binary_search.parametric_search;

import java.io.*;
import java.util.*;

public class BOJ_1300 {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static void input() {
        N = fr.nextInt();
        K = fr.nextInt();
    }

    static boolean determination(long candidate) {
        // candidate 이하의 숫자가 K개 이상인가?
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(N, candidate / i);
        }
        return sum >= K;
    }

    static void solve() {
        long L = 1, R = Math.min(1000000000, (long) Math.pow(N, 2)), ans = 0;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
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