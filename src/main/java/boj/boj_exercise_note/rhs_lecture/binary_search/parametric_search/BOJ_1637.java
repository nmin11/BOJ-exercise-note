package boj.boj_exercise_note.rhs_lecture.binary_search.parametric_search;

import java.io.*;
import java.util.*;

public class BOJ_1637 {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] info;

    static void input() {
        N = fr.nextInt();
        info = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) info[i][j] = fr.nextInt();
        }
    }

    static int count(int A, int C, int B, int X) {
        // A, A+B, ..., A+kB<=C  중에서 X 이하의 수 가 몇개나 있는가?
        if (X < A) return 0;
        if (C < X) return (C - A) / B + 1;
        return (X - A) / B + 1;
    }

    static boolean determination(int candidate) {
        // candidate 이하의 수가 홀수 개인가?
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += count(info[i][0], info[i][1], info[i][2], candidate);
        }
        return sum % 2 == 1;
    }

    static void solve() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0, ansCnt = 0;

        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination((int) mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        if (ans == 0) {  // 홀수번 등장하는 숫자가 없다면
            System.out.println("NOTHING");
        } else {  // 홀수번 등장하는 숫자가 있다면
            for (int i = 1; i <= N; i++) {
                if (info[i][0] <= ans &&
                        ans <= info[i][1] &&
                        (ans - info[i][0]) % info[i][2] == 0) {
                    ansCnt++;
                }
            }
            System.out.println(ans + " " + ansCnt);
        }
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
