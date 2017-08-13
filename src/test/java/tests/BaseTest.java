package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.Before;

/**
 * Created by sergey on 19.03.17.
 */
public class BaseTest {

    @Before
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        FirefoxDriverManager.getInstance().setup();
        Configuration.timeout = 10000;
        Configuration.baseUrl = "http://35.202.149.166:8086";
    }
}
