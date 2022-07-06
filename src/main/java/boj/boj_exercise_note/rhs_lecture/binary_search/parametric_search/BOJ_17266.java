package boj.boj_exercise_note.rhs_lecture.binary_search.parametric_search;

import java.io.*;
import java.util.*;

public class BOJ_17266 {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = fr.nextInt();
        M = fr.nextInt();
        A = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            A[i] = fr.nextInt();
        }
    }

    static boolean determination(int height) {
        int last = 0;  // 밝혀진 마지막 위치
        // height 로 불을 밝혔을 때, 모든 구간이 밝혀지는 지 확인하기!
        for (int i = 1; i <= M; i++) {
            if (A[i] - height > last) return false;
            last = A[i] + height;
        }
        return N <= last;
    }

    static void solve() {
        int L = 0, R = N, ans = N;
        while (L <= R) {
            int mid = (L + R) / 2;
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
