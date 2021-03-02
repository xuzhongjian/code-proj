package com.xuzhongjian;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjxu97 at 3/2/21 11:09 AM
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subRes = new LinkedList<>();

        dfs(nums, 0, res, subRes);

        return res;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> res, LinkedList<Integer> subRes) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        // 不选择 index 对应的当前位置
        dfs(nums, index + 1, res, subRes);

        // 选择当前位置
        subRes.addLast(nums[index]);
        dfs(nums, index + 1, res, subRes);
        subRes.removeLast();
    }
}
