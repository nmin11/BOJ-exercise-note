package boj.boj_exercise_note.rhs_lecture.sort_application;

import java.io.*;
import java.util.*;

public class BOJ_11652 {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] el;

    static void input() {
        N = fr.nextInt();
        el = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            el[i] = fr.nextLong();
        }
    }

    static void sort() {
        // Sort 정렬하기
        Arrays.sort(el, 1, N + 1);
        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수
        long mode = el[1];
        int modeCnt = 1, curCnt = 1;

        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는지, 새로운 숫자가 나왔는지를 판단하여
        // curCnt 를 갱신해주고, 최빈값을 갱신하는 작업.
        for (int i = 2; i <= N; i++) {
            if (el[i] == el[i - 1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }

            if (curCnt > modeCnt) {
                modeCnt = curCnt;
                mode = el[i];
            }
        }

        // 정답 출력하기
        System.out.println(mode);
    }

    public static void main(String[] args) {
        input();
        sort();
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
