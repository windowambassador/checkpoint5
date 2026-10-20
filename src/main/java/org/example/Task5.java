package org.example;

import java.util.*;

public class Task5 {
    static class Node {
        Node[] next = new Node[26];
        int cnt = 0;      // число слов в поддереве (включая это слово)
        int ends = 0;     // сколько слов заканчивается здесь (0/1)
    }

    public static void solve(String[] input) {
        int q = Integer.parseInt(input[0].trim());
        Node root = new Node();
        StringBuilder out = new StringBuilder();

        for (int i = 1; i <= q; i++) {
            String line = input[i].trim();
            String[] p = line.split(" ");
            String op = p[0];

            if (op.equals("ADD") || op.equals("REMOVE")) {
                String w = p[1];
                int delta = op.equals("ADD") ? 1 : -1;
                Node cur = root;
                cur.cnt += delta;
                for (int j = 0; j < w.length(); j++) {
                    int c = w.charAt(j) - 'a';
                    if (cur.next[c] == null) cur.next[c] = new Node();
                    cur = cur.next[c];
                    cur.cnt += delta;
                }
                cur.ends += delta;
            } else { // KTH prefix k
                String prefix = p[1];
                int k = Integer.parseInt(p[2]);
                Node cur = root;
                boolean ok = true;
                for (int j = 0; j < prefix.length(); j++) {
                    int c = prefix.charAt(j) - 'a';
                    if (cur.next[c] == null) { ok = false; break; }
                    cur = cur.next[c];
                }
                if (!ok || cur.cnt < k) {
                    out.append("NONE\n");
                    continue;
                }
                // спуск: ищем k-е слово в поддереве cur
                StringBuilder word = new StringBuilder(prefix);
                Node node = cur;
                int kk = k;
                while (true) {
                    if (node.ends >= kk) {
                        break; // слово заканчивается здесь
                    }
                    kk -= node.ends;
                    boolean moved = false;
                    for (int c = 0; c < 26; c++) {
                        if (node.next[c] != null && node.next[c].cnt > 0) {
                            if (kk <= node.next[c].cnt) {
                                word.append((char) ('a' + c));
                                node = node.next[c];
                                moved = true;
                                break;
                            } else {
                                kk -= node.next[c].cnt;
                            }
                        }
                    }
                    if (!moved) break; // не должно случаться при корректных данных
                }
                out.append(word).append('\n');
            }
        }
        System.out.print(out);
    }
}