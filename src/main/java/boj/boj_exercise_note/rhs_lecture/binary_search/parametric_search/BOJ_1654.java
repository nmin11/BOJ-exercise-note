package boj.boj_exercise_note.rhs_lecture.binary_search.parametric_search;

import java.io.*;
import java.util.*;

public class BOJ_1654 {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] A;

    static void input() {
        K = fr.nextInt();
        N = fr.nextInt();
        A = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            A[i] = fr.nextInt();
        }
    }

    static boolean determination(long len) {
        // len 만큼의 길이로 랜선들을 잘랐을 때, N 개 만큼의 랜선을 얻을 수 있는가?
        long sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += A[i] / len;
        }
        return sum >= N;
    }

    static void solve() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer 를 빠르게 구하자!
        while (L <= R) {
            long mid = ((L + R) / 2);
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
