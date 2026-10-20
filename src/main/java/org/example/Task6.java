package org.example;

public class Task6 {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    public static void solve(String[] input) {
        int n = Integer.parseInt(input[0].trim());
        String[] parts = input[1].trim().split("\\s+");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(parts[i]);

        TrieNode root = new TrieNode();
        insert(root, 0); // префиксный XOR до начала

        int pref = 0;
        int best = 0;
        for (int i = 0; i < n; i++) {
            pref ^= a[i];
            best = Math.max(best, queryMax(root, pref));
            insert(root, pref);
        }
        System.out.println(best);
    }

    private static final int BITS = 29; // a[i] < 2^30

    private static void insert(TrieNode root, int x) {
        TrieNode cur = root;
        for (int b = BITS; b >= 0; b--) {
            int bit = (x >> b) & 1;
            if (cur.child[bit] == null) cur.child[bit] = new TrieNode();
            cur = cur.child[bit];
        }
    }

    private static int queryMax(TrieNode root, int x) {
        TrieNode cur = root;
        int res = 0;
        for (int b = BITS; b >= 0; b--) {
            int bit = (x >> b) & 1;
            int want = 1 - bit;
            if (cur.child[want] != null) {
                res |= (1 << b);
                cur = cur.child[want];
            } else {
                cur = cur.child[bit];
            }
        }
        return res;
    }
}