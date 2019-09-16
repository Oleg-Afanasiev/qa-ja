package com.academy.automation.taf.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected void inputTextField(WebElement element, String value) {
        if (value != null) {
            element.click();
            String currentValue = element.getAttribute("value");
            if (!value.equals(currentValue)) {
                element.clear();
                element.sendKeys(value);
            }
        }
    }

    protected void selectByText(WebElement sortBySelect, String text) {
        new Select(sortBySelect).selectByVisibleText(text);
    }

    protected List<String> extractTextFromElements(List<WebElement> elements) {
        List<String> textList = new ArrayList<>(elements.size());
        for(WebElement el : elements)
            textList.add(el.getText().trim());

        return textList;
    }

    protected boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver,30);

        // wait for jQuery to load
        Function<WebDriver, Boolean> jQueryLoad = driver -> {
            try {
                return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
            }
            catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        // wait for Javascript to load
        Function<WebDriver, Boolean> jsLoad = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState")
                .toString().equals("complete");

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public static void waitForPageLoadComplete(WebDriver driver, int specifiedTimeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, specifiedTimeout);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

    protected  void alertAccept(boolean accept) {
        try {
            if (accept)
                driver.switchTo().alert().accept();
            else
                driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
