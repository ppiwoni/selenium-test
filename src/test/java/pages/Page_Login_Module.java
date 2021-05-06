package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Base;

import java.time.Duration;

public class Page_Login_Module extends Base {

    By element_Login_Border = By.xpath("//*[@class=\"login border\"]");
    By input_Username = By.id("username");
    By input_Password = By.id("password");
    By button_Login = By.id("LoginButton");

    @Step("Enter login details")
    public void enter_Login_Details_And_Click_Button(String username, String password)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(element_Login_Border));

        driver.findElement(input_Username).sendKeys(username);
        driver.findElement(input_Password).sendKeys(password);

        driver.findElement(button_Login).click();
    }
}
