package com.xuzhongjian.rxjava.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xuzhongjian.rxjava.model.User;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

/**
 * @author zjxu97 at 12/18/20 4:20 PM
 */
public class GsonUtil {
    private static Gson GSON_INSTANCE = null;

    private GsonUtil() {
    }

    public static Gson getInstance() {
        if (Objects.isNull(GSON_INSTANCE)) {
            GSON_INSTANCE = new Gson();
        }
        return GSON_INSTANCE;
    }
}
