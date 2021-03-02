package com.xuzhongjian;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjxu97 at 3/2/21 11:09 AM
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(solution.fourSum(nums, 0));
    }

    public List<List<Integer>> fourSum(int[] numsArray, int target) {
        List<Integer> nums = new ArrayList<>();
        for (Integer num : numsArray) {
            nums.add(num);
        }

        List<Integer> subRes = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, 4, subRes, res, target);
        for (List<Integer> list : res) {
            list.sort((o1, o2) -> o1 - o2);
        }
        return res;
    }

    /**
     * @param nums   数据底
     * @param i      当前的index
     * @param length 目标长度
     * @param subRes 单个答案
     * @param res    整体答案
     */
    public void dfs(List<Integer> nums, int i, int length, List<Integer> subRes, List<List<Integer>> res, int target) {
        if (i == nums.size()) {
            if (subRes.size() == length) {
                if (sumCollection(subRes) == target) {
                    res.add(new ArrayList<>(subRes));
                }
            }
            return;
        }
        // 不选择当前
        dfs(nums, i + 1, length, subRes, res, target);

        // 选择当前
        subRes.add(nums.get(i));
        dfs(nums, i + 1, length, subRes, res, target);
        subRes.remove(subRes.size() - 1);
    }

    public int sumCollection(List<Integer> nums) {
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }
}