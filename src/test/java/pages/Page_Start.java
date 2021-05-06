package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Base;

import java.time.Duration;

public class Page_Start extends Base {

    By button_Sign_In = By.id("ZalogujButton");

    @Step("Open login module")
    public void open_Login_Module()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(button_Sign_In));
        driver.findElement(button_Sign_In).click();
    }
}

