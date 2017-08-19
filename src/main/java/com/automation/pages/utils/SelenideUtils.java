package com.automation.pages.utils;

import com.automation.pages.Page;
import io.qameta.allure.Step;

/**
 * Created by sergey on 19.03.17.
 */
public class SelenideUtils {

    @Step
    public static <T> T open(Class<T> tClass) {
        try {
            Page page = (Page) tClass.newInstance();
            page.open();
            return (T) page;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
