package com.xuzhongjian.rxjava;

/**
 * @author zjxu97 at 12/19/20 4:12 PM
 */
//给定一个 n × n 的二维矩阵表示一个图像。
//
// 将图像顺时针旋转 90 度。
//
// 说明：
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//
// 示例 1:
//
// 给定 matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//
//
// 示例 2:
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
//
// Related Topics 数组
// 👍 703 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        if (nums.length == 1 && target == nums[0]) {
            return 0;
        }
        while (r > l && (target >= nums[l] || target <= nums[r])) {
            if (target == nums[l]) {
                return l;
            }
            if (target == nums[r]) {
                return r;
            }
            mid = (r + l) / 2;
            if (mid == r || mid == l) {
                break;
            }
            // 正常二分法
            if (nums[l] < nums[r]) {
                if (target < nums[mid]) {
                    r = mid;
                } else if (target > nums[mid]) {
                    l = mid;
                } else {
                    return mid;
                }
                continue;
            }

            if (nums[mid] > target) {
                if (target > nums[r]) {
                    // 进入正常二分法
                    r = mid;
                } else {
                    l = mid;
                }
            } else if (nums[mid] < target) {
                if (mid > nums[l]) {
                    l = mid;
                } else {
                    // 进入正常二分法
                    r = mid;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    public void rotate(int[][] matrix) {
        if (matrix.length % 2 == 0) {
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix.length / 2; j++) {
                    this.move(matrix, i, j);
                }
            }
        } else {
            for (int i = 0; i < matrix.length / 2 + 1; i++) {
                for (int j = 0; j < matrix.length / 2; j++) {
                    System.out.println(i + " " + j);
                    this.move(matrix, i, j);
                }
            }
        }
    }

    public void move(int[][] matrix, int i1, int j1) {
        int length = matrix.length;
        int i2, j2;
        i2 = j1;
        j2 = length - i1 - 1;
        int val0 = matrix[i1][j1];
        int val1 = this.setVal(matrix, val0, i2, j2);

        i1 = i2;
        j1 = j2;
        i2 = j1;
        j2 = length - i1 - 1;
        int val2 = this.setVal(matrix, val1, i2, j2);

        i1 = i2;
        j1 = j2;
        i2 = j1;
        j2 = length - i1 - 1;
        int val3 = this.setVal(matrix, val2, i2, j2);

        i1 = i2;
        j1 = j2;
        i2 = j1;
        j2 = length - i1 - 1;
        this.setVal(matrix, val3, i2, j2);
    }

    /**
     * 2 = 1
     * return 1
     */
    public int setVal(int[][] matrix, int val, int i2, int j2) {
        int temp = matrix[i2][j2];
        matrix[i2][j2] = val;
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)