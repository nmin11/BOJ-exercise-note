package boj.boj_exercise_note.rhs_lecture.binary_search;

import java.io.*;
import java.util.*;

public class BOJ_3273 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, Sum;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        Sum = scan.nextInt();
    }

    static boolean binarySearch(int[] A, int L, int R, int X) {
        // A[L ... R] 에서 X 가 존재하면 true, 없으면 false 를 return 하는 함수
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == X) return true;
            if (A[mid] < X) L = mid + 1;
            else R = mid - 1;
        }
        return false;
    }

    static void solve() {
        // A 에 대해 이분 탐색을 할 예정이니까, 정렬을 미리 해주자.
        Arrays.sort(A, 1, N + 1);

        int ans = 0;
        for (int i = 1; i <= N - 1; i++) {
            // A[i] 를 선택했다. 즉 우린 Sum - A[i] 가 배열에 있는 지 확인해야 한다.
            if (binarySearch(A, i + 1, N, Sum - A[i])) ans++;
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
