package com.xuzhongjian.rxjava.model;

import com.google.gson.Gson;
import lombok.Data;

/**
 * @author zjxu97 at 12/17/20 5:09 PM
 */
@Data
public class User {
    private String userId;
    private String headIcon;
    private String nickname;
    private String userText;
    private int gender;
    private Byte age;
    private String birthday;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
