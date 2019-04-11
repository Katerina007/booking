package com.booking.tests;

import com.booking.pages.MainPage;
import org.testng.annotations.Test;

public class MainPageElementsTest extends TestBase{

    @Test
    public void simpleTest() {
        onMainPage().verifySearchTitle();
    }

    private MainPage onMainPage() {
        return new MainPage(driver).open(baseUrl);
    }

}
