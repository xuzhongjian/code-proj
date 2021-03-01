package com.xuzhongjian.algo;

import java.util.*;

/**
 * @author zjxu97 at 3/1/21 3:14 PM
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums = {555, 666, 222, 111, 777, 333};
        List<Integer> integers = minK(nums, 2);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    private static List<Integer> solutionByHeap1(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        // 利用优先级队列构建一个小顶堆
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : input) {
            // 如果队列大小没有到k
            if (queue.size() < k) {
                queue.add(num);
                // 用堆顶，也就是最小的一个数据当前元素来比较
            } else if (Objects.nonNull(queue.peek()) && queue.peek() < num) {
                // 如果 num 比堆定元素大，那么 num 应该加入topK
                // poll 表示移除堆定的元素
                queue.poll();
                // 将num加入
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }

    /**
     * 取最大的 k 个数据
     */
    private static List<Integer> maxK(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0 || nums.length == 0) {
            return result;
        }
        //小顶堆
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (Objects.nonNull(queue.peek()) && queue.peek() < num) {
                queue.poll();
                queue.add(num);
            }
        }
        result.addAll(queue);
        return result;
    }

    /**
     * 取最小的 k 个数据
     */
    private static List<Integer> minK(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0 || nums.length == 0) {
            return result;
        }
        // 大顶堆
        Queue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (Objects.nonNull(queue.peek()) && queue.peek() > num) {
                queue.poll();
                queue.add(num);
            }
        }
        result.addAll(queue);
        return result;
    }

    /**
     * 错误案例
     * 保存了所有的数据，无法处理海量数据
     *
     * @param input 数据流，以数组的形式传入
     * @param k     取k个数据
     * @return 结果
     */
    private static List<Integer> solutionByHeap2(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int num : input) {
            queue.add(num);
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }

}
