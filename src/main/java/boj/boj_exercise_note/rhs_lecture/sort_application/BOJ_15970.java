package boj.boj_exercise_note.rhs_lecture.sort_application;

import java.io.*;
import java.util.*;

public class BOJ_15970 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] el;

    static void input() {
        N = scan.nextInt();
        el = new ArrayList[N + 1];
        for (int color = 1; color <= N; color++) {
            el[color] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            int coordinate, color;
            coordinate = scan.nextInt();
            color = scan.nextInt();
            el[color].add(coordinate);
        }
    }

    static int toLeft(int color, int idx) {
        if (idx == 0)  // 왼쪽에 더 이상 점이 없는 상태
            return Integer.MAX_VALUE;
        return el[color].get(idx) - el[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if (idx + 1 == el[color].size())  // 오른쪽에 더 이상 점이 없는 상태
            return Integer.MAX_VALUE;
        return el[color].get(idx + 1) - el[color].get(idx);
    }

    static void solve() {
        for (int color = 1; color <= N; color++)
            Collections.sort(el[color]);

        int ans = 0;
        for (int color = 1; color <= N; color++) {
            for (int i = 0; i < el[color].size(); i++) {
                int left_distance = toLeft(color, i);
                int right_distance = toRight(color, i);
                ans += Math.min(left_distance, right_distance);
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