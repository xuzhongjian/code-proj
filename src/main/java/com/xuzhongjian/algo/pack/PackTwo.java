package com.xuzhongjian.algo.pack;

/**
 * 完全背包
 *
 * @author zjxu97 at 4/2/21 8:01 PM
 */
public class PackTwo {
    public static void main(String[] args) {
        int[] values = {2, 2, 6, 5, 4};
        int[] sizes = {6, 3, 5, 4, 6};
        PackTwo packTwo = new PackTwo();
        System.out.println(packTwo.knapsack(values, sizes, 10));
    }

    /**
     * 有 N 件物品和一个容量是 maxSize 的背包。每件物品能使用多次。
     * 第 i 件物品的体积是 sizes i，价值是 values i。i [1,N]
     * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
     * 输出最大价值。
     * <p>
     *
     * @param values  价值列表
     * @param sizes   大小列表
     * @param maxSize 背包大小
     * @return 最大价值
     */
    public int knapsack(int[] values, int[] sizes, int maxSize) {
        int n = sizes.length;
        int[] dp = new int[maxSize + 1];
        for (int item = 1; item <= n; item++) {
            int curValue = values[item - 1];
            int curSize = sizes[item - 1];
            for (int size = curSize; size <= maxSize; size++) {
                dp[size] = Math.max(dp[size], dp[size - curSize] + curValue);
            }
        }
        return dp[maxSize];
    }
}
