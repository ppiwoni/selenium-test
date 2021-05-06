package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Base;

import java.time.Duration;

public class Page_User extends Base {

    By element_User_Name_Display = By.xpath("//*[@class=\"user-name-display\"]//span");

    @Step("Verify user")
    public String verify_User()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(element_User_Name_Display));

        return driver.findElement(element_User_Name_Display).getText();
    }
}

