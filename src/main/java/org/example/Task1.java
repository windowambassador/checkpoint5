package org.example;

public class Task1 {
    public static void solve(String[] input) {
        int n = Integer.parseInt(input[0].trim());
        StringBuilder out = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        gen(n, 0, 0, cur, out);
        System.out.print(out);
    }

    private static void gen(int n, int open, int close, StringBuilder cur, StringBuilder out) {
        if (cur.length() == 2 * n) {
            out.append(cur).append('\n');
            return;
        }
        if (open < n) {
            cur.append('(');
            gen(n, open + 1, close, cur, out);
            cur.setLength(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            gen(n, open, close + 1, cur, out);
            cur.setLength(cur.length() - 1);
        }
    }
}