package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.testng.annotations.BeforeClass;

/**
 * Created by sergey on 19.03.17.
 */
public class BaseTest {

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        FirefoxDriverManager.getInstance().setup();
//        Configuration.timeout = 10000;
        Configuration.baseUrl = "http://104.197.245.3:8086";
//        Configuration.remote = "http://35.202.239.95:4444/wd/hub";
    }
}
