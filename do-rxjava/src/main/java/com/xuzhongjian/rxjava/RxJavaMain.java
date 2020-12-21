package com.xuzhongjian.rxjava;

import com.xuzhongjian.rxjava.model.User;
import com.xuzhongjian.rxjava.util.GsonUtil;
import com.xuzhongjian.rxjava.util.MockUserUtil;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Arrays;
import java.util.List;

/**
 * @author zjxu97 at 12/17/20 5:06 PM
 */
public class RxJavaMain {
    public static void main(String[] args) {
//        RxJavaMain.testString();
        RxJavaMain.testUser();
    }

    private static List<User> testUser() {
        List<User> users = MockUserUtil.mockUserList();
        System.out.println(String.format("user list: %s", GsonUtil.getInstance().toJson(users)));
        return users;
    }

    private static void testString() {
        List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped",
                "over", "the", "lazy", "dogs");

        @NonNull Disposable subscribe = Observable.fromIterable(words)
                .flatMap(word -> Observable.fromArray(word.split("")))
                .distinct()
                .sorted()
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);
    }

    public Observable<User> listUser() {
        List<User> users = MockUserUtil.mockUserList();
        return Observable.fromIterable(users);
    }
}
