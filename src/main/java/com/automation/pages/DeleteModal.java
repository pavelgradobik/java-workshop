package com.automation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by sergey on 19.03.17.
 */
public class DeleteModal {

    public SelenideElement deleteBtn = $("#confirm-delete > div > div > div.modal-footer > a");
}
