package org.example;

import java.util.*;

public class Task2 {
    static class Node {
        Node[] next = new Node[26];
        int count = 0;      // сколько слов проходят через узел
    }

    public static void solve(String[] input) {
        int q = Integer.parseInt(input[0].trim());
        Node root = new Node();
        StringBuilder out = new StringBuilder();

        for (int i = 1; i <= q; i++) {
            String line = input[i].trim();
            int sp = line.indexOf(' ');
            String op = line.substring(0, sp);
            String arg = line.substring(sp + 1);

            if (op.equals("ADD") || op.equals("REMOVE")) {
                int delta = op.equals("ADD") ? 1 : -1;
                Node cur = root;
                for (int j = 0; j < arg.length(); j++) {
                    int c = arg.charAt(j) - 'a';
                    if (cur.next[c] == null) cur.next[c] = new Node();
                    cur = cur.next[c];
                    cur.count += delta;
                }
            } else { // COUNT
                Node cur = root;
                boolean ok = true;
                for (int j = 0; j < arg.length(); j++) {
                    int c = arg.charAt(j) - 'a';
                    if (cur.next[c] == null) { ok = false; break; }
                    cur = cur.next[c];
                }
                out.append(ok ? cur.count : 0).append('\n');
            }
        }
        System.out.print(out);
    }
}