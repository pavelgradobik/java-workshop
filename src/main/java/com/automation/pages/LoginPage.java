package com.automation.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by sergey on 19.03.17.
 */
public class LoginPage extends Page {

    public LoginPage open(){
        Selenide.open("/");
        return this;
    }

    public MainPage loginAs(String username, String password){
        $("#inputEmail3").val(username);
        $("#inputPassword3").val(password);
        $("#parent > form > div:nth-child(3) > div > button").click();
        return page(MainPage.class);
    }
}
