package com.automation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by sergey on 19.03.17.
 */
public class Video {

    private SelenideElement element;

    public Video(String selector){
        this.element = $(selector);
    }

    public SelenideElement videoName(){
        return element.find("h4 > a > strong");
    }

    public SelenideElement deleteBtn(){
        return element.find("#delete_item");
    }

    public SelenideElement downloadBtn(){
        return element.find("#download_btn");
    }

    public void delete(){
        deleteBtn().click();
        new DeleteModal().deleteBtn.click();
    }
}
