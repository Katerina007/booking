package com.booking.pages;

import com.booking.utils.ElementUtils;
import com.booking.utils.WaitUtils;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class MainPage extends Page {

    @FindBy(className = "sb-searchbox__title-text")
    private WebElement searchTitle;

    @FindBy(className = "sb-searchbox__subtitle-text")
    private WebElement searchSubtitle;

    public MainPage(WebDriver driver) {super(driver);}

    public boolean isOpened() {
        return searchTitle.isDisplayed();
    }

    @Step("Open Main Page")
    public MainPage open(String baseUrl) {
        driver.get(baseUrl);
        WaitUtils.forPageLoaded(driver, this.getClass());
        return this;
    }

    @Step("Verify searchBoxTitles")
    public void verifySearchTitle() {
        ElementUtils.waitForVisible(driver, searchTitle, 3);
        logger.info(searchTitle.getText());
        assertTrue(searchTitle.getText().equals("Find the perfect place to stay"));
    }

}
