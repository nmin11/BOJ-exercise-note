package boj.boj_exercise_note.rhs_lecture.sort_application;

import java.io.*;
import java.util.*;

public class BOJ_20291 {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] el;

    static void input() {
        N = fr.nextInt();
        el = new String[N+1];
        for (int i = 1; i <= N; i++) {
            // 입력된 파일 이름을 . 을 기준으로 나눠서 확장자를 가져오기
            el[i] = fr.next().split("\\.")[1];
        }
    }

    static void solve() {
        Arrays.sort(el, 1, N + 1);
        int cnt = 1;
        String curExtension = el[1];
        for (int i = 2; i <= N; i++) {
            if (el[i].equals(curExtension)) {
                cnt++;
            } else {
                sb.append(curExtension).append(' ').append(cnt).append('\n');
                curExtension = el[i];
                cnt = 1;
            }
        }
        sb.append(curExtension).append(' ').append(cnt).append('\n');

        System.out.println(sb);
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
