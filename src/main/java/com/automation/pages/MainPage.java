package com.automation.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by sergey on 19.03.17.
 */
public class MainPage  {

     public SelenideElement logo = $("a.navbar-brand");
     private SelenideElement uploadInput = $("#filestyle-0");
     private SelenideElement uploadBtn = $("#upload_submit > button");
     public Video video = new Video(".panel-heading");

     @Step
     public MainPage uploadVideo(String... filename){
          uploadInput.uploadFromClasspath(filename);
          uploadBtn.click();
          return this;
     }

     public MainPage then(){
          return this;
     }
}
