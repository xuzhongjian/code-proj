package com.xuzhongjian;

import java.util.Arrays;

/**
 * @author zjxu97 at 12/25/20 11:20 AM
 */
public class Main {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};

        int rootIndex = Arrays.binarySearch(inorder, 20);
        System.out.println(rootIndex);

    }

}
