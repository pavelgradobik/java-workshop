package tests;

import com.automation.pages.LoginPage;
import com.automation.pages.MainPage;
import com.automation.pages.Video;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;

import static com.automation.pages.utils.SelenideUtils.open;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;

/**
 * Created by sergey on 19.03.17.
 */
public class MainPageTest extends BaseTest {

    private MainPage mainPage = new MainPage();

    @Before
    public static void login() {
        if (!WebDriverRunner.url().equals(Configuration.baseUrl + "/index")) {
            open(LoginPage.class)
                    .loginAs("admin", "admin");
        }
    }

    @Test
    void testCanUploadVideoFile() {
        mainPage.uploadVideo("test_video.mp4")
                .video.videoName()
                .shouldHave(text("test_video.mp4"));
    }

    @Test
    void testDeleteVideoFile() {
        Video video = mainPage.uploadVideo("test_video.mp4").video;
        video.delete();
        video.videoName().should(disappear);
    }
}
