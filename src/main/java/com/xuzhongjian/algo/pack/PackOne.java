package com.xuzhongjian.algo.pack;

/**
 * 01背包
 *
 * @author zjxu97 at 4/2/21 8:01 PM
 */
public class PackOne {
    public static void main(String[] args) {
        int[] values = {2, 2, 6, 5, 4};
        int[] sizes = {6, 3, 5, 4, 6};
        PackOne packOne = new PackOne();
        System.out.println(packOne.knapsack2(values, sizes, 10));
    }

    /**
     * 有 N 件物品和一个容量是 maxSize 的背包。每件物品只能使用一次。
     * 第 i 件物品的体积是 sizes i，价值是 values i。i [1,N]
     * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
     * 输出最大价值。
     * <p>
     * 装入当前这件需要留出物品 i 的位置，并且其他的只能从前 i - 1 件中取：
     * dp[i - 1][j - sizes[i]] + values[i]
     * <p>
     * 不装入当前这件，那么其余的物品需要从前 i - 1 件中取得：
     * dp[i - 1][j]
     * <p>
     * 计算上面两个的最大值，就是dp[i][j]
     *
     * @param values  价值列表
     * @param sizes   大小列表
     * @param maxSize 背包大小
     * @return 最大价值
     */
    public int knapsack1(int[] values, int[] sizes, int maxSize) {
        int n = sizes.length;
        int[][] dp = new int[n + 1][maxSize + 1];

        for (int item = 1; item <= n; item++) {
            int curValue = values[item - 1];
            int curSize = sizes[item - 1];
            for (int size = 1; size <= maxSize; size++) {
                if (curSize > size) {
                    dp[item][size] = dp[item - 1][size];
                } else {
                    dp[item][size] = Math.max(dp[item - 1][size], dp[item - 1][size - curSize] + curValue);
                }
            }
        }
        return dp[n][maxSize];
    }

    /**
     * 把上面的 44 46 两行的 dp[item - 1] 优化掉了。
     *
     * @param values  价值列表
     * @param sizes   大小列表
     * @param maxSize 背包大小
     * @return 最大价值
     */
    public int knapsack2(int[] values, int[] sizes, int maxSize) {
        int n = sizes.length;
        int[] dp = new int[maxSize + 1];
        for (int item = 1; item <= n; item++) {
            int curValue = values[item - 1];
            int curSize = sizes[item - 1];
            for (int size = maxSize; size >= curSize; size--) {
                dp[size] = Math.max(dp[size], dp[size - curSize] + curValue);
            }
        }
        return dp[maxSize];
    }
}
