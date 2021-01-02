package com.xuzhongjian;

import net.sf.json.JSONObject;

/**
 * @author zjxu97 at 12/25/20 11:20 AM
 */
public class Main {
    public static void main(String[] args) {
        String bizExt = "{}";
        JSONObject resultJson = JSONObject.fromObject(bizExt);
        String articleId = resultJson.optString("articleId");
        System.out.println(articleId);
    }
}
