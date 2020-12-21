package com.xuzhongjian.rxjava.util;

import com.google.gson.reflect.TypeToken;
import com.xuzhongjian.rxjava.model.User;

import java.util.List;

/**
 * @author zjxu97 at 12/17/20 5:12 PM
 */
public class MockUserUtil {

    public static List<User> mockUserList() {
        String fileAsString = FileUtil.getFileAsString("/Users/zjxu97/Github/learning-proj/do-rxjava/src/main/resources/users.json");
        return GsonUtil.getInstance().fromJson(fileAsString, new TypeToken<List<User>>() {
        }.getType());
    }
}
