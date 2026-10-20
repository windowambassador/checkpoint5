package org.example;

public class Task3 {
    public static void solve(String[] input) {
        int n = Integer.parseInt(input[0].trim());
        String[] parts = input[1].trim().split("\\s+");
        int[] a = new int[n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
            x ^= a[i];
        }
        int lowbit = x & (-x);
        int r1 = 0, r2 = 0;
        for (int v : a) {
            if ((v & lowbit) != 0) r1 ^= v;
            else r2 ^= v;
        }
        int min = Math.min(r1, r2), max = Math.max(r1, r2);
        System.out.println(min + " " + max);
    }
}