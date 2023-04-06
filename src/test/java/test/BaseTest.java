package test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "file://";
    }
}

