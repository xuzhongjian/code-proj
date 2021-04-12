package com.xuzhongjian;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zjxu97 at 12/25/20 11:20 AM
 */
public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("log");
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main out");

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));
    }








/*
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = (i < 1 || j < 1) ? 0 : (dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(j < 1 ? 0 : dp[i][j - 1], i < 1 ? 0 : dp[i - 1][j]);
                }
            }
        }
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }

    *//**
     * dp[i] 表示凑齐 i 元的金额，需要的最少的 coin 数量
     * dp[i] = min{dp[i],dp[i-coins[i]+1}
     *//*

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount];
    }

    *//**
     * dp[i][j] 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配
     *//*
//    public static boolean isMatch(String s, String p) {
//        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//        dp[0][0] = true;
//
//        for (int i = 0; i <= s.length(); i++) {
//            for (int j = 1; j <= p.length(); j++) {
//                if (p.charAt(j - 1) == '*') {
//                    // xya*zzz -- 尝试使用字符y的位置的结果来匹配，也就是a*的重复次数为0
//                    dp[i][j] = dp[i][j - 2];
//                    if (!dp[i][j]) {
//                        if (i == 0) {
//                            continue;
//                        }
//                        char before = p.charAt(j - 2);
//                        if (s.charAt(i - 1) == before || before == '.') {
//                            dp[i][j] = dp[i - 1][j];
//                        }
//                    }
//                } else {
//                    // 普通字符
//                    if (i == 0) {
//                        continue;
//                    }
//                    // s 和 p 在对应的位置相同，或是 p 的位置为通配符 .
//                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
//                        dp[i][j] = dp[i - 1][j - 1];
//                    }
//                }
//            }
//        }
//
//        return dp[s.length()][p.length()];
//    }
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (i == 0) continue;
                char c = p.charAt(j - 1);
                // c 可能是 字符、? 和 *
                if (c == '*') {
                    // *
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (c == '?') {
                    // ? -- 通配
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 字符 --  对应位置的两个字符相同
                    if (s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }*/
}
