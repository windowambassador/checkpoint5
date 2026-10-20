package org.example;

import java.util.*;

public class Task4 {
    static int n;
    static boolean[][] forbidden;
    static long count;

    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        n = Integer.parseInt(first[0]);
        int b = Integer.parseInt(first[1]);

        forbidden = new boolean[n][n];
        for (int i = 0; i < b; i++) {
            String[] p = input[1 + i].trim().split("\\s+");
            int r = Integer.parseInt(p[0]) - 1;
            int c = Integer.parseInt(p[1]) - 1;
            forbidden[r][c] = true;
        }

        count = 0;
        // маски: столбцы, диагонали "\" (r-c+n-1), диагонали "/" (r+c)
        backtrack(0, 0L, 0L, 0L);
        System.out.println(count);
    }

    private static void backtrack(int row, long cols, long diag1, long diag2) {
        if (row == n) { count++; return; }
        for (int c = 0; c < n; c++) {
            long colBit = 1L << c;
            long d1Bit = 1L << (row - c + n - 1);
            long d2Bit = 1L << (row + c);
            if ((cols & colBit) != 0) continue;
            if ((diag1 & d1Bit) != 0) continue;
            if ((diag2 & d2Bit) != 0) continue;
            if (forbidden[row][c]) continue;
            backtrack(row + 1, cols | colBit, diag1 | d1Bit, diag2 | d2Bit);
        }
    }
}