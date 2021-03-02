package com.xuzhongjian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zjxu97 at 12/25/20 11:20 AM
 */
public class Main {
    public  void main(String[] args) {
        // System.out.println("hello world!");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        List<Integer> subRes = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, 3, subRes, res);
        System.out.println(res);

    }

    public static List<List<Integer>> getSub(List<Integer> nums, int length) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.size() < length) {
            return res;
        } else if (nums.size() == length) {
            res.add(nums);
            return res;
        }
        List<Integer> subRes = new ArrayList<>();
        return null;
    }

    /**
     * @param nums   数据底
     * @param i      当前的index
     * @param length 目标长度
     * @param subRes 单个答案
     * @param res    整体答案
     */
    public  void dfs(List<Integer> nums, int i, int length, List<Integer> subRes, List<List<Integer>> res) {
        if (i == nums.size()) {
            if (subRes.size() == length) {
                res.add(new ArrayList<>(subRes));
            }
            return;
        }
        // 不选择当前
        dfs(nums, i + 1, length, subRes, res);

        // 选择当前
        subRes.add(nums.get(i));
        dfs(nums, i + 1, length, subRes, res);
        subRes.remove(subRes.size() - 1);
    }
}
