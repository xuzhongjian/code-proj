package com.xuzhongjian;

/**
 * @author zjxu97 at 12/25/20 11:20 AM
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(Class.forName("xuzhongjian"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
