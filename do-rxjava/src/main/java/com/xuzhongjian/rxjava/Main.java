package com.xuzhongjian.rxjava;

import java.util.Random;

/**
 * @author zjxu97 at 12/23/20 3:51 PM
 */
public class Main {
    private static final Random RANDOM = new Random();
    private static final int LIANG_WEI_SHU = 10;
    private static final int TOTAL_MONTH = 12;
    private static final int BEHIN_YEAR = 1994;
    private static final int TOTALDAY = 30;
    private static final int YEARS_RANGE = 11;

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Main.randomBirthDay());
        }
    }

    /**
     * 生成随机的生日 16到26岁
     * 1994年1月1日到2004年12月31日
     *
     * @return
     */
    private static String randomBirthDay() {
        StringBuilder result = new StringBuilder();
        result.append(BEHIN_YEAR + RANDOM.nextInt(YEARS_RANGE));
        result.append("-");
        int month = 1 + RANDOM.nextInt(TOTAL_MONTH);
        if (month < LIANG_WEI_SHU) {
            result.append("0");
        }
        result.append(month);
        result.append("-");
        int day = 1 + RANDOM.nextInt(TOTALDAY);
        if (day < LIANG_WEI_SHU) {
            result.append("0");
        }
        result.append(day);

        return result.toString();
    }
}
